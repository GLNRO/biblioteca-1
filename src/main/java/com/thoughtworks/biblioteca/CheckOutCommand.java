package com.thoughtworks.biblioteca;

public class CheckOutCommand implements Command{

    private Biblioteca biblioteca;

    public CheckOutCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {

    }
}
