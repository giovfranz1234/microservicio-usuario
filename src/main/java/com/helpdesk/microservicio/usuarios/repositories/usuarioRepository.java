package com.helpdesk.microservicio.usuarios.repositories;

import com.helpdesk.microservicio.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {

}
