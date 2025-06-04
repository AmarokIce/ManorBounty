package com.djinfinite.manors_bounty.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	/**
	 * 叶子掉落果实的概率
	 * */
	public static final ForgeConfigSpec.ConfigValue<Double> FRUIT_TREE_DROP;
	/**
	 * 叶子开花的概率
	 * */
	public static final ForgeConfigSpec.ConfigValue<Double> FRUIT_TREE_BLOSSOM;
	/**
	 * 叶子执行随机刻的概率
	 * */
	public static final ForgeConfigSpec.ConfigValue<Double> FRUIT_TREE_FRUIT;
	/**
	 * 叶子是否可以开花结果
	 * */
	public static final ForgeConfigSpec.ConfigValue<Double> FRUIT_TREE_LEAVES_FRUIT_CHANCE;
	static {
		BUILDER.push("fruit_tree_common");
		FRUIT_TREE_DROP = BUILDER.comment("The probability of fruit tree leaves falling off when receiving a Random Tick").define("fruit_tree_drop", 0.25);
		FRUIT_TREE_BLOSSOM = BUILDER.comment("The probability of the leaves of fruit trees blooming upon receiving a Random Tick").define("fruit_tree_blossom", 0.3);
		FRUIT_TREE_FRUIT = BUILDER.comment("The probability of fruit tree leaves receiving Random Tick results").define("fruit_tree_fruit", 0.025);
		FRUIT_TREE_LEAVES_FRUIT_CHANCE = BUILDER.comment("The probability that leaves will bloom and bear fruit.").define("fruit_tree_leaves_fruit_chance", 0.4);
		BUILDER.pop();

		SPEC = BUILDER.build();
		/*  BUILDER.push("fruit_tree_common");
  FRUIT_TREE_DROP = BUILDER.comment("config.fruit_tree.drop").define("fruit_tree_drop", 0.25);
  FRUIT_TREE_BLOSSOM = BUILDER.comment("config.fruit_tree.blossom").define("fruit_tree_blossom", 0.3);
  FRUIT_TREE_FRUIT = BUILDER.comment("config.fruit_tree.fruit").define("fruit_tree_fruit", 0.025);
  FRUIT_TREE_LEAVES_FRUIT_CHANCE = BUILDER.comment("config.fruit_tree.leaves_fruit_chance").define("fruit_tree_leaves_fruit_chance", 0.4);
  BUILDER.pop();

  SPEC = BUILDER.build();*/
	}

}
