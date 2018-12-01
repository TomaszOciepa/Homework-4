package com.infoshareacademy.homeworks;

public class Student {
    private String name;
    private String rating;
    private String numberOfRatings;
    private String averageRetings;

    public Student(String name, String rating, String numberOfRatings, String averageRetings) {
        this.name = name;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
        this.averageRetings = averageRetings;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public String getAverageRetings() {
        return averageRetings;
    }

    public void setNumberOfRatings(String numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public void setAverageRetings(String averageRetings) {
        this.averageRetings = averageRetings;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
