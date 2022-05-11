package com.api.brekker.repository;

import com.api.brekker.entities.Colaborador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository  extends JpaRepository<Colaborador, Long>{
    boolean existsByCpf(String cpf);
}
