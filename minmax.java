public class minmax{
    static void minMax(int[] arr, int low, int high, int[] result) {
        if (low == high) {
            result[0] = arr[low];
            result[1] = arr[low]; 
            return;
        }

        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result[0] = arr[low];
                result[1] = arr[high];
            } else {
                result[0] = arr[high];
                result[1] = arr[low];
            }
            return;
        }

        
        int mid = (low + high) / 2;

        int[] left = new int[2];
        int[] right = new int[2];

        minMax(arr, low, mid, left);
        minMax(arr, mid + 1, high, right);

        
        if (left[0] < right[0])
            result[0] = left[0];
        else
            result[0] = right[0];

        if (left[1] > right[1])
            result[1] = left[1];
        else
            result[1] = right[1];
    }
        public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 1, 6};

        int[] result = new int[2]; 

        minMax(arr, 0, arr.length - 1, result);

        System.out.println("Minimum element: " + result[0]);
        System.out.println("Maximum element: " + result[1]);
    }
}