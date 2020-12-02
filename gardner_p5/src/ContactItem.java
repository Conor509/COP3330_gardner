public class ContactItem {

    public ContactItem(String i) {
    }

    public ContactItem() {

    }

    public static boolean checkFirstName(String FirstName) {
        if(FirstName.equals("")) {
            System.out.println("Error: This First Name is invalid please enter like this -> Ex. Conor");
            return false;
        }
        return true;
    }

    public static boolean checkLastName(String LastName) {
        if(LastName.equals("")) {
            System.out.println("Error: This Last Name is invalid please enter like this -> Ex. Gardner");
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String Email) {
        if(Email.equals("")) {
            System.out.println("Error: This Email is invalid please enter like this -> Ex. ConorG@gmail.com");
            return false;
        }
        return true;
    }

    public static boolean checkPhoneNum(String PhoneNum) {
        if(PhoneNum.length() != 12) {
            System.out.println("Error: This phone Number is invalid please enter like this -> Ex. 123-456-7890");
            return false;
        }
        return true;
    }
}

