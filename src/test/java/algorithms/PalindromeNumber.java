package algorithms;

import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String args[]) {
        final boolean palindrome = isPalindrome(new Scanner(System.in).nextLine());
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(String original) {
        String reverse = "";
        int length = original.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            return true;
        else
            return false;

    }
}
