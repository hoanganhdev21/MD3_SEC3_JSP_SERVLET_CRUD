package org.example.md3_sec1_jsp_servlet_crud.ra_crud.controller;


import org.example.md3_sec1_jsp_servlet_crud.ra_crud.model.Student;
import org.example.md3_sec1_jsp_servlet_crud.ra_crud.service.IStudentService;
import org.example.md3_sec1_jsp_servlet_crud.ra_crud.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet",value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action  = req.getParameter("action");
        if(action!=null){
            switch (action){
                case "getAll":
                    showAllStudent(req, resp);
                    break;
                case "DELETE" :
                    // lấy ra id
                    Long id = Long.valueOf(req.getParameter("id"));
                    studentService.deleteById(id);
                    showAllStudent(req, resp);
                    break;
                case "ADD":
                    req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
                    break;
                case "EDIT":
                    Long idEdit = Long.valueOf(req.getParameter("id"));
                    req.setAttribute("studentEdit",studentService.findById(idEdit));
                    req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
                    break;
            }
        }

    }
    // Chức năng:
    //Servlet này xử lý các yêu cầu HTTP GET liên quan đến quản lý dữ liệu học sinh.
    //Nó hoạt động như một bộ điều khiển, định tuyến các yêu cầu đến các hành động thích hợp dựa trên actiontham số được cung cấp.

    //Cấu trúc mã:
    //doGetPhương pháp:
    //Phương thức này được gọi khi servlet nhận được yêu cầu GET.
    //Nó lấy actiontham số từ yêu cầu.
    //Nó thực hiện các hành động dựa trên giá trị của action:
    //"getAll": Hiển thị danh sách tất cả sinh viên ( showAllStudentchức năng gọi).
    //"DELETE": Xóa một sinh viên có ID được chỉ định và sau đó hiển thị lại danh sách sinh viên.
    //"ADD": Chuyển tiếp yêu cầu tới trang "add.jsp" để thêm học sinh mới.
    //"EDIT": Truy xuất một học sinh có ID được chỉ định, đặt ID đó làm thuộc tính yêu cầu và chuyển tiếp yêu cầu đến trang "edit.jsp" để chỉnh sửa.

    //Những điểm chính:
    //Servlet: Một lớp Java xử lý các yêu cầu và phản hồi HTTP.
    //doGetPhương pháp: Xử lý các yêu cầu GET một cách cụ thể.
    //HttpServletRequest: Cung cấp quyền truy cập vào thông tin yêu cầu (tham số, tiêu đề, v.v.).
    //HttpServletResponse: Dùng để gửi phản hồi lại cho client.
    //RequestDispatcher: Chuyển tiếp yêu cầu đến các tài nguyên khác (ví dụ: các trang JSP).
    //studentService: Có thể là một lớp dịch vụ bên ngoài xử lý các hoạt động dữ liệu của học sinh (không được hiển thị trong mã).

    private static void showAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/views/list-student.jsp").forward(req, resp);
    }
    // Mục đích:
    //Mã này định nghĩa một phương thức có tên showAllStudenttrong một servlet Java.
    //Mục đích chính của nó là lấy danh sách sinh viên từ nguồn dữ liệu và hiển thị chúng trên trang JSP.

    //Khai báo phương thức:
    //private static void showAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    //Khai báo một phương thức tĩnh riêng có tên showAllStudent.
    //Có hai tham số: HttpServletRequestđể truy cập thông tin yêu cầu và HttpServletResponsexử lý phản hồi.
    //Tuyên bố throws ServletException, IOExceptionxử lý các trường hợp ngoại lệ tiềm ẩn.

    //Truy xuất dữ liệu sinh viên:
    //List<Student> students = studentService.findAll();
    //Gọi một phương thức có tên findAll()trên một studentServiceđối tượng (có thể là lớp dịch vụ chịu trách nhiệm truy cập dữ liệu).
    //Truy xuất danh sách Studentcác đối tượng (có lẽ là đại diện cho thông tin sinh viên) và lưu nó vào studentsbiến.

    //Đặt thuộc tính trong yêu cầu:
    //req.setAttribute("students", students);
    //Thêm studentsdanh sách dưới dạng thuộc tính có tên "students" vào đối tượng yêu cầu.
    //Điều này làm cho dữ liệu sinh viên có thể truy cập được vào trang JSP.

    //Chuyển tiếp tới JSP:
    //req.getRequestDispatcher("/WEB-INF/views/list-student.jsp").forward(req, resp);
    //Lấy đối tượng requestDispatcher cho trang JSP có tại /WEB-INF/views/list-student.jsp.
    //Chuyển tiếp yêu cầu và phản hồi tới trang JSP đó.
    //Sau đó, trang JSP có thể truy cập thuộc tính "students" và hiển thị thông tin về sinh viên.

    //Những điểm chính:
    //Mã này trình bày cách một servlet tương tác với một lớp dịch vụ để lấy dữ liệu và chuyển tiếp nó đến trang JSP để trình bày.
    //Nó tuân theo mẫu Model-View-Controller (MVC) phổ biến trong phát triển web.
    //Đối studentServicetượng có thể gói gọn logic để tương tác với cơ sở dữ liệu hoặc nguồn dữ liệu khác.
    //Trang này /WEB-INF/views/list-student.jspchịu trách nhiệm hiển thị dữ liệu sinh viên ở định dạng thân thiện với người dùng.

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set utf8
        req.setCharacterEncoding("utf-8");

        String action  = req.getParameter("action");
        if(action!=null){
            switch (action){
                case "ADD":
                    String name = req.getParameter("name");
                    Integer age = Integer.valueOf(req.getParameter("age"));
                    Boolean sex = Boolean.valueOf(req.getParameter("sex"));
                    Student newStudent = new Student(null,name,age,sex);
                    studentService.save(newStudent);
                    showAllStudent(req, resp);
                    break;
                case "EDIT":
                    Long  idEdit = Long.valueOf(req.getParameter("id"));
                    String nameEdit = req.getParameter("name");
                    Integer ageEdit = Integer.valueOf(req.getParameter("age"));
                    Boolean sexEdit = Boolean.valueOf(req.getParameter("sex"));
                    Student updateStudent = new Student(idEdit,nameEdit,ageEdit,sexEdit);
                    studentService.save(updateStudent);
                    showAllStudent(req, resp);
                    break;
            }
        }
    }
    // Mục đích:
    //Mã này xử lý các yêu cầu POST được gửi tới một servlet.
    //Nó chủ yếu tập trung vào việc quản lý dữ liệu sinh viên (thêm, chỉnh sửa và hiển thị).

    //Những điểm chính:
    //Mã hóa ký tự:
    //Đặt mã hóa ký tự của yêu cầu thành UTF-8 để đảm bảo xử lý dữ liệu văn bản đúng cách.

    //Tham số hành động:
    //Truy xuất tham số "hành động" từ yêu cầu để xác định hoạt động dự định.

    //Tuyên bố chuyển đổi:
    //Sử dụng câu lệnh switch để thực thi các khối mã khác nhau dựa trên hành động:
    //"THÊM VÀO":
    //Lấy thông tin chi tiết về sinh viên (tên, tuổi, giới tính) từ các tham số yêu cầu.
    //Tạo một Studentđối tượng mới.
    //Lời gọi studentService.save()để duy trì học sinh (có thể sử dụng cơ sở dữ liệu).
    //Chuyển tiếp đến một trang hiển thị tất cả học sinh đang sử dụng showAllStudent(req, resp).

    //"BIÊN TẬP":
    //Truy xuất thông tin chi tiết về sinh viên, bao gồm cả ID để cập nhật sinh viên.
    //Tạo một Studentđối tượng mới với thông tin được cập nhật.
    //Lệnh gọi studentService.save()để cập nhật sinh viên vào cơ sở dữ liệu.
    //Chuyển tiếp đến trang hiển thị của sinh viên.

    //Ghi chú bổ sung:
    //Thiếu studentServicetriển khai: Mã dựa vào một studentServiceđối tượng để tương tác với cơ sở dữ liệu, nhưng việc triển khai nó không được cung cấp.
    //showAllStudentPhương pháp: Phương thức này showAllStudent(req, resp)không được hiển thị, nhưng có thể nó sẽ truy xuất dữ liệu của học sinh và hiển thị trên một trang web.
    //Xử lý lỗi: Mã không bao gồm xử lý lỗi rõ ràng, điều này rất quan trọng đối với các ứng dụng mạnh mẽ.
}


