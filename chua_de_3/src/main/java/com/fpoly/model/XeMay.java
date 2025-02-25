package com.fpoly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "XeMay")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XeMay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Ma")
    private String code;

    @Column(name = "Ten")
    private String name;

    @Column(name = "Mota")
    private String description;

    @Column(name = "SoLuong")
    private int quantity;

}
