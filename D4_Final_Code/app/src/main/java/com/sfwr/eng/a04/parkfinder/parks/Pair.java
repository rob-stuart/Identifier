package com.sfwr.eng.a04.parkfinder.parks;


import java.io.Serializable;

public class Pair<T, G> implements Serializable {
    private final T item1;
    private final G item2;

    public Pair(T item1, G item2) {
        assert (item1 != null && item2 != null);
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public G getItem2() {
        return item2;
    }

    public boolean isItem1Same(Object obj) {
        return obj instanceof Pair && this.item1.equals(((Pair) obj).item1);
    }

    public boolean isItem2Same(Object obj) {
        return obj instanceof Pair && this.item2.equals(((Pair) obj).item2);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pair && this.item1.equals(((Pair) obj).item1) && this.item2.equals(((Pair) obj).item2);
    }

}