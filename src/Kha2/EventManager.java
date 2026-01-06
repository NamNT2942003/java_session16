package Kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {
    private static List<Event> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ SỰ KIỆN (DATETIME API) ===");
            System.out.println("1. Thêm sự kiện mới");
            System.out.println("2. Xem danh sách sự kiện");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: addEvent(); break;
                    case 2: showEvents(); break;
                    case 0:
                        System.out.println("Kết thúc chương trình.");
                        return;
                    default: System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    private static void addEvent() {
        System.out.print("Nhập tên sự kiện: ");
        String name = scanner.nextLine();

        LocalDateTime start = null;
        LocalDateTime end = null;

        try {

            System.out.print("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
            String startStr = scanner.nextLine();
            start = LocalDateTime.parse(startStr, INPUT_FORMATTER);
            System.out.print("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
            String endStr = scanner.nextLine();
            end = LocalDateTime.parse(endStr, INPUT_FORMATTER);

            if (end.isBefore(start)) {
                System.out.println("Lỗi logic: Thời gian kết thúc không được trước thời gian bắt đầu!");
                return;
            }

            events.add(new Event(name, start, end));
            System.out.println("Thêm sự kiện thành công!");

        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày giờ không hợp lệ! Hãy nhập đúng dạng dd/MM/yyyy HH:mm");
        }
    }
    private static void showEvents() {
        if (events.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("--- Danh sách sự kiện ---");
            System.out.println("Thời gian hiện tại: " + LocalDateTime.now().format(INPUT_FORMATTER));
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }
}
