package by.ld1995tut.Frame;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.mics.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.text.ParseException;
import java.util.Date;

public class FrameRegistration extends JPanel {
    private JPanel rootPanel;
    private JPanel topPanel;
    private JComboBox wards;
    private JPanel center;
    private JFormattedTextField number;
    private JTextField lastName;
    private JTextField secondName;
    private JTextField namePerson;
    private JButton search;
    private JEditorPane organization;
    private JFormattedTextField age;
    private JEditorPane diagnosis;
    private JEditorPane inhabitation;
    private JButton save;
    private JFormattedTextField timeOfReceipt;
    private JFormattedTextField dateOfReceipt;
    private JFormattedTextField dateDischarge;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public FrameRegistration()
    {
        try {
            MaskFormatter timeMask = new MaskFormatter("##:##");
            timeMask.setPlaceholder(null);
            timeMask.setPlaceholderCharacter(' ');
            timeOfReceipt.setFormatterFactory(new DefaultFormatterFactory(timeMask));
            MaskFormatter dateMask = new MaskFormatter("##.##.####");
            dateMask.setPlaceholder(null);
            dateMask.setPlaceholderCharacter(' ');
            dateOfReceipt.setFormatterFactory(new DefaultFormatterFactory(dateMask));
            MaskFormatter ageMask = new MaskFormatter("##.##.####");
            ageMask.setPlaceholder(null);
            ageMask.setPlaceholderCharacter('_');
            age.setFormatterFactory( new DefaultFormatterFactory(dateMask));
            MaskFormatter dateMaskD = new MaskFormatter("##.##.####");
            ageMask.setPlaceholder(null);
            ageMask.setPlaceholderCharacter('_');
            dateDischarge.setFormatterFactory( new DefaultFormatterFactory(dateMaskD));
            cleanForm();
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
        if (organization.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) organization.getDocument()).setDocumentFilter(new DocumentTextLimit(299));
        if (diagnosis.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) diagnosis.getDocument()).setDocumentFilter(new DocumentTextLimit(299));
        if (inhabitation.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) inhabitation.getDocument()).setDocumentFilter(new DocumentTextLimit(299));
    }

    public JPanel getRootPanel()
    {
        return rootPanel;
    }

    public String getWards()
    {
        String getWards = (String) wards.getSelectedItem();
        return getWards;
    }

    public int getNumber()
    {
        if (!number.getText().equals(""))
            return Integer.parseInt(number.getText());
        else
            return 0;
    }

    public String getTimeOfReceipt()
    {
        return timeOfReceipt.getText();
    }

    public String getDateOfReceipt() {
        return dateOfReceipt.getText();
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

    public String getAge()
    {
        if (!age.getText().equals("  .  .    "))
            return age.getText();
        else
            return "00.00.0000";
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

    public java.sql.Time getTimePerson(String time)
    {
        return DateFormatSQL.getTimePerson(time);
    }

    public java.sql.Date getDatePerson(String date)
    {
        return DateFormatSQL.getSearchDate(date);
    }

    public String getDateDischarge()
    {
        if (!dateDischarge.getText().equals("  .  .    "))
            return dateDischarge.getText();
        else
            return "00.00.0000";
    }

    public void setDateOfReceipt(String date) {
        this.dateOfReceipt.setText(date);
    }

    public void setTimeOfReceipt(String timeOfReceipt)
    {
        this.timeOfReceipt.setText(timeOfReceipt);
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

    public void setDateDischarge(String dateDischarge) {
        this.dateDischarge.setText(dateDischarge);
    }

    public Person getPerson()
    {
        Person person = new Person(getWards(), getNumber(),
                getDatePerson(getDateOfReceipt()), getTimePerson(getTimeOfReceipt()),
                getLastName(), getNamePerson(), getSecondName(),
                getOrganization(), getDatePerson(getAge()),
                getDiagnosis(), getInhabitation(), getDatePerson(getDateDischarge()));
        return person;
    }

    public void cleanForm()
    {
        setTimeOfReceipt(timeFormat.format(new Date()));
        setDateOfReceipt(dateFormat.format(new Date()));
        setAge("");
        setNamePerson("");
        setNumber("");
        setLastName("");
        setSecondName("");
        setOrganization("");
        setDiagnosis("");
        setInhabitation("");
        setDateDischarge("");
    }
}
