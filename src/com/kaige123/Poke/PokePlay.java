package com.kaige123.Poke;

import java.util.*;

/**
 * 排序类，准备排序的方法
 */
abstract class SortByPaiMian implements Comparator<Poke> {

}

/**
 * 扑克牌的操作类
 */
public class PokePlay {
    private List<Poke> pokesuit = new ArrayList<Poke>();
    private List<Poke>[] players = new ArrayList[]{new ArrayList<Poke>(), new ArrayList<Poke>(), new ArrayList<Poke>()};
    private int indexOfdizhu;

    /**
     * 构造器，同时完成混牌和发牌
     */
    public PokePlay() {
        for (PokeHuaSe h : PokeHuaSe.values()) {
            for (PokePaiMian p : PokePaiMian.values()) {
                if (p.getDaxiao() < 16) {
                    pokesuit.add(new Poke(h, p));
                }
            }
        }
        pokesuit.add(new Poke(PokePaiMian.smallJoker));
        pokesuit.add(new Poke(PokePaiMian.bigJoker));
    }

    /**
     * 选地主，同时添加3张牌
     */
    public void xuanDiZhu() {
        Random random = new Random();
        //混牌 先发出其他牌
        Collections.shuffle(pokesuit);
        Iterator<Poke> pokesuitIterator = pokesuit.iterator();
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 17; j++) {
                if (pokesuitIterator.hasNext()) {
                    players[i].add(pokesuitIterator.next());
                }
            }
        }
        indexOfdizhu = random.nextInt(54) % 3;
        for (int i = 0; i < 3; i++) {
            if (pokesuitIterator.hasNext()) {
                players[indexOfdizhu].add(pokesuitIterator.next());
            }
        }
    }

    /**
     * 给三个人的牌面进行排序
     */
    public void sort() {
        for (int i = 0; i < players.length; i++) {
            Collections.sort(players[i], new SortByPaiMian() {
                @Override
                public int compare(Poke o1, Poke o2) {
                    if (o1.getPaiMian().getDaxiao() > o2.getPaiMian().getDaxiao()) {
                        return -1;
                    } else if (o1.getPaiMian().getDaxiao() == o2.getPaiMian().getDaxiao()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    /**
     * 显示扑克牌的牌面
     */
    public void show() {
        String paimainVal;
        for (int i = 0; i < players.length; i++) {
            System.out.println("\n第" + (i + 1) + "个玩家的牌面：");
            if (i == indexOfdizhu) {
                System.out.println("此玩家是地主");
            }
            for (int j = 0; j < players[i].size(); j++) {
                paimainVal = players[i].get(j).getPaiMian().getPaimianVal();
                if (paimainVal.equals("小王") || paimainVal.equals("大王")) {
                    System.out.print(paimainVal + " ");
//                    System.out.println("大小"+players[i].get(j).getPaiMian().getDaxiao());
                } else {
                    System.out.print(players[i].get(j).getHuaSe().getHuaseVal() + paimainVal + " ");
//                    System.out.println("大小"+players[i].get(j).getPaiMian().getDaxiao());
                }
            }
            System.out.println();
        }
    }
}
