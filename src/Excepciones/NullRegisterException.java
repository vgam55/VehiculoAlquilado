/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import java.util.Collections;

/**
 *
 * @author VictorManuel
 */
public class NullRegisterException extends Exception {

    /**
     * Creates a new instance of <code>NullRegisterException</code> without
     * detail message.
     */
    public NullRegisterException() {
    }

    /**
     * Constructs an instance of <code>NullRegisterException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NullRegisterException(String msg) {
        super(msg);
    }
    
    public void devolucionNula(Object objeto) throws NullRegisterException
    {
        if(objeto==null)
            throw new NullRegisterException("No se encontraron resultados en la selección");
    }
}
