package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealRepository {
    private final List<MealTo> mealToList;
    private final int CALORIES_PER_DAY;

    public MealRepository(int caloriesPerDay) {
        this.CALORIES_PER_DAY = caloriesPerDay;

        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        mealToList = MealsUtil.filteredByStreams(meals, LocalTime.of(0, 0, 0),
                LocalTime.of(23, 59, 59), CALORIES_PER_DAY);
    }

    public List<MealTo> getMealToList() {
        return mealToList;
    }

    public int getCALORIES_PER_DAY() {
        return CALORIES_PER_DAY;
    }
}