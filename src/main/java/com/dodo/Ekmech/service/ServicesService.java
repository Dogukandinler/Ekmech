package com.dodo.Ekmech.service;

import com.dodo.Ekmech.dto.ServicesDto;
import com.dodo.Ekmech.model.Services;
import com.dodo.Ekmech.repository.ServicesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<ServicesDto> getAllServices() {
        return servicesRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ServicesDto getServiceById(Long id) {
        return servicesRepository.findById(id).map(this::convertToDto).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public ServicesDto createService(ServicesDto servicesDto) {
        Services services = new Services(null, servicesDto.getCustomerName(), servicesDto.getBalance(), null,
                servicesDto.getReturnedBreads(), servicesDto.getService1Quantity(), servicesDto.getService2Quantity(),
                servicesDto.getService3Quantity(), servicesDto.getService4Quantity(), servicesDto.getService5Quantity(),
                servicesDto.getPayment(), servicesDto.getServiceDate());
        return convertToDto(servicesRepository.save(services));
    }

    public ServicesDto updateService(Long id, ServicesDto servicesDto) {
        Services services = servicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
        services.setCustomerName(servicesDto.getCustomerName());
        services.setBalance(servicesDto.getBalance());
        services.setReturnedBreads(servicesDto.getReturnedBreads());
        services.setService1Quantity(servicesDto.getService1Quantity());
        services.setService2Quantity(servicesDto.getService2Quantity());
        services.setService3Quantity(servicesDto.getService3Quantity());
        services.setService4Quantity(servicesDto.getService4Quantity());
        services.setService5Quantity(servicesDto.getService5Quantity());
        services.setPayment(servicesDto.getPayment());
        services.setServiceDate(servicesDto.getServiceDate());
        return convertToDto(servicesRepository.save(services));
    }

    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

    private ServicesDto convertToDto(Services services) {
        return new ServicesDto(services.getId(), services.getCustomerName(), services.getBalance(),
                services.getReturnedBreads(), services.getService1Quantity(), services.getService2Quantity(),
                services.getService3Quantity(), services.getService4Quantity(), services.getService5Quantity(),
                services.getPayment(), services.getServiceDate());
    }
}
