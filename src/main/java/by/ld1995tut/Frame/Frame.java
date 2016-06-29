package by.ld1995tut.Frame;

import by.ld1995tut.Dao.ConnectionFactory;
import by.ld1995tut.Dao.Person;
import by.ld1995tut.Dao.PersonDao;
import by.ld1995tut.Dao.PersonDaoJdbcImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame
{
    private FrameRegistration frameRegistration = new FrameRegistration();
    private FrameSearch frameSearch = new FrameSearch();
//    private Person person = new Person();
    private static PersonDao personDao = new PersonDaoJdbcImpl(ConnectionFactory.getInstance());

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
//                frameSearch.setTablePerson(personDaoDao.getAll());
                switchForm();
                frameRegistration.cleanForm();
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
                if (frameRegistration.getPerson().control())
                {
                    personDao.insert(frameRegistration.getPerson());
                    frameRegistration.cleanForm();
                }
                else errorMessage();
            }
        });
        frameSearch.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(personDao.getByFIO(frameSearch.getPerson().getLastName(),
                        frameSearch.getPerson().getNamePerson(), frameSearch.getPerson().getSecondName()));
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
        frameSearch.getSave().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    private void errorMessage()
    {
        JOptionPane.showMessageDialog(getRootPane(),"Поле заполнено неверно","Внимание",JOptionPane.INFORMATION_MESSAGE);
    }

}
