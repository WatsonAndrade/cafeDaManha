package com.api.brekker.Controller;

import java.util.List;

import javax.validation.Valid;

import com.api.brekker.Service.ColaboradorService;
import com.api.brekker.entities.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        if(colaboradorService.existsUserById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado no banco de dados!");
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody @Valid Colaborador colaborador){
        if(colaboradorService.existsUserCpf(colaborador.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cpf cadastrado no banco de dados");
        }
        else if(colaboradorService.existsByComida(colaborador.getComida())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Comida ja solicitada por outro Colaborador, por favor escolher outra opção!");
        }
            return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.createUser(colaborador));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody @Valid Colaborador colaborador){
        if(colaboradorService.existsByComida(colaborador.getComida())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Comida ja solicitada por outro Colaborador, por favor escolher outra opção!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.updateComida(id, colaborador));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteColaborador(@PathVariable Long id){
        if(colaboradorService.existsUserById(id)){
            colaboradorService.deleteColaborador(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado da lista do café da manhã");
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado na lista");
    }
}
