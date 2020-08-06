package ar.com.ada.api.buques.controllers;

import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.buques.entities.Buque;
import ar.com.ada.api.buques.models.response.GenericResponse;
import ar.com.ada.api.buques.services.BuqueService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BuquesController {

    @Autowired
    BuqueService buqueService;

    @PostMapping("/buques")
    public ResponseEntity<GenericResponse> crearBuque(@RequestBody Buque buque) {

        boolean resultado = buqueService.crearBuque(buque);
        GenericResponse resp = new GenericResponse();

        if (resultado) {
            resp.isOk = true;
            resp.id = buque.get_id();
            resp.message = "Se creo buque correctamente";

            return ResponseEntity.ok(resp);
        }
        resp.isOk = false;
        resp.message = "no se pudo crear el buque";

        return ResponseEntity.badRequest().body(resp);
    }

    @GetMapping("/buques")
    public ResponseEntity<List<Buque>> listarBuques() {

        List<Buque> listaBuques = buqueService.listarBuques();

        return ResponseEntity.ok(listaBuques);
    }

}