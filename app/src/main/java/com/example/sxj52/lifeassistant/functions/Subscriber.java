package com.example.sxj52.lifeassistant.functions;

/**
 * Created by haoping on 17/5/22.
 * TODO
 */
public interface Subscriber<T> {
    void onComplete(T t);
    void onError(Exception e);
}
