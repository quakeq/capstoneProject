package src.game.components;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static src.utility.Constants.*;

public abstract class Plot extends Component implements KeyListener {
    private final Image[] plotGrowth;
    private final PlotTypes plotType;

    private int curFrame = 0;

    private Point pos;

    public Plot(PlotTypes plotType, Point point){
        this.plotGrowth = new Image[plotType.cycleFrames];
        for (int i = 0; i < plotGrowth.length; i++){
            try {
                BufferedImage img = ImageIO.read(new File("src/game/resources/plotImages" + plotType.name() + "/" + i + ".png"));
                plotGrowth[i] = img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
            } catch (IOException ignored) {}
        }
        this.plotType = plotType;
        this.pos = point;
    }

    @Override
    public Dimension getPreferredSize() {return GraphicSizes.plotSize;}

    @Override
    public void paint(Graphics g){
        g.drawImage(plotGrowth[curFrame], pos.x, pos.y, null);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Point getPos() {
        return pos;
    }

    public void interaction(){}

    public void tickUpdate(){
        if (this.curFrame < plotType.cycleFrames){
            this.curFrame++;
        } else {
            this.curFrame = 0;
        }
    }

}
