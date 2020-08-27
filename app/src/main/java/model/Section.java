package model;

public class Section {

    public static final int LEC = 0;
    public static final int TUT = 1;
    public static final int PRA = 2;

    private int startTime;
    private int finishTime;
    private int day;
    private int type;
    private String code;

    public Section(int startTime, int finishTime, int day, int type, String code) {
    }

    public int getStartTime() { return this.startTime; }
    public int getFinishTime() { return this.finishTime; }
    public int getType() { return this.type; }
    public String getCode() { return this.code; }
    public int getDay() { return this.day; }
    public String getDayString() {
        switch (this.day) {
            case 0: return "Monday";
            case 1: return "Tuesday";
            case 2: return "Wednesday";
            case 3: return "Thursday";
            case 4: return "Friday";
            case 5: return "Saturday";
            case 6: return "Sunday";
        }
        return "";
    }

    public void setStartTime(int time) {
        if (0 <= time && time < 168)
            this.startTime = time + this.day*24;
    }

    public void setFinishTime(int time) {
        if (0 <= time && time < 168 && time > this.startTime)
            this.finishTime = time + this.day*24;
    }

    public void setDay(int day) {
        if (0 <= day && day < 7)
            this.day = day;
    }

    public void setType(int type) {
        if (0 <= type && type <= 2)
            this.type = type;
    }

    public void setCode(String code) { this.code = code; }

    public static int dist(Section s1, Section s2) {
        if (s1.getStartTime() >= s2.getFinishTime())
            return s1.getStartTime() - s2.getFinishTime();
        else if (s2.getStartTime() >= s1.getFinishTime())
            return s2.getStartTime() - s1.getFinishTime();
        return -1;
    }

    public static boolean isOverlap(Section s1, Section s2) {
        if ((s1.getStartTime() <= s2.getStartTime() && s2.getStartTime() < s1.getFinishTime()) ||
                (s1.getStartTime() < s2.getFinishTime() && s2.getFinishTime() <= s1.getFinishTime()))
                    return true;
        else if ((s2.getStartTime() <= s2.getStartTime() && s1.getStartTime() < s2.getFinishTime()) ||
                (s2.getStartTime() < s1.getFinishTime() && s1.getFinishTime() <= s2.getFinishTime()))
                    return true;
        return false;
    }
}
