package com.dodo.Ekmech.service;

import com.dodo.Ekmech.dto.BakeryDto;
import com.dodo.Ekmech.exception.ResourceNotFoundException;
import com.dodo.Ekmech.model.Bakery;
import com.dodo.Ekmech.repository.BakeryRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BakeryService {

    private final BakeryRepository bakeryRepository;
    private final PasswordEncoder passwordEncoder;

    public BakeryService(BakeryRepository bakeryRepository, PasswordEncoder passwordEncoder) {
        this.bakeryRepository = bakeryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public BakeryDto getBakeryById(Long id) {
        return bakeryRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Fırın bulunamadı, ID: " + id));
    }

    public BakeryDto createBakery(BakeryDto bakeryDto) {
        String encodedPassword = passwordEncoder.encode(bakeryDto.getPassword());
        Bakery bakery = new Bakery(null, bakeryDto.getEmail(), encodedPassword, bakeryDto.getName(), null, null, null);
        return convertToDto(bakeryRepository.save(bakery));
    }

    public BakeryDto updateBakery(Long id, BakeryDto bakeryDto) {
        Bakery bakery = bakeryRepository.findById(id).orElseThrow(() -> new RuntimeException("Bakery not found"));
        bakery.setEmail(bakeryDto.getEmail());
        bakery.setPassword(bakeryDto.getPassword());
        bakery.setName(bakeryDto.getName());
        return convertToDto(bakeryRepository.save(bakery));
    }


    private BakeryDto convertToDto(Bakery bakery) {
        return new BakeryDto(bakery.getId(), bakery.getEmail(),  bakery.getName(), bakery.getPassword(),null, null, null);
    }
}