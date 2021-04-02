package optional.app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = screenSize.width - 400;
    public static final int height = screenSize.height - 400;

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawPanel canvas;
    /**
     * constructor
     */
    SelectShapePanel selectShapePanel;
    public MainFrame() {
        super("App");
        init();
    }

    /**
     *This method:
     * Set the object size
     * Calculate and Set the new frame location
     * create the components
     * arrange the components in the container (frame)

     */
    private void init()
    {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(950, 600));

        this.setSize(width, height);
        this.setResizable(false);

        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        canvas = new DrawPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        selectShapePanel = new SelectShapePanel(this);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(selectShapePanel, BorderLayout.WEST);
        pack();

    }

}