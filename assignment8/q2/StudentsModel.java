package assignment8.q2;

import assignment8.q2.controller.StudentsManager;
import assignment8.q2.model.Student;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Comparator;
import java.util.List;

public class StudentsModel {

    private StudentsManager manager;
    private DefaultTableModel table;

    public StudentsModel(StudentsManager manager, DefaultTableModel table) {
        this.manager = manager;
        this.table = table;
        loadStudentsToTable();
    }

    private void loadStudentsToTable() {
        List<Student> students = manager.getStudents();
        students.sort(Comparator.comparing(Student::getId));
        students.forEach(this::addRow);
    }

    public StudentsManager getStudentManager() {
        return manager;
    }

    public int getRowCount() {
        return manager.getStudentCount();
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Roll Number";
        } else {
            return "Name";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;
    }

    public void addStudent(Student student) {
        manager.addStudent(student);
        addRow(student);
    }

    public void addRow(Student student) {
        table.addRow(new Object[]{student.getId(), student.getName()});
    }

    public void modifyStudent(String id, String name) {
        manager.modifyStudent(id, new Student(id, name));
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals(id)) {
                table.setValueAt(name, i, 1);
                return;
            }
        }
    }

    public void deleteStudent(Student student) {
        manager.deleteStudent(student.getId());
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals(student.getId())) {
                table.removeRow(i);
                return;
            }
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (rowIndex > getRowCount()) {
            throw new IllegalArgumentException("Invalid rowIndex value. ");
        }

        if (rowIndex == getRowCount()) {
            manager.addStudent(new Student());
        }

        Student student = manager.getStudents().get(rowIndex);
        if (columnIndex == 0) {
            student.setId(aValue.toString());
        } else {
            student.setName(aValue.toString());
        }
    }

}
