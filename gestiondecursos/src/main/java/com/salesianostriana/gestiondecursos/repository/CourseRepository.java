package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByCategoryId(Long categoryId);

}
