package by.ld1995tut.Dao;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbcImpl implements PersonDao
{
    public static final String SELECT_BY_NAME = "SELECT * FROM patient.patient WHERE last = ?";
    public static final String SELECT_BY_DATE = "SELECT * FROM patient.patient WHERE date = ?";
    public static final String SELECT_BY_DATE_DISCHARGE = "SELECT * FROM patient.patient WHERE discharge = ?";
    public static final String SELECT_BY_WARDS = "SELECT * FROM patient.patient WHERE wards = ?";
    public static final String SELECT_ALL = "SELECT * FROM patient.patient";
    public static final String INSERT = "INSERT INTO patient.patient " +
            "(wards, number, date, time, last, fast, second, organization, age, diagnosis, inhabitation, discharge)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE patient.patient SET wards = ?, number = ?, date = ?, time = ?, last = ?, " +
            "fast = ?, second = ?, organization = ?, age = ?, diagnosis = ?, inhabitation = ?, discharge = ? WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM patient.patient WHERE id = ?";
    public static final String DELETE_ALL = "DELETE FROM patient.patient";

    public static final String ID = "id";
    public static final String WARDS = "wards";
    public static final String NUMBER= "number";
    public static final String DATE = "date";
    public static final String TIME ="time";
    public static final String LAST = "last";
    public static final String FAST = "fast";
    public static final String SECOND = "second";
    public static final String ORGANIZATION = "organization";
    public static final String DATA = "age";
    public static final String DIAGNOSIS = "diagnosis";
    public static final String INHABITATION = "inhabitation";
    public static final String DISCHARGE = "discharge";

    private ConnectionFactory connectionFactory;

    public PersonDaoJdbcImpl(ConnectionFactory connectionFactory)
    {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public List<Person> getByFIO(String last) {
        ArrayList<Person> all = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SELECT_BY_NAME);) {
            statement.setString(1,last);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    all.add(new Person(resultSet.getInt(ID),
                            resultSet.getString(WARDS),
                            resultSet.getInt(NUMBER),
                            resultSet.getDate(DATE),
                            resultSet.getTime(TIME),
                            resultSet.getString(LAST),
                            resultSet.getString(FAST),
                            resultSet.getString(SECOND),
                            resultSet.getString(ORGANIZATION),
                            resultSet.getDate(DATA),
                            resultSet.getString(DIAGNOSIS),
                            resultSet.getString(INHABITATION),
                            resultSet.getDate(DISCHARGE)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getByFIO(id: '%d') has thrown an exception.", last ), e);
        }
        return all;
    }

    @Override
    public List<Person> getByDate(Date date) {
        ArrayList<Person> all = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SELECT_BY_DATE);) {
            statement.setDate(1,date);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    all.add(new Person(resultSet.getInt(ID),
                            resultSet.getString(WARDS),
                            resultSet.getInt(NUMBER),
                            resultSet.getDate(DATE),
                            resultSet.getTime(TIME),
                            resultSet.getString(LAST),
                            resultSet.getString(FAST),
                            resultSet.getString(SECOND),
                            resultSet.getString(ORGANIZATION),
                            resultSet.getDate(DATA),
                            resultSet.getString(DIAGNOSIS),
                            resultSet.getString(INHABITATION),
                            resultSet.getDate(DISCHARGE)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getByFIO(id: '%d') has thrown an exception.", date), e);
        }
        return all;
    }

    @Override
    public List<Person> getByWards(String wards) {
        ArrayList<Person> all = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SELECT_BY_WARDS);) {
            statement.setString(1,wards);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    all.add(new Person(resultSet.getInt(ID),
                            resultSet.getString(WARDS),
                            resultSet.getInt(NUMBER),
                            resultSet.getDate(DATE),
                            resultSet.getTime(TIME),
                            resultSet.getString(LAST),
                            resultSet.getString(FAST),
                            resultSet.getString(SECOND),
                            resultSet.getString(ORGANIZATION),
                            resultSet.getDate(DATA),
                            resultSet.getString(DIAGNOSIS),
                            resultSet.getString(INHABITATION),
                            resultSet.getDate(DISCHARGE)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getByFIO(id: '%d') has thrown an exception.", wards), e);
        }
        return all;
    }

    @Override
    public List<Person> getAll() {
        ArrayList<Person> all = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL);) {
                while (resultSet.next()) {
                    all.add(new Person(resultSet.getInt(ID),
                            resultSet.getString(WARDS),
                            resultSet.getInt(NUMBER),
                            resultSet.getDate(DATE),
                            resultSet.getTime(TIME),
                            resultSet.getString(LAST),
                            resultSet.getString(FAST),
                            resultSet.getString(SECOND),
                            resultSet.getString(ORGANIZATION),
                            resultSet.getDate(DATA),
                            resultSet.getString(DIAGNOSIS),
                            resultSet.getString(INHABITATION),
                            resultSet.getDate(DISCHARGE)
                    ));
                }
            }
        } catch (Exception e) {
            throw new DaoException("Method getAll() has thrown an exception.", e);
        }
        return all;
    }

    @Override
    public void insert(Person person)
    {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(INSERT);) {
            statement.setString(1, person.getWards());
            statement.setInt(2, person.getNumber());
            statement.setDate(3, person.getDate());
            statement.setTime(4, person.getTime());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getNamePerson());
            statement.setString(7, person.getSecondName());
            statement.setString(8, person.getOrganization());
            statement.setDate(9,  person.getAge());
            statement.setString(10, person.getDiagnosis());
            statement.setString(11, person.getInhabitation());
            statement.setDate(12,person.getDischarge());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'patient' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(author:'%s') has thrown an exception", person), e);
        }
    }

    @Override
    public void update(Person person) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(UPDATE);) {
            statement.setString(1, person.getWards());
            statement.setInt(2, person.getNumber());
            statement.setDate(3, person.getDate());
            statement.setTime(4, person.getTime());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getNamePerson());
            statement.setString(7, person.getSecondName());
            statement.setString(8, person.getOrganization());
            statement.setDate(9,  person.getAge());
            statement.setString(10, person.getDiagnosis());
            statement.setString(11, person.getInhabitation());
            statement.setDate(12, person.getDischarge());
            statement.setInt(13, person.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method update(author:'%s') has thrown an exception", person), e);
        }
    }

    @Override
    public void deleteById(int id)
    {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(DELETE_BY_ID_QUERY);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id:'%d') has thrown an exception", id), e);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE_ALL);
        } catch (Exception e) {
            throw new DaoException("Method deleteAll() has thrown an exception", e);
        }
    }
}
