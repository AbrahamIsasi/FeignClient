package com.devs.usuario_service.repository;

import com.devs.usuario_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository <Usuario, Integer> {
}
