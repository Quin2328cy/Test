package amazon.two_sum;

import java.util.Arrays;

public class Car {
    public double[] twosum(double[] numbers, double target) {
        Arrays.sort(numbers);
        int l = 0, r = numbers.length - 1;
        double current_max = Integer.MIN_VALUE;
        double[] res = new double[2];
        while(l < r) {
            double cur = numbers[l] + numbers[r];

            if(cur <= target && cur > current_max) {
                current_max = cur;
                res[0] = numbers[l];
                res[1] = numbers[r];
            }
            if(cur < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        double[] containersWt = {7.33, 8.13, 103.7313, 11.24, 23.79, 18.350};
        double max = 43.3;
        Car car = new Car();
        double[] res = car.twosum(containersWt, max);
        System.out.print(res[0] + ", " + res[1]);
    }
}


/**
 *
 * package amazon.two_sum;
 *
 * import java.util.Arrays;
 *
 * public class Car {
 *     public double[] twosum(double[] numbers, double target) {
 *         Arrays.sort(numbers);
 *         int l = 0, r = numbers.length - 1;
 *         double d = Integer.MAX_VALUE;
 *         double[] res = new double[2];
 *         while(l < r) {
 *             double cur = numbers[l] + numbers[r];
 *             double diff = target - cur;
 *             // 因为是排好序的,所以只要符合这个条件
 *             if(diff < d && diff >= 0) {
 *                 d = diff;
 *                 res[0] = numbers[l];
 *                 res[1] = numbers[r];
 *             }
 *             if(cur < target) {
 *                 l++;
 *             } else {
 *                 r--;
 *             }
 *         }
 *         return res;
 *     }
 *
 *     public static void main(String[] args) {
 *         double[] containersWt = {7.33, 8.13, 103.7313, 11.24, 23.79, 18.350};
 *         double max = 43.3;
 *         Car car = new Car();
 *         double[] res = car.twosum(containersWt, max);
 *         System.out.print(res[0] + ", " + res[1]);
 *     }
 * }
 *
 *
 */
