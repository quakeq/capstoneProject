package utility;

import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static Dimension plotSize = new Dimension(200,200);
        public static Dimension renderSize = new Dimension(plotSize.width+10, plotSize.height+10);
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
                new Point(0,0), new Point(100, 0), new Point(200, 0),
                new Point(0, 130), new Point(100, 130), new Point(200,130),
                new Point(0, 260), new Point(100,260), new Point(200, 260)
        };

    }
}
