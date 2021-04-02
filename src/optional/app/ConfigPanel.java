package optional.app;

import javax.swing.*;


public class ConfigPanel extends JPanel
{
    final MainFrame frame;
    JLabel labelPolygon1;
    JLabel labelPolygon2;
    JLabel labelPolygon3;
    JLabel labelStar1;
    JLabel labelStar2;
    JLabel labelStar3;
    JSpinner sidesField;
    JSpinner nrOfPointsField;
    JSpinner sizeField;
    JComboBox colorCombo;
    JCheckBox randSizeCheck;

    /**
     * constructor
     * @param frame
     */
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * this method initializes the configuration panel with all labels depends on the shape (in this case, star and polygon)
     */
    private void init()
    {

        this.labelPolygon1 = new JLabel("Number of sides:");
        this.labelPolygon2 = new JLabel("Color:");
        this.labelPolygon3 = new JLabel("Size:");
        this.sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        this.sizeField = new JSpinner(new SpinnerNumberModel(5, 5, 100, 5));
        this.sidesField.setValue(6);
        this.sizeField.setValue(20);
        String[] colors={"Random Color","Black"};
        this.colorCombo = new JComboBox(colors);
        add(labelPolygon1);
        add(sidesField);
        add(labelPolygon2);
        add(colorCombo);
        add(labelPolygon3);
        add(sizeField);


        this.labelStar1= new JLabel("Color: ");
        this.labelStar2= new JLabel("Radius: ");
        this.labelStar3= new JLabel("Number of points: ");
        this.nrOfPointsField= new JSpinner(new SpinnerNumberModel(5, 5, 10, 1));
    }
}