package com.kaige123;

import java.util.Arrays;

/**
 * 2.把一个字符串里面的大小写取反 小写变大写  大写变小写
 * 3."asdajavasdasdasjavaddddjavaddddddjavaddddddjavaddd" 判断字符串中有多少个java关键字
 * 4.写一个能将字符串内容进行排序程序
 */
public class _20180730String {

    /**
     * 2.把一个字符串里面的大小写取反 小写变大写  大写变小写
     *
     * @param s 字符串
     * @return 变换过的字符串
     */
    static String lowerUpperCaseReverse(String s) {
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                newS.append((char) (s.charAt(i) + 32));
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                newS.append((char) (s.charAt(i) - 32));
            } else {
                newS.append(s.charAt(i));
            }
        }
        return newS.toString();
    }

    /**
     * 3."asdajavasdasdasjavaddddjavaddddddjavaddddddjavaddd" 判断字符串中有多少个java关键字
     *
     * @param s   字符串
     * @param key 关键字
     * @return 重复次数
     */
    static int searchKeyString(String s, String key) {
        int index = 0, count = 0;
        while (index < (s.length() - key.length())) {
            if (s.indexOf(key, index) != -1) {
                index = s.indexOf(key, index);
                count++;
            } else if (index == -1) {
                break;
            }
            index++;
        }
        return count;
    }

    /**
     * 4.写一个能将字符串内容进行排序程序
     *
     * @param s       字符串
     * @param reverse 反序
     * @return 排序过的字符串
     */
    static String stringSort(String s, boolean reverse) {
        char[] tempchar = new char[]{};
        StringBuilder stringBuilder = new StringBuilder();
        tempchar = s.toCharArray();
        Arrays.sort(tempchar);
        if (reverse) {
            for (int i = tempchar.length - 1; i >= 0; i--) {
                stringBuilder.append(tempchar[i]);
            }
        } else {
            for (int i = 0; i < tempchar.length; i++) {
                stringBuilder.append(tempchar[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String temp = _20180730String.lowerUpperCaseReverse("Abc现DeFg在HIGk什lMN");
        System.out.println(temp);
        temp = _20180730String.lowerUpperCaseReverse("BDNase现Ek在Phanta什Pfu");
        System.out.println(temp);
        int countTime = _20180730String.searchKeyString("asdajavasdasdasjavaddddjavaddddddjavaddddddjavaddd", "java");
        System.out.println(countTime);
        countTime = _20180730String.searchKeyString("hellohellohello", "he");
        System.out.println(countTime);
        countTime = _20180730String.searchKeyString("hellohellohellopllo", "llo");
        System.out.println(countTime);
        String tempch = _20180730String.stringSort("bfghasdgf", false);
        System.out.println(tempch);
        tempch = _20180730String.stringSort("bfghasdgf", true);
        System.out.println(tempch);
    }
}
