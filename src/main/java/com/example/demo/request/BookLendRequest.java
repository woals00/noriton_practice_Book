package com.example.demo.request;

import lombok.Data;

import java.util.List;

@Data
public class BookLendRequest {
    private List<Long> bookIds;
    private Long bookid;
    private Long memberId;
}
