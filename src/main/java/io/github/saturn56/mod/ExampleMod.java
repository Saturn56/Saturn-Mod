package io.github.saturn56.mod;

import io.github.saturn56.mod.hacks.AutoFishing;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	private static ExampleMod instance;
	public AutoFishing autoFishing;

	public static final Logger LOGGER = LoggerFactory.getLogger("Saturn-Mod");

	public Boolean Toggle1_ENABLED = false;
	public Boolean Toggle_xRay = false;
	public Boolean Toggle_ClientConnectionPacket = false;
	public Boolean Toggle_SoundPacket = false;
	public Boolean Toggle_AutoFish = false;
	public int recastRod = -1;



	@Override
	public void onInitialize() {
		MinecraftClient client = MinecraftClient.getInstance();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		instance = this;
		LOGGER.info("Hello Fabric world!");
		ClientTickEvents.START_CLIENT_TICK.register(client1 -> AutoFishing.tick(client));
	}


	public static ExampleMod getInstance() {
		return instance;
	}
}
