public class SwitchDemo {
    public static void main(String[] args) {
        int month = 4;
        String monthString;

        switch (month) {
            case 1: case 2: case 3:
            case 4: case 5: case 6:
                monthString = "before July";
                break;
            case 7:  monthString = "Jul";
                     break;
            case 8:  monthString = "Aug";
                     break;
            case 9:  monthString = "Sep";
                     break;
            case 10: monthString = "Oct";
                     break;
            case 11: monthString = "Nov";
                     break;
            case 12: monthString = "Dec";
                     break;
            default: monthString = "Invalid Month";
                     break;
        }

        System.out.println(monthString);
    }
}