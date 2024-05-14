package dev.cabalugu.repository;

import dev.cabalugu.model.Client;

import java.util.List;

public interface IClientRepository {

    void save(Client client);

    List<Client> findAll();
}
