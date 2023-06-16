package com.example.ex_2.repo.impl;

import com.example.ex_2.repo.ITranslateRepo;
import org.springframework.stereotype.Repository;


import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class TranslateRepoImpl implements ITranslateRepo {
    private static final Map<String, String> list = new LinkedHashMap<>();

    static {
        list.put("Cat", "Con Mèo");
        list.put("Dog", "Con Chó");
        list.put("Lion", "Sư Tủ");
        list.put("Tiger", "Con Hổ");
    }

    @Override
    public Map<String, String> getList() {
        return list;
    }
}
