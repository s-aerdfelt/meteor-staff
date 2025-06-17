package com.turtledshell.finalproject.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BlazeSword extends Item {

    public BlazeSword(Settings settings) {
        super(settings.fireproof().maxCount(1).sword(ToolMaterial.NETHERITE, 11, -2.5f));
    }
}