package formatting_information;

import java.util.Date;

public class PracticeThree {
    public static void main(String[] args) {
        Date now = new Date();

        // 1. %tY - год в четырехзначном формате
        System.out.printf("1. Year: %tY%n", now);

        // 2. %tB - полное название месяца
        System.out.printf("2. Month: %tB%n", now);

        // 3. %tH:%tM - часы и минуты
        System.out.printf("3. Time: %tH:%tM%n", now, now);

        // 4. %tA - полное название дня недели
        System.out.printf("4. Day: %tA%n", now);

        // 5. %td.%tm.%tY - полная дата
        System.out.printf("5. Date: %td.%tm.%tY%n", now, now, now);

    }
}