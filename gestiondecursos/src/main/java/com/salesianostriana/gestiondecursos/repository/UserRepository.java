package com.salesianostriana.gestiondecursos.repository;

import com.salesianostriana.gestiondecursos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    Optional<User> findByEmail(String email);

}
