package by.ld1995tut.mics;

import by.ld1995tut.Dao.Person;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class TablePerson extends AbstractTableModel {

    private Set<TableModelListener> listeners = new HashSet<>();

    private List<Person> beans;

    public List<Person> getBeans() {
        return beans;
    }

    public TablePerson(List<Person> beans)
    {
        this.beans = beans;
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Отделение";
            case 1:
                return "№";
            case 2:
                return "Дата приема";
            case 3:
                return "Время";
            case 4:
                return "Фамилия";
            case 5:
                return "Имя";
            case 6:
                return "Отчество";
            case 7:
                return "Возраст";
            case 8:
                return "Организация";
            case 9:
                return "Диагноз";
            case 10:
                return "Прописка";
            case 11:
                return "Дата выписки";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return beans.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person bean = beans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getWards();
            case 1:
                return bean.getNumber();
            case 2:
                return bean.getDate();
            case 3:
                return bean.getTime();
            case 4:
                return bean.getLastName();
            case 5:
                return bean.getNamePerson();
            case 6:
                return bean.getSecondName();
            case 7:
                return bean.getAge();
            case 8:
                return bean.getOrganization();
            case 9:
                return bean.getDiagnosis();
            case 10:
                return bean.getInhabitation();
            case 11:
                return bean.getDischarge();
        }
        return "";
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex)
    {
        Person bean = beans.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                bean.setWards((String)value);
                break;
            case 1:
                bean.setNumber(Integer.parseInt(value.toString()));
                break;
            case 2:
                bean.setDate(Date.valueOf(value.toString()));
                break;
            case 3:
                bean.setTime(Time.valueOf(value.toString()));
                break;
            case 4:
                bean.setLastName((String)value);
                break;
            case 5:
                bean.setNamePerson((String)value);
                break;
            case 6:
                bean.setSecondName((String)value);
                break;
            case 7:
                bean.setAge(Date.valueOf(value.toString()));
                break;
            case 8:
                bean.setOrganization((String) value);
                break;
            case 9:
                bean.setDiagnosis((String)value);
                break;
            case 10:
                bean.setInhabitation((String)value);
                break;
            case 11:
                bean.setDischarge(Date.valueOf(value.toString()));
                break;
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }
}
