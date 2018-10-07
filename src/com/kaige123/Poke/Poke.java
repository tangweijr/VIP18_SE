package com.kaige123.Poke;

/**
 * 扑克牌类，每一个扑克牌都是一个实例对象
 */
public class Poke implements Comparable{
    private PokeHuaSe huaSe;
    private PokePaiMian paiMian;

    public PokeHuaSe getHuaSe() {
        return huaSe;
    }

    public PokePaiMian getPaiMian() {
        return paiMian;
    }

    public Poke(PokeHuaSe huase, PokePaiMian paimian) {
        this.huaSe = huase;
        this.paiMian = paimian;
    }

    public Poke(PokePaiMian paimian) {
        this.paiMian = paimian;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getPaiMian().getDaxiao() > ((Poke)o).getPaiMian().getDaxiao()) {
            return -1;
        } else if (this.getPaiMian().getDaxiao() == ((Poke)o).getPaiMian().getDaxiao()) {
            return 0;
        } else {
            return 1;
        }
    }
}
