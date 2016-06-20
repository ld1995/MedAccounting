package by.ld1995tut;

import java.util.Date;

public class Person
{
    private int wards;
    private Date date;
    private Date time;
    private String lastName;
    private String secondName;
    private String namePerson;
    private String organization;
    private Date age;
    private String diagnosis;
    private String inhabitation;

    public Person(int wards, Date date, Date time,
                  String lastName, String secondName, String namePerson,
                  String organization, Date age,
                  String diagnosis, String inhabitation)
    {
        this.wards = wards;
        this.date = date;
        this.time = time;
        this.lastName = lastName;
        this.secondName = secondName;
        this.namePerson = namePerson;
        this.organization = organization;
        this.age = age;
        this.diagnosis = diagnosis;
        this.inhabitation = inhabitation;
    }
}
