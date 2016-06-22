package by.ld1995tut.Frame;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.mics.CheckingFilling;
import by.ld1995tut.mics.NumberFilling;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameRegistration extends JPanel {
    private JPanel rootPanel;
    private JPanel top;
    private JComboBox wards;
    private JPanel center;
    private JFormattedTextField number;
    private JFormattedTextField dateAndTime;
    private JTextField lastName;
    private JTextField secondName;
    private JTextField namePerson;
    private JButton search;
    private JEditorPane organization;
    private JFormattedTextField age;
    private JEditorPane diagnosis;
    private JEditorPane inhabitation;
    private JButton save;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private SimpleDateFormat dateHB = new SimpleDateFormat("dd.MM.yyyy");
    private Date date = new Date();

    public FrameRegistration() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##.##.#### ##:##");
            dateMask.setPlaceholder(null);
            dateMask.setPlaceholderCharacter(' ');
            dateAndTime.setFormatterFactory(new DefaultFormatterFactory(dateMask));
            MaskFormatter dateHB = new MaskFormatter("##.##.####");
            age.setFormatterFactory(new DefaultFormatterFactory(dateHB));
            setDatePerson(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (number.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) number.getDocument()).setDocumentFilter(new NumberFilling());
        if (lastName.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) lastName.getDocument()).setDocumentFilter(new CheckingFilling());
        if (secondName.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) secondName.getDocument()).setDocumentFilter(new CheckingFilling());
        if (namePerson.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) namePerson.getDocument()).setDocumentFilter(new CheckingFilling());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getWards() {
        String getWards = (String) wards.getSelectedItem();
        return getWards;
    }

    public int getNumber() {
        return Integer.parseInt(number.getText());
    }

    public String getDateAndTime() {
        return dateAndTime.getText();
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime.setText(dateAndTime);
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

    private Timestamp getDatePerson()
    {
        Date docDate = null;
        try {
            docDate = dateFormat.parse(getDateAndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp timestamp = new java.sql.Timestamp(docDate.getTime());
        return timestamp;
    }

    private java.sql.Date getAgePerson() {
        Date docAge = null;
        try {
            docAge = dateHB.parse(getAge());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(docAge.getTime());
        return sqlDate;
    }

    public Person getPerson() {
        Person person = new Person(getWards(), getNumber(),
                getDatePerson(), getLastName(),
                getNamePerson(), getSecondName(),
                getAgePerson(), getOrganization(),
                getDiagnosis(), getInhabitation());
        return person;
    }

    public void cleanForm()
    {
        setDatePerson(new Date());
        setAge("");
        setNamePerson("");
        setNumber("");
        setLastName("");
        setSecondName("");
        setOrganization("");
        setDiagnosis("");
        setInhabitation("");
    }

    private void setDatePerson(Date date) {
        setDateAndTime(dateFormat.format(date));
    }

    public void setNumber(String number) {
        this.number.setText(number);
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    public void setSecondName(String secondName) {
        this.secondName.setText(secondName);
    }

    public void setNamePerson(String namePerson) {
        this.namePerson.setText(namePerson);
    }

    public void setOrganization(String organization) {
        this.organization.setText(organization);
    }

    public void setAge(String age) {
        this.age.setText(age);
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.setText(diagnosis);
    }

    public void setInhabitation(String inhabitation) {
        this.inhabitation.setText(inhabitation);
    }
}