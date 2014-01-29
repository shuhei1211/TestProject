package com.example.app.test;

public interface ChaineIntentInterface<T extends ChaineIntentInterface<T>> {
    T move(Class<?> className);
    T moveActivity();
    T finish();
}
