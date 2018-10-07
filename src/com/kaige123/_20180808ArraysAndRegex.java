package com.kaige123;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 1.练习课堂上的数值运算
 * 2.练习Arrays工具类
 * 3.练习正则表达式
 * 4.自学一下正则表达式的写法,只要做能看懂即可
 */
public class _20180808ArraysAndRegex {
//    数值运算
    static void bigNumberCal(){
        double i=1d;
        for (int j = 0; j < 10000; j++) {
            i+=0.00001;
        }
        System.out.println("精度损失了"+i);
        /*
        public BigDecimal(double val)
            将 double 转换为 BigDecimal，后者是 double 的二进制浮点值准确的十进制表示形式。返回的 BigDecimal 的标度是使 (10scale × val) 为整数的最小值。
            注：
            此构造方法的结果有一定的不可预知性。有人可能认为在 Java 中写入 new BigDecimal(0.1) 所创建的 BigDecimal 正好等于 0.1（非标度值 1，其标度为 1），但是它实际上等于 0.1000000000000000055511151231257827021181583404541015625。这是因为 0.1 无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。这样，传入 到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。
            另一方面，String 构造方法是完全可预知的：写入 new BigDecimal("0.1") 将创建一个 BigDecimal，它正好 等于预期的 0.1。因此，比较而言，通常建议优先使用 String 构造方法。
            当 double 必须用作 BigDecimal 的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：先使用 Double.toString(double) 方法，然后使用 BigDecimal(String) 构造方法，将 double 转换为 String。要获取该结果，请使用 static valueOf(double) 方法。
         */
        BigDecimal bi=new BigDecimal(Double.toString(1));
        for (int j = 0; j < 10000; j++) {
            bi=bi.add(new BigDecimal(Double.toString(0.00001)));
        }
        System.out.println("使用大数据类型"+bi);


        BigInteger bI=new BigInteger(Integer.toString(100000));
        for (int j = 0; j < 100000; j++) {
            bI=bI.add(new BigInteger(Integer.toString(100000)));
        }
        System.out.println("使用大数据类型"+bI);
    }

//    Arrays工具类
    static void arraysMethod(int[] ints){
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("搜索特定key的位置："+Arrays.binarySearch(ints,0));
        int[] beforeSort={1,3,-5,7,9,-12,0};
        System.out.println("数组比较："+Arrays.equals(beforeSort,ints));
        Arrays.sort(beforeSort);
        System.out.println("数组比较："+Arrays.equals(beforeSort,ints));
        Arrays.fill(beforeSort,0);
        System.out.println("数组填充："+Arrays.toString(beforeSort));
    }

    public static void main(String[] args) {
        _20180808ArraysAndRegex.bigNumberCal();
        int[] beforeSort={1,3,-5,7,9,-12,0};
        _20180808ArraysAndRegex.arraysMethod(beforeSort);


    }
}
