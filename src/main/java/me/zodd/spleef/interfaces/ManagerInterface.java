package me.zodd.spleef.interfaces;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Event;

public interface ManagerInterface<T> {

    /**
     * @return new instance of T
     */
    T create();

    /**
     * @return true if operation is successful
     */
    default boolean destroy() {
        return false;
    }

    /**
     * @param event to post to the event manager
     */
    default void postEvent(Event event) {
        Sponge.eventManager().post(event);
    }
}
