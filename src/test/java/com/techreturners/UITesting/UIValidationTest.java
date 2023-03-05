package com.techreturners.UITesting;

import com.techreturners.UI.UIValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UIValidationTest {
    /*
    Name Validations
     */
    @Test
    public void canEnterAnyLengthOfName(){
        assertTrue(UIValidation.isValidName("D"));
        assertTrue(UIValidation.isValidName("Debbie"));
    }

    @Test
    public void nameCannotBeEmpty(){
        assertFalse(UIValidation.isValidName(""));
        assertFalse(UIValidation.isValidName("    "));
    }

    @Test
    public void nameCannotBeNumberOrSpecialCharacters(){
        assertFalse(UIValidation.isValidName("1"));
        assertFalse(UIValidation.isValidName("1232323"));
    }

    @Test
    public void nameCannotContainNumberOrSpecialCharacters(){
        assertFalse(UIValidation.isValidName("Deb1bie"));
        assertFalse(UIValidation.isValidName("D£bbie"));
    }

}
