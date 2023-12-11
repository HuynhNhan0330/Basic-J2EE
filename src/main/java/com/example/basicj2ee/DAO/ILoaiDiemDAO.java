package com.example.basicj2ee.DAO;

import com.example.basicj2ee.LoaiDiem;

import java.util.List;

public interface ILoaiDiemDAO {
    List<LoaiDiem> findAll();

    String findMaxMaLoaiDiem();

    LoaiDiem findOne(String maLoaiDiem);

    String save(LoaiDiem loaiDiem);

    void update(LoaiDiem loaiDiem);

    void delete(String maLoaiDiem);
}
