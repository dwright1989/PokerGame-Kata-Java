package com.techreturners.EnumsAndConstants;

public enum Colour {
        MAIN_TEXT_COLOUR("\033[0;34m"),
        RESET("\033[0m");

        private final String code;

        Colour(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }

}
