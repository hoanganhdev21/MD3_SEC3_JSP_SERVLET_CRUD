package org.example.md3_sec1_jsp_servlet_crud.ra_crud.service;

import org.example.md3_sec1_jsp_servlet_crud.ra_crud.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Object findById(Long id);

    void save(Student student);

    void deleteById(Long id);

}

// Mục đích:
//Xác định hợp đồng cho các lớp quản lý dữ liệu liên quan đến sinh viên.
//Đảm bảo các phương pháp nhất quán để tương tác với thông tin của sinh viên qua các triển khai khác nhau.
//Phương pháp:
//findAll():
//Trả về danh sách tất cả các đối tượng sinh viên có sẵn.
//Được sử dụng để truy xuất một bộ sưu tập đầy đủ của sinh viên.
//findById(Long id):
//Truy xuất một đối tượng sinh viên cụ thể dựa trên ID duy nhất của nó.
//Trả về nullnếu không tìm thấy sinh viên nào có ID được chỉ định.
//Được sử dụng để lấy thông tin chi tiết của từng học sinh.
//save(Student student):
//Lưu một đối tượng sinh viên mới vào bộ lưu trữ dữ liệu cơ bản.
//Dùng để tạo hồ sơ sinh viên.
//deleteById(Long id):
//Xóa học sinh có ID được chỉ định khỏi bộ lưu trữ dữ liệu.
//Dùng để xóa hồ sơ sinh viên.

    // Phân biệt giữa kiểu dữ liệu viết thường và viết hoa
    // Đó là 1 class lớp có các trường thuộc tính và phương thức, lớp có thể null,
