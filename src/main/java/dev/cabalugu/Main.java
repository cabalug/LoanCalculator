package dev.cabalugu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
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
                    System.out.println("============================");
                    System.out.println("Create Client");
                    System.out.println("============================");
                    break;
                case 2:
                    System.out.println("============================");
                    System.out.println("List clients");
                    System.out.println("============================");
                    break;
                case 0:
                    System.out.println("============================");
                    System.out.println("Bye!");
                    System.out.println("============================");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!exit);
    }
}