package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private BufferedReader reader;
    private QuitCommand quitCommand;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Map<String,Command> options;

    public Menu(PrintStream printStream, BufferedReader reader, Biblioteca biblioteca, QuitCommand quitCommand) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = reader;
        this.quitCommand = quitCommand;
        this.options = new HashMap<>();
        addOptionCommands();
    }

    private void addOptionCommands(){
        options.put("1", new ListBooks(biblioteca));
        options.put("2", quitCommand);
    }

    public void handleOptions() throws IOException {

        showMenu();
        while (quitCommand.getShouldRun()){
            String input = reader.readLine();
            if (options.containsKey(input)){
                options.get(input).execute();
            }
            else {
                printStream.println("Select a valid option!");
            }
        }

    }


    public void showMenu() {
        printStream.println("1. List Books");
        printStream.println("2. Quit");
    }
}
