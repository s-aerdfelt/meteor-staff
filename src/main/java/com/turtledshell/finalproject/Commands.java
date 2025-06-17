package com.turtledshell.finalproject;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.turtledshell.finalproject.item.MeteorStaff;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class Commands {
    public static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("meteor_power").then(CommandManager.argument("Power", IntegerArgumentType.integer(0, 127)).executes(context -> {
                MeteorStaff.power=(byte)IntegerArgumentType.getInteger(context, "Power");
                context.getSource().sendFeedback(() -> Text.literal("Set Meteor Power to "+IntegerArgumentType.getInteger(context, "Power")), false);
                return 1;
            })));
        });
    }
}
