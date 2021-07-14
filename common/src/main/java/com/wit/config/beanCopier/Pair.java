/**
 * @ClassName Pair
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/20 19:51
 */
package com.wit.config.beanCopier;

class Pair<T,U> {

    public T first;
    public U second;

    public Pair(T first,U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> pair(T first, U second) {
        return new Pair<>(first, second);
    }

    @Override
    public int hashCode() {
        return this.first.hashCode() * 31 + this.second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pair)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Pair<?,?> o = (Pair<?,?>) obj;
        if(o.first.getClass() != this.first.getClass() || o.second.getClass() != this.second.getClass()) {
            return false;
        }
        return (o.first.equals(this.first)) && (o.second.equals(this.second));
    }

    @Override
    public String toString() {
        return this.first + " " + this.second;
    }
}