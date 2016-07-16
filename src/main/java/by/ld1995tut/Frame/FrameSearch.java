package by.ld1995tut.Frame;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.mics.CheckingFilling;
import by.ld1995tut.mics.DateFormatSQL;
import by.ld1995tut.mics.NumberFilling;
import by.ld1995tut.mics.TablePerson;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrameSearch extends JPanel
{
    private JPanel rootPanel;
    private JPanel optionsPanel;
    private JButton search;
    private JButton delete;
    private JButton next;
    private JPanel navigationPanel;
    private JComboBox selection;
    private JPanel result;
    private JButton save;
    private JTable tablePerson;
    private JButton reset;
    private TablePerson model;

    public FrameSearch()
    {
        selection.setEditable(true);
        selection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (selection.getSelectedItem().equals("Фамилия"))
                {
                    Object editorComponent = selection.getEditor().getEditorComponent();
                    Document document = ((JTextComponent)editorComponent).getDocument();
                    if (document instanceof AbstractDocument)
                        ((AbstractDocument) document).setDocumentFilter(new CheckingFilling());
                }
                else if (selection.getSelectedItem().equals("Дата приёма"))
                {
                    Object editorComponent = selection.getEditor().getEditorComponent();
                    Document document = ((JTextComponent)editorComponent).getDocument();
                    if (document instanceof AbstractDocument)
                        ((AbstractDocument) document).setDocumentFilter(new NumberFilling());
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getSearch() {
        return search;
    }

    public JButton getDelete()
    {
        return delete;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getReset() {
        return reset;
    }

    public int getIdTablePerson()
    {
        Person id = model.getBeans().get(tablePerson.getSelectedRow());
        return id.getId();
    }

    public Person update()
    {
        return model.getBeans().get(tablePerson.getSelectedRow());
    }

    public void setTableModel(List<Person> list)
    {
        this.model = new TablePerson(list);
        this.tablePerson.setModel(model);
    }

    public String getSelection() {
        String searchOptions = (String)selection.getSelectedItem();
        return searchOptions.trim();
    }

    public Date getSearchDate(String date)
    {
        return DateFormatSQL.getSearchDate(date);
    }
}