// Given a String find the length of longest substring with non-repeating characher
import java.util.*;

public class Question2 {
    static int substringFinder(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        char[] sa = s.toCharArray();

        for (int end = 0; end < sa.length; end++) {
            char currentChar = sa[end];

            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }

            map.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(substringFinder(s));
    }
}
