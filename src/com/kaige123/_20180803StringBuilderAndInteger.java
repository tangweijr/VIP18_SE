package com.kaige123;

/**
 * 2.练习进制转换
 * 3.8个设备有四个状态，写一个程序吧4个状态存在4个字符(16进制)内，然后还能进行解析
 */
public class _20180803StringBuilderAndInteger {

    /**
     * 2.练习进制转换
     */
    static void jinZhiZhuanHuan() {
        String[] strings = {"110101010101", "7654", "12345", "FFac"};
        int[] jinzhis = {2, 8, 10, 16};
        for (int i = 0; i < strings.length; i++) {
            int tempNum = Integer.parseInt(strings[i], jinzhis[i]);
            System.out.println("先转换成10进制" + tempNum + "，然后转化其他进制：");
            for (int j = 0; j < jinzhis.length; j++) {
                System.out.println("转化" + jinzhis[j] + "进制：" + Integer.toString(tempNum, jinzhis[j]));
            }
        }
    }

    /**
     * 3.8个设备有四个状态，写一个程序吧4个状态存在4个字符(16进制)内，然后还能进行解析
     * 每个设备有4个状态，分别是a,b,c,d，从二进制上描述就是00,01,10,11，也就是说，8个设备，总共需要占据2*8个位
     *
     * @param states 状态数组
     * @return 加密/压缩的状态
     */
    static String equipmentStateM(String[] states) {
        if (states.length != 8) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < states.length; i++) {
            if (states[i].equals("a")) {
                temp.append("00");
            } else if (states[i].equals("b")) {
                temp.append("01");
            } else if (states[i].equals("c")) {
                temp.append("10");
            } else if (states[i].equals("d")) {
                temp.append("11");
            }
        }
        System.out.println(temp.toString());
        return Integer.toString(Integer.parseInt(temp.toString(), 2), 16);
    }

    /**
     * 状态的解密
     *
     * @param jiami 加密/压缩的状态
     * @return 状态数组
     */
    static String[] equipmentStateJ(String jiami) {
        int jiami10 = Integer.parseInt(jiami, 16);
        String jiemi = Integer.toString(jiami10, 2);
        while (16 - jiemi.length() > 0) {
            jiemi = "0" + jiemi;
        }
        String[] states = new String[8];
        for (int i = 0; i < jiemi.length(); i += 2) {
            if (jiemi.subSequence(i, i + 2).equals("00")) {
                states[i / 2] = "a";
            } else if (jiemi.subSequence(i, i + 2).equals("01")) {
                states[i / 2] = "b";
            } else if (jiemi.subSequence(i, i + 2).equals("10")) {
                states[i / 2] = "c";
            } else if (jiemi.subSequence(i, i + 2).equals("11")) {
                states[i / 2] = "d";
            }
        }
        return states;
    }

    public static void main(String[] args) {
        Integer integera = new Integer(12);
        int a = integera.intValue();
        a = integera + 90;

        _20180803StringBuilderAndInteger.jinZhiZhuanHuan();

//        描述8个设备的状态
        String[] booleans = {"d", "a", "b", "b", "c", "c", "d", "d"};
        String jiami = _20180803StringBuilderAndInteger.equipmentStateM(booleans);
        System.out.println("加密后储存为:" + jiami);
        String[] jiemiState = _20180803StringBuilderAndInteger.equipmentStateJ(jiami);
        for (int i = 0; i < jiemiState.length; i++) {
            System.out.println("第" + i + "个状态是：" + jiemiState[i]);
        }
    }
}
