package com.example.demo.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 400 Bad Request
    // 401 Unauthorized
    // 402 Payment Required
    // 403 Forbidden
    // 404 Not Found
    DAILY_SONG_NOT_FOUND(404, "너가준 아이디의 URL이 업슴..");
    // 405 Method Not Allowed
    // 406 Not Acceptable
    // 407 Proxy Authentication Required
    // 408 Request Timeout
    // 409 Conflict
    // 410 Gone
    // 411 Length Required
    // 412 Precondition Failed
    // 413 Payload Too Large
    // 414 URI Too Long
    // 415 Unsupported Media Type
    // 416 Range Not Satisfiable
    // 417 Expectation Failed
    // 418 I'm a teapot
    // 419 Authentication Timeout
    // 420 Method Failure
    // 421 Misdirected Request
    // 422 Unprocessable Entity
    // 423 Locked
    // 424 Failed Dependency
    // 425 Too Early
    // 426 Upgrade Required
    // 428 Precondition Required
    // 429 Too Many Requests
    // 431 Request Header Fields Too Large
    // 451 Unavailable For Legal Reasons
    // 500 Internal Server Error

    private final int status;
    private final String message;
}