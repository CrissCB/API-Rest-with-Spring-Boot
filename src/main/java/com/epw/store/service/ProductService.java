package com.epw.store.service;

import java.util.List;

import com.epw.store.dto.CreateProductRequest;
import com.epw.store.dto.ProductResponse;
import com.epw.store.dto.UpdateProductRequest;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);
    List<ProductResponse> list();
    ProductResponse getById(Long id);
    ProductResponse update(Long id, UpdateProductRequest request);
    void delete(Long id);
}
