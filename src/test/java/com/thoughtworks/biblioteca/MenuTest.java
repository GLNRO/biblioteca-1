package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private Biblioteca biblioteca;
    private QuitCommand quitCommand;
    private BufferedReader reader;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        quitCommand = mock(QuitCommand.class);
        reader = mock(BufferedReader.class);
        menu = new Menu(printStream,reader, biblioteca, quitCommand);
    }

    @Test
    public void shouldDisplayMenuAfterStart() throws IOException {
        when(reader.readLine()).thenReturn("1") ;
        menu.showMenu();
        verify(printStream).println(contains("1. List Books"));
        verify(printStream).println(contains("2. Quit"));
    }

    @Test
    public void shouldListBooksWhenUserEnters1AfterMenuDisplayed() throws IOException {
        when(reader.readLine()).thenReturn("1") ;
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldGiveErrorMessageWhenUserEntersInvalidInput() throws IOException {
        when(reader.readLine()).thenReturn("1000").thenReturn("1");
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldExitBibliotecaWhenUserEntersQuit() throws IOException {
        when(reader.readLine()).thenReturn("2");
        when(quitCommand.getShouldRun()).thenReturn(true).thenReturn(false);
        menu.handleOptions();

        verify(quitCommand).execute();
    }


}