package com.djinfinite.manors_bounty.items;

public enum FoodType {
    //甜浆果
    SWEET_BERRIES("sweet_berries"),
    //发光浆果
    GLOW_BERRIES("glow_berries"),
    //蓝莓
    BLUEBERRIES("blueberries"),
    //草莓
    STRAWBERRY("strawberry"),
    //蔓越莓
    CRANBERRY("cranberry"),
    //苹果
    APPLE("apple"),
    //蜜桃
    PEACH("peach"),
    //洋梨
    PEAR("pear"),
    //柑橙
    ORANGE("orange"),
    //柠檬
    LEMON("lemon"),
    //香柚
    YUZUMELO("yuzumelo"),
    //车厘子
    CHERRIES("cherries"),
    //樱花树叶
    CHERRY_LEAVES("cherry_leaves"),
    //杨桃
    STARFRUIT("starfruit"),
    //菠萝
    PINEAPPLE("pineapple"),
    //芒果
    MANGO("mango"),
    //西瓜
    MELON("melon"),
    //哈密瓜
    HAMI_MELON("hami_melon"),
    //橄榄果
    OLIVE_FRUIT("olive_fruit"),
    //猫山王榴莲
    DURIAN("durian"),
    //火龙果
    DRAGON_FRUIT("dragon_fruit"),
    //猕猴桃
    KIWIFRUIT("kiwifruit"),
    //牛油果
    AVOCADO("avocado"),
    //深海明珠沙拉
    SEA_PEARL_SALAD("sea_pearl_salad"),
    //马天尼
    MARTINI("martini"),
    //浆果奶昔
    GRIMACE_SHAKE("grimace_shake"),
    //紫颂果
    CHORUS_FRUIT("chorus_fruit"),

    ROSA_SALAD("rosa_salad"),
    COSMIC_DRAGON_SALAD("cosmic_dragon_salad"),
    MELON_SALAD("melon_salad"),
    BLUEBERRY_AND_CHERRIES_ICE_CREAM("blueberry_and_cherries_ice_cream"),
    POWSICLE_PALETERIA("powsicle_paleteria"),
    PINK_SNOWMAN_PALETERIA("pink_snowman_paleteria"),
    HEART_CRUSH_PALETERIA("heart_crush_paleteria"),
    STARFRUIT_JALAPENO_ICE_CREAM("starfruit_jalapeno_ice_cream"),
    LUAU_PALETERIA("luau_paleteria"),
    PINE_BERRY("pine_berry");
    final String name;
    FoodType(String name){
        this.name = name;
    }


}
