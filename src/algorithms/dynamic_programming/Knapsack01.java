package algorithms.dynamic_programming;

public class Knapsack01 {
    public static void printKnapSack(int[][] items, int capacity) {
        int knapsackValues[][] = new int[items.length + 1][capacity + 1];

        // start at 1 since 0 weight and 0 items would be 0
        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i-1][1];
            int currentValue = items[i-1][0];
            for (int w = 1; w < capacity + 1; w++) {
                if (currentWeight <= w) {
                    knapsackValues[i][w] = Math.max(currentValue +
                            knapsackValues[i - 1][w - currentWeight], knapsackValues[i - 1][w]);
                } else {
                    knapsackValues[i][w] = knapsackValues[i - 1][w];
                }
            }
        }

        int res = knapsackValues[items.length][capacity];
        System.out.println(res);
        for (int i = items.length, w = capacity; i > 0 && res > 0; i--) {
            if (res != knapsackValues[i - 1][w]) {
                int currentWeight = items[i-1][1];
                int currentValue = items[i-1][0];
                System.out.print(currentWeight + " ");
                res -= currentValue;
                w -= currentWeight;
            }
        }
    }
}
