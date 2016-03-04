package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutCommandTest {
    @Test
    public void shouldCheckOutBookFromBibliotecaWhenExecuting(){
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutCommand checkOutCommand = new CheckOutCommand(biblioteca);
        checkOutCommand.execute();
        verify(biblioteca).checkOutBook();
    }


}