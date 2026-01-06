package LuyenTap1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppointmentBusiness {
    List<Appointment> appointmentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addAppointment() {
        Appointment appointment = new Appointment();
        appointment.intputData(scanner);
        appointmentList.add(appointment);
    }

    public void displayAppointments() {
        appointmentList.stream().
                sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public void findPatient() {
        System.out.println("Enter Patient Name");
        String patientName = scanner.nextLine();
        boolean found = appointmentList.stream().anyMatch(appointment -> appointment.getPatientName().equals(patientName));
        if (found) {
            appointmentList.stream()
                    .filter(appointment -> appointment.getPatientName().equalsIgnoreCase(patientName))
                    .forEach(System.out::println);
        } else {
            System.out.println("Patient Not Found");
        }

    }

    public void updateAppointment() {
        System.out.println("Nhập mã lịch hẹn cần cập nhật:");
        String id = scanner.nextLine();

        Optional<Appointment> opt = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();

        opt.ifPresentOrElse(appointment -> {
            System.out.println("Chọn thông tin cần cập nhật : ");
            System.out.println("1. Patient Name ");
            System.out.println("2. Phone Number ");
            System.out.println("3. Appointment Date ");
            System.out.println("4. Doctor ");
            ;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:  // cập nhật patientName
                            System.out.println("Nhập tên bệnh nhân mới:");
                            appointment.setPatientName(scanner.nextLine());
                            break;
                        case 2:
                            // cập nhật phoneNumber
                            System.out.println("Nhập số điện thoại mới:");
                            String phone;
                            do {
                                phone = scanner.nextLine();
                            } while (!phone.matches("^0(3|5|7|8|9)[0-9]{8}$"));
                            appointment.setPhoneNumber(phone);
                            break;
                        case 3:
                            // cập nhật appointmentDate
                            System.out.println("Nhập ngày hẹn mới (dd/MM/yyyy):");
                            try {
                                String date = scanner.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                appointment.setAppointmentDate(LocalDate.parse(date, formatter));
                            } catch (Exception e) {
                                System.out.println("Ngày không hợp lệ, giữ nguyên ngày cũ");
                            }
                            break;
                        case 4:

                            // cập nhật doctor
                            System.out.println("Nhập bác sĩ mới:");
                            appointment.setDoctor(scanner.nextLine());
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");



                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } while (true);

            System.out.println("Cập nhật lịch hẹn thành công!");

        }, () -> {
            System.out.println("Không tìm thấy lịch hẹn với mã: " + id);
        });
    }
    public void deleteAppointment() {
        System.out.println("Nhập mã Appointment cần xóa: ");
        String appointmentId = scanner.nextLine();
        boolean found = appointmentList.stream().anyMatch(a -> a.getAppointmentId().equalsIgnoreCase(appointmentId));
        if (found) {
            System.out.println("Xác nhận trước khi xóa (Nhập Y/N)");
            String choice = scanner.nextLine();
           if (choice.equalsIgnoreCase("Y")) {
               boolean remove = appointmentList.removeIf(appointment -> appointment.getAppointmentId().equalsIgnoreCase(appointmentId));

               if (remove) {
                   System.out.println("Appointment has been deleted!");
               }else  {
                   System.out.println("Không tồn tại Appointment để xóa ");
               }
           }
           else if (choice.equalsIgnoreCase("N")) {
               return;
           }else {
               System.out.println("Vui lòng nhập Y/N");

           }
        }


    }
    public void statistical(){
        int count = appointmentList.size();
        System.out.println("Tổng số lịch hẹn:  "+ count);

    }

}
