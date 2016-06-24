package by.ld1995tut.Dao;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbcImpl implements PersonDao
{
//    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM authors WHERE id = ?";
    public static final String SELECT_ALL = "SELECT * FROM patient.patient";
    public static final String INSERT = "INSERT INTO patient.patient " +
            "(wards, number, date, last, fast, second, organization, age, diagnosis, inhabitation)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";
//    public static final String UPDATE = "UPDATE  SET name = ?, trade_union = ? WHERE id = ?";
//    public static final String DELETE_BY_ID_QUERY = "DELETE FROM authors WHERE id = ?";
//    public static final String DELETE_ALL_QUERY = "DELETE FROM authors";

    public static final String WARDS = "Отделение";
    public static final String NUMBER= "Номер";
    public static final String DATE_AND_TIME = "Дата";
    public static final String LAST = "Фамилия";
    public static final String NAME = "Имя";
    public static final String SECOND = "Отчество";
    public static final String ORGANIZATION = "Организация";
    public static final String DATA = "Возраст";
    public static final String DIAGNOSIS = "Диагноз";
    public static final String INHABITATION = "Прописка";

    private ConnectionFactory connectionFactory;

    public PersonDaoJdbcImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Person getById() {
        return null;
    }

    @Override
    public void insert(Person person)
    {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(INSERT);) {
            statement.setString(1, person.getWards());
            statement.setInt(2, person.getNumber());
            statement.setTimestamp(3, person.getDateAndTime());
            statement.setString(4, person.getLastName());
            statement.setString(5, person.getNamePerson());
            statement.setString(6, person.getSecondName());
            statement.setString(7, person.getOrganization());
            statement.setDate(8,  person.getAge());
            statement.setString(9, person.getDiagnosis());
            statement.setString(10, person.getInhabitation());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'patient' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(author:'%s') has thrown an exception", person), e);
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> all = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL);) {
                while (resultSet.next()) {
                    all.add(new Person(resultSet.getString(WARDS),
                            resultSet.getInt(NUMBER),
                            resultSet.getTimestamp(DATE_AND_TIME),
                            resultSet.getString(LAST),
                            resultSet.getString(NAME),
                            resultSet.getString(SECOND),
                            resultSet.getDate(DATA),
                            resultSet.getString(ORGANIZATION),
                            resultSet.getString(DIAGNOSIS),
                            resultSet.getString(INHABITATION)
                            ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getAll() has thrown an exception.", e);
        }
        return all;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
