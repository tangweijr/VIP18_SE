package com.kaige123;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 2.打印出一个简单的日历格式
 * 3.写一个上机下机时间的计算程序  输入上机金额和时间，自动计算下机时间
 * 4.打印出7个国家的4种日期格式
 * 5.7月5日 22:22:55 2018年  把这个字符串转换成日期对象
 */
public class _20180729DateTime {
    /**
     * 2.打印出一个简单的日历格式
     *
     * @param year  年份
     * @param month 月份
     */
    static void printCal(int year, int month) {
        //    练习2
        Calendar nowCal = Calendar.getInstance();
        nowCal.set(Calendar.YEAR, year);
        nowCal.set(Calendar.MONDAY, month - 1);
        nowCal.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(nowCal.getTime());
        int maxDay = nowCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("正在打印" + year + "年" + month + "月" + "的日历：");
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t");
        for (int i = 1; i < nowCal.get(Calendar.DAY_OF_WEEK); i++) {
            System.out.print("\t\t");
        }
        for (int i = 1; i <= maxDay; i++) {
            System.out.print(i + "\t\t");
            nowCal.set(Calendar.DAY_OF_MONTH, i);
            if (nowCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * 3.写一个上机下机时间的计算程序  输入上机金额和时间，自动计算下机时间
     *
     * @param money 上机的总金额
     */
    static void netCafeTimeCounting(int money) {
        System.out.println("欢迎来到网吧计费系统，本网吧每小时上网费用为5元：");
        System.out.println("上机持续到：");
        Calendar nowCal = Calendar.getInstance();
        int time = money / 5;
        nowCal.set(Calendar.HOUR, nowCal.get(Calendar.HOUR) + time);
        System.out.println(nowCal.getTime().toLocaleString());
    }

    /**
     * 4.打印出7个国家的4种日期格式
     */
    static void printVariousDateFormat() {
        System.out.println("即将打印7个国家的4种日期格式：");
        Locale[] locales = {Locale.CHINA, Locale.CANADA, Locale.ENGLISH, Locale.FRANCE, Locale.GERMAN, Locale.JAPAN, Locale.KOREA};
        int[] fourDateFormats = {DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT};
        for (int i = 0; i < locales.length; i++) {
            Calendar nowCal = Calendar.getInstance(locales[i]);
            for (int j = 0; j < fourDateFormats.length; j++) {
                DateFormat thisDateFormat = DateFormat.getDateInstance(fourDateFormats[j], locales[i]);
                System.out.println(locales[i].getDisplayCountry(locales[i]) + "\t" + locales[i].getDisplayLanguage(locales[i]) + "\t" + thisDateFormat.format(new Date()));
            }
        }
    }

    /**
     * 5.7月5日 22:22:55 2018年  把这个字符串转换成日期对象
     *
     * @param s 字符串格式的日期
     * @return 日期类
     */
    static Date setString2Date(String s) {
//      7月5日 22:22:55 2018年
        SimpleDateFormat nowDate = new SimpleDateFormat("MM月dd日 HH:mm:ss yyyy年");
        Date transDate = new Date();
        try {
            transDate = nowDate.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return transDate;
    }

    public static void main(String[] args) {
        _20180729DateTime.printCal(2018, 7);
        _20180729DateTime.printCal(2018, 2);
        //    练习3
        _20180729DateTime.netCafeTimeCounting(5);
        _20180729DateTime.netCafeTimeCounting(120);
        //    练习4
        _20180729DateTime.printVariousDateFormat();
        //    练习5
        Date printDate = _20180729DateTime.setString2Date("7月5日 22:22:55 2018年");
        System.out.println(printDate.toLocaleString());
        printDate = _20180729DateTime.setString2Date("1月30日 12:11:10 2016年");
        System.out.println(printDate.toLocaleString());
    }

}
