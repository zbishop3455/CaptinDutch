package captindutch.core;

public class Launcher {

    public Launcher () {

    }

    public static void main(String[]args){
        Game game = new Game("Captin Dutch Adventures!", 800, 600);
        game.start();
    }
}
