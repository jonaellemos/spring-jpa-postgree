package com.cadastro.usuario.service;

import com.cadastro.usuario.entity.Usuario;
import com.cadastro.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> getAll() throws IOException {
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public Optional<Usuario> getUserById(Long id) throws IOException{
       Optional<Usuario> usuario = Optional.of(new Usuario());

        return usuario = repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void salvar(Usuario usuario){
        repository.save(usuario);
    }

    public void atualizar(Usuario usuario){
        repository.save(usuario);
    }


}
