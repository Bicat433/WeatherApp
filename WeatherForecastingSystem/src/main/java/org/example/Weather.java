package org.example;

public class Weather {

    private String scale;
    private double maxTemperatureToday;
    private double minTemperatureToday;
    private double windSpeed;
    private double temperature;
    private double humidity;
    private double cloudPercentage;
    private double feelsLike;

    // Constructor
    public Weather(String scale, double maxTemperatureToday, double minTemperatureToday,
                   double windSpeed, double temperature, double humidity, double cloudPercentage, double feelsLike) {
        this.scale = scale;
        this.maxTemperatureToday = maxTemperatureToday;
        this.minTemperatureToday = minTemperatureToday;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cloudPercentage = cloudPercentage;
        this.feelsLike = feelsLike;
    }

    // Getters and Setters
    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public double getMaxTemperatureToday() {
        return maxTemperatureToday;
    }

    public void setMaxTemperatureToday(double maxTemperatureToday) {
        this.maxTemperatureToday = maxTemperatureToday;
    }

    public double getMinTemperatureToday() {
        return minTemperatureToday;
    }

    public void setMinTemperatureToday(double minTemperatureToday) {
        this.minTemperatureToday = minTemperatureToday;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getCloudPercentage() {
        return cloudPercentage;
    }

    public void setCloudPercentage(int cloudPercentage) {
        this.cloudPercentage = cloudPercentage;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    // toString method for easy printing of Weather object
    @Override
    public String toString() {
        return "Weather{" +
                "scale='" + scale + '\'' +
                ", maxTemperatureToday=" + maxTemperatureToday +
                ", minTemperatureToday=" + minTemperatureToday +
                ", windSpeed=" + windSpeed +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", cloudPercentage=" + cloudPercentage +
                ", feelsLike=" + feelsLike +
                '}';
    }
}
