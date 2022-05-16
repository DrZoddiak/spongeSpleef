package me.zodd.spleef.events.senders;

import me.zodd.spleef.Spleef;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.impl.AbstractEvent;

public abstract class AbstractSpleefEvent extends AbstractEvent implements Cancellable {

    private final Spleef instance;

    private boolean cancel = false;

    AbstractSpleefEvent(Spleef instance) {
        this.instance = instance;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public Cause cause() {
        return Cause.of(instance.getEventContext(), instance.getPlugin());
    }
}
