public class TaskItem {

    public TaskItem(String i) {
    }

    public TaskItem() {

    }

    public static boolean checkDate(String date) {
        //[YYYY-MM-DD]
        boolean retVal = true;
        int currYear = 2020;
        int currMonth = 12;
        int currDay = 1;
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


    public static boolean checkTaskNum(String FirstName) {
        if(FirstName.equals("")) {
            System.out.println("Error: This First Name is invalid please enter like this -> Ex. 2");
            return false;
        }
        return true;
    }

    public static boolean validNoteLength(String TaskNote) {
        if(TaskNote.equals("")) {
            System.out.println("Error: This Note is invalid please enter like this -> Ex. Do Dishes");
            return false;
        }
        return true;
    }

    public static boolean checkDateLength(String date) {
        if (date.length() != 10) {
            System.out.println("Error: This Date is invalid please enter like this -> Ex. YYYY-MM-DD");
            return false;
        }
        return true;

    }
}
