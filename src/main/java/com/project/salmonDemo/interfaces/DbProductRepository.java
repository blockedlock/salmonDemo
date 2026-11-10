package com.project.salmonDemo.interfaces;

import com.project.salmonDemo.classes.DbProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbProductRepository extends JpaRepository<DbProduct, Long> {
}