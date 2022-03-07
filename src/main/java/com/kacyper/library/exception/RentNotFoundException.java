package com.kacyper.library.exception;

public class RentNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Rent not found.";
    }
}
