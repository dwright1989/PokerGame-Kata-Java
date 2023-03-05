package com.techreturners.UI;

import java.util.regex.Pattern;

public class UIValidation {

    public static boolean isValidName(String name){
        return Pattern.matches("[A-Za-z]*", name) && name.length()>=1;
    }

}
