package com.helpdesk.microservicio.usuarios.repositories;

import com.helpdesk.microservicio.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long> {

}
