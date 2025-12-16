package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
