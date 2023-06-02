package com.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "jpa_laptops")
public class Laptop {
    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
