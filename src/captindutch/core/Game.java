package captindutch.core;

import captindutch.StateManager;
import captindutch.input.KeyManager;
import captindutch.states.GameState;
import captindutch.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    public static final boolean HIT_BOX_DEBUG = false;

    private int width, height;
    private Display display;
    private KeyManager keyManager;
    private GameCamera gameCamera;
    private Thread thread;
    private boolean running;
    public String title;

    // States
    private State gameState;

    private Handler handler;

    private Graphics g;
    private BufferStrategy bs;

    public Game(String title, int width, int height) {
        this.title = title;
        running = false;
        this.width = width;
        this.height = height;
    }


    private void init() {

        // Load assets
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        // Set state
        gameState = new GameState(handler);
        StateManager.setState(gameState);

        // create display
        display = new Display(title, width, height);
        keyManager = new KeyManager();
        display.getFrame().addKeyListener(keyManager);
    }


    private void render() {

        // Setup buffer strategy
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        // graphics
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,width,height);

        BufferedImage tmp = Assets.getAsset(57);


        if(StateManager.getState() != null)
            StateManager.getState().render(g);

        //g.drawImage(Assets.getAsset(1735), 0, 0, 500, 500, null);
        bs.show();
        g.dispose();
    }

    private void tick() {

        keyManager.tick();

        if(StateManager.getState() != null)
            StateManager.getState().tick();
    }


    public void run () {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    synchronized void start() {

        if (running) return;

        running = true;

        thread = new Thread(this);
        thread.start();
    }

    synchronized void stop() {

        if (!running) return;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
