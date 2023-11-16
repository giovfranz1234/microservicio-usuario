package com.helpdesk.microservicio.usuarios.controllers;

import com.helpdesk.microservicio.usuarios.models.Usuario;
import com.helpdesk.microservicio.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/HelpDesk")
@CrossOrigin
public class UsuarioController {
     @Autowired
    private UsuarioService usuarioService;

     @GetMapping("/usuarios")
      public ResponseEntity<?> obtUsuarios(){
         return ResponseEntity.ok().body(usuarioService.findAll());
     }
     @GetMapping("/usuario/{id}")
     public ResponseEntity<?> obtUsuario(@PathVariable Long id){
         Optional<Usuario> o = usuarioService.findById(id);
         if (o.isEmpty()){
          return  ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(o.get());
     }
     @PostMapping("/crearUs")
    public ResponseEntity<?> crear(@RequestBody Usuario usuario){
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));

     }
     @PutMapping("/actualizarUS/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
         Optional<Usuario> usuariomod= usuarioService.findById(id);
         if (usuariomod.isEmpty()){
            return ResponseEntity.notFound().build();
         }
         Usuario usuarioDB = usuariomod.get();
         usuario.setNombres(usuarioDB.getNombres());
         usuario.setPaterno(usuarioDB.getPaterno());
         usuario.setMaterno(usuarioDB.getMaterno());
         usuario.setCorreoElectronico(usuarioDB.getCorreoElectronico());
         usuario.setDocIdentidad(usuarioDB.getDocIdentidad());
         usuario.setEstado(usuarioDB.getEstado());
         usuario.setTelefono(usuarioDB.getTelefono());
         usuario.setRol(usuarioDB.getRol());
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioDB));

     }
     @DeleteMapping("/borrarUS/{id}")
     public ResponseEntity<?> eliminar(@PathVariable Long id){
         usuarioService.deleteById(id);
         return ResponseEntity.noContent().build();

     }
}
