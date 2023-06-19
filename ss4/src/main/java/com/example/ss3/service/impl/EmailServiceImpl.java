package com.example.ss3.service.impl;

import com.example.ss3.repo.IEmailRepo;
import com.example.ss3.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private IEmailRepo emailRepo;

    @Override
    public List<String> getLanguageList() {
        return emailRepo.getLanguageList();
    }

    @Override
    public List<String> getPageList() {
        return emailRepo.getPageList();
    }

}
