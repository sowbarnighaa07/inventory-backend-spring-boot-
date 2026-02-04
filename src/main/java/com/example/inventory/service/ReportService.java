package com.example.inventory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;

@Service
public class ReportService {

    private final ProductRepository repo;

    public ReportService(ProductRepository repo) {
        this.repo = repo;
    }

    public long totalProducts() {
        return repo.count();
    }

    public int totalStock() {
        return repo.findAll()
                   .stream()
                   .mapToInt(Product::getQuantity)
                   .sum();
    }

    public long lowStockCount() {
        return repo.findByQuantityLessThanEqual(5).size();
    }
}
