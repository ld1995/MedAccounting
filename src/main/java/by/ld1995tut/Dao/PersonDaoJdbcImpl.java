package by.ld1995tut.Dao;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoJdbcImpl implements PersonDao
{
//    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM authors WHERE id = ?";
//    public static final String SELECT_ALL_QUERY = "SELECT * FROM authors";
    public static final String INSERT = "INSERT INTO patient.patient " +
            "(wards, number, date, last, fast, second, organization, age, diagnosis, inhabitation)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";
//    public static final String UPDATE = "UPDATE  SET name = ?, trade_union = ? WHERE id = ?";
//    public static final String DELETE_BY_ID_QUERY = "DELETE FROM authors WHERE id = ?";
//    public static final String DELETE_ALL_QUERY = "DELETE FROM authors";
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_UNION = "trade_union";

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
        return null;
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
