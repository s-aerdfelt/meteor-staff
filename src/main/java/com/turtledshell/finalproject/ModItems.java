package com.turtledshell.finalproject;

import com.turtledshell.finalproject.item.BlazeSword;
import com.turtledshell.finalproject.item.CustomItem;
import com.turtledshell.finalproject.item.MeteorStaff;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {
    private ModItems() {
    }

    public static final Item CUSTOM_ITEM = register("custom_item", CustomItem::new, new Item.Settings());
    public static final Item BLAZE_SWORD = register("blaze_sword", BlazeSword::new, new Item.Settings());
    public static final Item METEOR_STAFF = register("meteor_staff", MeteorStaff::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("finalproject", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {

    }
}

