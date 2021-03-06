package com.mcmoddev.basemetals.properties;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.IMMDObject;
import com.mcmoddev.lib.material.MMDMaterial;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ColdIronProperty extends BMEPropertyBase {
	@Override
	public void apply(ItemStack stack) {
		if(hasEffect(stack)) {
			// only apply if there is an effect
			// we should always double check here :)
		}
	}

	@Override
	public void apply(ItemStack stack, EntityPlayer player) {
		//if(hasEffect(stack, player)) {                        
			if (hasFullSuit(player, MaterialNames.COLDIRON)) { 
				final PotionEffect fireProtection = new PotionEffect(MobEffects.FIRE_RESISTANCE,
						EFFECT_DURATION, 0, false, false);
				player.addPotionEffect(fireProtection);
			}
      	//}
	}

	@Override
	public void apply(ItemStack stack, EntityLivingBase ent) {
		if (ent instanceof EntityPlayer) { // Checks for full suit should be done in the second "apply" call
			apply(stack, (EntityPlayer)ent);
		}
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false; // no effect for just the stack
	}

	@Override
	public boolean hasEffect(ItemStack stack, EntityPlayer player) {
		MMDMaterial mat = Materials.getMaterialByName(MaterialNames.COLDIRON);
/*
		boolean rv = (stackIsArmorMaterial(stack, mat) 
				&& ((stack.getItem() instanceof IMMDObject) && 
						(((IMMDObject)stack.getItem()).getMMDMaterial() == mat))) && 
				(countArmorPieces(Materials.getMaterialByName(MaterialNames.COLDIRON),player) > 0);
 */
		return true;
	}

	@Override
	public boolean hasEffect(ItemStack stack, EntityLivingBase ent) {
		return ent instanceof EntityPlayer?hasEffect(stack, (EntityPlayer)ent):false;
	}
}
