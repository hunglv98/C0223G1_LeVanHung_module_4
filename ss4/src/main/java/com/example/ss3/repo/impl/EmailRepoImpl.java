package com.example.ss3.repo.impl;

import com.example.ss3.repo.IEmailRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepoImpl implements IEmailRepo {
    private static List<String> languageList = new ArrayList<>();
    private static List<String> pageList = new ArrayList<>();

    static {
        languageList.add("Vietnamese");
        languageList.add("English");
        languageList.add("Japanese");
        languageList.add("Chinese");
        pageList.add("5");
        pageList.add("10");
        pageList.add("15");
        pageList.add("25");
        pageList.add("50");
        pageList.add("100");
    }

    @Override
    public List<String> getLanguageList() {
        return languageList;
    }

    @Override
    public List<String> getPageList() {
        return pageList;
    }
}
