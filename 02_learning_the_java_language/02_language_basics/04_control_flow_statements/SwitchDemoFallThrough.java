public class SwitchDemoFallThrough {
    public static void main(String[] args) {
        java.util.ArrayList<String> futureMonths =
            new java.util.ArrayList<String>();

        int month = 8;

        switch (month) {
            case 1:  futureMonths.add("Jan");
            case 2:  futureMonths.add("Feb");
            case 3:  futureMonths.add("Mar");
            case 4:  futureMonths.add("Apr");
            case 5:  futureMonths.add("May");
            case 6:  futureMonths.add("Jun");
            case 7:  futureMonths.add("Jul");
            case 8:  futureMonths.add("Aug");
            case 9:  futureMonths.add("Sep");
            case 10: futureMonths.add("Oct");
            case 11: futureMonths.add("Nov");
            case 12: futureMonths.add("Dec");
                     break;
            default: break;
        }

        if (futureMonths.isEmpty()) {
            System.out.println("Invalid Month Number");
        } else {
            for (String monthName : futureMonths) {
                System.out.println(monthName);

            }
        }
    }
}