/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Jenna
 */
public class EmptyStringException extends IllegalArgumentException {
    private final static String MSG = "This string cannot be empty!";
    
    public EmptyStringException() {
        super(MSG);
    }

    public EmptyStringException(String s) {
        super(MSG);
    }

    public EmptyStringException(String message, Throwable cause) {
        super(MSG, cause);
    }

    public EmptyStringException(Throwable cause) {
        super(cause);
    }
    
}
