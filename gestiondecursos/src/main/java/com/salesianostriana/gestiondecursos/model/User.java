package com.salesianostriana.gestiondecursos.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre, password;


    private String email;


    @Enumerated(EnumType.STRING)
    private UserRole role;


    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor")
    @Builder.Default
    @ToString.Exclude
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private Set<Enrollment> enrollments = new HashSet<>();



}
