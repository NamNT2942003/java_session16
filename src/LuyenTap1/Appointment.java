package LuyenTap1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void intputData(Scanner scanner) {
        //appointmentId
        System.out.println("Nhập vào appointmentId : ");
        do {
            this.appointmentId = scanner.nextLine();
            if (this.appointmentId.length() == 6) {
                boolean isDuplicate = false;
                for (int i = 0; i < this.appointmentId.length() - 1; i++) {
                    for (int j = i + 1; j < this.appointmentId.length(); j++) {
                        if (this.appointmentId.charAt(i) == this.appointmentId.charAt(j)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) break;
                }

                if (isDuplicate) {
                    System.out.println("appointmentId không được chứa ký tự trùng lặp");
                    continue;
                }

                break;


            } else {
                System.out.println("appointmentId là chuỗi có 6 ký tự ");

            }


        } while (true);
        // patientName
        System.out.println("Nhập vào patientName: ");
        do {
            this.patientName = scanner.nextLine();
            if (this.patientName.length() >= 10 && this.patientName.length() <= 50) {
                break;
            } else {
                System.out.println("patientName  là một chuỗi có từ 10-50 ký tự ");
            }

        } while (true);
        // phoneNumber
        System.out.println("Nhập số điện thoại:");
        do {
            phoneNumber = scanner.nextLine();

            if (!phoneNumber.matches("^0(3|5|7|8|9)[0-9]{8}$")) {
                System.out.println("Số điện thoại không hợp lệ (VD: 0987654321)");
                continue;
            }

            break;

        } while (true);
        //appointmentDate
        System.out.println("Nhập vào appointmentDate ( dd/MM/yyyy) ");
        do {
            try {
                String date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.appointmentDate = LocalDate.parse(date, formatter);
                break;

            } catch (Exception e) {
                System.out.println("Vui lòng nhập giá trị hợp lệ");
            }


        } while (true);
//doctor
        System.out.println("Nhập vào doctor : ");
        do {
            this.doctor = scanner.nextLine();
            if (this.doctor.length() <= 200) {
                break;
            }else {
                System.out.println("(doctor): là một chuỗi có tối đa 200 ký tự");

            }

        }while (true);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", doctor='" + doctor + '\'' +
                '}';
    }

}
