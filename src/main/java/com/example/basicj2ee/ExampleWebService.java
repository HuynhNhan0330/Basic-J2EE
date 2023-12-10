package com.example.basicj2ee;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        LoaiDiemDAO loaiDiemDAO = new LoaiDiemDAO();

        // get list object
        List<LoaiDiem> listLoaiDiem = loaiDiemDAO.getList();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listLoaiDiem);
        return;
    }
}
