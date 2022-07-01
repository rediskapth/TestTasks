package ua.test.taskTwo;

import java.util.Arrays;

import static java.lang.Math.min;

public class City {
    private int[][] cost;

    public City(int city) {     // number of cities of our task
        cost = new int[city][city];
    }

    public void setEdge(int firstCity, int secondCity, int weight) {        // weight between two cities
        cost[firstCity][secondCity] = weight;
    }

    /*
        return 10001 when two cities don't have direct connection
     */
    private int getCost(int firstCity, int secondCity) {
        if (firstCity == secondCity) {
            return 0;
        } else {
            return cost[firstCity][secondCity] == 0 ? 10001 : cost[firstCity][secondCity];
        }
    }

    /*
        get min index of the city, ignoring visited
     */
    private int getUntaggedCity(Integer[] result, boolean[] visited) {
        int minIndex = -1;

        for (int i = 0; i < cost.length; i++) {
            if (!visited[i] && (minIndex < 0 || result[i] < result[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /*
        find min cost between two cities
     */
    public Integer[] findMinimumCostBetweenCities(int startIndex) {
        boolean[] visited = new boolean[cost.length];
        Integer[] result = new Integer[cost.length];
        Arrays.fill(result, 10001);
        result[startIndex] = startIndex;

        for (int[] eachCost : cost) {
            int city = getUntaggedCity(result, visited);
            visited[city] = true;
            for (int j = 0; j < cost.length; j++) {
                result[j] = min(result[j], result[city] + getCost(city, j));
            }
        }
        return result;
    }
}
