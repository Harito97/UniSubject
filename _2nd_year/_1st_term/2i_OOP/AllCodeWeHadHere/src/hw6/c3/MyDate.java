package hw6.c3;

public class MyDate {
    //Attributes
    private int day;
    private int month;
    private int year;
    public static final String[] MONTHS = {"Jan","Feb","Mar","Apr","May",
                        "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public static final String[] DAYS = {"Sunday","Monday","Tuesday","Wednesday",
                        "Thursday","Friday","Saturday"};
    public static final int[] DAYS_IN_MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};

    //Constructors
    public MyDate(int year, int month, int day){
        if(isValidDate(year,month,day)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    //Getters and Setters
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if (day >= 1 && day <= DAYS_IN_MONTHS[this.month - 1]){
            this.day = day;
        } else if (isLeapYear(year) && day == 29) {
            this.day = 29;
        } else {
                System.out.println("Invalid day!");
        }
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12){
            this.month = month;
        } else {
            System.out.println("Invalid month!");
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if (year >= 1 && year <= 9999){
            this.year = year;
        } else {
            System.out.println("Invalid year!");
        }
    }
    public void setDate(int year, int month, int day){
        if(isValidDate(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid year, month or day!");
        }
    }

    //API
    public boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public boolean isValidDate(int year, int month, int day){
        if (day >= 1 && day <= 31 &&
                month >= 1 && month <= 12 &&
                year >= 1900 && year <= 9999){
            if (isLeapYear(year)//is a leap year
                    && month == 2
                    && day <= DAYS_IN_MONTHS[1] + 1){
                return true;
            } else return day <= DAYS_IN_MONTHS[month - 1];
        }
        return false;
    }

    public int getDayOfWeek(int year, int month, int day){

        //we have the input like abcd (year), ef (month), gh (day)
        //use (f1[ab] + cd + cd/4 + f2[abcd, ef] + gh) % 7 = result

        //identify f1
        int f1 = 0;
        int firstTwoDigitOfYear = year / 100;   //identify ab
        switch (firstTwoDigitOfYear % 4) {
            case 1 -> f1 = 4;
            case 2 -> f1 = 2;
            case 3 -> f1 = 0;
            case 0 -> f1 = 6;
        }

        //identify cd - last 2 digit of year
        int lastTwoDigitOfYear = year % 100;

        //identify f2
        int[] f2NonLeapYear = {0, 3, 3, 6, 1, 4,
                6, 2, 5, 0, 3, 5};
        int[] f2LeapYear = {6, 2, 3, 6, 1, 4,
                6, 2, 5, 0, 3, 5};
        int f2 = 0;
        //Phai de cai dieu kien thang ngo ngan nay
        //vi trinh bien dich khong phan biet duoc dieu mk gia su ngay thang nam nhap vao la dung
        //nen no luon tinh truong hop month = 0 va bao loi -1 out of index
        if (isLeapYear(year) && month >= 1){
            f2 = f2LeapYear[month - 1];
        } else if(month >= 1) {
            f2 = f2NonLeapYear[month - 1];
        }

        //so now we have known f1, cd, f2 and gh
        //remember use:
        //(f1[ab] + cd + cd/4 + f2[abcd, ef] + gh) % 7 = result
        int result = f1 + lastTwoDigitOfYear +
                lastTwoDigitOfYear/4 + f2 + day;
        return result % 7;
    }

    @Override
    public String toString() {
        String xxxday = "", mmm = "";
        if (isValidDate(this.year,this.month,this.day)){
            xxxday = MyDate.DAYS[getDayOfWeek(year, month, day)];
            mmm = MyDate.MONTHS[month - 1];
        }
        return xxxday + " " + this.day + " " + mmm + " " + this.year;
    }

    public MyDate nextYear(){
        this.setYear(year + 1);
        return this;
    }

    public MyDate nextMonth(){
        if (this.month == 12){
            this.setMonth(1);
            this.nextYear();
        } else {
            this.setMonth(month + 1);
        }
        return this;
    }

    public MyDate nextDay(){
        if (isValidDate(year,month,day)){
            if ( (isLeapYear(year) && month == 2 && day == 29)
                    || (!isLeapYear(year) && month != 2 && day != 29 && this.day == DAYS_IN_MONTHS[this.month - 1]) ){
                this.setDay(1);
                this.nextMonth();
            } else {
                this.setDay(day + 1);
            }
        }
        return this;
    }

    public MyDate previousYear(){
        if (isLeapYear(year) && month == 2 && day == 29){
            this.setDay(28);
        }
        this.setYear(year - 1);
        return this;
    }

    public MyDate previousMonth(){
        if (this.month == 1){
            this.setMonth(12);
            this.previousYear();
        } else {
            this.setMonth(month - 1);
        }
        if (this.day > DAYS_IN_MONTHS[month - 1]){
            this.day = DAYS_IN_MONTHS[month - 1];
        }
        if (month == 2 && isLeapYear(year) && day > 29){
            day = 29;
        }
        return this;
    }

    public MyDate previousDay(){
        if (isValidDate(year, month, day)){
            if (this.day == 1){
                if (isLeapYear(year) && month == 3){
                    this.setDay(29);
                    this.previousMonth();
                } else if (month == 1){
                    this.setDay(DAYS_IN_MONTHS[month - 1]);
                    this.month = 12;
                    this.previousYear();
                }
                else {
                    this.setDay(DAYS_IN_MONTHS[month - 1]);
                    this.previousMonth();
                }
            } else {
                this.setDay(day - 1);
            }
        }
        return this;
    }
}
