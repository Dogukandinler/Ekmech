package com.dodo.Ekmech.exception;

import com.dodo.Ekmech.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 📌 Özel hatalar için ayrı handler'lar
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now(), null));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> handleBadCredentials(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponseDto(HttpStatus.UNAUTHORIZED.value(), "Geçersiz email veya şifre.", LocalDateTime.now(), null));
    }

    // 📌 Genel hata yakalama - stack trace ile
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex) {
        ex.printStackTrace(); // Konsola detaylı hata mesajı yazdır
        List<String> stackTrace = Arrays.stream(ex.getStackTrace())
                .limit(5) // Stack trace'i çok uzun olmaması için 5 satır ile sınırlandırdık.
                .map(StackTraceElement::toString)
                .toList();

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(), // Gerçek hata mesajını ekleyelim
                LocalDateTime.now(),
                stackTrace // Stack trace'in ilk 5 satırını ekliyoruz
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
