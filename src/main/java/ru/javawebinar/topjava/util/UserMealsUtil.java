package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

//        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        List<UserMealWithExcess> mealsTo = filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> calorieSum = new HashMap<>();
        List<LocalDate> excessDays = new ArrayList<>();
        List<UserMeal> filteredList = new ArrayList<>();

        for (UserMeal meal : meals) {
            LocalDate date = meal.getDateTime().toLocalDate();
            int calorie = meal.getCalories();

            calorieSum.computeIfPresent(date, (k, v) -> v + calorie);
            calorieSum.putIfAbsent(date, calorie);

            if (calorieSum.get(date) > caloriesPerDay && !excessDays.contains(date)) {
                excessDays.add(date);
            }

            if (TimeUtil.isBetweenHalfOpen(meal.getDateTime().toLocalTime(), startTime, endTime)) {
                filteredList.add(meal);
            }
        }

        List<UserMealWithExcess> result = new ArrayList<>();

        if (!filteredList.isEmpty()) {
            for (UserMeal um : filteredList) {
                if (excessDays.contains(um.getDateTime().toLocalDate())) {
                    result.add(new UserMealWithExcess(um.getDateTime(), um.getDescription(), um.getCalories(), true));
                } else {
                    result.add(new UserMealWithExcess(um.getDateTime(), um.getDescription(), um.getCalories(), false));
                }
            }
        }

        return result;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> calorieSum = meals.stream()
                        .collect(Collectors.toMap(x-> x.getDateTime().toLocalDate(), UserMeal::getCalories, Integer::sum));

        return meals.stream()
                .filter(x -> x.getDateTime().toLocalTime().compareTo(startTime) >= 0 && x.getDateTime().toLocalTime().compareTo(endTime) < 0)
                .map(x -> calorieSum.get(x.getDateTime().toLocalDate()) > caloriesPerDay
                        ? new UserMealWithExcess(x.getDateTime(), x.getDescription(), x.getCalories(), true)
                        : new UserMealWithExcess(x.getDateTime(), x.getDescription(), x.getCalories(), false))
                .collect(Collectors.toList());
    }
}
