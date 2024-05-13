package dev.cabalugu;

import dev.cabalugu.model.Client;
import dev.cabalugu.repository.ClientRepository;
import dev.cabalugu.repository.impl.ClientRepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        ClientRepository clientRepository = new ClientRepositoryImpl();
        boolean exit = false;
        int opction;

        System.out.println("============================");
        System.out.println("Welcome to Loan Calculator!");
        System.out.println("============================");

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Create Client");
            System.out.println("2. List clients");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            opction = Integer.parseInt(bufer.readLine());

            switch (opction) {
                case 1:
                    System.out.println("=======================================================================================================");
                    System.out.println("Create Client");
                    System.out.println("=======================================================================================================");
                    Client client = new Client();

                    do {
                        System.out.print("Get the client identification: ");
                        client.setIdentification(bufer.readLine());
                    } while (client.getIdentification().isEmpty());

                    do {
                        System.out.print("Get the client first name: ");
                        client.setFirstName(bufer.readLine());
                    } while (client.getFirstName().isEmpty());

                    do {
                        System.out.print("Get the client last name: ");
                        client.setLastName(bufer.readLine());
                    } while (client.getLastName().isEmpty());

                    do {
                        System.out.print("Get the client phone number: ");
                        client.setPhoneNumber(bufer.readLine());
                    } while (client.getPhoneNumber().isEmpty());

                    do {
                        System.out.print("Get the client email: ");
                        client.setEmail(bufer.readLine());
                    } while (client.getEmail().isEmpty());

                    clientRepository.save(client);
                    System.out.println("Client created successfully");
                    break;
                case 2:
                    System.out.println("=======================================================================================================");
                    System.out.println("List clients");
                    System.out.println("=======================================================================================================");
                    System.out.printf("| %-20s | %-20s | %-20s | %-30s |\n", "Identification","Full Name", "Phone Number", "Email");
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    for (Client client1: clientRepository.findAll()){
                        System.out.printf("| %-20s | %-20s | %-20s | %-30s |\n", client1.getIdentification(), client1.getFirstName()+" "+client1.getLastName(), client1.getPhoneNumber(), client1.getEmail());
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    break;
                case 0:
                    System.out.println("=======================================================================================================");
                    System.out.println("Bye!");
                    System.out.println("=======================================================================================================");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!exit);
    }
}