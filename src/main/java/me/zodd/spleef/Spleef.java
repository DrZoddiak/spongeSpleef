package me.zodd.spleef;

import com.google.inject.Inject;
import me.zodd.spleef.events.listeners.BreakBuildListener;
import me.zodd.spleef.events.listeners.PlayerDeath;
import me.zodd.spleef.game.GameManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.event.EventContext;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.event.lifecycle.StartingEngineEvent;
import org.spongepowered.api.event.lifecycle.StoppingEngineEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("spleef")
public class Spleef {

    private final PluginContainer plugin;
    private final Logger logger;
    private final Spleef instance;

    private GameManager manager;

    private final EventContext eventContext;


    @Inject
    Spleef(final PluginContainer plugin, final Logger logger) {
        this.plugin = plugin;
        this.logger = logger;
        this.instance = this;

        eventContext = EventContext.builder().add(EventContextKeys.PLUGIN, plugin).build();
    }

    @Listener
    public void onConstructPlugin(final ConstructPluginEvent event) {
        // Perform any one-time setup
        this.logger.info("Constructing spleef");

        manager = new GameManager(instance);

        Sponge.eventManager()
                .registerListeners(getPlugin(), new PlayerDeath())
                .registerListeners(getPlugin(), new BreakBuildListener());
    }

    @Listener
    public void onServerStarting(final StartingEngineEvent<Server> event) {
        // Any setup per-game instance. This can run multiple times when
        // using the integrated (singleplayer) server.
    }

    @Listener
    public void onServerStopping(final StoppingEngineEvent<Server> event) {
        // Any tear down per-game instance. This can run multiple times when
        // using the integrated (singleplayer) server.
    }

    @Listener
    public void onRegisterCommands(final RegisterCommandEvent<Command.Parameterized> event) {
        // Register a simple command
        // When possible, all commands should be registered within a command register event
        final Parameter.Value<String> nameParam = Parameter.string().key("name").build();
        event.register(this.plugin, Command.builder()
                .addParameter(nameParam)
                .permission("spleef.command.greet")
                .executor(ctx -> {
                    //temporary;

                    return CommandResult.success();
                })
                .build(), "greet", "wave");
    }

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getPlugin() {
        return plugin;
    }

    public GameManager getManager() {
        return manager;
    }

    public EventContext getEventContext() {
        return eventContext;
    }

    public Spleef getInstance() {
        return instance;
    }
}
