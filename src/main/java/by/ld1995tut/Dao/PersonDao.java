package by.ld1995tut.Dao;

import java.sql.Date;
import java.util.List;

public interface PersonDao
{
    List<Person> getByFIO(String last);

    List<Person> getByDate(Date date);

    List<Person> getByWards(String wards);

    void insert(Person person);

    List<Person> getAll();

    void update(Person person);

    void deleteById(int id);

    void deleteAll();
}
