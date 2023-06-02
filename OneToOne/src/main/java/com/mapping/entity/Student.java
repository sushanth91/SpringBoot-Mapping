package com.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "jpa_student" )
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String about;
    @OneToOne(mappedBy ="student", cascade = CascadeType.ALL)
    private Laptop laptop;

}
