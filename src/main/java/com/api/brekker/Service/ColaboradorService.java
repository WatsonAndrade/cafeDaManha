package com.api.brekker.Service;

import java.util.List;
import java.util.Optional;

import com.api.brekker.entities.Colaborador;
import com.api.brekker.repository.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

  @Autowired
  private ColaboradorRepository colaboradorRepository;

  public List<Colaborador> findAll() {
    List<Colaborador> colab = colaboradorRepository.findAll();
    return colab;
  }

  public boolean existsUserById(Long id){
    return colaboradorRepository.existsById(id);
  }

  public Optional<Colaborador> findById(Long id){
    return colaboradorRepository.findById(id);
  }

  public boolean existsUserCpf(String cpf){
    return colaboradorRepository.existsByCpf(cpf);
  }

  public Colaborador createUser(Colaborador colaboradorAccount){
    Colaborador colaborador = colaboradorRepository.save(colaboradorAccount);
    return colaborador;
  }
}
