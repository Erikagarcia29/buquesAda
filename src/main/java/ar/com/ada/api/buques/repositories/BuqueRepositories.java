package ar.com.ada.api.buques.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.buques.entities.Buque;

@Repository
public interface BuqueRepository extends MongoRepository<Buque, ObjectId> {

    Buque findBy_id(ObjectId id);
}