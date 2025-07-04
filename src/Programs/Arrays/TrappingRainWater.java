package Programs.Arrays;

public class TrappingRainWater {

    public static int findWater(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        // Calculate the trapped water
        for (int i = 1; i < n - 1; i++) {
            int minHeight = Math.min(left[i - 1], right[i + 1]);
            if (minHeight > arr[i]) {
                water += minHeight - arr[i];
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        int n = arr.length;
        System.out.println("Trapped water: " + findWater(arr, n));
    }
}

