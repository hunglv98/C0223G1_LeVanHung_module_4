package com.example.ss1.service.impl;

import com.example.ss1.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public double getVnd(double usd, double rate) {
        return usd * rate;
    }
}
