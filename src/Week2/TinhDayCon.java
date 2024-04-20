package Week2;

public class TinhDayCon {

    public static int countSubArray(int[] arr, int k){
        int left = 0;
        int count = 0;
        int currS = 0;
        int n = arr.length;

        for (int right =0; right< n; right++){
            currS += arr[right];

            while (currS >= k) {
                count += n - right;

                currS -= arr[left++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0 ,2};
        int k = 3;

        System.out.println(countSubArray(arr, k));
    }
}
