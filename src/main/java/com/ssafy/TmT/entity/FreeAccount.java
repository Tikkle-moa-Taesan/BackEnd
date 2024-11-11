package com.ssafy.TmT.entity;


public class FreeAccount{
	
	// 계좌 id
    private Long accountId;
    
    // 계좌 번호
    private String accountNumber;
    
    // 은행 이름
    private String bankName;
    
    // 계좌 소유자 아이디
    private Long memberId; // 계좌 소유자의 ID (외래키 역할)
    
    // 계좌 잔액
    private Long balance;
}