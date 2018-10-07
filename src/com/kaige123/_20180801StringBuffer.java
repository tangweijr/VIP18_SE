package com.kaige123;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;

/**
 * 2.练习字符集转换
 * 3.把课堂上的实验做一遍，String和StringBuffer
 * 4.按照符号分割字符串
 * 192.168.0.0   .
 * 139-0755-0123  -
 * 2018-08-09 11:11:12  字符串分割  不能使用时间格式类
 * 把年月日时分秒 拆解
 */
public class _20180801StringBuffer {
    /**
     * 3.把课堂上的实验做一遍，String和StringBuffer
     */
    static void stingStringBufferLinkCompare() {
        String s = new String();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            s += " ";
        }
        System.out.println("通过Sting连接需要:" + (System.currentTimeMillis() - time) + "ms");
        StringBuffer sb = new StringBuffer();
        time = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            sb.append(" ");
        }
        System.out.println("通过StingBuffer连接需要:" + (System.currentTimeMillis() - time) + "ms");
    }

    /**
     * 4.按照符号分割字符串,ip
     *
     * @param s 字符串
     * @return 字符串数组
     */
    static String[] ipParse(String s) {
        String[] ip = new String[]{};
        ip = s.split("\\.");
        return ip;
    }

    /**
     * 4.按照符号分割字符串,tel
     *
     * @param s 字符串
     * @return 字符串数组
     */
    static String telParse(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.split("-").length; i++) {
            sb.append(s.split("-")[i]);
        }
        return sb.toString();
    }

    /**
     * 4.按照符号分割字符串,日期
     *
     * @param s 字符串
     * @return 字符串数组
     */
    static Calendar calendarParse(String s) {
        String date = new String();
        String time = new String();
        try {
            date = s.split(" ")[0];
            time = s.split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1]) - 1
                , Integer.parseInt(date.split("-")[2]));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(":")[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
        calendar.set(Calendar.SECOND, Integer.parseInt(time.split(":")[2]));
        return calendar;
    }

    public static void main(String[] args) {
//        2.练习字符集转换
        String byteset = "2.练习字符集转换maitang";
        System.out.println("当前的字符集是：" + Charset.defaultCharset());
        System.out.println("系统支持的字符集是：" + Charset.availableCharsets());
        byte[] result = byteset.getBytes();
        System.out.println(new String(result));
        try {
            result = byteset.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(new String(result, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            result = byteset.getBytes("EUC-KR");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(new String(result, "EUC-KR"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        3.把课堂上的实验做一遍，String和StringBuffer
        _20180801StringBuffer.stingStringBufferLinkCompare();

//        4.
        String[] ip = _20180801StringBuffer.ipParse("192.168.0.1");
        for (int i = 0; i < ip.length; i++) {
            System.out.println(ip[i]);
        }

        System.out.println(_20180801StringBuffer.telParse("187-6186-1234"));

        Calendar cal = _20180801StringBuffer.calendarParse("2018-08-09 11:11:12");
        System.out.println(cal.getTime().toLocaleString());
    }
}
