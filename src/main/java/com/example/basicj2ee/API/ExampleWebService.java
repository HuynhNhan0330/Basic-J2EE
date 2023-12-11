package com.example.basicj2ee.API;

import com.example.basicj2ee.LoaiDiem;
import com.example.basicj2ee.DAO.impl.LoaiDiemDAO;
import com.example.basicj2ee.Service.ILoaiDiemService;
import com.example.basicj2ee.Service.impl.LoaiDiemService;
import com.example.basicj2ee.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-loaidiem" })
public class ExampleWebService extends HttpServlet {
    private ILoaiDiemService loaiDiemService;

    public ExampleWebService() {
        loaiDiemService = new LoaiDiemService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        LoaiDiemDAO loaiDiemDAO = new LoaiDiemDAO();
//
//        // get list object
        List<LoaiDiem> listLoaiDiem = loaiDiemService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listLoaiDiem);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LoaiDiem loaiDiemNew = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // create new data point in database
        loaiDiemNew = loaiDiemService.save(loaiDiemNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), loaiDiemNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LoaiDiem loaidiemUpdate = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // update new data point in database
        loaidiemUpdate = loaiDiemService.update(loaidiemUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), loaidiemUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        LoaiDiem loaiDiemDelete = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // delete target data point in database
        loaiDiemService.delete(loaiDiemDelete.getMaLoaiDiem());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
