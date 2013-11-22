package me.messageofdeath.MobLimit.Utils.MobManager;

import org.bukkit.entity.EntityType;

public class MobManager {
	
	public MobType getMobType(EntityType type) {
		switch(type) {
			case CHICKEN:
			case COW:
			case OCELOT:
			case PIG:
			case SHEEP:
			case HORSE:
			case SQUID:
			case BAT:
			case VILLAGER:
			case MUSHROOM_COW:
				return MobType.Passive;
			case CAVE_SPIDER:
			case ENDERMAN:
			case SPIDER:
			case WOLF:
			case PIG_ZOMBIE:
				return MobType.Neutral;
			case BLAZE:
			case CREEPER:
			case GHAST:
			case MAGMA_CUBE:
			case SILVERFISH:
			case SKELETON:
			case SLIME:
			case WITCH:
			case ZOMBIE:
			case ENDER_DRAGON:
			case WITHER:
				return MobType.Aggressive;
			default:
				return MobType.Other;
		}
	}
}
