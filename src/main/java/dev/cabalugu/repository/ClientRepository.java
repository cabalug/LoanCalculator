package dev.cabalugu.repository;

import dev.cabalugu.model.Client;

import java.util.List;

public interface ClientRepository {

    void save(Client client);
    List<Client> findAll();
}
