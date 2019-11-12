package com.example.question.service.impl;

import com.example.question.entity.Product;
import com.example.question.mapper.ProductMapper;
import com.example.question.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }
}
