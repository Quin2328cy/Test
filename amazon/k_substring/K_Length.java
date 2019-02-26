package amazon.k_substring;

import java.util.*;

public class K_Length {
    // Length = K with K character -- 去重了
    public List<String> KSubstring(String stringIn, int K) {

        if (stringIn == null || stringIn.length() == 0 || K <= 0 || K > 26) {
            return new ArrayList<>();
        }
        int count = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashSet<String> resultSet = new HashSet<String>();
        int len = stringIn.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < Math.min(i + K, len) && charMap.size() < K) {
                char c = stringIn.charAt(j);
                if (charMap.containsKey(c)) {
                    break;
                }
                charMap.put(c, 1);
                j++;
                if (charMap.size() == K) {
                    resultSet.add(stringIn.substring(i, j));
                }
            }
            charMap.remove(stringIn.charAt(i));
        }
        List<String> res = new ArrayList<>(resultSet);
        return res;
    }

    public static void main(String[] args) {
        K_Length k_length = new K_Length();
        String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        List<String> res = k_length.KSubstring(s, 25);
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String l : res) {
            System.out.println(l);
        }
    }
}
