package me.zodd.spleef.events.listeners;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;

public class BreakBuildListener {

    @Listener
    public void onBlockModification(ChangeBlockEvent.Pre event) {
        //TODO Check if players are in game
        //TODO Check if location is inside of arena
        List<ServerLocation> locations = event.locations();

        event.setCancelled(true);
    }

}
