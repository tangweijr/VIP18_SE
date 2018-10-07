package com.kaige123.Poke;

/**
 * 花色的枚举类
 */
public enum PokeHuaSe {
    Spade("黑桃"), Heart("红心"), Diamond("方块"), Club("梅花");

    private String huaseVal;

    PokeHuaSe(String h) {
        this.huaseVal = h;
    }

    /**
     * 获得枚举类的值
     * @return 花色值
     */
    public String getHuaseVal() {
        return huaseVal;
    }

}
