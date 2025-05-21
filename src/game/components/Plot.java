package game.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utility.Constants.*;

public abstract class Plot extends JComponent implements MouseListener, KeyListener {
    private final Image[] plotGrowth;
    private final PlotTypes plotType;

    protected PopupMenu menu;

    private int curFrame = 0;

    private boolean doneGrowing;
    private int pos;

    public Plot(int pos){
        this.plotGrowth = new Image[PlotTypes.EMPTY.cycleFrames];
        for (int i = 0; i < plotGrowth.length; i++){
            try {
                BufferedImage img = ImageIO.read(new File("src/graphics/plotImages/" + PlotTypes.EMPTY.name() + "/" + i + ".png"));
                this.plotGrowth[i] = img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.menu = new PopupMenu();
        this.doneGrowing = false;
        this.plotType = PlotTypes.EMPTY;
        this.pos = pos;
    }


    public Plot(PlotTypes plotType, int pos){
        this.plotGrowth = new Image[plotType.cycleFrames];
        for (int i = 0; i < plotGrowth.length; i++){
            try {
                BufferedImage img = ImageIO.read(new File("src/graphics/plotImages/" + plotType.name() + "/" + i + ".png"));
                this.plotGrowth[i] = img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.menu = new PopupMenu();
        this.doneGrowing = false;
        this.plotType = plotType;
        this.pos = pos;
    }

    @Override
    public Dimension getPreferredSize() {return GraphicSizes.plotSize;}

    @Override
    public void paint(Graphics g){
        g.drawImage(plotGrowth[this.curFrame], GameConstants.PLOT_POINT[this.pos].x, GameConstants.PLOT_POINT[this.pos].y, null);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (SwingUtilities.isRightMouseButton(e)){
            this.menu.show(this, e.getX(), e.getY());
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void tickUpdate(){
        if (this.curFrame < this.plotType.cycleFrames-1 && this.plotType.cycleFrames > 1) {
            this.curFrame++;
        } else {
            this.doneGrowing = true;
        }
    }


    public Point getPoint(){
        return GameConstants.PLOT_POINT[this.pos];
    }

    public String getName(){
        return this.plotType.name();
    }

    public void setPlotGrowth(int i){
        this.curFrame = i;
    }

    public boolean isDoneGrowing(){
        return this.doneGrowing;
    }

}
