public class PrimitiveOperations{
    public static void main(String[] args) {
        int var_one = 6;
        double var_two = 9.0;
        double multiply_answer = var_one * var_two;
        float myFlt_one = var_one;
        int myInt_two = (int) var_two;
        char myChar = 'A';
        int ascii = (int) myChar + 32;
        char myCharLower = (char) ascii;
        System.out.println(var_one);
        System.out.println(var_two);
        System.out.println(multiply_answer);
        System.out.println(myFlt_one);
        System.out.println(myInt_two);
        System.out.println(myChar);
        System.out.println(myCharLower);
    }

}
