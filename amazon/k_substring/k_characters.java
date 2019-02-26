package amazon.k_substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class k_characters {
    // K distinct character without length limit
    List<String> findSubstring(String inputString, int num) {
        List<String> res = new ArrayList<>();
        if (inputString == null || inputString.length() == 0 || num == 0 || num > inputString.length()) {
            return res;
        }
        int res_count = 0;
        int n = inputString.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int distinctNum = 0;
            Arrays.fill(count, 0);
            int j = i;
            for (; j < n; j++) {
                char c = inputString.charAt(j);
                if (count[c - 'a'] == 0) {
                    distinctNum++;
                }
                count[c - 'a']++;
                if (distinctNum == num) {
                    String temp_res = inputString.substring(i, j + 1);
                    res.add(temp_res);
                    res_count++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        k_characters k_characters = new k_characters();
        String s = "abcdefghijklmnopqrstuvwxyzzzzzzzz";
        List<String> res = k_characters.findSubstring(s, 26);
        for(String l : res) {
            System.out.println(l);
        }
    }


//    /**
//     * @param str: The string
//     * @param k: The length of the substring
//     * @return: The answer
//     */
//    public List<String> findSubstring(String str, int k) {
//        // Write your code here
//        if (k > 26 || k <= 0) {
//            return null;
//        }
//        HashSet<String> stringSet = new HashSet<String>();
//        int ans = 0;
//        for (int i = 0; i + k - 1 < str.length(); i++) {
//            HashSet<Character> hashSet = new HashSet<Character>();
//            int count = 0;
//            int endIndex = i;
//            for (; count <= k && endIndex < str.length(); endIndex++) {
//                if (!hashSet.contains(str.charAt(endIndex))) {
//                    count++;
//                    continue;
//                }
//                hashSet.add(str.charAt(endIndex));
//            }
//            if (count == k) {
//                String s = str.substring(i, endIndex);
//                if (stringSet.contains(s)) {
//                    continue;
//                } else {
//                    stringSet.add(s);
//                    ans++;
//                }
//            }
//        }
////        return ans;
//        List<String> list = new ArrayList<>(stringSet);
//        return list;
//    }
//

}
