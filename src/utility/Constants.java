package utility;

import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static Dimension plotSize = new Dimension(200,200);
        public static Dimension windowMinSize = new Dimension(1200,800);
        public static Dimension plotPanelSize = new Dimension(1200,600);
        public static Dimension uiPanelSize = new Dimension(1200, 145);
        public static Dimension iconSize = new Dimension(64,64);
        public static Dimension menuIconSize = new Dimension(150,150);
    }
    public enum PlotTypes{
        CHICKEN(5),
        COW(5),
        RICE(4),
        WHEAT(4),
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
        RICE(false, true, 5, 0),
        RICE_SEEDS(true, false, 0, 10),
        EGGS(false, true, 20, 0),
        FERTILIZER(true, true, 10, 20),
        SEEDS(true, false, 0, 10),
        WHEAT(false, true, 20, 0),
        BEEF(false, true, 200, 0),
        CALF(true, false, 0, 80),
        CHICKEN(true, false, 0, 100),
        CHICKEN_BUTCHERED(false, true, 50, 0);


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
        public static int startMoney = 10000;

        public static Point[] PLOT_POINT = {
                new Point(0,0), new Point(200, 0),new Point(400, 0),
                new Point(0, 200), new Point(200, 200), new Point(400,200),
                new Point(0, 400), new Point(200,400), new Point(400, 400),


                new Point(600,0), new Point(600,200), new Point(600,400)
        };
    }
}
