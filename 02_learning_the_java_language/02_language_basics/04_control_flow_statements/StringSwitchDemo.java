public class StringSwitchDemo {

    public static int getMonthNumber(String month) {
        int monthNumber = 0;

        if (month == null) {
            return monthNumber;
        }

        switch (month.toLowerCase()) {
            case "jan":
                monthNumber = 1;
                break;
            case "feb":
                monthNumber = 2;
                break;
            case "mar":
                monthNumber = 3;
                break;
            case "apr":
                monthNumber = 4;
                break;
            default:
                monthNumber = 0;
                break;
        }

        return monthNumber;
    }

    public static void main(String[] args) {
        String month = "feb";

        int returnedMonthNumber = StringSwitchDemo.getMonthNumber(month);

        if (returnedMonthNumber == 0) {
            System.out.println("Invalid month");
        } else {
            System.out.println(returnedMonthNumber);
        }
    }
}