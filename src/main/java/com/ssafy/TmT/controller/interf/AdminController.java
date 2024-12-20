package com.ssafy.TmT.controller.interf;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.TmT.dto.account.FreeAccountResponse;
import com.ssafy.TmT.dto.admin.InsertAccountRequest;
import com.ssafy.TmT.dto.admin.InsertTransactionRequest;
import com.ssafy.TmT.exception.CustomExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/api/admin")
public interface AdminController {

	
	// 거래내역 추가 기능
	@PostMapping("/transaction")
	@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "거래 내역 추가", description = "관리자 권한으로 거래 내역을 추가합니다")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "거래 내역 추가 성공",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FreeAccountResponse.class))),
        @ApiResponse(responseCode = "401", description = "권한 부족",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class))),
        @ApiResponse(responseCode = "404", description = "서비스 로직 오류",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class))),
        @ApiResponse(responseCode = "500", description = "내부 서버 오류",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class)))
    })
	ResponseEntity<String> insertTransaction(@RequestBody InsertTransactionRequest request);

	// 계좌 추가 기능
	@PostMapping("/account")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "계좌 생성 추가", description = "관리자 권한으로 계좌를 추가합니다")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "계좌 추가 성공",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = FreeAccountResponse.class))),
		@ApiResponse(responseCode = "401", description = "권한 부족",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class))),
		@ApiResponse(responseCode = "404", description = "서비스 로직 오류",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class))),
		@ApiResponse(responseCode = "500", description = "내부 서버 오류",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomExceptionResponse.class)))
	})
	ResponseEntity<String> insertAccount(@RequestBody InsertAccountRequest request);
	

}
