import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPossibleSubsetSumProblem {
    // dp[i][j] is going to store true if sum j is
    // possible with array elements from 0 to i.
    static boolean[][] dp;
    static List<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> waste = new ArrayList<>();

    static void display(ArrayList<Integer> v)
    {
        System.out.println(v);
    }

    // A recursive function to print all subsets with the
    // help of dp[][]. Vector p[] stores current subset.
    static void printSubsetsRec(int arr[], int i, int sum,
                                ArrayList<Integer> p)
    {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum]
        // is true.
        if (i == 0 && sum != 0 && dp[0][sum])
        {
            p.add(arr[i]);
            display(p);
            ArrayList<Integer> p2 = new ArrayList<>(p);
            solutions.add(p2);
            waste = (ArrayList<Integer>) waste.stream()
                    .filter(index -> !p2.contains(index))
                    .collect (Collectors.toList());
            p.clear();
            return;
        }

        // If sum becomes 0
        if (i == 0 && sum == 0)
        {
            display(p);
            ArrayList<Integer> p2 = new ArrayList<>(p);
            solutions.add(p2);
            waste = (ArrayList<Integer>) waste.stream()
                    .filter(index -> !p2.contains(index))
                    .collect (Collectors.toList());
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[i-1][sum])
        {
            // Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i-1, sum, b);
        }

        // If given sum can be achieved after considering
        // current element.
        if (sum >= arr[i] && dp[i-1][sum-arr[i]])
        {
            p.add(arr[i]);
            printSubsetsRec(arr, i-1, sum-arr[i], p);
        }
        System.out.println("test");
    }

    // Prints all subsets of arr[0..n-1] with sum 0.
    static void printAllSubsets(int arr[], int n, int sum)
    {
        if (n == 0 || sum < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][sum + 1];
        for (int i=0; i<n; ++i)
        {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] ||
                        dp[i-1][j-arr[i]])
                        : dp[i - 1][j];
        if (dp[n-1][sum] == false)
        {
            System.out.println("There are no subsets with sum "+ sum);
            try {
                FileWriter myWriter = new FileWriter(System.getProperty("user.dir") + "\\resources\\output.txt");
                myWriter.write("There are no subsets with sum "+ sum);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n-1, sum, p);
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    //Driver Program to test above functions
    public static void main(String args[])
    {
        ArrayList<String> inputLines = new ArrayList<String>();
        try {
            File input = new File(System.getProperty("user.dir") + "\\resources\\input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputLines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int n = Integer.parseInt(inputLines.get(0));
        String[] stringArr = inputLines.get(1).split(" ");
        int[] arr = StringArrToIntArr(stringArr);
        int sum = Integer.parseInt(inputLines.get(2));

        waste = IntStream.of(Arrays.copyOf(arr, arr.length)).boxed().collect(Collectors.toCollection(ArrayList::new));
        printAllSubsets(arr, n, sum);

        try {
            String outputFileName = System.getProperty("user.dir") + "\\resources\\output.txt";
            File output = new File(outputFileName);
            FileWriter myWriter = new FileWriter(outputFileName);
            myWriter.write(solutions.size() + "\n");
            for(ArrayList<Integer>list : solutions){
                myWriter.write(list + System.lineSeparator());
            }
            myWriter.write("Waste = " + waste.size());
            myWriter.close();
            if (output.createNewFile()) {
                System.out.println("File created: " + output.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
