<%@ page import="com.example.basicj2ee.ExampleWebService" %>
<%@ page import="com.example.basicj2ee.ExampleJDBC" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.basicj2ee.ExampleBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1>Welcome to JSP Example</h1>

  <form action="ExampleServlet" method="POST">
    <input type="text" name="name" placeholder="Enter your name">
    <input type="submit" value="Submit">
  </form>

  <h2>Response from Web Service and JDBC:</h2>
  <h3>LoaiDiem List</h3>
  <table id="loaidiem-table">
    <thead>
    <tr>
      <th>Mã Loại Điểm</th>
      <th>Tên Loại Điểm</th>
      <th>Tỉ lệ</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
  </table>

  <h2>Response from EJB:</h2>
  <%
    ExampleBean exBean = new ExampleBean();
    String name = exBean.processName("Nguyen");
  %>
  <p><%=name%></p>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  $(document).ready(function() {
    console.log("succes");
    // Gửi yêu cầu AJAX để lấy danh sách LoaiDiem từ API
    $.ajax({
      url: "/api-admin-loaidiem",
      type: "GET",
      dataType: "json",
      success: function(data) {
        console.log("succes");

        // Xóa dữ liệu cũ trong bảng
        $("#loaidiem-table tbody").empty();

        // Vòng lặp qua danh sách LoaiDiem và thêm dữ liệu vào bảng
        for (var i = 0; i < data.length; i++) {
          var loaiDiem = data[i];
          var row = "<tr>" +
                  "<td>" + loaiDiem.maLoaiDiem + "</td>" +
                  "<td>" + loaiDiem.tenLoaiDiem + "</td>" +
                  "<td>" + loaiDiem.tiLe + "</td>" +
                  "</tr>";
          $("#loaidiem-table tbody").append(row);
        }
      },
      error: function(error) {
        console.log("Error: " + error);
      }
    });
  });
</script>
</html>