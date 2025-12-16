package com.salesianostriana.gestiondecursos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name,description;


    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    private Set<Course> courses = new HashSet<>();
}
