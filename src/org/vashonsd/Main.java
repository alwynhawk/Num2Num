package org.vashonsd;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

    System.out.println("Enter a Roman Numeral (All Caps)");
    String numeral = scan.nextLine();
    System.out.println(romToNum(numeral));

    }

    public static int romToNum(String str){
        int number = 0;
        Map<String, Integer> oddballs = new HashMap<>();
        oddballs.put("IX", 9);
        oddballs.put("IV", 4);
        oddballs.put("XC", 90);
        oddballs.put("XL", 40);
        oddballs.put("CM", 900);
        oddballs.put("CD", 400);
        int oddballnumber = 0;

        Map<String, Integer> commons = new HashMap<>();
        int commonNumber = 0;
        commons.put("I", 1);
        commons.put("V", 5);
        commons.put("X", 10);
        commons.put("C", 100);
        commons.put("L", 50);
        commons.put("M", 1000);
        commons.put("D", 500);

        for(String s : oddballs.keySet()) {
            if(str.contains(s)) {
                oddballnumber = oddballs.get(s);
                str = str.replace(s, "");
            }
        }

        for (int i = 0; i < str.length(); i++) {
            for(String s: commons.keySet()) {
                while(str.contains(s)) {
                    commonNumber = commons.get(s);
                    str = str.replaceFirst(s, "");
                }
            }
        }
        return number + oddballnumber + commonNumber;
    }

}
