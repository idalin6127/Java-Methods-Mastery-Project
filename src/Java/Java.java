package exercise3;

public class Java {
    public static void main(String[] args) {
        // three overloaded results
        System.out.println("First: " + overloadedMethod(3));
        System.out.println("Second: " + overloadedMethod(8, 2));
        System.out.println("Third: " + overloadedMethod("Ling", 20));
    }

    // first overloaded method, receive an integer parameter and return square of parameter.
    public static int overloadedMethod(int number) {
        return number * number;
    }

    //second overloaded method, receive two integer parameter and return minutes of parameter.
    public static int overloadedMethod(int number1, int number2) {
        return number1 - number2;
    }

    // third overloaded method, receive one string and one integer parameter, and return result of their combination.
    public static String overloadedMethod(String str1, int number1) {
        return str1 + " " + number1;
    }
}
