package by.ld1995tut.Dao;

import java.util.List;

public interface PersonDao
{
    Person getById();

    void insert(Person person);

    List<Person> getAll();

    void update(Person person);

    void deleteById(long id);

    void deleteAll();
}