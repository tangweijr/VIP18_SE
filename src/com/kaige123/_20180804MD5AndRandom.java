package com.kaige123;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

/**
 * 2.申请一个字符串数组，里面有10个人的名字，随机出3个人，但是不能重复
 * 3.制作MD5的嵌套加密
 * 4.制作一个随机的32位16进制字符串
 * 5.了解一下UUID
 * 6.学习工程中加入jar包
 */
public class _20180804MD5AndRandom {

    /**
     * 2.申请一个字符串数组，里面有10个人的名字，随机出3个人，但是不能重复
     *
     * @param names 姓名
     * @return 选择的3个姓名
     */
    static String[] namePickBySet(String[] names) {
        Random random = new Random();
        String[] namePick = new String[3];
//        首先使用hashset确定三个不重复的index，然后依次取值
        HashSet<Integer> indexs = new HashSet<>();
        while (indexs.size() < 3) {
            indexs.add(random.nextInt(10));
        }
        Iterator nextIndex = indexs.iterator();
        for (int i = 0; i < 3; i++) {
            namePick[i] = names[(int) nextIndex.next()];
        }
        return namePick;
    }

    /**
     * @param names 姓名
     * @return 选择的3个姓名
     */
    static String[] namePick(String[] names) {
        Random random = new Random();
        String[] namePick = new String[3];
//        创建一个boolean数组，开始全是false，随机从中取值，一旦选择过，就是true
        boolean[] isThisIndexPicked = new boolean[names.length];
        for (int i = 0; i < isThisIndexPicked.length; i++) {
            isThisIndexPicked[i] = false;
        }
        int pickNumber = 0;
//        只选择标识符为false的
        while (pickNumber < 3) {
            int i = random.nextInt(10);
            while (!isThisIndexPicked[i]) {
                isThisIndexPicked[i] = true;
                namePick[pickNumber++] = names[i];
            }
        }
        return namePick;
    }

    /**
     * 3.制作MD5的嵌套加密
     *
     * @param s    待加密字符串
     * @param time loop次数
     * @return MD5加密完成的字符串
     */
    static String MD5Loop(String s, int time) {
        String tempMD5 = s;
        for (int i = 0; i < time; i++) {
            tempMD5 += "temp";
            tempMD5 = MD5FileUtil.getMD5String(tempMD5);
        }
        return tempMD5;
    }

    /**
     * 4.制作一个随机的32位16进制字符串
     *
     * @param length 字符串长度
     * @param radix  字符串的进制
     * @return 随机生成的字符串
     */
    static String randomRadixString(int length, int radix) {
        Random random = new Random();
        String[] allRadix = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String randomString = "";
        for (int i = 0; i < length; i++) {
            randomString += allRadix[random.nextInt(radix)];
        }
        return randomString;
    }

    public static void main(String[] args) {
        String[] names = {"赵1", "钱2", "孙3", "李4", "周5", "吴6", "郑7", "王8", "冯9", "陈10"};
//        第一种使用hashset的方案
        String[] namePick = _20180804MD5AndRandom.namePickBySet(names);
        for (int i = 0; i < namePick.length; i++) {
            System.out.println("第一种方法：" + namePick[i]);
        }
//        第二种使用常规方法
        namePick = _20180804MD5AndRandom.namePick(names);
        for (int i = 0; i < namePick.length; i++) {
            System.out.println("第二种方法：" + namePick[i]);
        }

//        单次加密
        String md5re = MD5FileUtil.getMD5String("abc");
        System.out.println(MD5FileUtil.checkPassword("abc", md5re));
//        循环加密
        md5re = _20180804MD5AndRandom.MD5Loop("abc", 3);
        System.out.println(MD5FileUtil.checkPassword("abc", md5re));

//        十六进制
        System.out.println("十六进制：" + _20180804MD5AndRandom.randomRadixString(32, 16));
//        十进制
        System.out.println("十进制：" + _20180804MD5AndRandom.randomRadixString(16, 10));
//        八进制
        System.out.println("八进制：" + _20180804MD5AndRandom.randomRadixString(8, 8));

//        UUID
//        https://docs.oracle.com/javase/10/docs/api/java/util/UUID.html
//        随机生成的
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
//        System.out.println(uuid.version());
//        通过字符串生成
        uuid = UUID.fromString("0-4-4-9-8");
        System.out.println(uuid);
//        通过数组生成
        byte[] newbyte = {'a', 'b', 'c', 'd', 'e'};
        uuid = UUID.nameUUIDFromBytes(newbyte);
        System.out.println(uuid);
    }
}
