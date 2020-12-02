import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    void creationFailsWithBlankFirstName(){

        assertEquals(false, ContactItem.checkFirstName(""));

    }
    @Test
    void creationSucceedsWithNonBlankFirstName(){

        assertEquals(true, ContactItem.checkFirstName("Conor"));

    }
    @Test
    void creationFailsWithBlankLastName(){

        assertEquals(false, ContactItem.checkLastName(""));

    }
    @Test
    void creationSucceedsWithNonBlankLastName(){

        assertEquals(true, ContactItem.checkLastName("Gardner"));

    }
    @Test
    void creationFailsWithBlankPhoneNum(){

        assertEquals(false, ContactItem.checkPhoneNum(""));

    }
    @Test
    void creationSucceedsWithNonBlankPhoneNum(){

        assertEquals(true, ContactItem.checkPhoneNum("123-456-7891"));

    }
    @Test
    void creationFailsWithBlankEmail(){

        assertEquals(false, ContactItem.checkPhoneNum(""));

    }
    @Test
    void creationSucceedsWithNonBlankEmail(){

        assertEquals(true, ContactItem.checkEmail("ConorG@live.com"));

    }

    @Test
    void creationSucceedsWithNonBlankValues(){

        assertEquals(true, ContactItem.checkPhoneNum("123-456-7891"));
        assertEquals(true, ContactItem.checkEmail("ConorG@live.com"));
        assertEquals(true, ContactItem.checkLastName("Gardner"));
        assertEquals(true, ContactItem.checkFirstName("Conor"));

    }
    @Test
    void editingFailsWithAllBlankValues(){
        assertEquals(false, ContactItem.checkPhoneNum(""));
        assertEquals(false, ContactItem.checkEmail(""));
        assertEquals(false, ContactItem.checkFirstName(""));
        assertEquals(false, ContactItem.checkLastName(""));
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        assertEquals(true, ContactItem.checkPhoneNum("123-456-7891"));
        assertEquals(true, ContactItem.checkEmail("ConorG@live.com"));
        assertEquals(true, ContactItem.checkLastName("Gardner"));
        assertEquals(true, ContactItem.checkFirstName("Conor"));
    }
    @Test
    void testingIfListIncreaseAfterAddingContact(){


    }

    @Test
    void testEmptyList(){
        try {
            assertEquals(true, TaskList.checkEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}