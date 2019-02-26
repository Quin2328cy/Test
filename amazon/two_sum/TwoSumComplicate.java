package amazon.two_sum;

import java.util.*;

public class TwoSumComplicate {
    // 复杂版
    public List<List<Integer>> TwoSum(List<List<Integer>> list1, List<List<Integer>> list2, int max_load) {

        int max_value = 0;
        List<List<Integer>> res = new ArrayList<>();
        // ascending
        Collections.sort(list1, new Comparator<List<Integer>>() {
            public int compare(List<Integer> p1, List<Integer> p2) {
                return p1.get(1).compareTo(p2.get(1));
            }
        });

        // descending
        Collections.sort(list2, new Comparator<List<Integer>>() {
            public int compare(List<Integer> p1, List<Integer> p2) {
                return p2.get(1).compareTo(p1.get(1));
            }
        });
        System.out.println("L2");
        for (List<Integer> l : list2) {
            System.out.println(l.get(0) + ", " + l.get(1));
        }

        Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();

        List<Integer> l1_temp = (List<Integer>) it1.next();
        int left_value = 0;
        System.out.println("left = " + left_value);

        List<Integer> l2_temp = (List<Integer>) it2.next();
        int right_value = 0;
        System.out.println("right = " + right_value);

        while (it1.hasNext() && it2.hasNext()) {
            left_value = l1_temp.get(1);
            right_value = l2_temp.get(1);
            int cur = left_value + right_value;
            System.out.println("cur = " + cur);
            if (cur <= max_load) {
                if (cur > max_value) {
                    res.clear();
                    max_value = cur;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(l1_temp.get(0));
                    temp.add(l2_temp.get(0));
                    res.add(temp);
                } else if (cur == max_value) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(l1_temp.get(0));
                    temp.add(l2_temp.get(0));
                    res.add(temp);
                }
                l1_temp = (List<Integer>) it1.next();

            } else {
                l2_temp = (List<Integer>) it2.next();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumComplicate twoSumComplicate = new TwoSumComplicate();
        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> l1_temp = new ArrayList<>();
        l1_temp.add(1);
        l1_temp.add(3000);
        l1.add(new ArrayList<>(l1_temp));

        l1_temp.clear();
        l1_temp.add(2);
        l1_temp.add(5000);
        l1.add(new ArrayList<>(l1_temp));

        l1_temp.clear();
        l1_temp.add(3);
        l1_temp.add(7000);
        l1.add(new ArrayList<>(l1_temp));

        l1_temp.clear();
        l1_temp.add(4);
        l1_temp.add(10000);
        l1.add(new ArrayList<>(l1_temp));

        List<List<Integer>> l2 = new ArrayList<>();
        List<Integer> l2_temp = new ArrayList<>();
        l2_temp.add(1);
        l2_temp.add(2000);
        l2.add(new ArrayList<>(l2_temp));

        l2_temp.clear();
        l2_temp.add(2);
        l2_temp.add(3000);
        l2.add(new ArrayList<>(l2_temp));

        l2_temp.clear();
        l2_temp.add(3);
        l2_temp.add(4000);
        l2.add(new ArrayList<>(l2_temp));

        l2_temp.clear();
        l2_temp.add(4);
        l2_temp.add(5000);
        l2.add(new ArrayList<>(l2_temp));


        List<List<Integer>> res = twoSumComplicate.TwoSum(l1, l2, 10000);
        System.out.println("================res============");
        for (List<Integer> l : res) {
            System.out.println(l.get(0) + ", " + l.get(1));
        }

    }
}
