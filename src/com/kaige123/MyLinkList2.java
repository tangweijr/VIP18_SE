package com.kaige123;

import java.util.NoSuchElementException;

public class MyLinkList2 {
    private Object[] prev;
    private Object[] next;
    private int size = 0;

    public void add(Object o) {
        if (prev == null) {
            prev = new Object[]{null, o, null};
            next = prev;
        } else {
            Object[] tempObjs = new Object[]{next, o, null};
            next[2] = tempObjs;
            next = tempObjs;
        }
        size++;
    }

    public void addFirst(Object o) {
        if (prev == null) {
            add(o);
        } else {
            Object[] tempObjs = new Object[]{null, o, prev};
            prev[0] = tempObjs;
            prev = tempObjs;
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
                Object[] nextObjs = (Object[]) prev[2];
                nextObjs[0] = null;
                prev = nextObjs;
            }
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
                Object[] prevObjs = (Object[]) next[0];
                prevObjs[2] = null;
                next = prevObjs;
            }
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
