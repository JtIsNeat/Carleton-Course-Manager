import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JLabel programTitle;
    private JLabel developper;
    private JPanel titlePanel;

    public MainPanel(){
        this.setBackground(Color.RED);

        
        programTitle = new JLabel("Course Manipulator");
        programTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
        programTitle.setForeground(Color.WHITE);

        titlePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTitlePanel = new GridBagConstraints();
        gbcTitlePanel.weightx = 0;
        gbcTitlePanel.weighty = 0;
        gbcTitlePanel.gridx = 0;
        gbcTitlePanel.gridy = 0;
        gbcTitlePanel.gridwidth = 3;


    }


}
