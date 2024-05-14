package dev.cabalugu.ui;

import dev.cabalugu.model.Client;
import dev.cabalugu.repository.IClientRepository;
import dev.cabalugu.repository.impl.ClientRepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMenu {
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static final IClientRepository clientRepository = new ClientRepositoryImpl();

    public static void showWelcome() {
        System.out.println("=======================================================================================================");
        System.out.println("Welcome to Loan Calculator!");
        System.out.println("=======================================================================================================");
    }

    public static void showMenu() {
        System.out.println("Client Menu");
        System.out.println("1. Show all Clients");
        System.out.println("2. Add a new Client");
        System.out.println("0. Exit");
    }

    public static int getOption() throws IOException {
        System.out.print("Enter your choice: ");
        return Integer.parseInt(buffer.readLine());
    }

    public static void processOption(int option) throws IOException {
        switch (option) {
            case 1:
                showAllClients();
                break;
            case 2:
                addNewClient();
                break;
            case 0:
                System.out.println("Thank you for using the Loan Calculator. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please select a valid option.");
                break;
        }
    }

    private static void showAllClients() {
        String tableFormat = "| %-20s | %-20s | %-20s | %-30s |\n";
        System.out.println("=======================================================================================================");
        System.out.println("List of all clients");
        System.out.println("=======================================================================================================");
        System.out.print("+----------------------+----------------------+----------------------+--------------------------------+\n");
        System.out.printf(tableFormat, "Identification", "Full Name", "Phone Number", "Email");
        System.out.print("+----------------------+----------------------+----------------------+--------------------------------+\n");
        for (Client client : clientRepository.findAll()) {
            System.out.printf(tableFormat,
                    client.getIdentification(),
                    client.getFirstName() + " " + client.getLastName(),
                    client.getPhoneNumber(),
                    client.getEmail());
        }
        System.out.print("+----------------------+----------------------+----------------------+--------------------------------+\n");
    }

    private static void addNewClient() throws IOException {
        System.out.println("=======================================================================================================");
        System.out.println("Register a new Client");
        System.out.println("=======================================================================================================");
        Client client = new Client();
        client.setIdentification(getClientInput("Get the identification: "));
        client.setFirstName(getClientInput("Get the first name: "));
        client.setLastName(getClientInput("Get the last name: "));
        client.setPhoneNumber(getClientInput("Get the phone number: "));
        client.setEmail(getClientInput("Get the email: "));

        clientRepository.save(client);
        System.out.println("=======================================================================================================");
        System.out.println("Client created successfully");
        System.out.println("=======================================================================================================");
    }

    private static String getClientInput(String message) throws IOException {
        String input;
        do {
            System.out.print(message);
            input = buffer.readLine();
        } while (input.isEmpty());
        return input;
    }
}
