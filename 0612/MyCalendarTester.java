import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MyCalendarTester {

    //主函数入口
    public static void main(String[] args)throws Exception {
        MyCalendar myCalendar = new MyCalendar();
        //把客户输入的数据分离出年与月，并且转为整数类型
        LocalDate today = LocalDate.now();
        myCalendar.setDay(today);
        //输出当天日历
        myCalendar.printCalendar(false);
        //加载事件
        List<Event> eventList = readFile();
        myCalendar.setEventList(eventList);
        System.out.println("Loading is done!.");
        //
        myCalendar.mainMenu();
    }

    /**
     * read file
     * @return
     * @throws Exception
     */
    public static List<Event> readFile() throws Exception{
        String path = MyCalendarTester.class.getResource("/") +  "events.txt";
        path = path.replace("file:/", "");
        path = path.replace("/", "//");
        File file = new File(path);
        BufferedReader reader=new BufferedReader(new FileReader(file));

        List<String> list = new ArrayList<String>();
        String temp=null;
        while((temp=reader.readLine())!=null){
            list.add(temp);
        }

        List<Event> eventList = new ArrayList<Event>();
        for(int i=0;i<list.size();i=i+2){
            String eventName = list.get(i);
            String dateStr = list.get(i+1);

            Event event = parseDate(dateStr);
            event.setEventName(eventName);
            eventList.add(event);
        }
        return eventList;
    }

    private static Event parseDate(String dateStr){
        Event event = new Event();
        TimeInterval timeInterval = new TimeInterval();
        String[] strs = dateStr.split(" ");
        LocalDate startDate = null;
        LocalDate endDate = null;

        LocalTime startTime = null;
        LocalTime endTime = null;

        if(strs.length==3){
            event.setType(1);
            startDate = LocalDate.parse(strs[0], DateTimeFormatter.ofPattern("M/d/yy"));
            endDate = LocalDate.parse(strs[0], DateTimeFormatter.ofPattern("M/d/yy"));
        }else if(strs.length==5){
            event.setType(2);
            List<DayOfWeek> weekDays = new ArrayList<>();
            String weeks = strs[0];

            if(weeks.contains("S")){
                weekDays.add(DayOfWeek.SUNDAY);
            }
            if(weeks.contains("M")){
                weekDays.add(DayOfWeek.MONDAY);
            }
            if(weeks.contains("T")){
                weekDays.add(DayOfWeek.TUESDAY);
            }
            if(weeks.contains("W")){
                weekDays.add(DayOfWeek.WEDNESDAY);
            }
            if(weeks.contains("R")){
                weekDays.add(DayOfWeek.THURSDAY);
            }
            if(weeks.contains("F")){
                weekDays.add(DayOfWeek.FRIDAY);
            }
            if(weeks.contains("A")){
                weekDays.add(DayOfWeek.SATURDAY);
            }
            timeInterval.setWeekDays(weekDays);

            startDate = LocalDate.parse(strs[3], DateTimeFormatter.ofPattern("M/d/yy"));
            endDate = LocalDate.parse(strs[4], DateTimeFormatter.ofPattern("M/d/yy"));
        }
        timeInterval.setStartDate(startDate);
        timeInterval.setEndDate(endDate);

        startTime = LocalTime.parse(strs[1],DateTimeFormatter.ofPattern("H:m"));
        endTime = LocalTime.parse(strs[2],DateTimeFormatter.ofPattern("H:m"));
        timeInterval.setStartTime(startTime);
        timeInterval.setEndTime(endTime);
        event.setTimeInterval(timeInterval);
        return event;
    }
}