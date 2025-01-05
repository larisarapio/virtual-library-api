package br.com.larissasarapio.virtual_library_api.exceptions;

public class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}
