package com.kaige123;

public class MyArrayList5 {
    private Object[] objects;
    private int index = 0;

    public void add(Object o) {
        if (objects == null) {
            objects = new Object[5];
            objects[index++] = o;
        } else {
            if (index >= objects.length) {
                Object[] temObjs = new Object[(int) (objects.length * 1.6)];
                System.arraycopy(objects, 0, temObjs, 0, objects.length);
                objects = temObjs;
            }
            objects[index++] = o;
        }
    }

    public void remove(int i) {
        if (i < 0 || i >= index) {
            throw new IndexOutOfBoundsException();
        } else {
            if (i == objects.length - 1) {
                objects[i] = null;
                index--;
            } else {
                System.arraycopy(objects, i + 1, objects, i, objects.length - i - 1);
                index--;
            }
            if (objects.length / index >= 3) {
                Object[] reduce = new Object[objects.length / 2];
                System.arraycopy(objects, 0, reduce, 0, reduce.length);
                objects = reduce;
            }
        }
    }

    public Object get(int i) {
        if (i < 0 || i >= index) {
            throw new IndexOutOfBoundsException();
        } else {
            return objects[i];
        }
    }

    public int size() {
        return index;
    }
}
