package com.api.brekker.Controller;

import java.util.List;

import com.api.brekker.Service.ColaboradorService;
import com.api.brekker.entities.Colaborador;
import com.api.brekker.repository.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/user")
    public List<Colaborador> findAll(){
		List<Colaborador> colab = colaboradorService.findAll();
        return colab;
	}
}
