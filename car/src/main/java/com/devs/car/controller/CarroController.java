package com.devs.car.controller;

import com.devs.car.entity.Carro;
import com.devs.car.service.CarroService;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> obtenerAllCarros(){
        List<Carro> carro = carroService.getAll();
        if (carro.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carro);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarroPorId(@PathVariable("id")int id){
        Carro carro = carroService.getCarById(id);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);

    }
    @PostMapping
    public ResponseEntity<Carro> guardarCarros(@RequestBody Carro carro){
        Carro nuevoCarro = carroService.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarroPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Carro> carros = carroService.byUsuarioId(id);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }



}
