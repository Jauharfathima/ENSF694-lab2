import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public static int linearSearch(int[] arr, int target) {
        // Linear search algorithm
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if element is found
            }
        }
        return -1; // Number not found
    }

    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) {
                    return low; // Return the index if element is found
                }
                return -1; // Number not found
            }

            // Interpolation formula to calculate the mid index
            int mid = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[mid] == target) {
                return mid; // Return the index if element is found
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Number not found
    }
    
    public static int improvedlinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (i > 0) {
                    // Swap the found element with its immediate predecessor
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
                return i; // Return the index if element is found
            }
        }
        return -1; // Number not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the search key: ");
        int target = scanner.nextInt();

        // Linear Search
        long startTime = System.nanoTime();
        int linearSearchIndex = linearSearch(arr, target);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;

        if (linearSearchIndex != -1) {
            System.out.println("Linear Search:");
            System.out.println("Search key FOUND at index " + linearSearchIndex);
        } else {
            System.out.println("Linear Search:");
            System.out.println("Search key NOT FOUND ");
        }
        
        // Sort the array
        Arrays.sort(arr);

        // Interpolation Search
        startTime = System.nanoTime();
        int interpolationSearchIndex = interpolationSearch(arr, target);
        endTime = System.nanoTime();
        long interpolationSearchTime = endTime - startTime;
             

        if (interpolationSearchIndex != -1) {
            System.out.println("Interpolation Search:");
            System.out.println("Search key FOUND at index " + interpolationSearchIndex);
        } else {
            System.out.println("Interpolation Search:");
            System.out.println("Search key NOT FOUND ");
        }
        
        // Improved Linear Search
        startTime = System.nanoTime();
        int improvedlinearSearchIndex = improvedlinearSearch(arr, target);
        endTime = System.nanoTime();
        long improvedlinearSearch = endTime - startTime;

        if (improvedlinearSearchIndex != -1) {
            System.out.println("Improved Linear Search:");
            System.out.println("Search key FOUND at index " + improvedlinearSearchIndex);
        } else {
            System.out.println("Improved Linear Search:");
            System.out.println("Search key NOT FOUND ");
        }
        
        System.out.println("Linear Search Time: " + linearSearchTime + " nanoseconds");
        System.out.println("Interpolation Search Time: " + interpolationSearchTime + " nanoseconds");
        System.out.println("Improved Linear Search Time: " + improvedlinearSearch + " nanoseconds");
        scanner.close();
    }
}
