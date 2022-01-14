package game;

public class GameLoop {

    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void run() {
        while (game.isRunning()) {
            game.update();
            game.render();
        }

    }

}
