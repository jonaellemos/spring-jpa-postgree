package com.cadastro.usuario.controller;

import com.cadastro.usuario.entity.Usuario;
import com.cadastro.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> list () throws IOException {
        return usuarioService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Usuario> one(@PathVariable Long id) throws IOException {
        return usuarioService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(Long id){
        usuarioService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity salvar(@RequestBody final Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(CREATED).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void atualizar(@RequestBody final Usuario usuario){
        usuarioService.atualizar(usuario);
    }


}
