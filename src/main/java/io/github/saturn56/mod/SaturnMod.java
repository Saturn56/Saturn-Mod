package io.github.saturn56.mod;

import io.github.saturn56.mod.hacks.AutoFishing;
import io.github.saturn56.mod.hacks.FlightHack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaturnMod implements ModInitializer {


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
		instance = this;
		LOGGER.info("Hello Fabric world!");
		ClientTickEvents.START_CLIENT_TICK.register(client1 -> AutoFishing.tick(client));
		ClientTickEvents.START_CLIENT_TICK.register(client1 -> FlightHack.tick(client));
	}

	private static SaturnMod instance;
	public AutoFishing autoFishing;
	public FlightHack flightHack;
	public static SaturnMod getInstance() {
		return instance;
	}

	public AutoFishing getAutoFishing() {
		return autoFishing;
	}

	public FlightHack getFlightHack() {
		return flightHack;
	}
}
