package hw6.c2;

public class MyTime {
    //Attributes
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    //Constructors
    private boolean checkRightTimeValue(int hour, int minute, int second) {
        if (hour >= 0 && hour <= 23 &&
                minute >= 0 && minute <= 59 &&
                second >= 0 && second <= 59) {
            return true;
        }
        return false;
    }

    public MyTime(){}

    public MyTime(int hour, int minute, int second) {
        if (checkRightTimeValue(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("That's not correct form of time.");
        }
    }

    //Getters, Setters
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        if (checkRightTimeValue(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("\"Invalid hour, minute, or second!\"");
        }
    }

    //APIs
    @Override
    public String toString() {
        String time = "";
        if (hour < 10){
            time += "0" + hour + ":";
        } else {
            time += hour + ":";
        }
        if (minute < 10){
            time += "0" + minute + ":";
        } else {
            time += minute + ":";
        }
        if (second < 10){
            time += "0" + second;
        } else {
            time += second;
        }
        return time;
    }

    public MyTime nextSecond(){
        MyTime nextSecond = new MyTime(this.hour, this.minute, this.second);
        if (this.second == 59) {
            nextSecond.setSecond(0);
            if (this.minute == 59) {
                nextSecond.setMinute(0);
                if (this.hour == 23) {
                    nextSecond.setHour(0);
                } else {
                    nextSecond.setHour(nextSecond.getHour()+1);
                }
            } else {
                nextSecond.setMinute(nextSecond.getMinute()+1);
            }
        } else {
            nextSecond.setSecond(nextSecond.getMinute()+1);
        }
        return nextSecond;
    }

    public MyTime previousSecond(){
        MyTime previousSecond = new MyTime(this.hour, this.minute, this.second);
        if (this.second == 0) {
            previousSecond.second = 59;
            if (this.minute == 0) {
                previousSecond.minute = 59;
                if (this.hour == 0) {
                    previousSecond.hour = 23;
                } else {
                    previousSecond.hour--;
                }
            } else {
                previousSecond.minute--;
            }
        } else {
            previousSecond.second--;
        }
        return previousSecond;
    }

    public MyTime nextMinute(){
        MyTime nextMinute = new MyTime(this.hour, this.minute, this.second);
        if (this.minute == 59) {
            nextMinute.minute = 0;
            if (this.hour == 23) {
                nextMinute.hour = 0;
            } else {
                nextMinute.hour++;
            }
        } else {
            nextMinute.minute++;
        }
        return nextMinute;
    }

    public MyTime previousMinute(){
        MyTime previousMinute = new MyTime(this.hour, this.minute, this.second);
        if (this.minute == 0) {
            previousMinute.minute = 59;
            if (this.hour == 0) {
                previousMinute.hour = 23;
            } else {
                previousMinute.hour--;
            }
        } else {
            previousMinute.minute--;
        }
        return previousMinute;
    }

    public MyTime nextHour(){
        MyTime nextHour = new MyTime(this.hour, this.minute, this.second);
        if (this.hour == 23) {
            nextHour.hour = 0;
        } else {
            nextHour.hour++;
        }
        return nextHour;
    }

    public MyTime previousHour(){
        MyTime previousHour = new MyTime(this.hour, this.minute, this.second);
        if (this.hour == 0) {
            previousHour.hour = 23;
        } else {
            previousHour.hour--;
        }
        return previousHour;
    }

}
