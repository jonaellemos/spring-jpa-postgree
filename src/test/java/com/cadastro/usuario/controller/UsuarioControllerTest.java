package com.cadastro.usuario.controller;

import com.cadastro.usuario.entity.Usuario;
import com.cadastro.usuario.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    private Usuario usuarioIn;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario();
        usuario.setEndereco("Rua Franco s221");
        usuario.setNome("Usuario Teste");
        usuario.setEmail("teste@teste.com");
        usuario.setTelefone("85888888888");

        usuarioIn = usuario;
    }

    @Test
    void salvar() {
        var response = assertDoesNotThrow(() -> usuarioController.salvar(usuarioIn));
        assertEquals(ResponseEntity.status(CREATED).build(), response);
    }

    @Test
    void list() {
        var response = assertDoesNotThrow(() -> usuarioController.list());
        assertNotEquals("[]", response);
    }

    @Test
    void one() {
        var response = assertDoesNotThrow(() -> usuarioController.one(1L));
        assertEquals(Optional.empty(), response);
    }

    @Test
    void deletar() {
    }

    @Test
    void atualizar() {
    }
}