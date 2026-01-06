package Kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Event() {
    }

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(startDate)) {
            return "Sắp diễn ra";
        } else if (now.isAfter(endDate)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    @Override
    public String toString() {
        return String.format("Sự kiện: %-20s | Bắt đầu: %s | Kết thúc: %s | Trạng thái: %s",
                name,
                startDate.format(FORMATTER),
                endDate.format(FORMATTER),
                getStatus());
    }
}
