package com.helpdesk.microservicio.usuarios.controllers;

import com.helpdesk.microservicio.usuarios.models.Usuario;
import com.helpdesk.microservicio.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UsuarioController {
     @Autowired
    private UsuarioService usuarioService;

     @GetMapping
      public ResponseEntity<?> obtUsuarios(){
         return ResponseEntity.ok().body(usuarioService.findAll());
     }
     @GetMapping("/{id}")
     public ResponseEntity<?> obtUsuario(@PathVariable Long id){
         Optional<Usuario> o = usuarioService.findById(id);
         if (o.isEmpty()){
          return  ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(o.get());
     }
     @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario usuario){
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));

     }
     @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
         Optional<Usuario> usuariomod= usuarioService.findById(id);
         if (usuariomod.isEmpty()){
            return ResponseEntity.notFound().build();
         }
         Usuario usuarioDB = usuariomod.get();
         usuarioDB.setNombres(usuario.getNombres());
         usuarioDB.setPaterno(usuario.getPaterno());
         usuarioDB.setMaterno(usuario.getMaterno());
         usuarioDB.setCorreoElectronico(usuario.getCorreoElectronico());
         usuarioDB.setDocIdentidad(usuario.getDocIdentidad());
         usuarioDB.setEstado(usuario.getEstado());
         usuarioDB.setTelefono(usuario.getTelefono());
         usuarioDB.setRol(usuario.getRol());
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioDB));

     }
     @DeleteMapping("/{id}")
     public ResponseEntity<?> eliminar(@PathVariable Long id){
         usuarioService.deleteById(id);
         return ResponseEntity.noContent().build();

     }
}
