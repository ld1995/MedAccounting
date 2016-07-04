package by.ld1995tut.mics;

import by.ld1995tut.Dao.Person;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;

public class TablePerson implements TableModel {

        private Set<TableModelListener> listeners = new HashSet<>();

        private List<Person> beans;

        public TablePerson(List<Person> beans) {
            this.beans = beans;
        }

        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public int getColumnCount() {
            return 9;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Отделение";
                case 1:
                    return "№";
                case 2:
                    return "Дата";
                case 3:
                    return "фамилия";
                case 4:
                    return "Имя";
                case 5:
                    return "Отчество";
                case 6:
                    return "Возраст";
                case 7:
                    return "Организация";
                case 8:
                    return "Диагноз";
                case 9:
                    return "Прописка";
            }
            return "";
        }

        public int getRowCount() {
            return beans.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Person bean = beans.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return bean.getWards();
                case 1:
                    return bean.getNumber();
                case 2:
                    return bean.getDateAndTime();
                case 3:
                    return bean.getLastName();
                case 4:
                    return bean.getNamePerson();
                case 5:
                    return bean.getSecondName();
                case 6:
                    return bean.getAge();
                case 7:
                    return bean.getOrganization();
                case 8:
                    return bean.getDiagnosis();
                case 9:
                    return  bean.getInhabitation();
            }
            return "";
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }

        public void setValueAt(Object value, int rowIndex, int columnIndex) {

        }
}
