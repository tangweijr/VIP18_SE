package com.kaige123.MahJong;

import java.util.*;

public class MahJong {
    public List<String> zongpai = new ArrayList();
    public List<String>[] persons = new ArrayList[]{new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()};

    public MahJong() {
        for (int i = 0; i < 4; i++) {
            Collections.addAll(zongpai, MahJongBaseType.fengpai);
            Collections.addAll(zongpai, MahJongBaseType.jianpai);
            for (int j = 0; j < MahJongBaseType.xushuNum.length; j++) {
                zongpai.add(MahJongBaseType.xushuNum[j] + MahJongBaseType.xushu[0]);
                zongpai.add(MahJongBaseType.xushuNum[j] + MahJongBaseType.xushu[1]);
                zongpai.add(MahJongBaseType.xushuNum[j] + MahJongBaseType.xushu[2]);
            }
        }
        Collections.addAll(zongpai, MahJongBaseType.huapai);
//        System.out.println(zongpai.size());

        Collections.shuffle(zongpai);
    }

    public void fapai() {
        Random random = new Random();
        int zjIndex = random.nextInt(4);
        int paiIndex = 0;
        for (int i = 0; i < persons.length; i++) {
            if (i == zjIndex) {
                for (int j = 0; j < 14; j++) {
                    persons[i].add(zongpai.get(paiIndex++));
                }
            } else {
                for (int j = 0; j < 13; j++) {
                    persons[i].add(zongpai.get(paiIndex++));
                }
            }
        }
//        System.out.println(paiIndex);
    }

    public void show() {
        for (int i = 0; i < persons.length; i++) {
            System.out.println("第" + (i + 1) + "位玩家");
            if (persons[i].size() == 14) {
                System.out.println("这个玩家做庄");
            }
            for (int j = 0; j < persons[i].size(); j++) {
                System.out.print(persons[i].get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("剩下的牌是：");
        for (int i = 53; i < zongpai.size(); i++) {
            System.out.print(zongpai.get(i)+" ");
        }
    }

}
