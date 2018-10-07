package com.kaige123;

import java.util.NoSuchElementException;

public class MyLinkList4 {
    private Object[] prev;
    private Object[] next;
    private int size = 0;

    public void add(Object o) {
        if (prev == null) {
            prev = new Object[]{null, o, null};
            next = prev;
        } else {
            Object[] temp = new Object[]{next, o, null};
            next[2] = temp;
            next = temp;
        }
        size++;
    }

    public void addFirst(Object o) {
        if (prev == null) {
            add(o);
        } else {
            Object[] temp = new Object[]{null, o, prev};
            prev[0] = temp;
            prev = temp;
            size++;
        }
    }

    public void addLast(Object o) {
        add(o);
    }

    public Object removeFirst() {
        if (prev == null) {
            throw new NoSuchElementException();
        } else {
            Object current = prev[1];
            if (prev == next) {
                prev = null;
                next = null;
            } else {
                Object[] temp = (Object[]) prev[2];
                temp[0] = null;
                prev = temp;
            }
            size--;
            return current;
        }
    }

    public Object removeLast() {
        if (prev == null) {
            throw new NoSuchElementException();
        } else {
            Object current = next[1];
            if (prev == next) {
                prev = null;
                next = null;
            } else {
                Object[] temp = (Object[]) next[0];
                temp[2] = null;
                next = temp;
            }
            size--;
            return current;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
