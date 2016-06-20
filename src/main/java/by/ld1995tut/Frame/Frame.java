package by.ld1995tut.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame
{
    private FrameRegistration frameRegistration = new FrameRegistration();
    private FrameSearch frameSearch = new FrameSearch();

    public Frame()
    {
        setTitle("Мед учёт");
        setSize(800,600);
        setContentPane(frameRegistration.getRootPanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        frameRegistration.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchForm();
            }
        });
        frameSearch.getNext().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchForm();
            }
        });
        frameRegistration.getSave().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {


            }
        });
        frameSearch.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        frameSearch.getDelete().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        frameSearch.getEdit().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    private void switchForm()
    {
        if (getContentPane() == frameRegistration.getRootPanel())
        {
            setContentPane(frameSearch.getRootPanel());
        }
        else
        {
            setContentPane(frameRegistration.getRootPanel());
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
