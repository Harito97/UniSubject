package hw6.c2;

public class TestMyTime {
    public static void main(String[] args) {
        System.out.println("Time a: ");
        MyTime a = new MyTime(24, 35, 6);
        MyTime b = new MyTime(23, 59, 59);
        System.out.println("Time b: \n" + b.toString());
        System.out.println("Time b next second: \n" + b.nextSecond());
        System.out.println("Time b next minute: \n" + b.nextMinute());
        System.out.println("Time b next hour: \n" + b.nextHour());
        MyTime c = new MyTime();
        System.out.println("Time c: \n" + c.toString());
        System.out.println("Time c previous second: \n" + c.previousSecond());
        System.out.println("Time c next minute: \n" + c.nextMinute());
        System.out.println("Time c next hour: \n" + c.nextHour());
        System.out.println();
        System.out.println("Set time a = 15h16m17s");
        a.setTime(15,16,17);
        System.out.println(a.getHour() + " " + a.getMinute()
                            + " " + a.getSecond());
        //=>Mac du doi tuong a duoc khoi tao voi gia tri khong thoa man
        //Vay nen doi tuong a hien giong nhu null va bien a o vung Stack
        //se tro den 1 doi tuong khi no co gia tri nap vao thoa man
    }
}
