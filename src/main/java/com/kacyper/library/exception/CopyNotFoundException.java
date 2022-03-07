package com.kacyper.library.exception;

public class CopyNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "No copies found.";
    }
}
