package com.infoshareacademy.homeworks;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class GradeService {

    public String[][] calculateAverage(String[][] data) {
        if (data == null || data.length == 0) {
            return new String[][]{{}};
        } else {
            List<Student> stringListStudent = tableConvertToList(data);
            List<Student> listStudents = checkHowManyRatingsItHasAndSumRatings(stringListStudent);
            List<Student> listStudentsOfCalculateAverage = countAverage(listStudents);
            List<Student> sortList = sortList(listStudentsOfCalculateAverage);
            String[][] output = listConvertToTable(sortList);

            return output;
        }
    }

    public List<Student> tableConvertToList(String[][] data) {
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            list.add(new Student(data[i][0], data[i][1], "1", "0"));
        }
        return list;
    }

    private List<Student> checkHowManyRatingsItHasAndSumRatings(List<Student> stringListStudent) {
        List<Student> list = stringListStudent;

        Double numberOfRatingsDouble;
        String numberOfRatingsString;
        Double sumRetingInt;
        String sumRetingString;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i).getName().equalsIgnoreCase(list.get(j).getName())) {
                    numberOfRatingsDouble = Double.parseDouble(list.get(i).getNumberOfRatings());
                    numberOfRatingsDouble = numberOfRatingsDouble + Double.parseDouble(list.get(j).getNumberOfRatings());
                    numberOfRatingsString = String.valueOf(numberOfRatingsDouble);
                    list.get(i).setNumberOfRatings(numberOfRatingsString);


                    sumRetingInt = Double.parseDouble(list.get(i).getRating());
                    sumRetingInt = sumRetingInt + Double.parseDouble(list.get(j).getRating());
                    sumRetingString = String.valueOf(sumRetingInt);
                    list.get(i).setRating(sumRetingString);
                    list.remove(j);

                }
            }
        }
        return list;
    }

    private List<Student> countAverage(List<Student> list) {
        Double averageRetingsDouble;
        Double numberOfRatingsDouble;
        Double sumRating;

        for (int i = 0; i < list.size(); i++) {

            sumRating = Double.parseDouble(list.get(i).getRating());
            numberOfRatingsDouble = Double.parseDouble(list.get(i).getNumberOfRatings());
            averageRetingsDouble = sumRating / numberOfRatingsDouble;

            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat formatter = new DecimalFormat("0.00", decimalFormatSymbols);
            String result = formatter.format(averageRetingsDouble);

            list.get(i).setAverageRetings(result);
        }
        return list;
    }

    private List<Student> sortList(List<Student> listStudentsOfCalculateAverage) {
        return listStudentsOfCalculateAverage
                .stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());
    }

    public String[][] listConvertToTable(List<Student> list) {
        String[][] output = new String[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            output[i][0] = list.get(i).getName();
            output[i][1] = list.get(i).getAverageRetings();
        }
        return output;
    }
}
