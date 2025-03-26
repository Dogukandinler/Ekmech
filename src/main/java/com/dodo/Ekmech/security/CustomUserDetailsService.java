package com.dodo.Ekmech.security;

import com.dodo.Ekmech.model.Bakery;
import com.dodo.Ekmech.repository.BakeryRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final BakeryRepository bakeryRepository;

    public CustomUserDetailsService(BakeryRepository bakeryRepository) {
        this.bakeryRepository = bakeryRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Bakery bakery = bakeryRepository.findByEmail(email)
                .orElseThrow(() -> {
                    System.out.println("Kullanıcı bulunamadı: " + email);
                    return new UsernameNotFoundException("Kullanıcı bulunamadı: " + email);
                });

        System.out.println("Kullanıcı bulundu: " + bakery.getEmail());

        return User.builder()
                .username(bakery.getEmail())
                .password(bakery.getPassword())  // encode edilmiş şifre burada olmalı!
                .roles("USER")
                .build();
    }
}