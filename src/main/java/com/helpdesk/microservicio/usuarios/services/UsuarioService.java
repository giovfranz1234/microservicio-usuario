package com.helpdesk.microservicio.usuarios.services;

import com.helpdesk.microservicio.usuarios.models.Usuario;
import com.helpdesk.microservicio.usuarios.repositories.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> findAll();

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario usuario);
    public void deleteById(Long id);


}
