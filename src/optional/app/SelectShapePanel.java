package optional.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SelectShapePanel extends JPanel
{
    final MainFrame frame;
    ButtonGroup bGroup;
    ButtonGroup drawAndDelete;
    JRadioButton draw;
    JRadioButton del;
    JRadioButton RegularPolygon;
    JRadioButton Star;
    JLabel layoutDummy;

    /**
     * constructor
     * @param frame
     */
    public SelectShapePanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    /**
     * this panel allows the choice of a certain shape (star or polygon)
     * is created 4 radio buttons for elections
     */
    private void init()
    {
        bGroup=new ButtonGroup();
        RegularPolygon = new JRadioButton("Regular Polygon");

        Star = new JRadioButton("optional.app.shapes.Star");
        bGroup.add(RegularPolygon);

        bGroup.add(Star);

        drawAndDelete=new ButtonGroup();
        draw= new JRadioButton("Draw");
        del= new JRadioButton("Delete");
        drawAndDelete.add(draw);
        drawAndDelete.add(del);
        draw.setSelected(true);

        RegularPolygon.setSelected(true);
        RegularPolygon.addActionListener(this::RegularPolygon);
        Star.addActionListener(this::Star);

        layoutDummy=new JLabel(" ");
        setLayout(new GridLayout(10, 1));
        add(RegularPolygon);

        add(Star);
        add(layoutDummy);
        add(layoutDummy);
        add(layoutDummy);
        add(draw);
        add(del);
    }

    /**
     * this method configure the configPanel in case in which the regular polygon is selected
     * @param e
     */
    private void RegularPolygon(ActionEvent e)
    {
        frame.configPanel.removeAll();
        frame.configPanel.add(frame.configPanel.labelPolygon1);
        frame.configPanel.add(frame.configPanel.sidesField);
        frame.configPanel.add(frame.configPanel.labelPolygon2);
        frame.configPanel.add(frame.configPanel.colorCombo);
        frame.configPanel.add(frame.configPanel.labelPolygon3);
        frame.configPanel.add(frame.configPanel.sizeField);
        frame.configPanel.add(frame.configPanel.randSizeCheck);
        frame.configPanel.updateUI();
    }

    /**
     * this method configure the configPanel in case in which the star is selected
     * @param e
     */
    private void Star(ActionEvent e)
    {
        frame.configPanel.removeAll();
        frame.configPanel.add(frame.configPanel.labelStar3);
        frame.configPanel.add(frame.configPanel.nrOfPointsField);
        frame.configPanel.add(frame.configPanel.labelStar1);
        frame.configPanel.add(frame.configPanel.colorCombo);
        frame.configPanel.add(frame.configPanel.labelStar2);
        frame.configPanel.add(frame.configPanel.sizeField);
        frame.configPanel.updateUI();
    }

}