package com.example.ex_1.controller;

import com.example.ex_1.model.Product;
import com.example.ex_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
@SessionAttributes("productOrder")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("productOrder")
    public Map<Product, Integer> initOrderList() {
        return new HashMap<>();
    }

    @GetMapping("")
    public String getList(Model model) {
        List<Product> list = productService.getList();
        model.addAttribute("list", list);
        return "list_product";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (productService.getProductById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
            return "redirect:/product";
        }
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "detail_product";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute Product product, @SessionAttribute("productOrder") Map<Product, Integer> orderList, RedirectAttributes redirectAttributes) {
        boolean flag = true;
        if (orderList.size() == 0) {
            orderList.put(product, 1);
        } else {
            for (Product p : orderList.keySet()) {
                if (p.getId() == product.getId()) {
                    orderList.put(p, orderList.get(p) + 1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                orderList.put(product, 1);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Order Successfully");
        return "redirect:/product";
    }

    @GetMapping("cart")
    public String getCart(@SessionAttribute("productOrder") Map<Product, Integer> orderList, Model model) {
        model.addAttribute("orderList", orderList);
        return "cart";
    }

    @GetMapping("cart/delete/{id}")
    public String deleteProduct(@PathVariable int id, @SessionAttribute("productOrder") Map<Product, Integer> orderList
            , RedirectAttributes redirectAttributes) {
        if (productService.getProductById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
            return "redirect:/product";
        }
        Product product = productService.getProductById(id);
        for (Product p : orderList.keySet()
        ) {
            if (p.getId() == product.getId()) {
                orderList.remove(p);
                break;
            }
        }
        return "redirect:/product/cart";
    }

    @GetMapping("cart/decrease/{id}")
    public String decrease(@PathVariable int id, @SessionAttribute("productOrder") Map<Product, Integer> orderList,
                           RedirectAttributes redirectAttributes) {
        if (productService.getProductById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
            return "redirect:/product";
        }
        Product product = productService.getProductById(id);
        for (Product p : orderList.keySet()
        ) {
            if (p.getId() == product.getId()) {
                if (orderList.get(p) == 1) {
                    orderList.remove(p);
                } else {
                    orderList.put(p, orderList.get(p) - 1);
                }
                break;
            }
        }
        return "redirect:/product/cart";
    }

    @GetMapping("cart/increase/{id}")
    public String increase(@PathVariable int id, @SessionAttribute("productOrder") Map<Product, Integer> orderList,
                           RedirectAttributes redirectAttributes) {
        if (productService.getProductById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
            return "redirect:/product";
        }
        Product product = productService.getProductById(id);
        for (Product p : orderList.keySet()
        ) {
            if (p.getId() == product.getId()) {
                orderList.put(p, orderList.get(p) + 1);
                break;
            }
        }
        return "redirect:/product/cart";
    }

    @GetMapping("cart/pay")
    public String pay(@SessionAttribute("productOrder") Map<Product, Integer> orderList, RedirectAttributes redirectAttributes) {
        orderList.clear();
        redirectAttributes.addFlashAttribute("message", "Payment Successfully");
        return "redirect:/product";
    }
}
