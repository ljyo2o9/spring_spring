package com.example.demo.global.error.custom;

import com.example.demo.global.error.ErrorCode;
import com.example.demo.global.error.exception.CustomException;

public class DailySongIsEmpty extends CustomException {
    public DailySongIsEmpty(ErrorCode errorCode) {
        super(errorCode);
    }
}
