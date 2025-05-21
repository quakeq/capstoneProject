package utility;

import javax.swing.*;
import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static Dimension plotSize = new Dimension(200,200);
        public static Dimension windowMinSize = new Dimension(1200,800);
    }
    public enum PlotTypes{
        ANIMAL(3),
        FISH(2),
        HYDROPONIC(3),
        PLANT(4),
        SHOP(1),
        REALTOR(1),
        MARKET(1),
        EMPTY(1);


        public final int cycleFrames;

        PlotTypes(int cycleFrames){
            this.cycleFrames = cycleFrames;

        }
    }
    public enum ShopItems{
        FERTILIZER()
    }

    public static class GameConstants{
        public static int MAX_FARM_PLOTS = 9;
        public static int startMoney = 10;

        public static Point[] PLOT_POINT = {
                new Point(0,0), new Point(200, 0),new Point(400, 0),
                new Point(0, 200), new Point(200, 200), new Point(400,200),
                new Point(0, 400), new Point(200,400), new Point(400, 400)
        };

    }
}
