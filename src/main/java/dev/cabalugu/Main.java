package dev.cabalugu;

import dev.cabalugu.ui.MenuOption;

import java.io.IOException;

import static dev.cabalugu.ui.ClientMenu.*;
import static dev.cabalugu.ui.MenuOption.EXIT;

public class Main {
    public static void main(String[] args) throws IOException {

        MenuOption option;
        showWelcome();
        do {
            showMenu();
            option = getOption();
            processOption(option);
        } while (option != EXIT);
    }
}