package com.student.project.dao;

// Import lớp Model
import com.student.project.Student; 
// Import thư viện List để chứa danh sách sinh viên
import java.util.List; 

/**
 * This interface defines the contract for data access operations on Student.
 * (DAO - Data Access Object)
 * Đây là bản hợp đồng, chỉ định nghĩa các chức năng CẦN có.
 */
public interface StudentDAO {

    /**
     * Lấy về danh sách TẤT CẢ sinh viên.
     * (Phục vụ chức năng FR2: Read)
     *
     * @return Một List các đối tượng Student.
     */
    List<Student> getAllStudents();

    /**
     * Lấy một sinh viên cụ thể bằng ID.
     *
     * @param id ID của sinh viên cần tìm.
     * @return Đối tượng Student, hoặc null nếu không tìm thấy.
     */
    Student getStudentById(int id);

    /**
     * Thêm một sinh viên mới vào CSDL.
     * (Phục vụ chức năng FR1: Create)
     *
     * @param student Đối tượng Student chứa thông tin mới.
     */
    void addStudent(Student student);

    /**
     * Cập nhật thông tin của một sinh viên đã có.
     * (Phục vụ chức năng FR3: Update)
     *
     * @param student Đối tượng Student chứa thông tin đã cập nhật.
     */
    void updateStudent(Student student);

    /**
     * Xóa một sinh viên khỏi CSDL dựa trên ID.
     * (Phục vụ chức năng FR4: Delete)
     *
     * @param id ID của sinh viên cần xóa.
     */
    void deleteStudent(int id);
}