package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
