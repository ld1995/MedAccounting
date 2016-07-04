package by.ld1995tut.Frame;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.mics.CheckingFilling;
import by.ld1995tut.mics.TablePerson;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.List;

public class FrameSearch extends JPanel
{
    private JPanel rootPanel;
    private JPanel optionsPanel;
    private JButton search;
    private JButton delete;
    private JButton edit;
    private JButton next;
    private JPanel navigationPanel;
    private JComboBox selection;
    private JPanel result;
    private JTable tablePerson;
    private JButton save;

    public FrameSearch()
    {
        selection.setEditable(true);
        Object editorComponent = selection.getEditor().getEditorComponent();
        Document document = ((JTextComponent)editorComponent).getDocument();
        if (document instanceof AbstractDocument)
            ((AbstractDocument) document).setDocumentFilter(new CheckingFilling());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getSearch() {
        return search;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getEdit() {
        return edit;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getSave() {
        return save;
    }

    public void setNavigationPanel(Component component) {
        this.navigationPanel.add(component);
    }

    public void setTablePerson(List<Person> list) {
        TablePerson model = new TablePerson(list);
        this.tablePerson.setModel(model);
    }

    public String getSelection() {
        String searchOptions = (String)selection.getSelectedItem();
        return searchOptions;
    }

    public Person getPerson()
    {
        String last = "";
        String fast = "";
        String second = "";
        Person person;
        String fIO = getSelection();
        String fIOUser[] = fIO.split("\\s+");
        if(fIOUser.length == 3)
        {
            if (fIOUser[0].matches("^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$"))
               last = fIOUser[0];
            if (fIOUser[1].matches("^[А-ЯЁ][а-яё]+$"))
               fast = fIOUser[1];
            if (fIOUser[2].matches("^[А-ЯЁ][а-яё]+$"))
               second = fIOUser[2];

        person = new Person(last, fast, second);
        return person;
        }
        else
        {
          return person = new Person();
        }
    }

}
