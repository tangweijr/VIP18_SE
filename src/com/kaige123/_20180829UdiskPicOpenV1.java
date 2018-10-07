package com.kaige123;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

/**
 * 2.制作一个U盘发现器，只要你在电脑上插U盘就会自动打开u盘的夹子  3元
 * U盘的盘符不一定是最后一个
 * Thread.sleep();
 * @author tangweijr
 */
public class _20180829UdiskPicOpenV1 {
    private static void picOpenLoop(File file) {
        if (file.isFile() && file.getName().contains(".")) {
            String lastname = file.getName().split("\\.")[1];
            if (lastname.equals("jpg") || lastname.equals("jpeg") || lastname.equals("gif") || lastname.equals("bmp") || lastname.equals("tif")) {
                Runtime newruntime = Runtime.getRuntime();
                try {
                    newruntime.exec("explorer.exe " + file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    picOpenLoop(file1);
                }
            }
        }
    }
    /**
     * 使用runtime.exec打开文件夹
     * 使用runtime.exec打开所有的图片
     * @param path 准备打开的路径
     */
    public static void pathOpen(List<File> path) {
        Runtime newruntime = Runtime.getRuntime();
        for (int i = 0; i < path.size(); i++) {
            //列出U盘的路径
            File subpath = path.get(i);
            //列出U盘中的所有文件
            File[] subpathfiles = path.get(i).listFiles();
            for (File subpathfile : subpathfiles) {
                picOpenLoop(subpathfile);
            }
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
                List<File> path = _20180829UdiskPicOpenV1.findDiffPath(systemPath, systemPathAgain);
                _20180829UdiskPicOpenV1.pathOpen(path);
//                _20180828UdiskTester.pathOpen(systemPathAgain[systemPathAgain.length-1]);
                System.out.println("U盘插入了");
            } else if (systemPathAgain.length == systemPath.length - 1) {
                System.out.println("U盘弹出了");
            }
        }
    }
}
