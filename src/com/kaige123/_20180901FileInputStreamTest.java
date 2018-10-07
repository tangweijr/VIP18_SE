package com.kaige123;

import java.io.*;
import java.util.Arrays;

public class _20180901FileInputStreamTest {

    /**
     * 2.写一个递归把所有的文件都读取前面的5个字节 然后转换成字符串输出
     * @param file 文件路径
     */
    private static void fileReader(File file) {
        if (file.isFile()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                byte[] firstFiveBytes = new byte[5];
                if (inputStream.read(firstFiveBytes) != -1) {
                    System.out.println("文件名：" + file.getName());
                    System.out.println("前5个字符是：" + new String(firstFiveBytes));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    fileReader(subFile);
                }
            }
        }
    }

    /**
     * 4.读取一个MP3 把每个字节都转换成文字 然后看一看 歌曲的名字是否在里面
     * @param file 文件路径
     */
    private static void findSongName(File file) {
        byte[] bytes = new byte[2048];
        try {
            InputStream inputStream = new FileInputStream(file);
            StringBuffer stringBuffer = new StringBuffer();
            while (inputStream.read(bytes) != -1) {
                for (byte aByte : bytes) {
                    stringBuffer.append((char) aByte);
                }
            }
//            System.out.println(new String(bytes));
//            System.out.println(stringBuffer);
            if (stringBuffer.toString().contains(file.getName())) {
                System.out.println("包含歌曲的名称");
            } else {
                System.out.println("没有歌曲的名称");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File fileTestPath = new File("..\\VIP18_SE_Exercise");
        _20180901FileInputStreamTest.fileReader(fileTestPath);
        fileTestPath = new File("..\\VIP18_SE_Exercise\\1908.告白气球.mp3");
        _20180901FileInputStreamTest.findSongName(fileTestPath);
    }
}
