package com.devs.usuario_service.service;

import com.devs.car.entity.Carro;
import com.devs.moto.entity.Moto;
import com.devs.usuario_service.feingclient.CarFeingClient;
import com.devs.usuario_service.feingclient.MotoFeignClient;
import com.devs.usuario_service.model.Usuario;
import com.devs.usuario_service.repository.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired
    private CarFeingClient carFeingClient;

    @Autowired
    private MotoFeignClient motoFeignClient;



    public List<Usuario> getAll (){
        return usuarioRespository.findAll();
    }
    public Usuario findById (int id){
        return usuarioRespository.findById(id).orElse(null);
    }

    public Usuario save (Usuario usuario){
        Usuario nuevoUsuario = usuarioRespository.save(usuario);
        return nuevoUsuario;
     }
    public Carro saveCarro(int usuarioId, Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carFeingClient.save(carro);
        return nuevoCarro;
    }

    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto nuevaMoto = motoFeignClient.save(moto);
        return nuevaMoto;
    }
    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {
        Map<String, Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRespository.findById(usuarioId).orElse(null);

        if (usuario == null) {
            resultado.put("Mensaje", "El usuario no existe");
        }
        resultado.put("Usuario", usuario);
        List<Carro> carros = carFeingClient.getCarros(usuarioId);

        if (carros.isEmpty()) {
            resultado.put("Carros", "El usuario no tiene carros");
        } else {
            resultado.put("Carros", carros);
        }
        List<Moto> motos = motoFeignClient.getMotos(usuarioId);
        if (motos.isEmpty()){
            resultado.put("Motos", "El usuario no tiene motos");
        }else {
            resultado.put("Motos", motos);
        }
        return resultado;
    }


}
