package Calclator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input numbers and operator");
        System.out.println("operator: +, -, x, ÷,%,^,r(square root)");
        System.out.println("symbol: =");

        while (true) {
            String[] user_input = new String[4];
            for (int i = 0; i < user_input.length; i++) {
                user_input[i] = new java.util.Scanner(System.in).nextLine();
            }
            if (user_input[0].equals("")) {
                System.out.println("Over");
                break;
            } else if (user_input[1].equals("")) {
                System.err.println("Error");
                continue;
            }

            String[] ops = { "+", "-", "×", "÷", "%", "^", "r" };

            if (!(user_input[1].equals(ops[6])) && user_input[3].equals("")) {
                int calc;
                int digit1 = Integer.parseInt(user_input[0]);
                int digit2 = Integer.parseInt(user_input[2]);
                int ans = calc(digit1, digit2, user_input);
                System.out.println(ans);
            } else if (user_input[1].equals(ops[6]) && user_input[3].equals("")) {
                double calc2;
                double digit3 = Double.parseDouble(user_input[0]);
                double result = calc2(digit3, user_input);
                System.out.println(result);
            }

            else if (!(user_input[3].equals(""))) {
                user_input = tempArray(user_input);
            }

            for (int i = 0; i < user_input.length; i++) {
                user_input[i] = new java.util.Scanner(System.in).nextLine();
            }
            int calc;
            int digit1 = Integer.parseInt(user_input[0]);
            int digit2 = Integer.parseInt(user_input[2]);
            int digit4 = Integer.parseInt(user_input[4]);

            int interAns = calc(digit1, digit2, user_input);
            int newAns = calc4(digit4, interAns, user_input);
            System.out.println(newAns);
        }
    }

    public static int calc(int digit1, int digit2, String[] user_input) {
        if (user_input[1].equals("+")) {
            return digit1 + digit2;
        }
        if (user_input[1].equals("-")) {
            return digit1 - digit2;
        }
        if (user_input[1].equals("×")) {
            return digit1 * digit2;
        }
        if (user_input[1].equals("÷")) {
            return digit1 / digit2;
        }

        if (user_input[1].equals("%")) {
            return digit1 % digit2;
        }
        if (user_input[1].equals("^")) {
            return digit1 ^ digit2;
        }
        return 0;
    }

    public static double calc2(double digit3, String[] user_input) {
        if (user_input[1].equals("r")) {
            double A = Math.sqrt(digit3);
            return A;
        }
        return 0.0;
    }

    public static String[] tempArray(String[] user_input) {
        String[] temp_input = new String[user_input.length + 3];
        for (int i = 0; i < user_input.length; i++) {
            temp_input[i] = user_input[i];
        }
        user_input = temp_input;
        return user_input;
    }

    public static int calc4(int digit4, int interAns, String[] user_input) {
        if (user_input[3].equals("+")) {
            return interAns + digit4;
        }
        if (user_input[3].equals("-")) {
            return interAns - digit4;
        }
        if (user_input[3].equals("×")) {
            return interAns * digit4;
        }
        if (user_input[1].equals("÷")) {
            return interAns / digit4;
        }
        if (user_input[3].equals("%")) {
            return interAns % digit4;
        }
        if (user_input[3].equals("^")) {
            return interAns ^ digit4;
        }
        return 0;
    }
}
