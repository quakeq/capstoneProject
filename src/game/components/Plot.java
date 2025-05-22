package game.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utility.Constants.*;

public abstract class Plot extends JComponent implements MouseListener, KeyListener {
    private final Image[] plotGrowth;
    private final PlotTypes plotType;
    protected final JPopupMenu popupMenu = new JPopupMenu();


    protected PopupMenu menu;

    private int curFrame = 0;

    protected boolean isEmpty;
    protected boolean isDoneGrowing;
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
        this.isDoneGrowing = false;
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
        this.isDoneGrowing = false;
        this.plotType = plotType;
        this.pos = pos;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(plotGrowth[this.curFrame], 0,0, getWidth(), getHeight(), this);
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
        if (Math.random() > 0.5){
            if (this.curFrame < this.plotType.cycleFrames-1 && this.plotType.cycleFrames > 1 && !this.isEmpty) {
                this.curFrame++;
            }
        }

    }
    public void fastUpdate(){
        if (this.curFrame == this.plotType.cycleFrames-1){
            this.isDoneGrowing = true;
        }
        if (this.isEmpty){
            this.curFrame = 0;
        }
    }

    public void setMenu(){

        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
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
    public PlotTypes getPlotType(){
        return this.plotType;
    }


    public boolean isDoneGrowing(){
        return this.isDoneGrowing;
    }
    public boolean isEmpty(){
        return this.isEmpty;
    }



}
