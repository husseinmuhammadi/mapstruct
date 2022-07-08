package com.javastudio.tutorial.mapping.model;

public abstract class BaseEntity<T> {

    public abstract T getId();

    public abstract void setId(T id);
}
