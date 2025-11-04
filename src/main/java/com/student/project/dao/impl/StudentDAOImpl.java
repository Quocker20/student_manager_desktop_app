package com.student.project.dao.impl;

import com.student.project.Student;
import com.student.project.dao.StudentDAO;
import com.student.project.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; // QUAN TRỌNG: Dùng java.sql.Date cho CSDL
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; // Tạm thời import dù chưa dùng

/**
 * Đây là lớp triển khai (implementation) của StudentDAO.
 * Nơi này chứa code JDBC "bài bản" để thao tác với CSDL MySQL.
 */

public class StudentDAOImpl implements StudentDAO {

    /**
     * Triển khai phương thức Thêm Sinh viên (FR1)
     */
    @Override
    public void addStudent(Student student) {
        Connection conn = DatabaseConnection.getConnection();

        // LỖI #3: Tên cột phải là 'dateOfBirth' (khớp với CSDL đã tạo)
        String sql = "INSERT INTO students (name, email, dateOfBirth) VALUES (?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, student.getName());
            pstm.setString(2, student.getEmail());

            // Xử lý nếu dateOfBirth là null (để tránh NullPointerException)
            if (student.getDateOfBirth() != null) {
                pstm.setDate(3, new Date(student.getDateOfBirth().getTime()));
            } else {
                pstm.setNull(3, java.sql.Types.DATE);
            }

            pstm.executeUpdate();
            System.out.println("Thêm sinh viên thành công!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Thêm sinh viên thất bại!");
        } finally {
            try {
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date dateOfBirth = rs.getDate("dateOfBirth");

                Student student = new Student(id, name, email, dateOfBirth);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();

            if (rs.next()) {
                int studentId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date dateOfBirth = rs.getDate("dateOfBirth");

                student = new Student(studentId, name, email, dateOfBirth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "UPDATE students SET name = ?, email = ?, dateOfBirth = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getName());
            pstm.setString(2, student.getEmail());
            if (student.getDateOfBirth() != null) {
                pstm.setDate(3, new Date(student.getDateOfBirth().getTime()));
            } else {
                pstm.setNull(3, java.sql.Types.DATE);
            }
            pstm.setInt(4, student.getId());

            pstm.executeUpdate();
            System.out.println("Cập nhật sinh viên thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cập nhật sinh viên thất bại!");
        } finally {
            try {
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "DELETE FROM students WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();
            System.out.println("Xóa sinh viên thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Xóa sinh viên thất bại!");
        } finally {
            try {
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}