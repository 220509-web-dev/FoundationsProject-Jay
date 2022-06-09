package dev.jay.daos;

import dev.jay.entitities.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    Student createStudent(Student student);

    Student getStudentbyid (int id);
    List<Student>  getAllStudent() throws SQLException;

    Student updateStudent(Student student);

    void deleteStudentbyid (int id);


}
