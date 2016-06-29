package by.ld1995tut.mics;

import by.ld1995tut.Dao.Person;
import by.ld1995tut.Dao.PersonDao;
import by.ld1995tut.Frame.Frame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class PersonTableModel extends AbstractTableModel
{
    private int columnCount;
    private ArrayList<String []> list;

    public PersonTableModel()
    {
        this.columnCount = columnCount;
        list = new ArrayList<String[]>();
        for (int i =0; i < list.size(); i++)
        {
            list.add(new String[getColumnCount()]);
        }

    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String [] rows = list.get(rowIndex);
        return rows[columnIndex];
    }

    public void addDate(String[] date)
    {
        String [] rowTable = new String[getColumnCount()];
        rowTable = date;
        list.add(rowTable);

    }
}
