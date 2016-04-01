package com.a04.parkfinder.parks;

/**
 * Created by robert on 01-Apr-16.
 */

public class Pair<T, G> {
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
        if(obj instanceof Pair){
            return this.item1.equals(((Pair) obj).item1);
        }
        return false;
    }

    public boolean isItem2Same(Object obj) {
        if(obj instanceof Pair){
            return this.item2.equals(((Pair) obj).item2);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair that = (Pair) obj;
            return this.item1.equals(that.item1) && this.item2.equals(that.item2);
        }
        return false;
    }

}