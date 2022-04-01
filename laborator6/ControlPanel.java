package laborator6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    public ControlPanel(MainFrame mainFrame) {
        this.frame = mainFrame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3));
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);
        exitBtn.addActionListener(this::exitGame);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
