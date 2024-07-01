package dev.cb.store.business.service;

import dev.cb.store.business.model.Client;
import dev.cb.store.business.model.Status;
import dev.cb.store.persistence.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // basic CRUD
    public void save(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void update(Client client) {
        Optional<Client> optionalClient = clientRepository.findById(client.getId());
        optionalClient.ifPresent(fetchedClient -> {
            fetchedClient.update(client);
            clientRepository.update(fetchedClient);
        });
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
