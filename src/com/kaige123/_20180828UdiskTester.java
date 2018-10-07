package com.kaige123;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 2.制作一个U盘发现器，只要你在电脑上插U盘就会自动打开u盘的夹子  3元
 * U盘的盘符不一定是最后一个
 * Thread.sleep();
 */
public class _20180828UdiskTester {
    /**
     * 使用runtime.exec打开文件夹
     * @param path 准备打开的路径
     */
    public static void pathOpen(List<File> path) {
        Runtime newruntime = Runtime.getRuntime();
        try {
            for (int i = 0; i < path.size(); i++) {
                newruntime.exec("explorer.exe " + path.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取两个集合的差
     * @param a 路径a
     * @param b 路径b
     * @return 返回list集合
     */
    public static List<File> findDiffPath(File[] a, File[] b) {
        List<File> filesPatha = new ArrayList<File>(Arrays.asList(a));
        List<File> filesPathb = new ArrayList<File>(Arrays.asList(b));
        if (a.length > b.length) {
            filesPatha.removeAll(filesPathb);
            return filesPatha;
        } else {
            filesPathb.removeAll(filesPatha);
            return filesPathb;
        }
    }
    public static void main(String[] args) {
        File[] systemPath;
        File[] systemPathAgain;
        while (true) {
            systemPath = File.listRoots();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            systemPathAgain = File.listRoots();
            if (systemPathAgain.length - systemPath.length == 1) {
                List<File> path = _20180828UdiskTester.findDiffPath(systemPath, systemPathAgain);
                _20180828UdiskTester.pathOpen(path);
//                _20180828UdiskTester.pathOpen(systemPathAgain[systemPathAgain.length-1]);
                System.out.println("U盘插入了");
            } else if (systemPathAgain.length == systemPath.length - 1) {
                System.out.println("U盘弹出了");
            }
        }
    }
}
