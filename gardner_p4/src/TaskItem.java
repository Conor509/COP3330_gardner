public class TaskItem {

    public TaskItem(String i) {
    }

    public TaskItem() {

    }

    public static boolean checkDate(String date) {
        //[YYYY-MM-DD]
        boolean retVal = true;
        int currYear = 2020;
        int currMonth = 11;
        int currDay = 17;
        int yearInt = Integer.parseInt(date.substring(1, 5));
        int monthInt = Integer.parseInt(date.substring(6, 8));
        int dayInt = Integer.parseInt(date.substring(9, 11));
        if (yearInt > currYear)
            return true;
        else if (yearInt == currYear) {
            if (monthInt > currMonth)
                return true;
            else if (monthInt == currMonth) {
                if (dayInt > currDay)
                    return true;
                else if (dayInt == currDay)
                    return true;
            }
        }

        return false;
    }

    public static boolean checkTitle(String title) {
        return !(title.equals(""));
    }

}
