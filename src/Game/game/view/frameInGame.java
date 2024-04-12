package Game.game.view;

import javax.swing.*;
import java.awt.*;

import static Game.Data.constants.GLASS_FRAME_DIMENSION;

public final class frameInGame extends JFrame {
    private static frameInGame frame;

    public static frameInGame getFrame() {
        if (frame == null) {
            frame = new frameInGame();
        }
        return frame;
    }

    private frameInGame() {
        setUndecorated(true);
        setFocusable(true);
        setFocusableWindowState(true);
        setBackground(new Color(0, 0, 0, 0));
        setSize(GLASS_FRAME_DIMENSION);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
    }

    public frameInGame(int width, int height) {
        this();
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
    }


    public frameInGame(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public frameInGame(int x, int y, int width, int height) {
        this();
        setBounds(x, y, width, height);
    }
}
