package com.devs.usuario_service.feingclient;

import com.devs.car.entity.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car", url = "http://localhost:8002")
@RequestMapping("/carro")
public interface CarFeingClient {

     @PostMapping()
     public Carro save(@RequestBody Carro carro);

     @GetMapping("/usuario/{usuarioId}")
     public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
