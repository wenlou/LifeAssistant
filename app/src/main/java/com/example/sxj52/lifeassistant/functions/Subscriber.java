package com.example.sxj52.lifeassistant.functions;


public interface Subscriber<T> {
    void onComplete(T t);
    void onError(Exception e);
}
