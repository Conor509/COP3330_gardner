public class Decrypter {

    //Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10
    //Then swap the first digit with the third, and swap the second digit with the fourth
    Decrypter num = new Decrypter();

    public static void main(String[] args)
    {
        System.out.println("num = 6083");
        System.out.println(decrypt("6083"));

    }

    public static String decrypt(String number)
    {
        int numbers[] = new int[4];
        for (int i=0;i<4;i++)
        {
            char c = number.charAt(i);
            numbers[i] = Character.getNumericValue(c);
        }
        int temp = numbers[0];
        numbers[0] = numbers[2];
        numbers[2] = temp;
        temp = numbers[1];
        numbers[1] = numbers[3];
        numbers[3] = temp;
        for (int i=0;i<4;i++)
        {
            int index = numbers[i];
            if(index < 7)
                numbers[i] = index + 3;
            else numbers[i] = (index + 3) % 10;
        }
        int arg2 = 0;
        for (int i = 0; i < 4; i++)
        {
            arg2 = arg2 * 10 + numbers[i];
        }
        String Finished = Integer.toString(arg2);
        if (numbers[0] == 0)
            Finished = "0" + Finished;
        return Finished;
    }
}

