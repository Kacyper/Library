package com.kacyper.library.exception;

public class BookNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Book not found.";
    }
}
