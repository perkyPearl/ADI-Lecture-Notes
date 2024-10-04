import java.util.*;

public class Question1 {
    static int Finder(String s){
        HashMap<Character,Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();

        for(Character ch:arr){
            if(map.containsKey(ch)){
                int val = map.get(ch);
                map.put(ch, val+1);
            }else{
                map.put(ch, 1);
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(Finder(s));
    }
}