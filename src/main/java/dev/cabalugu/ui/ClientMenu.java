package dev.cabalugu.ui;

import dev.cabalugu.model.Client;
import dev.cabalugu.repository.IClientRepository;
import dev.cabalugu.repository.impl.ClientRepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static dev.cabalugu.ui.MenuOption.*;

public class ClientMenu {
    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    private static final IClientRepository clientRepository = new ClientRepositoryImpl();

    public static void showWelcome() {
        System.out.println("=======================================================================================================");
        System.out.println("Welcome to Loan Calculator!");
        System.out.println("=======================================================================================================");
    }

    public static void showMenu() {
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getOption() + ". " + option.getDescription());
        }
    }

    public static MenuOption getOption() throws IOException {
        Integer choice = Integer.parseInt(getClientInput("Enter your choice: "));

        MenuOption selectedOption = null;
        for (MenuOption option : MenuOption.values()) {
            if (choice.equals(option.getOption())) {
                selectedOption = option;
                break;
            }
        }
        return selectedOption;
    }

    public static void processOption(MenuOption option) throws IOException {
        switch (option) {
            case SHOW_ALL_CLIENTS:
                showAllClients();
                break;
            case ADD_A_NEW_CLIENT:
                addNewClient();
                break;
            case EXIT:
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