// Đăng ký Servlet:
//@WebServlet(name = "StudentServlet", value = "/StudentServlet"): Chú thích này đăng ký servlet với tên "StudentServlet" và ánh xạ nó tới mẫu URL "/StudentServlet". Điều này có nghĩa là mọi yêu cầu tới URL "/StudentServlet" sẽ được servlet này xử lý.

//Định nghĩa lớp:
//public class StudentServlet extends HttpServlet: Dòng này định nghĩa một lớp có tên "StudentServlet" mở rộng HttpServletlớp, cung cấp chức năng cơ bản để xử lý các yêu cầu và phản hồi HTTP trong các máy chủ Java.

//Dịch vụ sinh viên:
//private static final IStudentService studentService = new StudentServiceImpl();: Dòng này tạo một thể hiện của StudentServiceImpllớp (có lẽ là thực hiện IStudentServicegiao diện) và gán nó cho studentServicebiến. Dịch vụ này có thể chịu trách nhiệm tương tác với cơ sở dữ liệu hoặc nguồn dữ liệu khác để quản lý thông tin học sinh.

//Xử lý yêu cầu HTTP GET:
//doGet(HttpServletRequest req, HttpServletResponse resp): Phương thức này được gọi khi servlet nhận được yêu cầu HTTP GET. Nó thực hiện các hành động sau:
//Truy xuất tham số "hành động" từ yêu cầu: String action = req.getParameter("action");
//Thực hiện các hành động dựa trên tham số "action":
//"getAll": Truy xuất danh sách tất cả học sinh và chuyển tiếp đến trang "list-student.jsp" để hiển thị.
//"DELETE": Truy xuất ID sinh viên cần xóa, gọi studentService.deleteById()phương thức xóa sinh viên đó rồi chuyển tiếp đến trang "list-student.jsp".
//"ADD": Chuyển tiếp đến trang "add.jsp" để thêm học sinh mới.
//"EDIT": Truy xuất ID sinh viên cần chỉnh sửa, lấy thông tin của sinh viên bằng cách sử dụng studentService.findById(), và chuyển tiếp đến trang "edit.jsp" để chỉnh sửa.

