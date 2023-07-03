package org.mineacademy.template;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;

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

	int firstNumber = 5;
	int secondNumber = 10;
	int result = firstNumber - secondNumber;

	@Override
	protected void onPluginStart() {
		System.out.println("Plugin has started!");


		String hello = "hello! " + "Hello!";
		String multiLine = "This is the first part"
				+ "of a multi-line message";
	}

	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param e Hello
	 *
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
//int multiply(int firstNumber, int secondNumber) {
//	int result = firstNumber * secondNumber;/* This line is redundant, could just do
//											  return firstNumber * secondNumber; */
//	return result;
//} 			(event.getRightClicked().isOnGround() && event.getRightClicked().getType() == cow);
//			event.getRightClicked().setCustomName(cowName1);
}

