package by.ld1995tut.Dao;

import java.sql.Timestamp;

public class Person
{
    private String wards;
    private int number;
    private Timestamp dateAndTime;
    private String lastName;
    private String namePerson;
    private String secondName;
    private String organization;
    private java.sql.Date age;
    private String diagnosis;
    private String inhabitation;

    public Person()
    {

    }

    public Person(String wards, int number, Timestamp dateAndTime,
                  String lastName, String namePerson, String secondName,
                  java.sql.Date age, String organization,
                  String diagnosis, String inhabitation)
    {
        this.wards = wards;
        this.number = number;
        this.dateAndTime = dateAndTime;
        this.lastName = lastName;
        this.namePerson = namePerson;
        this.secondName = secondName;
        this.age = age;
        this.organization = organization;
        this.diagnosis = diagnosis;
        this.inhabitation = inhabitation;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public java.sql.Date getAge() {
        return age;
    }

    public void setAge(java.sql.Date age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getInhabitation() {
        return inhabitation;
    }

    public void setInhabitation(String inhabitation) {
        this.inhabitation = inhabitation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "wards=" + wards +
                ", number=" + number +
                ", dateAndTime=" + dateAndTime +
                ", lastName='" + lastName + '\'' +
                ", namePerson='" + namePerson + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", organization='" + organization + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", inhabitation='" + inhabitation + '\'' +
                '}';
    }

    public boolean control()
    {
        if (wards.isEmpty() || number ==0 && lastName.isEmpty() || namePerson.isEmpty() || secondName.isEmpty() || organization.isEmpty() ||
        diagnosis.isEmpty() || inhabitation.isEmpty())
        {
            return false;
        }
        else
            return true;
    }
}