package com.kaige123.Poke;

/**
 * 牌面的枚举类
 */
public enum PokePaiMian {
    Three(3,"3"), Four(4,"4"), Five(5,"5"), Six(6,"6"), Seven(7,"7"), Eight(8,"8"), Nine(9,"9"), Ten(10,"10"),
    Jack(11,"J"), Queen(12,"Q"), King(13,"K"), Ace(14,"A"), Two(15,"2"), smallJoker(16,"小王"), bigJoker(17,"大王");

    private int daxiao;

    private String paimianVal;

    PokePaiMian(int d, String p) {
        this.daxiao = d;
        this.paimianVal = p;
    }

    /**
     * 获得牌面值的大小
     * @return 大小
     */
    public int getDaxiao() {
        return daxiao;
    }

    /**
     * 获得牌面值的描述
     * @return 描述
     */
    public String getPaimianVal() {
        return paimianVal;
    }

}
