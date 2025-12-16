package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
