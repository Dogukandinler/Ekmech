package com.dodo.Ekmech.controller;

import com.dodo.Ekmech.dto.AuthResponseDto;
import com.dodo.Ekmech.dto.LoginRequestDto;
import com.dodo.Ekmech.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDto loginRequest) {
        try {
            System.out.println("Login denemesi: " + loginRequest.getEmail());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            System.out.println("Login başarılı: " + authentication.getName());

            String token = tokenProvider.generateToken(authentication.getName());
            return ResponseEntity.ok(new AuthResponseDto(token));

        } catch (BadCredentialsException ex) {
            System.out.println("Hatalı giriş: Geçersiz şifre!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Geçersiz email veya şifre");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sunucu hatası oluştu");
        }
    }
}