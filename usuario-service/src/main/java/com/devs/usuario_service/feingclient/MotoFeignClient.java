package com.devs.usuario_service.feingclient;
import com.devs.moto.entity.Moto;
import com.devs.usuario_service.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(name = "moto", url = "http://localhost:8003")
@RequestMapping("/moto")
public interface MotoFeignClient {

    @PostMapping()
    public Moto save(@RequestBody Moto moto);

    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);



}
