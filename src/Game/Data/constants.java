package Game.Data;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.concurrent.TimeUnit;

public class constants {
    public static final String PROJECT_NAME = "Window Kill";
    public static final int LOGIN_WIDTH = 900;
    public static final int LOGIN_HEIGHT = 531;
    public static final int LOGIN_X = 150;
    public static final int LOGIN_Y = 331;
    public static final int LOGIN_TUTORIAL_X = 476;
    public static final int LOGIN_TUTORIAL_Y = 416;
    public static final int LOGIN_BUTTON_WIDTH = 163;
    public static final int LOGIN_BUTTON_HEIGHT = 184;
    public static final int LOGIN_SETTING_Y = 266;
    public static final int LOGIN_SETTING_X = 52;
    public static final int LOGIN_START_X = 246;
    public static final int LOGIN_START_Y = 27;
    public static final int LOGIN_SKILL_TREE_X = 691;
    public static final int LOGIN_SKILL_TREE_Y = 156;
    public static final int LOGIN_EXIT_X = 0;
    public static final int LOGIN_EXIT_Y = 0;
    public static final int LOGIN_EXIT_WIDTH = 77;
    public static final int LOGIN_EXIT_HEIGHT = 41;
    public static final String LOGIN_PHOTO_PATH = "src\\sources\\photo\\login.png";
    public static final String PROJECT_ICON_PATH = "src\\sources\\photo\\imageICon.png";
    //  public static final Dimension FIRST_GAME_FRAME_DIMENSION = new Dimension(700, 700);
    public static final int FPS = GraphicsEnvironment.getLocalGraphicsEnvironment ().getScreenDevices ()[0].getDisplayMode ().getRefreshRate ();
    public static final double FRAME_UPDATE_TIME = (double) TimeUnit.SECONDS.toMillis (1) / FPS;
    public static final int UPS = 100;
    public static final double MODEL_UPDATE_TIME = (double) TimeUnit.SECONDS.toMillis (1) / UPS;
    public static final double SPEED = 3 * 60D / UPS;
    public static final Dimension GLASS_FRAME_DIMENSION = Toolkit.getDefaultToolkit ().getScreenSize ();
    public static final Dimension FIRST_PANEL_DIMENSION = new Dimension (780, 780);
    public static final Rectangle FIRST_PANEL_RECTANGLE = new Rectangle (new Point ((GLASS_FRAME_DIMENSION.width - FIRST_PANEL_DIMENSION.width) / 2, (GLASS_FRAME_DIMENSION.height - FIRST_PANEL_DIMENSION.height) / 2), FIRST_PANEL_DIMENSION);
    public static final Dimension SMALLEST_SIZE_OF_ORIGINAL_PANEL = new Dimension (400, 400);
    public static final double RADIUS_OF_EPSILON = 12;
    public static final double HEIGHT_OF_TRIANGLE = 2.5 * RADIUS_OF_EPSILON;
    public static final double SIDE_OF_TRIANGLE = Math.sqrt ((HEIGHT_OF_TRIANGLE * HEIGHT_OF_TRIANGLE * 4) / 3);
    public static final Color TRIANGLE_COLOR = Color.YELLOW;
    public static final double SIDE_OF_SQUARE = HEIGHT_OF_TRIANGLE;
    public static final Color SQUAER_COLOR = Color.GREEN;
    public static final double TRIANGLE_SAFE_DISTANCE = 60;
    public static int SPEED_OF_ADDING_BOLT = 600;
    public static Color PANEL_BACK_GRAND = Color.BLACK;
    public static Color PANEL_BAR_GRAND = Color.red;
    public static double RANGE_OF_INCREASE_SIZE = 15;
    public static double RANGE_OF_INCREASE_PLACE = RANGE_OF_INCREASE_SIZE;
    public static double DECREASE_OF_PANEL = 2;
    public static final double IMPACT_POWER = 50;
    public static double DELAY_OF_CLOSE_FRAME = 20;
    public static final int IMPACT_CYCLE = 15;
    public static final String  FIRE_BOLT_PATH = "src\\sources\\song\\water drop.wav";
    public static final String ENEMY_DESTROID_SOUND_PATH1 = "src\\sources\\song\\Big-Glass-Breaking-Combo-www.fesliyanstudios.com.wav";
    public static final String ENEMY_DESTROID_SOUND_PATH2 = "src\\sources\\song\\glass-breaking-93803.wav";

}
