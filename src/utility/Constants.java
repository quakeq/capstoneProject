package utility;

import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static final Dimension plotSize = new Dimension(100,100);
        public static final Dimension windowMinSize = new Dimension(1000,1000);
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
        public static final int MAX_FARM_PLOTS = 9;
        public static final int startMoney = 10;

        public static final Point[] PLOT_POINT = {
                new Point(100,100), new Point(500, 100), new Point(900, 100),
                new Point(100, 500), new Point(500, 500), new Point(900,500),
                new Point(100, 900), new Point(500,900), new Point(900, 900)
        };
    }
}
