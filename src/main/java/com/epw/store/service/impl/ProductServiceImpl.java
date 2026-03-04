package com.epw.store.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.store.dto.CreateProductRequest;
import com.epw.store.dto.ProductResponse;
import com.epw.store.dto.UpdateProductRequest;
import com.epw.store.entity.Product;
import com.epw.store.exception.ResourceNotFoundException;
import com.epw.store.repository.ProductRepository;
import com.epw.store.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository repository;
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductResponse create(CreateProductRequest request) {
        Product p = new Product();
        p.setName(request.getName());
        p.setDescription(request.getDescription());
        p.setPrice(request.getPrice());
        p.setStock(request.getStock());
        Product saved = repository.save(p);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not found"));
        return toResponse(p);
    }

    @Override
    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not found"));

        p.setName(request.getName());
        p.setDescription(request.getDescription());

        if (request.getPrice() != null) {
            p.setPrice(request.getPrice());
        }
        if (request.getStock() != null) {
            p.setStock(request.getStock());
        }

        return toResponse(repository.save(p));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product " + id + " not found");
        }
        repository.deleteById(id);
    }

    private ProductResponse toResponse(Product p) {
        ProductResponse r = new ProductResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setPrice(p.getPrice());
        r.setStock(p.getStock());
        r.setCreatedAt(p.getCreatedAt());
        return r;
    }

}
