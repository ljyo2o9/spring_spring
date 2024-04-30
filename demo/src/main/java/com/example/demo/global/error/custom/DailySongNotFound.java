package com.example.demo.global.error.custom;

import com.example.demo.global.error.ErrorCode;
import com.example.demo.global.error.exception.CustomException;

public class DailySongNotFound extends CustomException {
    public DailySongNotFound() {
        super(ErrorCode.DAILY_SONG_NOT_FOUND);
    }
}
