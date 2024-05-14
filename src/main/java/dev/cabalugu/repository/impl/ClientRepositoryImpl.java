package dev.cabalugu.repository.impl;

import dev.cabalugu.model.Client;
import dev.cabalugu.repository.IClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements IClientRepository {

    private List<Client> database;

    public ClientRepositoryImpl() {
        database = new ArrayList<>();
    }

    @Override
    public void save(Client client) {
        database.add(client);
    }

    @Override
    public List<Client> findAll() {
        return database;
    }
}
