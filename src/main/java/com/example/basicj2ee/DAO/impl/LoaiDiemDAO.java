package com.example.basicj2ee.DAO.impl;

import com.example.basicj2ee.DAO.ILoaiDiemDAO;
import com.example.basicj2ee.ExampleJDBC;
import com.example.basicj2ee.LoaiDiem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoaiDiemDAO implements ILoaiDiemDAO {
    private ExampleJDBC jdbc;

    public  LoaiDiemDAO() {
        jdbc = new ExampleJDBC();
    }

    @Override
    public List<LoaiDiem> findAll() {
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

    @Override
    public String findMaxMaLoaiDiem() {
        Connection conn = jdbc.getConnection();

        if (conn == null) return null;

        Statement  statement = null;
        ResultSet resultSet = null;
        try {
            String MaxID = "";

            String query = "SELECT MAX(MaLoaiDiem) FROM LOAIDIEM";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                MaxID = resultSet.getString(1);
            }
            return MaxID;
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

    @Override
    public LoaiDiem findOne(String maLoaiDiem) {
        Connection conn = jdbc.getConnection();

        if (conn == null) return null;

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            LoaiDiem loaiDiem = new LoaiDiem();

            String query = "SELECT * FROM loaidiem WHERE maLoaiDiem = ?";
            statement = conn.prepareStatement(query);
            statement.setString(1, maLoaiDiem);
            if (resultSet.next()) {
                loaiDiem.setMaLoaiDiem(resultSet.getString("MaLoaiDiem"));
                loaiDiem.setTenLoaiDiem(resultSet.getString("TenLoaiDiem"));
                loaiDiem.setTiLe(resultSet.getDouble("TiLe"));
            }

            return loaiDiem;
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

    @Override
    public String save(LoaiDiem loaiDiem) {
        Connection conn = jdbc.getConnection();

        if (conn == null) return null;

        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO LOAIDIEM (MaLoaiDiem, TenLoaiDiem, TiLe) VALUES (?, ?, ?)";
            statement = conn.prepareStatement(query);
            statement.setString(1, loaiDiem.getMaLoaiDiem());
            statement.setString(2, loaiDiem.getTenLoaiDiem());
            statement.setDouble(3, loaiDiem.getTiLe());
            statement.executeUpdate();

            return loaiDiem.getMaLoaiDiem();
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

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(LoaiDiem loaiDiem) {
        Connection conn = jdbc.getConnection();

        if (conn == null) return;

        PreparedStatement statement = null;

        try {
            String query = "UPDATE LOAIDIEM SET TenLoaiDiem = ?, TiLe = ? WHERE MaLoaiDiem = ?";
            statement = conn.prepareStatement(query);
            statement.setString(3, loaiDiem.getMaLoaiDiem());
            statement.setString(1, loaiDiem.getTenLoaiDiem());
            statement.setDouble(2, loaiDiem.getTiLe());
            statement.executeUpdate();
        }
        catch (SQLException e) {
        }
        finally {
            // Đóng kết nối và các đối tượng Statement, ResultSet
            try {
                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String maLoaiDiem) {
        Connection conn = jdbc.getConnection();

        if (conn == null) return;

        PreparedStatement statement = null;

        try {
            String query = "DELETE FROM LOAIDIEM WHERE MaLoaiDiem = ?";
            statement = conn.prepareStatement(query);
            statement.setString(1, maLoaiDiem);
            statement.executeUpdate();
        }
        catch (SQLException e) {
        }
        finally {
            // Đóng kết nối và các đối tượng Statement, ResultSet
            try {
                if (statement != null) {
                    statement.close();
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
