package ar.com.ada.api.buques.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Puerto;
import ar.com.ada.api.buques.repositories.PuertoRepository;

@Service
public class PuertoService {
    @Autowired
    PuertoRepository puertoRepository;

    public boolean crearPuerto(Puerto puerto) {
        // Logica si se crea o no en la base de datos.
        puertoRepository.save(puerto);

        if (puerto.get_id() == null) {

            return false;
        }
        return true;

    }

    public List<Puerto> listarPuertos() {
        return puertoRepository.findAll();
    }
    public Puerto buscarPorNumero(Integer numeroPuerto) {
        return puertoRepository.findByNumero(numeroPuerto);
    }
}