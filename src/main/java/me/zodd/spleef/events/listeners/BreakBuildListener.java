package me.zodd.spleef.events.listeners;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.network.status.StatusResponse;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BreakBuildListener {
    @Listener
    public void onBlockModification(ChangeBlockEvent.Pre event) {
        List<Player> users = new ArrayList<>();
                for(org.spongepowered.api.entity.living.player.Player player : Sponge.server().onlinePlayers()){
                    users.add(player);
        }
        //TODO Check if location is inside of arena
        List<ServerLocation> locations = event.locations();

        event.setCancelled(true);
    }

}
