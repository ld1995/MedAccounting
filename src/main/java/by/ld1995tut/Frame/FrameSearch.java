package by.ld1995tut.Frame;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FrameSearch extends JPanel
{

    private JPanel rootPanel;
    private JList patientList;
    private JPanel optionsPanel;
    private JButton search;
    private JButton delete;
    private JButton edit;
    private JButton next;
    private JPanel navigationPanel;
    private JTextField fio;
    private JComboBox selection;
    private JPanel result;

    public FrameSearch()
    {
        if (selection.getSelectedIndex() == 0)
        {
            JTextField fio = new JTextField();
            selection.add(fio);
        }

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JList getPatientList() {
        return patientList;
    }

    public void setPatientList(JList patientList) {
        this.patientList = patientList;
    }

    public JPanel getOptionsPanel() {
        return optionsPanel;
    }

    public void setOptionsPanel(JPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JButton getEdit() {
        return edit;
    }

    public void setEdit(JButton edit) {
        this.edit = edit;
    }

    public JButton getNext() {
        return next;
    }

    public void setNext(JButton next) {
        this.next = next;
    }

    public JPanel getNavigationPanel() {
        return navigationPanel;
    }

    public void setNavigationPanel(JPanel navigationPanel) {
        this.navigationPanel = navigationPanel;
    }

    public JTextField getFio() {
        return fio;
    }

    public void setFio(JTextField fio) {
        this.fio = fio;
    }

}
