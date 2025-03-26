package com.dodo.Ekmech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
    private List<String> stackTrace; // 🔹 Stack trace ekledik
}