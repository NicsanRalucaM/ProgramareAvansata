package laborator6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1;
    JSpinner spinner2;
    JButton create;
    int a=10;
    int b=10;


    public ConfigPanel(MainFrame mainFrame) {
        this.frame = mainFrame;
        init();
    }

    public int getRows() {
        return (Integer) spinner1.getValue();
    }

    public int getCols() {
        return (Integer) spinner1.getValue();

    }


    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");

        spinner1 = new JSpinner(new SpinnerNumberModel(a, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(b, 2, 100, 1));
         create= new JButton("Create");
        add(label);
        add(spinner1);
        add(spinner2);
        add(create);
        create.addActionListener(this::resize);
    }

    private void resize(ActionEvent e) {
    }

}
