package optional.app;

import optional.app.shapes.Star;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawPanel extends JPanel
{
    List<ShapeSpecifications> shapes=new ArrayList<>();
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    /**
     * constructor
     * @param frame
     */
    public DrawPanel(MainFrame frame)
    {
        this.frame = frame; createOffscreenImage(); init();
    }

    /**
     * this method create the screen image
     */
    private void createOffscreenImage()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * this method analyzes 2 cases: when "Draw" is checked or when "Delete" is checked
     * in the case of "Delete" the list of optional.app.shapes is scrolled
     * and when the sum of the squares of the mouse coordinates is less than or equal to the size^2
     * and the figure is removed from the list
     */
    private void init()
    {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (frame.selectShapePanel.draw.isSelected())
                {
                    drawShape(e.getX(), e.getY());
                    repaint();
                }
                if (frame.selectShapePanel.del.isSelected())
                {
                    int x=e.getX();
                    int y=e.getY();
                    for (int i=shapes.size()-1;i>=0;i--)
                    {
                        ShapeSpecifications temp=shapes.get(i);
                        if ((x - temp.x)*(x - temp.x) + (y - temp.y)*(y - temp.y) <=temp.radius*temp.radius)
                        {
                            shapes.remove(i);
                            i=-1;
                        }
                    }
                    frame.canvas.graphics.setColor(Color.WHITE);
                    frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
                    frame.repaint();
                }
            }
        });
    }

    /**
     * this method takes over the shape setup
     * add the shape to the list of optional.app.shapes
     *
     * @param x
     * @param y
     */
    private void drawShape(int x, int y)
    {

        int sides=(int)frame.configPanel.sidesField.getValue() ;
        Color color =Color.BLACK;
        String col=frame.configPanel.colorCombo.getSelectedItem().toString();

        if(col.equals("Random Color"))
        {
            int r,g,b;
            r=(int)(Math.random()*1000)%255;
            g=(int)(Math.random()*1000)%255;
            b=(int)(Math.random()*1000)%255;
            color=new Color(r,g,b);
        }

        graphics.setColor(color);
        if(frame.selectShapePanel.Star.isSelected())
        {
            ShapeSpecifications star=new ShapeSpecifications(x,y,color,(int)frame.configPanel.nrOfPointsField.getValue()*2,(int)frame.configPanel.sizeField.getValue(),"optional.app.shapes.Star");
            shapes.add(star);

        }

        if(frame.selectShapePanel.RegularPolygon.isSelected())
        {
            ShapeSpecifications polygon=new ShapeSpecifications("optional.app.shapes.RegularPolygon",x,y,color,sides,(int)frame.configPanel.sizeField.getValue());
            shapes.add(polygon);

        }
    }
    public void update(Graphics g) { }

    /**
     * this method paint the optional.app.shapes one by one- retained mode
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        Iterator<ShapeSpecifications> it=shapes.iterator();
        while (it.hasNext())
        {
            ShapeSpecifications temp=it.next();
            graphics.setColor(temp.color);

            if (temp.shapeType.equals("optional.app.shapes.Star"))
            {
                new Star(temp.x,temp.y,temp.radius,graphics,temp.nPoints);
            }
            if (temp.shapeType.equals("optional.app.shapes.RegularPolygon"))
            {
                graphics.fill(new optional.app.shapes.RegularPolygon(temp.x, temp.y, temp.radius, temp.sides));
            }
        }
        g.drawImage(image, 0, 0, this);
    }
}