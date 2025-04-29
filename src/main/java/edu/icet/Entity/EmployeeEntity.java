package edu.icet.Entity;


import edu.icet.util.Department;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.time.LocalDateTime;

@Entity
@Table(name="employees")
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String nic;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;



}
