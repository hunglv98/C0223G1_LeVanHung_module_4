package com.example.ex_2.repo.impl;

import com.example.ex_2.repo.ITranslateRepo;
import org.springframework.stereotype.Repository;


import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class TranslateRepo implements ITranslateRepo {
    @Override
    public Map<String, String> getList() {
        Map<String, String> list = new LinkedHashMap<>();
        list.put("Cat", "Con Mèo");
        list.put("Dog", "Con Chó");
        list.put("Lion", "Sư Tủ");
        list.put("Tiger", "Con Hổ");
        return list;
    }
}
