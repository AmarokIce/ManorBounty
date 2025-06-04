package com.djinfinite.manors_bounty.registries;

import com.djinfinite.manors_bounty.ManorsBountyMod;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> FRYER_USABLE_ITEM = ItemTags.create(ManorsBountyMod.createModResourceLocation("fryer_useable_item"));
}
