package com.dodo.Ekmech.service;

import com.dodo.Ekmech.dto.BakeryDto;
import com.dodo.Ekmech.exception.ResourceNotFoundException;
import com.dodo.Ekmech.model.Bakery;
import com.dodo.Ekmech.repository.BakeryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BakeryService {

    private final BakeryRepository bakeryRepository;

    public BakeryService(BakeryRepository bakeryRepository) {
        this.bakeryRepository = bakeryRepository;
    }

    public BakeryDto getBakeryById(Long id) {
        return bakeryRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Fırın bulunamadı, ID: " + id));
    }

    public BakeryDto createBakery(BakeryDto bakeryDto) {
        Bakery bakery = new Bakery(null, bakeryDto.getMail(), bakeryDto.getPassword(), bakeryDto.getName(), null, null, null);
        return convertToDto(bakeryRepository.save(bakery));
    }

    public BakeryDto updateBakery(Long id, BakeryDto bakeryDto) {
        Bakery bakery = bakeryRepository.findById(id).orElseThrow(() -> new RuntimeException("Bakery not found"));
        bakery.setMail(bakeryDto.getMail());
        bakery.setPassword(bakeryDto.getPassword());
        bakery.setName(bakeryDto.getName());
        return convertToDto(bakeryRepository.save(bakery));
    }


    private BakeryDto convertToDto(Bakery bakery) {
        return new BakeryDto(bakery.getId(), bakery.getMail(), bakery.getPassword(), bakery.getName(), null, null, null);
    }
}