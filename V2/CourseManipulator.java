/*
 *   Developper: Jeremy Tran-Perez
 * Program Name: Course Manipulator
 *      Version: v.2.0
 */


// IMPORTS
import javax.swing.*;
import java.awt.*;


/*************************************************************************************/


public class CourseManipulator {

    // MAIN WINDOW DIMENSIONS
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;


    


    public static void main(String[] args) {
        

        Window GUI = new Window(WIDTH, HEIGHT);
        
  


        // Title Label
        JLabel titleLabel = new JLabel("Course Manipulator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(new Rectangle(WIDTH,400));
        
        //GUI.add(titleLabel);



        
        // Create button
        //GUI.addButton("Import", 150, 200, 100, 50, Color.red, Color.white, new Color(138,0,0), 2);
        
        



    }
}