package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class WeatherService {

    public Weather getWeather(String city) {
        try {
            // Make API call to api-ninjas weather API
            URL url = new URL("https://api.api-ninjas.com/v1/weather?city=" + city);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", "yxtMfJRw1MBJHmidNdxpFw==2BFR3tGYYolMlX1k");
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);


            // Read the JSON response
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
                System.out.println(response.toString() );
            }

            // Parse JSON response using org.json.simple.JSONObject
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.toString());

            // Extract relevant weather information from the JSON response
            //JSONObject fact = (JSONObject) json.get("{}");
            String scale = "Celsius";
            double maxTemp = (Long) json.get("max_temp");
            double minTemp = (Long) json.get("min_temp");
            double windSpeed = (double) json.get("wind_speed");
            double temperature = (Long) json.get("temp");
            double feelLike = (Long) json.get("feels_like");
            double cloudPct = (Long) json.get("cloud_pct");
            double humidity = (Long) json.get("humidity");

            // Create a Weather object with the extracted information
            Weather weather = new Weather(scale,maxTemp,minTemp,windSpeed,temperature,humidity,cloudPct,feelLike);

            connection.disconnect();

            return weather;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
