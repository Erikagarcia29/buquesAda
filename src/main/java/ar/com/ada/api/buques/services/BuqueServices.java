package ar.com.ada.api.buques.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Buque;
import ar.com.ada.api.buques.repositories.BuqueRepository;

@Service
public class BuqueService {

    @Autowired
    BuqueRepository repo;

    @Autowired
    PuertoService puertoService;

    public boolean crearBuque(Buque buque) {
        repo.save(buque);

        if (buque.get_id() == null) {
            return false;
        }
        return true;
    }

    public List<Buque> listarBuques() {
        return repo.findAll();
    }
    public boolean crearViaje(String id, Date fechaViaje, Date fechaSalida, Date fechaLlegada) {

        Viaje viaje = new Viaje();
        Buque buque = repo.findBy_id(new ObjectId(id));

        viaje.setFechaLlegada(fechaLlegada);
        viaje.setFechaSalida(fechaSalida);
        viaje.setFechaViaje(fechaViaje);

        buque.agregarViaje(viaje);
        repo.save(buque);
        return true;
    }

    public boolean cargarContenedor(String idBuque, Date fechaViaje, Integer contenedorId, Double peso,
            Integer numeroPuerto) {

        Contenedor contenedor = new Contenedor();
        contenedor.setContenedorId(contenedorId);
        contenedor.setPeso(peso);
        Puerto puerto = puertoService.buscarPorNumero(numeroPuerto);
        contenedor.setPuerto(puerto);
        Buque buque = repo.findBy_id(new ObjectId(idBuque));
        Viaje viaje = buque.buscarViaje(fechaViaje);
        boolean resultado = viaje.agregarContenedor(contenedor);

        if (resultado) {
            repo.save(buque);
            return true;
        }

        return false;

    }

}