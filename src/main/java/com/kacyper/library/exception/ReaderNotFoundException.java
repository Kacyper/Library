package com.kacyper.library.exception;

public class ReaderNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Reader not found.";
    }
}
