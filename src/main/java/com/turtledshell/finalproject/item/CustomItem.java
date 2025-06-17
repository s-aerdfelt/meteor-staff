package com.turtledshell.finalproject.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class CustomItem extends Item {
    static FoodComponent food = new FoodComponent.Builder().nutrition(2).alwaysEdible().saturationModifier(2).build();
    static ConsumableComponent consumable = ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 6 * 20, 1), 1f)).build();
    public CustomItem(Item.Settings settings) {
        super(settings.food(food, consumable));
    }
}