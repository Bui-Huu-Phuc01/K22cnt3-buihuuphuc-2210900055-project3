<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đặt Lịch Hẹn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            display: flex;
            height: 100vh;
            align-items: center;
            justify-content: center;
            margin: 0;
        }
        .container {
            background-color: #fff;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            width: 100%;
            max-width: 500px;
            padding: 30px;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input, textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        .btn-submit, .btn-history {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            width: 100%;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
            text-align: center;
            display: block;
            text-decoration: none;
            margin-top: 10px;
        }
        .btn-submit:hover, .btn-history:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            margin-top: 15px;
        }
        .success { color: #4CAF50; }
        .error { color: #f44336; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Đặt Lịch Hẹn</h1>

        <% if (request.getParameter("success") != null) { %>
            <div class="message success">Đặt lịch thành công! Vui lòng chờ xác nhận.</div>
        <% } else if (request.getParameter("error") != null) { %>
            <div class="message error">Đặt lịch thất bại. Vui lòng thử lại.</div>
        <% } %>

        <form action="bhp_DatLichServlet" method="post">
            <div class="form-group">
                <label for="customerName">Họ và Tên:</label>
                <input type="text" id="customerName" name="customerName" required>
            </div>
            <div class="form-group">
                <label for="customerPhone">Số điện thoại:</label>
                <input type="text" id="customerPhone" name="customerPhone" required>
            </div>
            <div class="form-group">
                <label for="customerEmail">Email:</label>
                <input type="email" id="customerEmail" name="customerEmail" required>
            </div>
            <div class="form-group">
                <label for="appointmentDate">Ngày hẹn:</label>
                <input type="date" id="appointmentDate" name="appointmentDate" required>
            </div>
            <div class="form-group">
                <label for="appointmentTime">Giờ hẹn:</label>
                <input type="time" id="appointmentTime" name="appointmentTime" required>
            </div>
            <div class="form-group">
                <label for="notes">Ghi chú (nếu có):</label>
                <textarea id="notes" name="notes" rows="3"></textarea>
            </div>
            <button type="submit" class="btn-submit">Gửi Yêu Cầu</button>
        </form>

        <!-- Nút xem lịch sử đặt lịch -->
        <a href="bhp_lichsu_datlich.jsp" class="btn-history">Xem Lịch Sử Đặt Lịch</a>
    </div>
</body>
</html>
