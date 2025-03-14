<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sản Phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }
        .container {
            width: 50%;
            margin: auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            font-weight: bold;
        }
        input, textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #218838;
        }
        .btn-cancel {
            background-color: #dc3545;
        }
        .btn-cancel:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Thêm Sản Phẩm Mới</h2>
        <form action="bhp_ThemSanPhamServlet" method="post">
            <label for="ten">Tên sản phẩm:</label>
            <input type="text" id="ten" name="ten" required>

            <label for="moTa">Mô tả:</label>
            <textarea id="moTa" name="moTa" required></textarea>

            <label for="gia">Giá (VNĐ):</label>
            <input type="number" id="gia" name="gia" required>

            <label for="soLuong">Số lượng:</label>
            <input type="number" id="soLuong" name="soLuong" required>

            <button type="submit" class="btn">➕ Thêm Sản Phẩm</button>
            <a href="bhp_product_list.jsp" class="btn btn-cancel">❌ Hủy</a>
        </form>
    </div>
</body>
</html>
