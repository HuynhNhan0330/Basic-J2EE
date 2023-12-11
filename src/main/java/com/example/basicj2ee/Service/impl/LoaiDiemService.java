package com.example.basicj2ee.Service.impl;

import com.example.basicj2ee.DAO.ILoaiDiemDAO;
import com.example.basicj2ee.DAO.impl.LoaiDiemDAO;
import com.example.basicj2ee.LoaiDiem;
import com.example.basicj2ee.Service.ILoaiDiemService;
import com.example.basicj2ee.utils.Helper;

import java.util.List;

public class LoaiDiemService implements ILoaiDiemService {
    private ILoaiDiemDAO loaiDiemDAO;

    public LoaiDiemService() {
        loaiDiemDAO = new LoaiDiemDAO();
    }
    @Override
    public List<LoaiDiem> findAll() {
        return loaiDiemDAO.findAll();
    }

    @Override
    public LoaiDiem findOne(String maLoaiDiem) {
        return loaiDiemDAO.findOne(maLoaiDiem);
    }

    @Override
    public LoaiDiem save(LoaiDiem loaiDiem) {
        String maxID = loaiDiemDAO.findMaxMaLoaiDiem();
        String newID = Helper.generateNewMa(maxID, "LD");
        loaiDiem.setMaLoaiDiem(newID);
        return loaiDiem;
    }

    @Override
    public LoaiDiem update(LoaiDiem loaiDiem) {
        loaiDiemDAO.update(loaiDiem);
        return loaiDiem;
    }

    @Override
    public void delete(String maLoaiDiem) {
        loaiDiemDAO.delete(maLoaiDiem);
    }
}
