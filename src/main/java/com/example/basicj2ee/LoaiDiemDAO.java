package com.example.basicj2ee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoaiDiemDAO {
    public List<LoaiDiem> getList() {
        ExampleJDBC jdbc = new ExampleJDBC();
        Connection conn = jdbc.getConnection();

        if (conn == null) return null;

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();

            // Thực hiện truy vấn
            resultSet = statement.executeQuery("SELECT * FROM LOAIDIEM");

            List<LoaiDiem> loaiDiemList = new ArrayList<>();

            // Xử lý kết quả
            while (resultSet.next()) {
                String maloaidiem = resultSet.getString("MaLoaiDiem");
                String tenloaidiem = resultSet.getString("TenLoaiDiem");
                double tile = resultSet.getDouble("TiLe");

                LoaiDiem loaiDiem = new LoaiDiem(maloaidiem, tenloaidiem, tile);

                // Thêm đối tượng LoaiDiem vào danh sách
                loaiDiemList.add(loaiDiem);
            }

            return loaiDiemList;
        }
        catch (SQLException e) {
            return null;
        }
        finally {
            // Đóng kết nối và các đối tượng Statement, ResultSet
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
