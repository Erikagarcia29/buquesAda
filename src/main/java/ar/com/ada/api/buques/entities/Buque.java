package ar.com.ada.api.buques.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buques")
public class Buque {

    private ObjectId _id;
    private String matricula;
    private String nombre;

    public String get_id() {

        if (_id == null) {
            return null;
        }
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}