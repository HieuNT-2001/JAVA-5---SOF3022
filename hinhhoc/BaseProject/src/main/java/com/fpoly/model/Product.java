package com.fpoly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products") // Chỉ định tên bảng là "products"
@Data
@Builder
@NoArgsConstructor  // Đảm bảo JPA có thể tạo đối tượng qua reflection
@AllArgsConstructor // Cung cấp constructor đầy đủ cho builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private double price;
}