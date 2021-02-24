package com.example.service.View;

// Ein generisches Interface, um verschiede Rückgabetypen zu behandeln
public interface ServiceView<T> {
    public String greeting(String content);
    public T greetingGeneric(String content);
}
