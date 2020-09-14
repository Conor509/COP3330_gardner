public class Encrypter {

    //Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10
    //Then swap the first digit with the third, and swap the second digit with the fourth
    Encrypter num = new Encrypter();

    public static void main(String[] args)
    {
        System.out.println("num = 1693");
        System.out.println(encrypt("1693"));

    }

    public static String encrypt(String code)
    {
        int numbers[] = new int[4];

        for(int i=0;i<code.length();i++)
        {
            char c = code.charAt(i);
            numbers[i] = Character.getNumericValue(c);
        }

        for(int i=0;i<code.length();i++)
        {
            int arg1 = numbers[i] ;
            arg1 = arg1 + 7 ;
            arg1 = arg1 % 10 ;
            numbers[i] = arg1 ;

        }

        int arg1 = numbers[0];
        numbers[0] = numbers[2];
        numbers[2]= arg1 ;
        arg1 = numbers[1];
        numbers[1] = numbers[3];
        numbers[3] = arg1 ;
        int arg2 = 0 ;

        for(int i=0;i<4;i++)
            arg2 = arg2 * 10 + numbers[i];

        String Finished = Integer.toString(arg2);

        if(numbers[0]==0)
            Finished = "0"+ Finished;

        return Finished;
    }
}
