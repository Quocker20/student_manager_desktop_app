package com.student.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Lớp này sử dụng Singleton Pattern để quản lý một kết nối CSDL duy nhất.
 */

public class DatabaseConnection {
    // 1. Thông tin kết nối CSDL (Lấy từ XAMPP)
    // URL: jdbc:mysql://{hostname}:{port}/{database_name}
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";

    // User 'root' cua XAMPP
    private static final String USER = "root";

    // Mật khẩu trống của XAMPP (mặc định)
    private static final String PASSWORD = "";

    // 2. Biến lưu trữ kết nối duy nhất
    private static Connection connection = null;

    // 3. Private constructor để ngăn chặn việc tạo đối tượng từ bên ngoài
    private DatabaseConnection() {
    }

    /**
     * Phương thức public, static để mọi nơi gọi và kết nối
     * Là cửa duy nhất để lấy kết nối CSDL
     * 
     * @return Đối tượng Connection duy nhất
     */
    public static Connection getConnection() {
        try {
            // Đưa IF vào BÊN TRONG try
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối CSDL thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối CSDL thất bại!");
        }
        return connection;
    }
}
