package org.example;

import java.util.Scanner;

public class WeatherApp {

    private static final WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearScreen();
            System.out.println("Weather Application:");
            System.out.println("1. Get Weather Information");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();

                    Weather weather = getWeatherWithRetry(city);
                    if (weather != null) {
                        clearScreen();
                        displayWeatherInfo(weather,city);
                    } else {
                        System.out.println("Failed to retrieve weather information.");
                    }
                    break;

                case 2:
                    System.out.println("Exiting Weather Application. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Weather getWeatherWithRetry(String city) {
        Weather weather = null;

        // Retry fetching weather information until a non-null value is obtained
        while (weather == null) {
            weather = weatherService.getWeather(city);

            if (weather == null) {
                System.out.println("Failed to retrieve weather information for " + city + ". Retrying...");

                //Add a delay
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return weather;
    }
    private static void displayWeatherInfo(Weather weather,String city) {
        System.out.println("Weather Information:");
        System.out.println("City: "+ city+ "\n-----------------------------------------------------------------------\n");
        System.out.println("Scale: " + weather.getScale());
        System.out.println("Temperature: " + weather.getTemperature());
        System.out.println("Max Temperature: " + weather.getMaxTemperatureToday());
        System.out.println("Min Temperature: " + weather.getMinTemperatureToday());
        System.out.println("Feels like: " + weather.getFeelsLike());
        System.out.println("Cloud Percentage: " + weather.getCloudPercentage()+"%");
        System.out.println("Humidity: " + weather.getHumidity());
        System.out.println("\nPress Enter to go back to the menu...");
        new Scanner(System.in).nextLine();
        clearScreen();
    }

    private static void clearScreen() {

        System.out.flush();
    }
}
