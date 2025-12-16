package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.Enrollment;
import com.salesianostriana.gestiondecursos.model.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
}
