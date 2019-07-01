package algorithms.dynamic_programming;

public class Knapsack01 {
    public static void printKnapSack(int weights[], int values[], int capacity) {
        int knapsackValues[][] = new int[values.length + 1][capacity + 1];

        // start at 1 since 0 weight and 0 items would be 0
        for (int i = 1; i <= values.length; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    knapsackValues[i][w] = Math.max(values[i - 1] +
                            knapsackValues[i - 1][w - weights[i - 1]], knapsackValues[i - 1][w]);
                } else {
                    knapsackValues[i][w] = knapsackValues[i - 1][w];
                }
            }
        }

        int res = knapsackValues[values.length][capacity];
        System.out.println(res);
        for (int i = values.length, w = capacity; i > 0 && res > 0; i--) {
            if (res != knapsackValues[i - 1][w]) {
                System.out.print(weights[i - 1] + " ");
                res -= values[i - 1];
                w -= weights[i - 1];
            }
        }
    }
}
