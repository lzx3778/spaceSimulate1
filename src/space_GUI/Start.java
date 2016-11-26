package space_GUI;

import javax.swing.*;
import java.awt.*;

public class
Start {

    private Frame f;
    private Frame Game_Frame;

    /**
     * Create the application.
     */
    public Start() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start window = new Start();
                    window.f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        f = new Frame();
        f.getContentPane().setBackground(Color.BLACK);
        f.setTitle("space");
        f.setResizable(false);
        f.setBounds(100, 100, 600, 420);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);

        Game_Frame = new Frame();
        Game_Frame.getContentPane().setBackground(Color.BLACK);
        Game_Frame.setTitle("space");
        Game_Frame.setResizable(false);
        Game_Frame.setBounds(100, 100, 600, 420);
        Game_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game_Frame.getContentPane().setLayout(null);
    }
}
