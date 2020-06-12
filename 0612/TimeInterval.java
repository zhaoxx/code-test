import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TimeInterval {

    /**
     * startTime
     */
    private LocalTime startTime;

    /**
     * endTime
     */
    private LocalTime endTime;

    /**
     * weekDays
     */
    private List<DayOfWeek> weekDays;

    /**
     * startDate
     */
    private LocalDate startDate;

    /**
     * endDate
     */
    private LocalDate endDate;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<DayOfWeek> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<DayOfWeek> weekDays) {
        this.weekDays = weekDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
