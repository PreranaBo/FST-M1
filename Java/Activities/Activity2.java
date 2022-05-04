package activities;
import java.util.*;
public class Activity2 {

        public static void main(String[] args) {
            int[] Arr = {10, 77, 10, 54, -11, 10};
            System.out.println("Original Array: " + Arrays.toString(Arr));

            int num = 10;
            int sum = 30;

            System.out.println("Result: " + result(Arr, num, sum));
        }

        public static boolean result(int[] numbers, int num, int sum) {
            int temp_sum = 0;

            for (int number : numbers) {

                if (number == num) {
                    temp_sum += num;
                }

                if (temp_sum > sum) {
                    break;
                }
            }

            return temp_sum == sum;
        }
    }

