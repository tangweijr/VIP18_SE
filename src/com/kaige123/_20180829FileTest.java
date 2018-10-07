package com.kaige123;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.util.*;

/**
 * 2.给你一个路径，查找这个路径有多个后缀，后缀的数量是多少
 * 3.给你一个路径，查找这个路径下最大的文件，和长时间没有使用的文件
 * 4.给你一个路径，路径下有N个记事本文件，需要把他们的名字全部命名为 1.txt~100.txt 有序的名称
 * @author tangweijr
 */
public class _20180829FileTest {
    private static HashMap<String, Integer> suffixCollections = new HashMap<>();
    private static File maxLengthFile = null;
    private static File lastModifiedFile = null;
    private static List<File> longTimeNoUse = new ArrayList<File>();
    /**
     * 给你一个路径，查找这个路径有多个后缀，后缀的数量是多少
     * 需要使用递归查找
     * @param file 地址的file类
     */
    private static void findSuffix(File file) {
        if (file.isFile()) {
            String lastSuffix;
            if (!file.getName().contains(".")) {
                lastSuffix = "无后缀";
            } else {
                lastSuffix = "." + file.getName().split("\\.")[1];
            }
            Integer count = suffixCollections.get(lastSuffix);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            suffixCollections.put(lastSuffix, count);
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subfile : files) {
                    findSuffix(subfile);
                }
            }
        }
    }

    /**
     * 3.给你一个路径，查找这个路径下最大的文件，和长时间没有使用的文件
     *
     * @param file 地址的file类
     */
    private static void largeFileAndFileTime(File file) {
        if (file.isFile()) {
            if (maxLengthFile == null) {
                maxLengthFile = file;
            } else if (file.length() > maxLengthFile.length()) {
                maxLengthFile = file;
            }
            if (lastModifiedFile == null) {
                lastModifiedFile = file;
            } else if (file.lastModified() > lastModifiedFile.lastModified()) {
                lastModifiedFile = file;
            }
            if (file.lastModified() < new Date(118, 6, 30).getTime()) {
                longTimeNoUse.add(file);
            }
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subfile : files) {
                    largeFileAndFileTime(subfile);
                }
            }
        }
    }

    /**
     * 4.给你一个路径，路径下有N个记事本文件，需要把他们的名字全部命名为 1.txt~100.txt 有序的名称
     *
     * @param file 地址的file类
     */
    private static void renameText(File file) {
        File[] files=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        int index = 0;
        assert files != null;
        for (File subfile : files) {
            subfile.renameTo(new File(subfile.getParent(),index+++".txt"));
        }
    }

    public static void main(String[] args) {

        File pathNeedTest = new File("D:\\IntelliJ IDEA 2018.1\\jre64");
        System.out.println(pathNeedTest.getPath());
        _20180829FileTest.findSuffix(pathNeedTest);
        System.out.println("路径" + pathNeedTest + "下的后缀为：");
        for (Map.Entry<String, Integer> stringIntegerEntry : suffixCollections.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + "\t" + stringIntegerEntry.getValue());
        }

        _20180829FileTest.largeFileAndFileTime(pathNeedTest);
        System.out.println("此文件夹最大的文件是：" + maxLengthFile.getName());
        String filelength;
        if (maxLengthFile.length() < 1024) {
            filelength = maxLengthFile.length() + "字节";
        } else if (maxLengthFile.length() < 1024 * 1024) {
            filelength = Math.floor(maxLengthFile.length() / 1024 * 100) / 100.0 + "KB";
        } else if (maxLengthFile.length() < 1024 * 1024 * 1024) {
            filelength = Math.floor(maxLengthFile.length() / 1024 / 1024d * 100) / 100.0 + "MB";
        } else {
            filelength = Math.floor(maxLengthFile.length() / 1024 / 1024 / 1024d * 100) / 100.0 + "GB";
        }
        System.out.println("此文件大小为：" + filelength);
        System.out.println("最后修改的文件为：" + lastModifiedFile.getName());
        //不使用new Date().toLocalString，使用DateFormat.format()
        System.out.println("最后修改的时间是：" + DateFormat.getDateTimeInstance().format(new Date(lastModifiedFile.lastModified())));
        System.out.println("长时间没有使用的文件为：");
        for (File file : longTimeNoUse) {
            System.out.println(file.getName() + "\n最后修改的时间为" + DateFormat.getDateTimeInstance().format(new Date(file.lastModified())));
        }

        File modifyTxtName = new File("D:\\txtRename");
        _20180829FileTest.renameText(modifyTxtName);
    }
}
