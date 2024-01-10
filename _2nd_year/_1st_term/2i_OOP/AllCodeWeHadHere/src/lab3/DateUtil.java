package lab3;

public class DateUtil {
    //Month's name - for printing
    public static String[] strMonths
            = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    //Number of days in each month (for non-leap years)
    public static int[] daysInMonths
            = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    //Name day of week
    public static String[] dayOfWeek
            = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};

    //Return true if the given year is a leap year
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0)
                || year % 400 == 0;
    }

    //Return true if the given year, month, day, is a valid date
    //year: 1 - 9999
    //month: 1 (Jan) - 12 (Dec)
    //day: 1 - 28|29|30|31 (the last day depends on month & year)
    public static boolean isValidDate(int year, int month, int day){
        //check month && year
        if ( (month < 1 || month > 12) &&
                (year < 1 || year > 9999) ){
            return false;
        }
        //identify the last day in that month
        int lastDayThatMonth;
        if (isLeapYear(year) && month == 2){
            lastDayThatMonth = 29;
        } else {
            lastDayThatMonth = DateUtil.daysInMonths[month - 1];
        }
        //check day
        return day >= 1 && day <= lastDayThatMonth;
    }

    //Return the day of the week vs 0: Sun, 1: Mon, ..., 6: Sat
    public static int getDayOfWeek(int year, int month, int day){
        if (!isValidDate(year, month, day)){
            return -1;
        }

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
        if (isLeapYear(year)){
            f2 = f2LeapYear[month - 1];
        } else {
            f2 = f2NonLeapYear[month - 1];
        }

        //so now we have known f1, cd, f2 and g2
        //remember use:
        //(f1[ab] + cd + cd/4 + f2[abcd, ef] + gh) % 7 = result
        int result = f1 + lastTwoDigitOfYear +
                lastTwoDigitOfYear/4 + f2 + day;
        return result % 7;
    }

    //Return String "xxxday dd mmm yyyy" (eg: Wednesday 09 Jul 2003)
    public static String printDate(int year, int month, int day){
        if (!isValidDate(year, month, day)){
            return "That's day can't be exist";
        }
        String xxxday = DateUtil.dayOfWeek[getDayOfWeek(year, month, day)];
        String mmm = DateUtil.strMonths[month - 1];
        return xxxday + " " + day + " " + mmm + " " + year;
    }

    //Test Driver
    public static void main(String[] args) {
        System.out.println(isLeapYear(1990));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2011));
        System.out.println(isLeapYear(2012));
        System.out.println();
        System.out.println(isValidDate(2012, 2, 29));
        System.out.println(isValidDate(2011, 2, 29));
        System.out.println(isValidDate(2099, 12, 31));
        System.out.println(isValidDate(2099, 12, 32));
        System.out.println();
        System.out.println(getDayOfWeek(1982, 4, 24));
        System.out.println(getDayOfWeek(2000, 1, 1));
        System.out.println(getDayOfWeek(2054, 6, 19));
        System.out.println(getDayOfWeek(2012, 2, 17));
        System.out.println();
        System.out.println(printDate(2012, 8, 25));
        System.out.println(printDate(79, 8, 25));
    }
}