package com.student.project.dao.impl;

import com.student.project.Student;
import com.student.project.dao.StudentDAO;
import com.student.project.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; // QUAN TRỌNG: Dùng java.sql.Date cho CSDL
import java.util.List; // Tạm thời import dù chưa dùng

/**
 * Đây là lớp triển khai (implementation) của StudentDAO.
 * Nơi này chứa code JDBC "bài bản" để thao tác với CSDL MySQL.
 */
// LỖI #1: Phải "implements StudentDAO"
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
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // --- LỖI #2: Thêm các phương thức còn lại ---
    
    @Override
    public List<Student> getAllStudents() {
        // TODO: Sẽ triển khai ở Tuần 3
        System.out.println("Chức năng getAllStudents chưa được triển khai.");
        return null; 
    }

    @Override
    public Student getStudentById(int id) {
        // TODO: Sẽ triển khai ở Tuần 3
        System.out.println("Chức năng getStudentById chưa được triển khai.");
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        // TODO: Sẽ triển khai ở Tuần 3
        System.out.println("Chức năng updateStudent chưa được triển khai.");
    }

    @Override
    public void deleteStudent(int id) {
        // TODO: Sẽ triển khai ở Tuần 3
        System.out.println("Chức năng deleteStudent chưa được triển khai.");
    }
}