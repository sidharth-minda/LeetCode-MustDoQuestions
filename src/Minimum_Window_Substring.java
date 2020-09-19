import java.util.*;
public class Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> original = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                original.put(c, 1);
                map.put(c, 0);
            }
            else
                original.put(c, original.get(c) + 1);
        }
        int l=0,r=0;
        int min=Integer.MAX_VALUE, start=0, end=-1;
        int orig=original.size(), uniq=0;
        while(r<s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c).intValue() == original.get(c).intValue())
                    ++uniq;
            }
            while (l<=r && uniq == orig) {
                if(r-l+1 < min) {
                    min = r-l+1;
                    start = l;
                    end = r;
                }
                c = s.charAt(l);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c).intValue() < original.get(c).intValue())
                        --uniq;
                }
                ++l;
            }
            ++r;
        }
        return min==Integer.MAX_VALUE?"":s.substring(start, end+1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        Minimum_Window_Substring ob = new Minimum_Window_Substring();
        System.out.println(ob.minWindow(s, t));
    }
}
