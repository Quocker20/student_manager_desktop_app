package com.student.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    private DatabaseConnection() {
        // Private constructor
    }

    /**
     * Phương thức 'synchronized' để đảm bảo an toàn đa luồng (Thread-Safe).
     * Chỉ một luồng được phép thực thi khối này tại một thời điểm.
     *
     * @return Đối tượng Connection duy nhất.
     */
    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Tạo kết nối mới nếu chưa có hoặc đã bị đóng
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối CSDL thành công!"); // Tùy chọn để debug
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối CSDL thất bại!"); // Tùy chọn để debug
        }
        return connection;
    }
}