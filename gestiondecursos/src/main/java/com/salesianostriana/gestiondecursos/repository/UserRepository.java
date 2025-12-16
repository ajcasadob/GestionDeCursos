package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
