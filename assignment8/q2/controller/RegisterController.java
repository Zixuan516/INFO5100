package assignment8.q2.controller;

import assignment8.q2.StudentsModel;
import assignment8.q2.UniversityFrame;
import assignment8.q2.exceptions.InvalidParameterException;
import assignment8.q2.exceptions.StudentAlreadyExistsException;
import assignment8.q2.exceptions.StudentNotExistException;
import assignment8.q2.exceptions.UserException;
import assignment8.q2.model.Student;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterController {

    public void addAction(ActionEvent event, UniversityFrame universityFrame) {
        String command = event.getActionCommand();
        try {
            switch (command) {
                case "Add":
                    addStudent(universityFrame);
                    break;
                case "Modify":
                    modifyStudent(universityFrame);
                    break;
                case "Delete":
                    deleteStudent(universityFrame);
                    break;
                case "Find":
                    findStudent(universityFrame);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported command.");
            }
        } catch (UserException e) {
            universityFrame.warn(e.getMessage());
        }
    }

    private void addStudent(UniversityFrame universityFrame) {
        StudentsModel studentsModel = universityFrame.getStudentsModel();
        StudentsManager studentsManager = studentsModel.getStudentManager();
        Student student = new Student(universityFrame.getRollText().getText(), universityFrame.getNameText().getText());
        validateStudentNotIn(student, studentsManager);
        studentsModel.addStudent(student);
    }

    private void validateStudentNotIn(Student student, StudentsManager studentsManager) {
        for (Student s : studentsManager.getStudents()) {
            if (s.getId().equals(student.getId())) {
                throw new StudentAlreadyExistsException(String.format("Student with ID %s already exists.", s.getId()));
            }
        }
    }

    private void modifyStudent(UniversityFrame universityFrame) {
        String id = universityFrame.getRollText().getText();
        String name = universityFrame.getNameText().getText();
        StudentsModel studentsModel = universityFrame.getStudentsModel();
        StudentsManager studentsManager = studentsModel.getStudentManager();
        validateStudentIn(id, studentsManager);
        studentsModel.modifyStudent(id, name);
    }

    private void validateStudentIn(String id, StudentsManager studentsManager) {
        for (Student s : studentsManager.getStudents()) {
            if (id.equals(s.getId())) {
                return;
            }
        }

        throw new StudentNotExistException("Student with ID " + id + " doesn't exist in the system.");
    }

    private void deleteStudent(UniversityFrame universityFrame) {
        Student student = new Student(universityFrame.getRollText().getText(), universityFrame.getNameText().getText());
        StudentsModel studentsModel = universityFrame.getStudentsModel();
        StudentsManager studentsManager = studentsModel.getStudentManager();
        validateStudentIn(student, studentsManager);
        studentsModel.deleteStudent(student);
    }

    private void validateStudentIn(Student student, StudentsManager studentsManager) {
        Student result = studentsManager.findStudent(student.getName());
        if (result == null) {
            throw new StudentNotExistException("Student: " + student.toString() + " doesn't exist in the system.");
        }
    }

    private void findStudent(UniversityFrame universityFrame) {
        String id = universityFrame.getRollText().getText();
        String name = universityFrame.getNameText().getText();
        StudentsManager studentsManager = universityFrame.getStudentsModel().getStudentManager();
        if (id.isEmpty() && name.isEmpty()) {
            throw new InvalidParameterException("Either Id or Name must have a value.");
        }

        if (!id.isEmpty() && !name.isEmpty()) {
            Student student = studentsManager.findStudent(name);
            if (student != null && student.getId().equals(id)) {
                universityFrame.warn(String.format("Student Information: %s", student.toString()));
            } else {
                universityFrame.warn(String.format("No such student ID: %s, Name:%s", id, name));
            }
        } else if (!id.isEmpty()) {
            List<Student> matchedStudents = studentsManager.getStudents()
                    .stream()
                    .filter(s -> s.getId().equals(id))
                    .collect(Collectors.toList());
            if (matchedStudents.size() == 0) {
                universityFrame.warn(String.format("Student with ID %s not found.", id));
            } else {
                universityFrame.warn(String.format("Student Information: %s", matchedStudents.get(0).toString()));
            }
        } else {
            Student student = studentsManager.findStudent(name);
            if (student != null) {
                universityFrame.warn(String.format("Student Information: %s", student.toString()));
            } else {
                universityFrame.warn(String.format("Student %s not found.", name));
            }
        }
    }
}
