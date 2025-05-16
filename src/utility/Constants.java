package src.utility;

import java.awt.*;

public class Constants {
    public static class GraphicSizes {
        public static final Dimension plotSize = new Dimension(100,100);
        public static final Dimension windowMinSize = new Dimension(1000,1000);
    }
    public enum PlotTypes{
        ANIMAL(3),
        FISH(2),
        HYDROPONIC(4),
        PLANT(4),
        SHOP(0),
        REALTOR(0),
        MARKET(0),
        HOUSE(0);


        public final int cycleFrames;

        PlotTypes(int cycleFrames){
            this.cycleFrames = cycleFrames;
        }
    }

    public static class GameConstants{
        public static final int MAX_FARM_PLOTS = 12;
    }
}
