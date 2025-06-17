package com.turtledshell.finalproject.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class MeteorStaff extends Item {
    public static byte power=0;
    private final static double reach = 25;
    public MeteorStaff(Settings settings) {
        super(settings.fireproof().maxCount(1).sword(ToolMaterial.NETHERITE, 2.5f, -2.5f));
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }
        // eye -----X[][][]----- end
        // raycast from eye to a point reach amount out from eye
        Vec3d eye = user.getEyePos();
        Vec3d end = user.getRotationVec(1.0F).multiply(reach).add(eye);
        RaycastContext context = new RaycastContext(eye, end, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user);
        BlockPos blockPos = world.raycast(context).getBlockPos();
        if (blockPos==null) {
            return ActionResult.PASS;
        }

        Vec3d fireballPos = blockPos.toCenterPos().add(7.5-Math.random()*15, 25, 7.5-Math.random()*15);
        FireballEntity fireball = new FireballEntity(world, user, blockPos.toCenterPos().subtract(fireballPos).multiply(0.05), power);
        fireball.setPosition(fireballPos);
        world.spawnEntity(fireball);
        return ActionResult.SUCCESS;
    }
}
