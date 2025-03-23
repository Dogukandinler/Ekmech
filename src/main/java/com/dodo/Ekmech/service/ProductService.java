package com.dodo.Ekmech.service;

import com.dodo.Ekmech.dto.ProductDto;
import com.dodo.Ekmech.model.Product;
import com.dodo.Ekmech.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) {
        return productRepository.findById(id).map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product(null, productDto.getName(), productDto.getPrice(), productDto.getWeight(), null);
        return convertToDto(productRepository.save(product));
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        return convertToDto(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    private ProductDto convertToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getWeight());
    }
}
