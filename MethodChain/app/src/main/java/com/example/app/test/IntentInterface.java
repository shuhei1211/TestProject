package com.example.app.test;

public interface IntentInterface<T extends IntentInterface<T>> {
    T move(Class<?> className);
    T moveActivity();
    T finish();
}
