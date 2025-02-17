package com.fpoly.chua_de_1.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@Table(name = "Ban")
@Data
@Builder
@NoArgsConstructor // Đảm bảo JPA có thể tạo đối tượng qua reflection
@AllArgsConstructor // Cung cấp constructor đầy đủ cho builder
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    private String code;

    @Column(name = "ten")
    private String name;

    @Column(name = "so_thich")
    private String favorite;

    @Column(name = "gioi_tinh")
    private Integer gender = 1;

    // @Column(name = "ngay_sinh")
    // private LocalDate ngaySinh;

    // @Column(name = "IdMQH")
    // private Integer idMQH;

    // @Column(name = "trang_thai")
    // private Integer trangThai;
}
