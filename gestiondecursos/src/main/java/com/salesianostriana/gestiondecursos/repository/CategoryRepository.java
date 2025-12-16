package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
