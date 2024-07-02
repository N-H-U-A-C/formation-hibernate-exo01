package dev.cb.store.presentation;

import dev.cb.store.business.model.Client;
import dev.cb.store.business.service.ClientService;

import java.util.HashMap;
import java.util.Optional;

public class ClientMenu extends Menu {

    private ClientService clientService;

    public ClientMenu(ClientService clientService) {
        super();
        this.clientService = clientService;
        this.actions = new HashMap<>();
        actions.put(1, this::create);
        actions.put(2, this::read);
        actions.put(3, this::readAll);
        actions.put(4, this::update);
        actions.put(5, this::delete);
        actions.put(6, () -> this.changeActualMenu(0));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.entityName = "Client";
        this.menuText = """
                \n=== Manage clients ===
                                
                1. Add a client
                2. Display a client (by id)
                3. Display all clients
                4. Update a client
                5. Delete a client
                6. Return to main menu
                0. Exit
                """;
    }

    private void delete() {
        Optional<Client> optionalClient = clientService.getById(this.inputId());
        optionalClient.ifPresentOrElse(
                client -> this.clientService.delete(client),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void update() {
        Optional<Client> optionalClient = clientService.getById(this.inputId());
        optionalClient.ifPresentOrElse(
                client -> this.clientService.update(this.inputUpdatedClient(client)),
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void readAll() {
        this.clientService.getAll().forEach(System.out::println);
    }

    private void read() {
        Optional<Client> optionalClient = this.clientService.getById(this.inputId());
        optionalClient.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(this.entityName + " not found")
        );
    }

    private void create() {
        this.clientService.save(this.inputNewClient());
    }

    protected Long inputId() {
        return Long.valueOf(Ihm.readInput(this.entityName.toLowerCase(), "id"));
    }

    private Client inputNewClient() {
        Client client = new Client();
        client.setFirstName(Ihm.readInput(this.entityName.toLowerCase(), "first name"));
        client.setLastName(Ihm.readInput(this.entityName.toLowerCase(), "last name"));
        client.setEmail(Ihm.readInput(this.entityName.toLowerCase(), "email"));
        return client;
    }

    private Client inputUpdatedClient(Client client) {
        System.out.println("= Current client =");
        System.out.println("\nCurrent first name: " + client.getFirstName());
        client.setFirstName(Ihm.readInput(this.entityName.toLowerCase(), "first name"));
        System.out.println("\nCurrent last name: " + client.getLastName());
        client.setLastName(Ihm.readInput(this.entityName.toLowerCase(), "last name"));
        System.out.println("\nCurrent email: " + client.getEmail());
        client.setEmail(Ihm.readInput(this.entityName.toLowerCase(), "email"));
        return client;
    }
}
