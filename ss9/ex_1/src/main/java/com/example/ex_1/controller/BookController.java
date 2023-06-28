package com.example.ex_1.controller;

import com.example.ex_1.model.Book;
import com.example.ex_1.model.Booking;
import com.example.ex_1.service.IBookService;
import com.example.ex_1.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookingService bookingService;

    @GetMapping("")
    public String getList(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
        return "book_list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        int code = (int) Math.floor((Math.random() + 1) * 10000);
        while (bookingService.existsAllByCode(code)) {
            code = (int) Math.floor((Math.random() + 1) * 10000);
        }
        model.addAttribute("code", code);
        return "detail_book";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute Book book, RedirectAttributes redirectAttributes, @RequestParam int code) {
        if (book.getVolume() == 0) {
            redirectAttributes.addFlashAttribute("message", "Not exist");
        } else {
            bookingService.add(book, code);
            book.setVolume(book.getVolume() - 1);
            bookService.update(book);
            redirectAttributes.addFlashAttribute("message", "Order Successfully with code " + code);
        }
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String showFormReturnBook() {
        return "return_book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam int code, RedirectAttributes redirectAttributes, Model model) {
        if (bookingService.findByIdBooking(code) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found");
            return "redirect:/book/return";
        } else {
            Booking booking = bookingService.findByIdBooking(code);
            model.addAttribute("booking", booking);
        }
        return "return_book";
    }

    @GetMapping("/giveback/{code}")
    public String giveBack(@PathVariable int code, RedirectAttributes redirectAttributes) {
        if (bookingService.findByIdBooking(code) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found");
            return "redirect:/book/return";
        } else {
            Booking booking = bookingService.findByIdBooking(code);
            Book book = booking.getBook();
            book.setVolume(book.getVolume() + 1);
            bookService.add(book);
            bookingService.deleteById(booking.getId());
            redirectAttributes.addFlashAttribute("message", "Give Back Successfully");
            return "redirect:/book";
        }
    }
}
