package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;

import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int USER_MEAL_ID = START_SEQ + 2;
    public static final LocalDateTime DUB_DATE_TIME = LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0);
    public static final Meal expectedMeal =
            new Meal(USER_MEAL_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);

}
