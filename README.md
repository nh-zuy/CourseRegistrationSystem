# Course Registration System

** LẬP TRÌNH ỨNG DỤNG JAVA 

* Chức năng chung: 
  - Giáo vụ đăng nhập, sửa thông tin, mật khẩu.
  - Sinh viên đăng nhập, sửa thông tin, mật khẩu.
  
CHỨC NĂNG GIÁO VỤ:
* Chức năng 1: Quản lí tài khoản giáo vụ (Thêm, sửa, xóa).

* Chức năng 2: Quản lí môn học (Thêm, sửa, xóa).

* Chức năng 3: Quản lí học kì (Thêm, sửa, xóa). Chọn làm học kì hiện tại 

* Chức năng 4: Quản lí lớp học (Thêm, xóa).

* Chức năng 5: Quản lí sinh viên (Thêm vào lớp, cập nhật mật khẩu).

* Chức năng 6: Quản lí kì đăng kí học phần.

* Chức năng 7: Xem danh sách các học phần trong học kì hiện tại.

* Chức năng 8: Xem danh sách và tìm kiếm sinh viên đã đăng kí học phần.

CHỨC NĂNG SINH VIÊN:
* Chức năng 1: Đăng kí học phần (Không được trùng thời gian).
* Chức năng 2: Xem các học phần đã đăng kí.
* Chức năng 3: Xóa học phần nếu còn hạn đăng kí.


Mô tả cơ sở dữ liệu:
* Bảng classes: Lưu thông tin lớp học, lớp sinh hoạt 
* Bảng courses: Lưu thông tin học phần 
* Bảng current_sem: Lưu thông tin học kì hiện tại 
* Bảng schedules: Lưu thông tin lịch học của từng môn học 
* Bảng semesters: Lưu thông tin các học kì được quản lí 
* Bảng sessions: Lưu thông tin kì đăng kí học phần 
* Bảng students: Lưu thông tin sinh viên 
* Bảng studies: Lưu thông tin môn học mà sinh viên đã đăng kí 
* Bảng trainers: Lưu thông tin giáo vụ 
