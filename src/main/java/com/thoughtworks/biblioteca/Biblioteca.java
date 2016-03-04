package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class Biblioteca {

    private BufferedReader reader;
    private PrintStream printStream;
    private List<Book> listOfBooks;


    public Biblioteca(PrintStream printStream, List<Book> listOfBooks) {
        this.printStream = printStream;
        this.listOfBooks = listOfBooks;
    }

    public void greetCustomer() {

        printStream.println("Welcome");
    }

    public void listBooks() {
        for (Book book: listOfBooks){
            book.print();
        }
    }



}
