package dev.cabalugu.ui;

public enum MenuOption {
    SHOW_ALL_CLIENTS(1, "Show all Clients"),
    ADD_A_NEW_CLIENT(2, "Add a new Client"),
    EXIT(0, "Exit");

    private Integer option;
    private String description;

    MenuOption(Integer option, String description) {
        this.option = option;
        this.description = description;
    }

    public Integer getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
