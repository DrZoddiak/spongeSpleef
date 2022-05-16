package me.zodd.spleef.lobby;

import me.zodd.spleef.interfaces.ManagerInterface;

public class LobbyManager implements ManagerInterface<Lobby> {
    @Override
    public Lobby create() {
        return new Lobby();
    }

    @Override
    public boolean destroy() {
        //TODO
        return false;
    }
}
