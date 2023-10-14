package org.acme.repositories;

import java.util.List;
import java.util.UUID;

import org.acme.model.Payment;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositoryPayment implements PanacheRepository<Payment> {

    public Payment persistPayment(Payment entity) {
        persist(entity);

        return entity;
    }

    public List<Payment> listFull() {
        return listAll();
    }

    public Payment findById(String id) {
        return find("id", UUID.fromString(id)).firstResult();
    }

    public int update(String id) {
        return update("receipt = 'sandrolax' where id = ?1", UUID.fromString(id));
    }

    public long delete(String id) {
        return delete("id", UUID.fromString(id));
    }

}
