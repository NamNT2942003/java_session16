package LuyenTap1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBusiness appointmentBusiness = new AppointmentBusiness();
        do {
            System.out.println("*********************QUẢN ẢN LÝ LỊCH HẸN********************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã lịch hẹn");
            System.out.println("5. Xóa lịch hẹn theo mã lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
           int choice = Integer.parseInt(sc.nextLine());
           switch (choice) {
               case 1: appointmentBusiness.addAppointment(); break;
               case 2: appointmentBusiness.displayAppointments(); break;
               case 3: appointmentBusiness.findPatient(); break;
               case 4: appointmentBusiness.updateAppointment(); break;
               case 5: appointmentBusiness.deleteAppointment(); break;
               case 6: appointmentBusiness.statistical(); break;
               case 7: System.exit(0); break;
           }


        }while (true);
    }
}
