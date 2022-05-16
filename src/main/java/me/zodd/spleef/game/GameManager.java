package me.zodd.spleef.game;

import me.zodd.spleef.Spleef;
import me.zodd.spleef.events.senders.CreateGameEvent;
import me.zodd.spleef.interfaces.ManagerInterface;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.api.event.Listener;

import java.util.Map;

public class GameManager implements ManagerInterface<Game> {

    static Map<Integer, Game> activeGames;

    static int runningGames = 0;

    Spleef instance;

    public GameManager(Spleef instance) {
        this.instance = instance;
    }

    @Listener
    public void onGameCreate(CreateGameEvent event) {
        if (event.isCancelled()) return;

        Game game = event.getGame();
    }

    private Game createGame() {
        Game game = new Game(runningGames);
        activeGames.put(runningGames++, game);
        return game;
    }

    private Game createGame(GameSettings settings) {

        Game game = new Game(runningGames, settings);

        CreateGameEvent gameEvent = new CreateGameEvent(game, instance);

        postEvent(gameEvent);

        activeGames.put(runningGames++, game);
        return game;
    }

    public void destroyGame(int gameId) {
        activeGames.remove(gameId);
        //todo Breakdown process for the game
    }

    @Nullable
    public Game getActiveGame(int gameId) {
        return activeGames.get(gameId);
    }

    @Override
    public Game create() {
        return null;
    }

    @Override
    public boolean destroy() {
        return ManagerInterface.super.destroy();
    }
}
