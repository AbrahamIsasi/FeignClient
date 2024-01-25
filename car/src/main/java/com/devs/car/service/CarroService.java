package com.devs.car.service;

import com.devs.car.entity.Carro;
import com.devs.car.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAll(){
       return carroRepository.findAll();
    }
    public Carro getCarById(int id){
        return carroRepository.findById(id).orElse(null);
    }
    public Carro save(Carro carro){
        Carro nuevoCarro = carroRepository.save(carro);
        return nuevoCarro;

    }
    public List<Carro> byUsuarioId(int usuarioId){
        return carroRepository.findByUsuario(usuarioId);
    }
}
