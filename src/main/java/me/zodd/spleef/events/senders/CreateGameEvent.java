package me.zodd.spleef.events.senders;

import me.zodd.spleef.game.Game;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.EventContext;
import org.spongepowered.api.event.impl.AbstractEvent;

public class CreateGameEvent extends AbstractEvent implements Cancellable {

    private boolean cancellable = false;
    private final Game game;
    private final Cause cause;

    public CreateGameEvent(Game game, Cause cause) {
        this.game = game;
        this.cause = cause;
    }

    public Game getGame() {
        return game;
    }


    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancellable = cancel;
    }

    @Override
    public Cause cause() {
        return this.cause;
    }

    @Override
    public Object source() {
        return super.source();
    }

    @Override
    public EventContext context() {
        return super.context();
    }
}
