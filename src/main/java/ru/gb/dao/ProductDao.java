package ru.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Product;


public interface ProductDao extends JpaRepository<Product, Long> {
}
