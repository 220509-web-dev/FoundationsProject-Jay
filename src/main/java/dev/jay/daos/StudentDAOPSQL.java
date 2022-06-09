package dev.jay.daos;

import dev.jay.entitities.Student;
import dev.jay.utils.ConnectionsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOPSQL implements StudentDAO{
    @Override
    public Student createStudent(Student student) {
        try (Connection conn = ConnectionsUtil.getConnection()) {
            String sql = "insert into student (student_id, FirstName, LastName, username, password, class_id) values (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,student.getStudent_id());
            ps.setString(2,student.getFirstName());
            ps.setString(3,student.getLastName());
            ps.setString(4, student.getUser());
            ps.setString(5,student.getPassword());
            ps.setInt(6,student.getClass_id());

            ps.execute();


            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("student_id");

            student.setStudent_id(generatedId);
            return student;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public Student getStudentbyid(int id) {


        try (Connection conn = ConnectionsUtil.getConnection()) {
            String sql = "select from students where class_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Student student = new Student();
            student.setStudent_id(id);
            student.setFirstName(rs.getString("FirstName"));
            student.setLastName(rs.getString("LastName"));
            student.setUser(rs.getString("username"));
            student.setPassword(rs.getString("password"));
            student.setClass_id(rs.getInt("class_id"));
            return student;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() throws SQLException {
        try (Connection conn = ConnectionsUtil.getConnection()) {
            String sql = "select * from students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Student> students = new ArrayList<Student>();

            while (rs.next()) {
                Student student = new Student();
                student.setStudent_id(rs.getInt("id"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setUser(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setClass_id(rs.getInt("class_id"));
                students.add(student);
            }
        return students;
    } catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
        }

        @Override
    public Student updateStudent(Student student) {

        try(Connection conn = ConnectionsUtil.getConnection()){
            String sql = "update student set id = ?, FirstName = ?, LastName = ?, username = ?, password = ?, class_id = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,student.getStudent_id());
            ps.setString(2,student.getFirstName());
            ps.setString(3,student.getLastName());
            ps.setString(4,student.getUser());
            ps.setString(5,student.getPassword());
            ps.setInt(6,student.getClass_id());

            ps.execute();

            return student;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
            return null;
    }

    @Override
    public void deleteStudentbyid (int id) {
        try (Connection conn = ConnectionsUtil.getConnection()) {
            String sql = "delete from students where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
