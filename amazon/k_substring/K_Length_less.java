package amazon.k_substring;

import java.util.*;

public class K_Length_less {
    // length = k with k - 1 distinct character -- 去重 - 这个不是很好搞,
    public List<String> KSubstring(String input, int k) {

        Map<Character, Integer> occurrenceMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i + k <= input.length(); i++) {
            String str = input.substring(i, i + k);
            boolean isRepeat = false;
            for (char c : str.toCharArray()) {
                if (occurrenceMap.containsKey(c)) {
                    if (!isRepeat)
                        occurrenceMap.put(c, occurrenceMap.get(c) + 1);
                    else
                        break;
                    isRepeat = true;
                } else
                    occurrenceMap.put(c, 1);
            }
            //if it makes it through and has precisely 1 repeat character
            if (isRepeat)
                resultList.add(str);
            //empty the map
            occurrenceMap.clear();
        }
        return resultList;
    }

    public static void main(String[] args) {
        K_Length_less k_length = new K_Length_less();
        String s = "aabbcddefgghikjklmnopqrstuvwxyyz";
        List<String> res = k_length.KSubstring(s, 3);
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("\n\nres=");
        for (String l : res) {
            System.out.println(l);
        }
    }
}
