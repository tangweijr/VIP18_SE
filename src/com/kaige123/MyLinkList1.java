package com.kaige123;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 4.使用链表集合做出一个队列模式
 * @author tangweijr
 */
public class MyLinkList1<T> implements Iterator {
    private Object[] prev;
    private Object[] next;
    private int size = 0;
    private int local = 0;

    public void add(T o) {
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

    public void add(int index, T o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(o);
        } else if (index == size - 1) {
            Object[] lastbefore = (Object[]) next[0];
            Object[] newadd = new Object[]{lastbefore, o, next};
            lastbefore[2] = newadd;
            next[0] = newadd;
            size++;
        } else {
            Object[] currentObj = (Object[]) currentIndexObj(index);
            Object[] currentbefore = (Object[]) currentObj[0];
            Object[] newadd = new Object[]{currentbefore, o, currentObj};
            currentbefore[2] = newadd;
            currentObj[0] = newadd;
            size++;
        }
    }

    public void addFirst(T o) {
        if (prev == null) {
            add(o);
        } else {
            Object[] tempObjs = new Object[]{null, o, prev};
            prev[0] = tempObjs;
            prev = tempObjs;
            size++;
        }
    }

    public void addLast(T o) {
        add(o);
    }

    public Object removeFirst() {
        if (prev == null) {
            throw new NoSuchElementException();
        } else{
            Object temp = prev[1];
            if (prev == next) {
                prev = null;
                next = null;
            } else {
                Object[] nextObjs = (Object[]) prev[2];
                nextObjs[0] = null;
                prev = nextObjs;
            }
            size--;
            return temp;
        }
    }

    public Object removeLast() {
        if (prev == null) {
            throw new NoSuchElementException();
        } else {
            Object temp = next[1];
            if (prev == next) {
                prev = null;
                next = null;
            } else {
                Object[] beforeObjs = (Object[]) next[0];
                beforeObjs[2] = null;
                next = beforeObjs;
            }
            size--;
            return temp;
        }
    }

    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] current = prev;
            if (index == 0) {
                return removeFirst();
            } else if (index == size-1) {
                return removeLast();
            } else {
                for (int i = 0; i < index; i++) {
                    if (current == null) {
                        throw new NoSuchElementException();
                    }
                    current = (Object[]) current[2];
                }
                Object[] prevOne = (Object[]) current[0];
                Object[] nextOne = (Object[]) current[2];
                prevOne[2] = nextOne;
                nextOne[0] = prevOne;
                return current[1];
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Object currentIndexObj(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return prev;
        } else if (index == size - 1) {
            return next;
        } else {
            Object[] current = prev;
            for (int i = 0; i < index; i++) {
                current = (Object[]) current[2];
            }
            return current;
        }
    }

    public void push(T o) {
        add(o);
    }

    public Object pop(){
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object currentObj = prev[1];
            removeFirst();
            return currentObj;
        }
    }

    @Override
    public boolean hasNext() {
        return local != size;
    }

    @Override
    public Object next() {
        Object[] current = prev;
        for (int i = 0; i < local; i++) {
            current = (Object[]) current[2];
        }
        local++;
        return current[1];
    }

    public void resetLocal(){
        local = 0;
    }
}
