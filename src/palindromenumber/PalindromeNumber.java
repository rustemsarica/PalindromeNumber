/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindromenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Rustem
 */
public class PalindromeNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String S = "8199";
        String[] digits = S.split("");        
        Arrays.sort(digits, Collections.reverseOrder());
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < ( 1 << S.length() );  i++){
            String numberStr = "";
            for(int j = 0; j < S.length(); j++){
                if( (i & (1 << j) ) > 0 ){
                    numberStr += digits[j];
                }
            }
            generatePermutations("", numberStr, numbers);
        }
        HashSet<Integer> uniqueSet = new HashSet<>(numbers);
        numbers.clear();
        numbers.addAll(uniqueSet);
        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers);
    }
    
    public static boolean isPolindrome(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void generatePermutations(String prefix, String remaining, List<Integer> numbers) {
        int n = remaining.length();
        if (n == 0) {
            if(isPolindrome(prefix)){
                numbers.add(Integer.valueOf(prefix));
            }
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n), numbers);
            }
        }
    }
}
