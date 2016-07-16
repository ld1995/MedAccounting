package by.ld1995tut.Frame;

import by.ld1995tut.Dao.ConnectionFactory;
import by.ld1995tut.Dao.Person;
import by.ld1995tut.Dao.PersonDao;
import by.ld1995tut.Dao.PersonDaoJdbcImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Frame extends JFrame
{
    private FrameRegistration frameRegistration = new FrameRegistration();
    private FrameSearch frameSearch = new FrameSearch();
    private static PersonDao personDao = new PersonDaoJdbcImpl(ConnectionFactory.getInstance());

    public Frame()
    {
        setTitle("Мед учёт");
        Dimension min = new Dimension(800,600);
        setMinimumSize(min);
        setContentPane(frameRegistration.getRootPanel());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameRegistration.getSearch().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                searchWards();
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
                    okMessage();
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
                search();
            }
        });
        frameSearch.getDelete().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                personDao.deleteById(frameSearch.getIdTablePerson());
                searchWards();
            }
        });
        frameSearch.getSave().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                personDao.update(frameSearch.update());
            }
        });
        frameSearch.getReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                searchWards();
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

    private void searchWards()
    {
        if (frameRegistration.getWards().equals("Все отделения"))
        {
            frameSearch.setTableModel(personDao.getAll());
        }
        else if (frameRegistration.getWards().equals("Статистика"))
        {
            frameSearch.setTableModel(personDao.getByWards("Статистика"));
        }
        else if (frameRegistration.getWards().equals("Приёмное отделение"))
        {
            frameSearch.setTableModel(personDao.getByWards("Приёмное отделение"));
        }
        else if (frameRegistration.getWards().equals("Травматологический пункт"))
        {
            frameSearch.setTableModel(personDao.getByWards("Травматологический пункт"));
        }
        else if (frameRegistration.getWards().equals("Травмотологическое отделение"))
        {
            frameSearch.setTableModel(personDao.getByWards("Травмотологическое отделение"));
        }
        else if (frameRegistration.getWards().equals("Хирургическое отделение 1"))
        {
            frameSearch.setTableModel(personDao.getByWards("Хирургическое отделение 1"));
        }
        else if (frameRegistration.getWards().equals("Хирургическое отделение 2"))
        {
            frameSearch.setTableModel(personDao.getByWards("Хирургическое отделение 2"));
        }
        else if (frameRegistration.getWards().equals("Хирургическое отделение 3"))
        {
            frameSearch.setTableModel(personDao.getByWards("Хирургическое отделение 3"));
        }
        else if (frameRegistration.getWards().equals("Отделение анестезиологии и реанимации"))
        {
            frameSearch.setTableModel(personDao.getByWards("Отделение анестезиологии и реанимации"));
        }
        else if (frameRegistration.getWards().equals("Терапевтическое отделение"))
        {
            frameSearch.setTableModel(personDao.getByWards("Терапевтическое отделение"));
        }
        else if (frameRegistration.getWards().equals("Оториноларингологическое отделение"))
        {
            frameSearch.setTableModel(personDao.getByWards("Оториноларингологическое отделение"));
        }
        else if (frameRegistration.getWards().equals("Неврологическое отделение"))
        {
            frameSearch.setTableModel(personDao.getByWards("Неврологическое отделение"));
        }
    }

    private void search()
    {
        if (frameSearch.getSelection().matches("^[А-ЯЁа-яё]+"))
        {
            frameSearch.setTableModel(personDao.getByFIO(frameSearch.getSelection()));
        }
        if (frameSearch.getSelection().matches("^[0-9.]+"))
        {
            frameSearch.setTableModel(personDao.getByDate(frameSearch.getSearchDate(frameSearch.getSelection())));
        }
    }

    private void errorMessage()
    {
        JOptionPane.showMessageDialog(getRootPane(),"Поля заполнены неверно","Внимание",JOptionPane.WARNING_MESSAGE);
    }

    private void okMessage()
    {
        JOptionPane.showMessageDialog(getRootPane(),"Запись успешно добавлена","Ok",JOptionPane.INFORMATION_MESSAGE);
    }

}
