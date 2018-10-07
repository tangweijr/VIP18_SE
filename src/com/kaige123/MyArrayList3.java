package com.kaige123;

public class MyArrayList3 {
    private Object[] objects;
    private int index = 0;

    public void add(Object o) {
        if (objects == null) {
            objects = new Object[5];
            objects[index++] = o;
        } else {
            if (index >= objects.length) {
                Object[] tempObjs = new Object[(int)(objects.length*1.5)];
                System.arraycopy(objects, 0, tempObjs, 0, objects.length);
                objects = tempObjs;
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
                System.arraycopy(objects,i+1,objects,i,objects.length-i-1);
                index--;
            }
            if (objects.length / index >= 3) {
                Object[] reduceObjs = new Object[objects.length / 2];
                System.arraycopy(objects, 0, reduceObjs, 0, reduceObjs.length);
                objects = reduceObjs;
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
