package Week1;

public class Eratosthenes {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[101];
        for (int i = 0; i < 101; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        sangSoNT(isPrime);

        for (int i = 0; i < 101; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void sangSoNT(boolean[] isPrime) {
        // Xet tu 2
        for (int i = 2; i < 101; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 101; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
