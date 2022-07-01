package ua.test.taskTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    private static final int NUMBER_OF_CITIES = 10000;

    public TaskTwo() {
    }

    /*
        read file input_data.txt from resources, find min costs and print it into console
     */
    public static void main(String[] args) throws IOException {
        File path = new File("src/main/resources/input_data.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(path.getAbsolutePath()))) {

            String line = br.readLine();
            int source = Integer.parseInt(line);

            for (int testIndex = 0; testIndex < source; ++testIndex) {
                String[] citiesIndex = new String[NUMBER_OF_CITIES];
                line = br.readLine();
                int countCities = Integer.parseInt(line);
                City city = new City(countCities + 1);

                int cityIndex;
                int startIndex;
                for (cityIndex = 0; cityIndex < countCities; ++cityIndex) {
                    line = br.readLine();
                    citiesIndex[cityIndex] = line;
                    line = br.readLine();
                    int p = Integer.parseInt(line);

                    for (int neighborIndex = 0; neighborIndex < p; ++neighborIndex) {
                        line = br.readLine();
                        String[] brokenLine = line.split(" ");
                        int cityToConnect = Integer.parseInt(brokenLine[0]);
                        startIndex = Integer.parseInt(brokenLine[1]);
                        city.setEdge(cityIndex, cityToConnect, startIndex);
                    }
                }

                line = br.readLine();
                cityIndex = Integer.parseInt(line);

                for (int routesIndex = 0; routesIndex < cityIndex; ++routesIndex) {
                    line = br.readLine();
                    String[] cityNames = line.split(" ");
                    String start = cityNames[0];
                    String destination = cityNames[1];
                    List<String> list = new ArrayList();
                    String[] cityName = citiesIndex;
                    int destinationIndex = citiesIndex.length;

                    int i;
                    for (i = 0; i < destinationIndex; ++i) {
                        String nameOfCity = cityName[i];
                        if (nameOfCity != null) {
                            list.add(nameOfCity);
                        }
                    }

                    citiesIndex = list.toArray(new String[0]);
                    startIndex = 0;
                    destinationIndex = 0;

                    for (i = 0; i < citiesIndex.length; ++i) {
                        if (start.equals(citiesIndex[i])) {
                            startIndex = i;
                            break;
                        }
                    }

                    for (i = 0; i < citiesIndex.length; ++i) {
                        if (destination.equals(citiesIndex[i])) {
                            destinationIndex = i;
                            break;
                        }
                    }

                    Integer[] distancesFromSource = city.findMinimumCostBetweenCities(startIndex);
                    int destinationDistance = distancesFromSource[destinationIndex];
                    System.out.println(destinationDistance);
                }
            }
        }
    }
}
