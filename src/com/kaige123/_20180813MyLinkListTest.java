package com.kaige123;

public class _20180813MyLinkListTest {
    public static void main(String[] args) {
        MyLinkList1 myLinkList1 = new MyLinkList1();
        myLinkList1.add("1");
        myLinkList1.add("2");
        myLinkList1.add("3");
        myLinkList1.add("4");
        myLinkList1.addLast("5");
        myLinkList1.addFirst("6");
        myLinkList1.add(0,"10");
        System.out.println("打印所有的序列");
        while (myLinkList1.hasNext()) {
            System.out.println(myLinkList1.next());
        }
        myLinkList1.removeFirst();
        myLinkList1.removeLast();
        System.out.println(myLinkList1.remove(1));

        System.out.println("测试队列结构：");
        MyLinkList1 queue = new MyLinkList1();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");
        queue.push("6");
        System.out.println("打印所有的序列");
        while (queue.hasNext()) {
            System.out.println(queue.next());
        }
        System.out.println("弹出的序列：");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
