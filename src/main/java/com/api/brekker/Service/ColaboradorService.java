package com.api.brekker.Service;

import java.util.List;

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
}
