import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Window extends JFrame{


    public Window(int WIDTH, int HEIGHT){
 
        // GBC object
        GridBagConstraints gbc = new GridBagConstraints();

        // Frame setup
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Course Manipulator");
        this.getContentPane().setBackground(Color.black);


        /**************************************************************/

        // Main panel
        MainPanel MAINPANEL = new MainPanel();
        MAINPANEL.setLayout(new GridBagLayout());
        MAINPANEL.setBackground(Color.red);

        // Title panel
        JPanel titlePanel = new JPanel();
        setBackground(Color.red);

        JLabel titleLabel = new JLabel("Course Manipulator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(new Rectangle(WIDTH,400));

        titlePanel.add(titleLabel);
        MAINPANEL.add(titlePanel);


        // set visible
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.add(MAINPANEL, gbc);
        this.setVisible(true);
    }        


    /*
     * Purpose: Adds a button to the class JFrame variable
     * Input: text, x, y, width, height, bgColor, fgColor, borderColor, borderWidth
     * Output: none
     */
    public void addButton(String text, int x, int y, int width, int height, Color bgColor, Color fgColor, Color borderColor, int borderWidth){

        // create button object
        JButton button = new JButton(text);

        // set button properties
        button.setBounds(x, y, width, height);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setBorder(new LineBorder(borderColor, borderWidth));
        button.setFocusPainted(false);
        button.setVisible(true);
        this.add(button);
    }
}