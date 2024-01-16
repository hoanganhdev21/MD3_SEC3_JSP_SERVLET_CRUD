package org.example.md3_sec1_jsp_servlet_crud.ra_crud.service;

import org.example.md3_sec1_jsp_servlet_crud.ra_crud.dao.IStudentDao;
import org.example.md3_sec1_jsp_servlet_crud.ra_crud.dao.StudentDaoImpl;
import org.example.md3_sec1_jsp_servlet_crud.ra_crud.model.Student;


import java.util.List;

public class StudentServiceImpl implements IStudentService{
    private static IStudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Object findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }
}

// Lớp học:
//Tên: StudentServiceImpl
//Mục đích: Triển khai IStudentServicegiao diện, có khả năng cung cấp lớp dịch vụ để quản lý dữ liệu học sinh.

//Các yếu tố chính:
//Giao diện: IStudentService (không hiển thị) xác định các phương thức dự kiến ​​cho các hoạt động liên quan đến học sinh.
//DAO: IStudentDao (không hiển thị) cung cấp các phương thức truy cập dữ liệu để tương tác với nguồn dữ liệu (ví dụ: cơ sở dữ liệu).
//Triển khai: StudentDaoImpl (không hiển thị) là việc triển khai cụ thể của IStudentDaogiao diện.
//Phương pháp:

//findAll():
//Trả về danh sách tất cả các đối tượng sinh viên từ nguồn dữ liệu.
//Được ủy quyền cho studentDao.findAll()phương pháp.

//findById(Long id):
//Trả về một đối tượng sinh viên cụ thể dựa trên ID của nó.
//Được ủy quyền cho studentDao.findById(id)phương pháp.

//save(Student student):
//Lưu một đối tượng sinh viên mới vào nguồn dữ liệu.
//Được ủy quyền cho studentDao.save(student)phương pháp.

//deleteById(Long id):
//Xóa một đối tượng sinh viên có ID được chỉ định khỏi nguồn dữ liệu.
//Được ủy quyền cho studentDao.deleteById(id)phương pháp.

//Quan sát bổ sung:
//DAO tĩnh: Biến studentDaođược khai báo là static, biểu thị một phiên bản duy nhất được chia sẻ trên tất cả các phiên bản của StudentServiceImpl. Điều này có thể có ý nghĩa đối với việc kiểm tra và an toàn luồng.
//Sự phụ thuộc: Lớp được liên kết chặt chẽ với StudentDaoImpllớp cụ thể, có khả năng cản trở tính linh hoạt và thử nghiệm.
