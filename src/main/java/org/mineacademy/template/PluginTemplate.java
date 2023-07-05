package org.mineacademy.template;

import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.CompMaterial;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class PluginTemplate extends SimplePlugin {

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */

	@Override
	protected void onPluginStart() {
	}

	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param e is the Event
	 */
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent e) {
		EntityType animal = EntityType.COW;
		String animalState1 = "im on land";
		String animalState2 = "Im in the water!";
		if (e.getRightClicked().isOnGround() && e.getRightClicked().getType() == animal) {
			e.getRightClicked().setCustomName(animalState1);
		}
		if (e.getRightClicked().isInWater() && e.getRightClicked().getType() == animal) {
			e.getRightClicked().setCustomName(animalState2);
			e.getRightClicked().getWorld().createExplosion(e.getRightClicked().getLocation(), 5);
		}
	}

	@EventHandler
	public void onRightClickAnything(PlayerInteractEvent e) {
		System.out.println("We've started handling click events!");

		if (e.getClickedBlock().getType() == CompMaterial.GRASS_BLOCK.getMaterial()) {
			handleClickingGrass(e.getClickedBlock(), e.getPlayer());
		}

		System.out.println("...And were done!");
	}

	void handleClickingGrass(Block block, Player player) {
		block.setType(CompMaterial.DIAMOND_BLOCK.getMaterial());

		player.sendMessage("you've turned this block into a diamond!");
	}
}

