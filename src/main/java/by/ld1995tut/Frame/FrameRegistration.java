package by.ld1995tut.Frame;

import by.ld1995tut.Person;
import by.ld1995tut.mics.CheckingFilling;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameRegistration extends JPanel
{
    private JPanel rootPanel;
    private JPanel top;
    private JComboBox wards;
    private JPanel center;
    private JFormattedTextField date;
    private JFormattedTextField time;
    private JTextField lastName;
    private JTextField secondName;
    private JTextField namePerson;
    private JButton search;
    private JEditorPane organization;
    private JFormattedTextField age;
    private JEditorPane diagnosis;
    private JEditorPane inhabitation;
    private JButton save;

    public FrameRegistration()
    {
        try {
            MaskFormatter dateMask = new MaskFormatter("##.##.####");
            dateMask.setPlaceholder(null);
            dateMask.setPlaceholderCharacter(' ');
            date.setFormatterFactory(new DefaultFormatterFactory(dateMask));
            MaskFormatter timeMask = new MaskFormatter("##:##");
            timeMask.setPlaceholder(null);
            timeMask.setPlaceholderCharacter(' ');
            time.setFormatterFactory(new DefaultFormatterFactory(timeMask));
            age.setFormatterFactory(new DefaultFormatterFactory(dateMask));
            Date d = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm aa");
            setDate(dateFormat.format(d));
            setTime(timeFormat.format(d));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        if (lastName.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) lastName.getDocument()).setDocumentFilter(new CheckingFilling());
        if (secondName.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) secondName.getDocument()).setDocumentFilter(new CheckingFilling());
        if (namePerson.getDocument() instanceof  AbstractDocument)
            ((AbstractDocument) namePerson.getDocument()).setDocumentFilter(new CheckingFilling());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public int getWards() {
        return wards.getSelectedIndex();
    }

    public String getDate() {
        return date.getText();
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public String getTime() {
        return time.getText();
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getSecondName() {
        return secondName.getText();
    }

    public String getNamePerson() {
        return namePerson.getText();
    }

    public JButton getSearch() {
        return search;
    }

    public String getOrganization() {
        return organization.getText();
    }

    public String getAge() {
        return age.getText();
    }

    public String getDiagnosis() {
        return diagnosis.getText();
    }

    public String getInhabitation() {
        return inhabitation.getText();
    }

    public JButton getSave() {
        return save;
    }

//    private Date getDatePerson()
//    {
//        Date date = new Date();
//        return date;
//    }
//
//    public Person getPerson()
//    {
//        Person person = new Person(getWards(),getDate());
//        return person;
//    }
}