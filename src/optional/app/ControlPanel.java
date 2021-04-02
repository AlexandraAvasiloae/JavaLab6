package optional.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;

public class ControlPanel extends JPanel {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(
            ControlPanel.class
    );
    final MainFrame frame;
    JFileChooser fileChooser;

    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    /**
     * constructor
     * @param frame
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    /**
     *  set layout
     *  add all buttons
     *  configure listeners for all buttons
     */
    private void init() {

        setLayout(new GridLayout(2, 2));

        //add where to save file chooser
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG images:   *.png", "png"));


        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

        //add buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
    }
    /**
     * create save button
     */
    private void save(ActionEvent e) {
        try {
            fileChooser.setDialogTitle("Specify where to save and the name:");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "PNG", fileChooser.getSelectedFile());
            }

        } catch (IOException ex) {
            logger.error(ex);
        }
    }

    /**
     * create load button
     * @param e
     */
    private void load(ActionEvent e) {
        BasicConfigurator.configure();
        try {
            fileChooser.setDialogTitle("Specify the file you want to load:");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                frame.canvas.image = ImageIO.read(fileChooser.getSelectedFile());
                frame.canvas.repaint();
            }
        } catch (IOException ex) {
            logger.error(ex);
        }
    }

    /**
     * create reset button
     * @param e
     */
    private void reset(ActionEvent e) {

    }

    /**
     * create exit button
     * @param e
     */
    private void exit(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}