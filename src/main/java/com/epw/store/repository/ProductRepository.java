package com.epw.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.store.entity.Product;

// Repository interface for Product entity, extending JpaRepository to provide CRUD operations and more
public interface ProductRepository extends JpaRepository<Product, Long>{    
}
