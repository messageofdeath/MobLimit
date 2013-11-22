package me.messageofdeath.MobLimit.Listener;

import me.messageofdeath.MobLimit.MobLimit;
import me.messageofdeath.MobLimit.Utils.MobManager.MobType;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class EntityListener implements Listener {
	
	private MobLimit instance;
	
	public EntityListener(MobLimit instance) {
		this.instance = instance;
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onEntitySpawnEvent(CreatureSpawnEvent event) {
		if(this.instance.getMobManager().getMobType(event.getEntityType()) == MobType.Passive) {
			if(event.getSpawnReason() != SpawnReason.EGG && event.getSpawnReason() != SpawnReason.SPAWNER
					&& event.getSpawnReason() != SpawnReason.SPAWNER_EGG && event.getSpawnReason() != SpawnReason.BREEDING) {
				event.setCancelled(true);
			}
		}
		if(this.instance.getMobManager().getMobType(event.getEntityType()) == MobType.Aggressive) {
			if(!this.instance.getTimer().isSpawned()) {
				this.instance.getTimer().setSpawned(true);
			}
		}
	}
}
