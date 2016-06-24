package by.ld1995tut.Frame;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.mics.CheckingFilling;
import by.ld1995tut.mics.NumberFilling;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.*;
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
        Vector<Person> vector = new Vector<>(list);
        DefaultTableModel aModel = (DefaultTableModel) tablePerson.getModel();
        aModel.addRow(vector);
        this.tablePerson.setModel(aModel);
    }

    public String getSelection() {
        String searchOptions = (String)selection.getSelectedItem();
        return searchOptions;
    }
}
