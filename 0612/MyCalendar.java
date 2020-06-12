import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

public class MyCalendar {

    private List<Event> eventList = new ArrayList<>();

    private LocalDate day = LocalDate.now();

    private YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue());

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public void mainMenu() throws Exception {
        System.out.println("Select one of the following main menu options:\n" +
                "[V]iew by [C]reate, [G]o to [E]vent list [D]elete [Q]uit");
        Scanner input = new Scanner(System.in);
        String s=input.next();
        switch (s.toUpperCase()){
            case "V":
                this.view();
                break;
            case "C":
                createEvent();
                break;
            case "G":
                goToDay();
                break;
            case "E":
                printEvents();
                break;
            case "D":
                deleteEvents();
                break;
            case "Q":
                //quit
                System.out.println("Good Bye");
                saveEvents();
                System.exit(0);
                break;
        }
        mainMenu();
    }

    private void saveEvents() throws Exception{
        String path = this.getClass().getResource("/") +  "output.txt";
        path = path.replace("file:/", "");
        path = path.replace("/", "//");
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        if(this.getEventList()!=null && this.getEventList().size()>0){
            for(Event event:this.getEventList()){
                bw.write(event.getEventName());
                bw.newLine();
                if(event.getType()==1){
                    //one time event
                    bw.write(event.getTimeInterval().getStartDate().format(DateTimeFormatter.ofPattern("M/d/yy"))
                        +" "
                        +event.getTimeInterval().getStartTime().format(DateTimeFormatter.ofPattern("H:m"))
                        +" "
                        +event.getTimeInterval().getEndTime().format(DateTimeFormatter.ofPattern("H:m")));
                }else{
                    //recurring event
                    String narrowWeek = "";
                    for(DayOfWeek dayOfWeek:event.getTimeInterval().getWeekDays()){
                        narrowWeek+=getNarrowDisplayName(dayOfWeek);
                    }
                    bw.write(narrowWeek
                            +" "
                            +event.getTimeInterval().getStartTime().format(DateTimeFormatter.ofPattern("H:m"))
                            +" "
                            +event.getTimeInterval().getEndTime().format(DateTimeFormatter.ofPattern("H:m"))
                            +" "
                            +event.getTimeInterval().getStartDate().format(DateTimeFormatter.ofPattern("M/d/yy"))
                            +" "
                            +event.getTimeInterval().getEndDate().format(DateTimeFormatter.ofPattern("M/d/yy")));
                }
                bw.newLine();
            }
        }
        bw.close();
    }

    private void createEvent(){
        System.out.print("Name:");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        String eventName=input.next();
//        System.out.println();
        System.out.print("Date(MM/dd/yyyy):");
        input = new Scanner(System.in);
        String dateStr=input.next();
        LocalDate date = LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        System.out.println();
        System.out.print("Starting time and ending time(HH:mm HH:mm):");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        String timeStr=input.next();
        String[] timeSplit = timeStr.split(" ");
        LocalTime startTime = LocalTime.parse(timeSplit[0],DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(timeSplit[1],DateTimeFormatter.ofPattern("HH:mm"));
        boolean isConflict = false;
        if(this.getEventList()!=null && this.getEventList().size()>0){
            //check conflict
            for(Event event:this.getEventList()){
                if(event.getType()==1){
                    //one time event
                    if(event.getTimeInterval().getStartDate().equals(date)){
                        //date adjust
                        if(event.getTimeInterval().getStartTime().isBefore(endTime)
                                && event.getTimeInterval().getEndTime().isAfter(startTime)){
                            isConflict = true;
                            break;
                        }
                    }
                }else{
                    //one time event
                    if(!event.getTimeInterval().getStartDate().isAfter(date) && !event.getTimeInterval().getEndDate().isBefore(date)){
                        //date adjust
                        if(event.getTimeInterval().getStartTime().isBefore(endTime)
                                && event.getTimeInterval().getEndTime().isAfter(startTime)){
                            //check weekday
                            if(event.getTimeInterval().getWeekDays().contains(date.getDayOfWeek())){
                                isConflict = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(!isConflict){
            Event e = new Event();
            e.setEventName(eventName);
            e.setType(1);
            TimeInterval timeInterval = new TimeInterval();
            timeInterval.setStartDate(date);
            timeInterval.setEndDate(date);
            timeInterval.setStartTime(startTime);
            timeInterval.setEndTime(endTime);
            e.setTimeInterval(timeInterval);
            this.getEventList().add(e);
        }else{
            System.out.println("existing events.");
        }
    }

    private void printEvents(){
        //startDate sort
        Comparator<Event> eventsComparatorByStartDate = (h1, h2) -> h1.getTimeInterval().getStartDate().compareTo(h2.getTimeInterval().getStartDate());
        Comparator<Event> eventsComparatorByStartTime = (h1, h2) -> h1.getTimeInterval().getStartTime().compareTo(h2.getTimeInterval().getStartTime());
        //one time event
        List<Event> oneTimeEvents = this.getEventList().stream().filter(e->e.getType()==1)
                .sorted(eventsComparatorByStartDate.thenComparing(eventsComparatorByStartTime))
                .collect(Collectors.toList());
        System.out.println("ONE TIME EVENTS");
        if(oneTimeEvents!=null && oneTimeEvents.size()>0){
            for(Event event:oneTimeEvents){
                System.out.println(
                        event.getTimeInterval().getStartDate().format(DateTimeFormatter.ofPattern("E, MMM d, yyyy",Locale.ENGLISH))
                +"\t"+event.getTimeInterval().getStartTime().format(DateTimeFormatter.ofPattern("H:m"))
                +" - "+event.getTimeInterval().getEndTime().format(DateTimeFormatter.ofPattern("H:m"))
                + "\t"+event.getEventName());
            }
        }else{
            System.out.println("NO ONE TIME EVENTS!");
        }

        System.out.println("\n");
        //recurring event
        List<Event> recurringEvents = this.getEventList().stream().filter(e->e.getType()==2)
                .sorted(eventsComparatorByStartDate).collect(Collectors.toList());
        System.out.println("RECURRING EVENTS");
        if(recurringEvents!=null && recurringEvents.size()>0){
            for(Event event:recurringEvents){
                System.out.println(event.getEventName());
                String weekShorts = "";
                for(DayOfWeek week:event.getTimeInterval().getWeekDays()){
                    weekShorts += getNarrowDisplayName(week);
                }
                System.out.println(
                        weekShorts
                                +"\t"+event.getTimeInterval().getStartTime().format(DateTimeFormatter.ofPattern("H:m"))
                                +"\t"+event.getTimeInterval().getEndTime().format(DateTimeFormatter.ofPattern("H:m"))
                                +"\t"+event.getTimeInterval().getStartDate().format(DateTimeFormatter.ofPattern("M/d/yy"))
                                +"\t"+event.getTimeInterval().getEndDate().format(DateTimeFormatter.ofPattern("M/d/yy"))
                );
            }
        }else{
            System.out.println("NO RECURRING EVENTS!");
        }
    }

    private void deleteEvents(){
        System.out.println("[S]elected [A]ll [DR]");
        Scanner input = new Scanner(System.in);
        String s=input.next();
        switch (s.toUpperCase()) {
            case "S":
                System.out.println("Enter the date [MM/dd/yyyy]");
                goToDay();
                System.out.print("Enter the name of the event to delete:");
                input = new Scanner(System.in);
                input.useDelimiter("\n");
                s=input.next();
                boolean deleteSEvent = false;
                if(this.getEventList()!=null && this.getEventList().size()>0){
                    for(Event event:this.getEventList()){
                        if(event.getType()==1
                                && event.getTimeInterval().getStartDate().equals(this.getDay())
                                && event.getEventName().equalsIgnoreCase(s)){
                            this.getEventList().remove(event);
                            deleteSEvent = true;
                            break;
                        }
                    }
                }
                System.out.println();
                if(deleteSEvent){
                    System.out.println("Delete select events success!");
                }else{
                    System.out.println("Delete select events fail!");
                }
                break;
            case "A":
                this.setEventList(new ArrayList<>());
                System.out.println("Delete all events success!");
                break;
            case "DR":
                System.out.print("Enter the name of the event to delete:");
                input = new Scanner(System.in);
                input.useDelimiter("\n");
                s=input.next();
                boolean deleteDREvent = false;
                if(this.getEventList()!=null && this.getEventList().size()>0){
                    for(Event event:this.getEventList()){
                        if(event.getEventName().equalsIgnoreCase(s)){
                            this.getEventList().remove(event);
                            deleteDREvent = true;
                            break;
                        }
                    }
                }
                System.out.println();
                if(deleteDREvent){
                    System.out.println("Delete ["+s+"]event success!");
                }else{
                    System.out.println("Delete ["+s+"]event fail!");
                }
                break;
        }
    }

    private void goToDay(){
        System.out.println("Enter a date in the form of MM/dd/yyyy.");
        Scanner input = new Scanner(System.in);
        String s=input.next();
        LocalDate date = LocalDate.parse(s,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.setDay(date);
        this.printDayEvent();
    }

    private void view(){
        System.out.println("[D]ay view or [M]view ?");
        Scanner input = new Scanner(System.in);
        String s=input.next();
        switch (s.toUpperCase()) {
            case "D":
                this.setDay(LocalDate.now());
                this.printDay();
                break;
            case "M":
                this.setYearMonth(YearMonth.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue()));
                this.printCalendar(true);
                break;
        }
    }

    private void printDay(){
        printDayEvent();
        System.out.println("[P]revious or [N]ext or [G]o back to the main menu ?");
        Scanner input = new Scanner(System.in);
        String s=input.next();
        switch (s.toUpperCase()) {
            case "P":
                this.setDay(this.getDay().minusDays(1));
                printDay();
                break;
            case "N":
                this.setDay(this.getDay().plusDays(1));
                printDay();
                break;
            case "G":
                //reset
                this.setDay(LocalDate.now());
                break;
        }
    }

    private void printDayEvent(){
        System.out.println(this.getDay().format(DateTimeFormatter.ofPattern("E, MMM d, yyyy",Locale.ENGLISH)));
        this.printEventByDay();
    }

    private void printEventByDay(){
        List<Event> adjustEventList = listAdjustEvent(this.getDay());
        if(adjustEventList.size()>0){
            for(Event event:adjustEventList){
                System.out.println(event.getEventName()
                        +" : "+event.getTimeInterval().getStartTime()
                        +"-" +event.getTimeInterval().getEndTime());
            }
        }
    }

    public void printCalendar(boolean isRecursion){
        //打印日历的头部
        printMonthTitle(this.getYearMonth().getYear(),this.getYearMonth().getMonthValue());
        //打印日历的日期部分
        printMonthbody();
        System.out.println();
        if(isRecursion){
            System.out.println("[P]revious or [N]ext or [G]o back to the main menu ?");
            Scanner input = new Scanner(System.in);
            String s=input.next();
            switch (s.toUpperCase()) {
                case "P":
                    this.setYearMonth(this.getYearMonth().minusMonths(1));
                    printCalendar(isRecursion);
                    break;
                case "N":
                    this.setYearMonth(this.getYearMonth().plusMonths(1));
                    printCalendar(isRecursion);
                    break;
                case "G":
                    //reset
                    this.setYearMonth(YearMonth.of(LocalDate.now().getYear(),LocalDate.now().getMonthValue()));
                    break;
            }
        }
    }

    //打印日历的头部部分
    private void printMonthTitle(int year, int month) {
        String nameOfMonth = getNameOfMonth(month);
        System.out.printf("%10s %-13d",nameOfMonth,year);
        System.out.println("\n Su Mo Tu We Th Fr Sa");
    }

    //获得某个月的英文名称
    private String getNameOfMonth(int month) {
        String nameOfMonth="January";
        switch(month) {
            case 1: nameOfMonth = "January";break;
            case 2: nameOfMonth = "February";break;
            case 3: nameOfMonth = "March";break;
            case 4: nameOfMonth = "April";break;
            case 5: nameOfMonth = "May";break;
            case 6: nameOfMonth = "June";break;
            case 7: nameOfMonth = "July";break;
            case 8: nameOfMonth = "August";break;
            case 9: nameOfMonth = "September";break;
            case 10: nameOfMonth = "October";break;
            case 11: nameOfMonth = "November";break;
            case 12: nameOfMonth = "Decmber";break;
        }
        return nameOfMonth;
    }

    /**
     * 指定某天是否有符合的事件
     * @param day
     * @return
     */
    private List<Event> listAdjustEvent(LocalDate day){
        //满足的事件
        List<Event> adjustEventList = new ArrayList<>();
        for(Event event:eventList){
            //默认符合
            boolean isAdjust = true;
            if(!event.getTimeInterval().getStartDate().isAfter(day)
                    && !day.isAfter(event.getTimeInterval().getEndDate())){
                //日符合
                if(event.getTimeInterval().getWeekDays()!=null && event.getTimeInterval().getWeekDays().size()>0){
                    //指定了周
                    if(!event.getTimeInterval().getWeekDays().contains(day.getDayOfWeek())){
                        //周不符合
                        isAdjust = false;
                    }
                }
            }else{
                isAdjust = false;
            }
            if(isAdjust){
                adjustEventList.add(event);
            }
        }
        return adjustEventList;
    }

    //输出打印的月份日期部分
    private void printMonthbody() {
        //本月第一天和最后一天
        LocalDate first =LocalDate.of(this.getYearMonth().getYear(),this.getYearMonth().getMonth(),1);
        LocalDate lastDay =this.getYearMonth().atEndOfMonth();
        //本月有多少天
        int days= lastDay.get(ChronoField.DAY_OF_MONTH);
        //本月第一天是星期几
        int firstweek = first.get(ChronoField.DAY_OF_WEEK);

        //打印空格
        for (int i = 0; i <(firstweek) ; i++) {
            System.out.printf("%3s"," ");
        }
        //打印从1-最后一天
        for (int i = (firstweek+1),j=1; j <=days; i++,j++) {
            LocalDate localDate = LocalDate.of(this.getYearMonth().getYear(),this.getYearMonth().getMonthValue(),j);
            List<Event> adjustEventList= listAdjustEvent(localDate);
            boolean isAdjust = adjustEventList.size()>0?true:false;
            if(localDate.equals(LocalDate.now())){
                if(isAdjust){
                    System.out.printf(" {[%d]}",j);
                }else{
                    System.out.printf(" [%d]",j);
                }
            }else{
                if(isAdjust){
                    System.out.printf(" {%d}",j);
                }else{
                    System.out.printf("%3d",j);
                }
            }

            if(i%7==0){
                System.out.printf("\n");
            }
        }
    }

    /**
     * get week NARROW
     * @param week
     * @return
     */
    private static String getNarrowDisplayName(DayOfWeek week){
        switch (week.getValue()){
            case 7:return "S";
            case 1:return "M";
            case 2:return "T";
            case 3:return "W";
            case 4:return "R";
            case 5:return "F";
            case 6:return "A";
        }
        return null;
    };
}