//Xử lý yêu cầu POST HTTP:
//doPost(HttpServletRequest req, HttpServletResponse resp): Phương thức này được gọi khi servlet nhận được yêu cầu HTTP POST. Nó thực hiện các hành động sau:
//Đặt mã hóa ký tự thành UTF-8: req.setCharacterEncoding("utf-8");
//Truy xuất tham số "hành động" từ yêu cầu.
//Thực hiện các hành động dựa trên tham số "action":
//"ADD": Truy xuất tên, tuổi và giới tính của học sinh từ các tham số yêu cầu, tạo một Studentđối tượng mới, gọi studentService.save()phương thức để lưu học sinh và sau đó chuyển tiếp đến trang "list-student.jsp".
//"EDIT": Truy xuất ID sinh viên, tên, tuổi và giới tính từ các tham số yêu cầu, tạo một Studentđối tượng mới với thông tin cập nhật, gọi studentService.save()phương thức để cập nhật sinh viên, sau đó chuyển tiếp đến trang "list-student.jsp" .

//Những điểm chính:
//servlet sử dụng a StudentServiceđể tương tác với dữ liệu sinh viên, có thể là cơ sở dữ liệu.
//Nó xử lý cả yêu cầu GET và POST cho các hành động khác nhau liên quan đến sinh viên.
//Nó chuyển tiếp tới các trang JSP để hiển thị và chỉnh sửa thông tin sinh viên.
//Nó đặt mã hóa ký tự thành UTF-8 để xử lý chính xác các ký tự quốc tế.