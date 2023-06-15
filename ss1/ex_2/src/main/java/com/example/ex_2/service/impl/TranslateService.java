package com.example.ex_2.service.impl;

import com.example.ex_2.repo.ITranslateRepo;
import com.example.ex_2.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    private ITranslateRepo translateRepo;

    @Override
    public String getVietnamese(String english) {
        Map<String, String> list = translateRepo.getList();
        String result = "";
        for (String s : list.keySet()) {
            if (s.equals(english)) {
                result = list.get(s);
                break;
            }
        }
        if (result.equals("")) {
            result = "Not found";
        }
        return result;
    }
}
