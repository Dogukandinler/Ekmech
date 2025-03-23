package com.dodo.Ekmech.controller;

import com.dodo.Ekmech.dto.BakeryDto;
import com.dodo.Ekmech.service.BakeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakeries")
public class BakeryController {

    private final BakeryService bakeryService;

    public BakeryController(BakeryService bakeryService) {
        this.bakeryService = bakeryService;
    }

    @GetMapping
    public ResponseEntity<BakeryDto> getBakeryById(@RequestParam Long id) {
        return ResponseEntity.ok(bakeryService.getBakeryById(id));
    }

    @PostMapping
    public ResponseEntity<BakeryDto> createBakery(@RequestBody BakeryDto bakeryDto) {
        return ResponseEntity.ok(bakeryService.createBakery(bakeryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BakeryDto> updateBakery(@PathVariable Long id, @RequestBody BakeryDto bakeryDto) {
        return ResponseEntity.ok(bakeryService.updateBakery(id, bakeryDto));
    }

}
