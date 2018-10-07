package com.kaige123;

import java.util.ArrayList;
import java.util.Arrays;

public class _20180810MyArrayListTest {
    private Object[] objs;
    private int index=0;

    public void addNormal(Object value){
        if(objs==null){
            objs=new Object[]{value};
        }else {
            Object[] tempobjs=new Object[objs.length+1];
            for (int i = 0; i < objs.length; i++) {
                tempobjs[i]=objs[i];
            }
            tempobjs[objs.length]=value;
            objs=tempobjs;
        }
    }

    public void addArraycopy(Object value){
        if(objs==null){
            objs=new Object[]{value};
        }else {
            Object[] tempobjs=new Object[objs.length+1];
            System.arraycopy(objs,0,tempobjs,0,objs.length);
            tempobjs[objs.length]=value;
            objs=tempobjs;
        }
    }

    public void add(Object value){
        if(index==0){
            objs=new Object[5];
            objs[index++]=value;
        }else {
            if (index==objs.length){
                Object[] tempobjs=new Object[(int)(objs.length*1.5)];
                System.arraycopy(objs,0,tempobjs,0,objs.length);
                objs=tempobjs;
            }
            objs[index++]=value;
        }
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        System.out.println("测试自己写的ArrayList：");
        MyArrayList1 myArrayList1=new MyArrayList1();
        myArrayList1.add("No1");
        myArrayList1.add("No2");
        myArrayList1.add("No3");
        myArrayList1.add("No4");
        myArrayList1.add("No5");
        myArrayList1.add("No6");

        for (int i = 0; i < myArrayList1.size(); i++) {
            System.out.println(myArrayList1.get(i));
        }
        System.out.println("删除开始");
        myArrayList1.remove(0);
        myArrayList1.remove(0);
        myArrayList1.remove(0);
        myArrayList1.remove(0);

        for (int i = 0; i < myArrayList1.size(); i++) {
            System.out.println(myArrayList1.get(i));
        }
        System.out.println("结束");
        MyArrayList2 myArrayList2=new MyArrayList2();
        myArrayList2.add("No1");
        myArrayList2.add("No2");
        myArrayList2.add("No3");
        myArrayList2.add("No4");
        myArrayList2.add("No5");
        myArrayList2.add("No6");

        for (int i = 0; i < myArrayList2.size(); i++) {
            System.out.println(myArrayList2.get(i));
        }
        System.out.println("删除开始");
        myArrayList2.remove(0);
        myArrayList2.remove(0);
        myArrayList2.remove(0);
        myArrayList2.remove(0);

        for (int i = 0; i < myArrayList2.size(); i++) {
            System.out.println(myArrayList2.get(i));
        }
        System.out.println("结束");

        MyArrayList3 myArrayList3=new MyArrayList3();
        myArrayList3.add("No1");
        myArrayList3.add("No2");
        myArrayList3.add("No3");
        myArrayList3.add("No4");
        myArrayList3.add("No5");
        myArrayList3.add("No6");

        for (int i = 0; i < myArrayList3.size(); i++) {
            System.out.println(myArrayList3.get(i));
        }
        System.out.println("删除开始");
        myArrayList3.remove(0);
        myArrayList3.remove(0);
        myArrayList3.remove(0);
        myArrayList3.remove(0);

        for (int i = 0; i < myArrayList3.size(); i++) {
            System.out.println(myArrayList3.get(i));
        }
        System.out.println("结束");

        MyArrayList4 myArrayList4=new MyArrayList4();
        myArrayList4.add("No1");
        myArrayList4.add("No2");
        myArrayList4.add("No3");
        myArrayList4.add("No4");
        myArrayList4.add("No5");
        myArrayList4.add("No6");

        for (int i = 0; i < myArrayList4.size(); i++) {
            System.out.println(myArrayList4.get(i));
        }
        System.out.println("删除开始");
        myArrayList4.remove(0);
        myArrayList4.remove(0);
        myArrayList4.remove(0);
        myArrayList4.remove(0);

        for (int i = 0; i < myArrayList4.size(); i++) {
            System.out.println(myArrayList4.get(i));
        }
        System.out.println("结束");

        MyArrayList5 myArrayList5=new MyArrayList5();
        myArrayList5.add("No1");
        myArrayList5.add("No2");
        myArrayList5.add("No3");
        myArrayList5.add("No4");
        myArrayList5.add("No5");
        myArrayList5.add("No6");

        for (int i = 0; i < myArrayList5.size(); i++) {
            System.out.println(myArrayList5.get(i));
        }
        System.out.println("删除开始");
        myArrayList5.remove(0);
        myArrayList5.remove(0);
        myArrayList5.remove(0);
        myArrayList5.remove(0);

        for (int i = 0; i < myArrayList5.size(); i++) {
            System.out.println(myArrayList5.get(i));
        }
        System.out.println("结束");
    }
}
