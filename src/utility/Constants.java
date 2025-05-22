package utility;

import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static Dimension plotSize = new Dimension(200,200);
        public static Dimension windowMinSize = new Dimension(1200,800);
        public static Dimension plotPanelSize = new Dimension(1200,600);
        public static Dimension uiPanelSize = new Dimension(1000, 165);
        public static Dimension iconSize = new Dimension(64,64);
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
    public enum MoneyItems {
        FERTILIZER(true, true, 10, 50),
        SEEDS(true, false, 0, 20),
        EGGS(true, true, 20, 100),
        WHEAT(false, true, 15, 0);

        public final boolean buyable;
        public final boolean sellable;
        public final double sellCost;
        public final double buyCost;
        MoneyItems(boolean buyable, boolean sellable, double sellCost, double buyCost){
            this.buyable = buyable;
            this.sellable = sellable;
            this.sellCost = sellCost;
            this.buyCost = buyCost;
        }
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
