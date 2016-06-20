package by.ld1995tut;

import by.ld1995tut.Frame.Frame;

import javax.swing.*;

public class Loader
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Frame frame = new Frame();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        });
    }
}
