package com.dodo.Ekmech.controller;

import com.dodo.Ekmech.dto.ServicesDto;
import com.dodo.Ekmech.service.ServicesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping
    public ResponseEntity<List<ServicesDto>> getAllServices() {
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesDto> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(servicesService.getServiceById(id));
    }

    @PostMapping
    public ResponseEntity<ServicesDto> createService(@RequestBody ServicesDto servicesDto) {
        return ResponseEntity.ok(servicesService.createService(servicesDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesDto> updateService(@PathVariable Long id, @RequestBody ServicesDto servicesDto) {
        return ResponseEntity.ok(servicesService.updateService(id, servicesDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
