package dev.cabalugu;

import java.io.IOException;

import static dev.cabalugu.ui.ClientMenu.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int option;
        showWelcome();
        do {
            showMenu();
            option = getOption();
            processOption(option);
        } while (option != 0);
    }
}