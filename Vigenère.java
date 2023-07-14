package testing;

import java.util.Random;
import java.util.Scanner;

public class Testing {

    public static void Encryption(int num, int key[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("please enter a plaintext: ");
        String text = in.nextLine();
        String result = "";
        System.out.println("\n The plaintext is: " + text);

        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                result += " ";
            } else if (Character.isUpperCase(text.charAt(i))) {
                result += (char) (((int) text.charAt(i) + key[i % num] - 65) % 26 + 65);
            } else {  //char isLowerCase
                result += (char) (((int) text.charAt(i) + key[i % num] - 97) % 26 + 97);
            }
        }
        System.out.println(" The ciphertext is: " + result);

    }

    public static void Decryption(int key[], int num) {
        Scanner in = new Scanner(System.in);
        String result = "";
        System.out.print("please enter a ciphertext: ");
        String text = in.nextLine();
        System.out.println("\n The ciphertext is: " + text);

        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                result += " ";
            } else if (Character.isUpperCase(text.charAt(i))) {
                result += (char) (((int) text.charAt(i) - key[i % num] + 26 - 65) % 26 + 65);
            } else {  //char isLowerCase
                result += (char) (((int) text.charAt(i) - key[i % num] + 26 - 97) % 26 + 97);
            }
        }
        System.out.println(" The plaintext is: " + result);
    }

    public static void main(String[] args) {

        int choice = 0;
        Scanner in = new Scanner(System.in);
        Random R = new Random();
        int answer = R.nextInt(25) + 1;
        System.out.print("Enter number of keys? ");
        int num = in.nextInt();
        int key[] = new int[num];
        System.out.print("keys ----> ");

        for (int i = 0; i < num; i++) {
            key[i] = R.nextInt(25) + 1;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(key[i] + "  ");
        }
        System.out.println("\n");

        while (true) {
            System.out.println(" 1- Encryption program");
            System.out.println(" 2- Dycreption program");
            System.out.println(" 3- Exit");
            System.out.println("*****************************");
            System.out.print("Please enter a choice that you want: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Encryption(num, key);
                    System.out.println("*****************************");
                    break;

                case 2:
                    Decryption(key, num);
                    System.out.println("*****************************");
                    break;
                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.print("Please renter number: ");
                    break;
            }
        }
    }
}
