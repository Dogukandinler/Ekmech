package com.dodo.Ekmech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
}
