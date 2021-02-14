package com.example.service.view;

public interface ServiceView<T> {
    public String greeting(String content);
    public T greetingGeneric(String content);
}
