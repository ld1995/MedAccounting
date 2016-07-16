package by.ld1995tut.Dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Person
{
    private int id;
    private String wards;
    private int number;
    private Date date;
    private Time time;
    private String lastName;
    private String namePerson;
    private String secondName;
    private String organization;
    private Date age;
    private String diagnosis;
    private String inhabitation;
    private Date discharge;

    public Person()
    {

    }

    public Person(String wards, int number, Date date, Time time,
                  String lastName, String namePerson, String secondName,
                  String organization, java.sql.Date age,
                  String diagnosis, String inhabitation, Date discharge)
    {
        this.wards = wards;
        this.number = number;
        this.date = date;
        this.time = time;
        this.lastName = lastName;
        this.namePerson = namePerson;
        this.secondName = secondName;
        this.organization = organization;
        this.age = age;
        this.diagnosis = diagnosis;
        this.inhabitation = inhabitation;
        this.discharge = discharge;
    }

    public Person(int id, String wards, int number,
                  Date date, Time time, String lastName,
                  String namePerson, String secondName,
                  String organization, Date age,
                  String diagnosis, String inhabitation,
                  Date discharge)
    {
        this.id = id;
        this.wards = wards;
        this.number = number;
        this.date = date;
        this.time = time;
        this.lastName = lastName;
        this.namePerson = namePerson;
        this.secondName = secondName;
        this.organization = organization;
        this.age = age;
        this.diagnosis = diagnosis;
        this.inhabitation = inhabitation;
        this.discharge = discharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public java.sql.Date getDischarge() {
        return discharge;
    }

    public void setDischarge(java.sql.Date discharge) {
        this.discharge = discharge;
    }

    public boolean control()
    {
        if (number == 0 || age.equals("00.00.0000") || lastName.isEmpty() || namePerson.isEmpty() || secondName.isEmpty())
        {
            return false;
        }
        else
            return true;
    }
}