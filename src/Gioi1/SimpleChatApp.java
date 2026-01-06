package Gioi1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleChatApp {
    private static List<Message> messages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        messages.add(new Message("Alice", "Xin chào mọi người!"));
        messages.add(new Message("Bob", "Chào Alice, khỏe không?"));
        messages.add(new Message("Alice", "Mình khỏe, cảm ơn Bob."));

        while (true) {
            System.out.println("\n=== ỨNG DỤNG CHAT CONSOLE ===");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem toàn bộ lịch sử chat");
            System.out.println("3. Tìm tin nhắn theo người gửi (Streams)");
            System.out.println("4. Tìm tin nhắn theo ngày (Streams)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        sendMessage();
                        break;
                    case 2:
                        viewHistory();
                        break;
                    case 3:
                        filterBySender();
                        break;
                    case 4:
                        filterByDate();
                        break;
                    case 0:
                        System.out.println("Đã thoát ứng dụng.");
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

    }
    private static void sendMessage() {
        System.out.print("Nhập tên người gửi: ");
        String sender = scanner.nextLine();

        System.out.print("Nhập nội dung: ");
        String content = scanner.nextLine();

        Message msg = new Message(sender, content);
        messages.add(msg);
        System.out.println("--> Tin nhắn đã được gửi!");
    }
    private static void viewHistory() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào.");
        } else {
            System.out.println("--- Lịch sử Chat ---");
            messages.forEach(System.out::println);
        }
    }
    private static void filterBySender() {
        System.out.print("Nhập tên người muốn tìm: ");
        String keyword = scanner.nextLine();

        System.out.println("--- Kết quả tìm kiếm: " + keyword + " ---");

        List<Message> result = messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(keyword)) // So sánh không phân biệt hoa thường
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn nào của " + keyword);
        } else {
            result.forEach(System.out::println);
        }
    }
    private static void filterByDate() {
        System.out.print("Nhập ngày cần tìm (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();

        try {
            LocalDate searchDate = LocalDate.parse(dateStr, DATE_INPUT_FORMATTER);
            System.out.println("--- Tin nhắn ngày " + searchDate + " ---");
            long count = messages.stream()
                    .filter(m -> m.getTimestamp().toLocalDate().isEqual(searchDate)) // So sánh phần ngày
                    .peek(System.out::println)
                    .count();

            if (count == 0) {
                System.out.println("Không có tin nhắn nào trong ngày này.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập đúng dd/MM/yyyy (VD: 25/08/2024)");
        }
    }
}

