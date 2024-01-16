package org.example.md3_sec1_jsp_servlet_crud.ra_crud.dao;

import org.example.md3_sec1_jsp_servlet_crud.ra_crud.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    void deleteById(Long id);
}

// Tên giao diện:
//IStudentDao: Tên này gợi ý rằng đây là một giao diện được thiết kế đặc biệt để tương tác với dữ liệu của sinh viên. Tiền tố "I" là quy ước chung để biểu thị giao diện trong Java.

//Phương pháp:
//List<Student> findAll();
//Mục đích: Truy xuất danh sách tất cả các đối tượng học sinh từ nguồn dữ liệu cơ bản (cơ sở dữ liệu, tệp, v.v.).
//Kiểu trả về: List<Student>, nghĩa là nó trả về một tập hợp các đối tượng sinh viên.
//Student findById(Long id);
//Mục đích: Truy xuất một đối tượng sinh viên dựa trên mã định danh (ID) duy nhất của nó.
//Tham số: Long id- ID của sinh viên cần lấy.
//Kiểu trả về: Student- đối tượng sinh viên có ID trùng khớp hoặc nullnếu không tìm thấy.
//void save(Student student);
//Mục đích: Lưu đối tượng sinh viên mới hoặc cập nhật đối tượng hiện có trong nguồn dữ liệu.
//Tham số: Student student- đối tượng sinh viên cần lưu hoặc cập nhật.
//Kiểu trả về: void- cho biết phương thức không trả về giá trị.
//void deleteById(Long id);
//Mục đích: Xóa đối tượng sinh viên khỏi nguồn dữ liệu dựa trên ID của nó.
//Thông số: Long id- ID của sinh viên cần xóa.
//Kiểu trả về: void- cho biết phương thức không trả về giá trị.

//Những điểm chính:
//Giao diện này xác định một hợp đồng để tương tác với dữ liệu của sinh viên, nhưng nó không cung cấp cách triển khai thực tế các phương pháp đó.
//Việc triển khai thường sẽ được cung cấp bởi một lớp cụ thể (ví dụ: StudentDaoImpl) triển khai giao diện này và tương tác với nguồn dữ liệu cụ thể.
//Sự tách biệt giữa giao diện và cách triển khai này thúc đẩy tính linh hoạt và khả năng kiểm thử trong thiết kế mã.
