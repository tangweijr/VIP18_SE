package com.kaige123;

public class MyArrayList2 {
    private Object[] objs;
    private int index=0;

    public void add(Object o) {
        if (objs == null) {
            objs = new Object[5];
            objs[index++] = o;
        } else {
            if (index >= objs.length) {
                Object[] tempobjs = new Object[(int) (objs.length * 1.5)];
                System.arraycopy(objs, 0, tempobjs, 0, objs.length);
                objs = tempobjs;
            }
            objs[index++] = o;
        }
    }

    public void remove(int i) {
        if (i < 0 || i >= index) {
            throw new IndexOutOfBoundsException();
        }else {
            if (i == objs.length - 1) {
                objs[i] = null;
                index--;
            }else {
                System.arraycopy(objs, i + 1, objs, i, objs.length - i - 1);
                index--;
            }
            if (objs.length / index >= 3) {
                Object[] reduceobjs = new Object[objs.length / 2];
                System.arraycopy(objs, 0, reduceobjs, 0, reduceobjs.length);
                objs = reduceobjs;
            }
        }
    }

    public Object get(int i) {
        if (i < 0 || i > index) {
            throw new IndexOutOfBoundsException();
        } else {
            return objs[i];
        }
    }

    public int size() {
        return index;
    }
}
