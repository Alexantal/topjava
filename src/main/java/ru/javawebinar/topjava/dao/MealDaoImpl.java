package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.List;

public class MealDaoImpl implements MealDao{
    private final MealRepository mealRepository;

    public MealDaoImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public void add(Meal meal) {

    }

    @Override
    public void delete(int id) {
        List<Meal> meals = mealRepository.getMeals();
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getId() == id) {
                meals.remove(i);
                break;
            }
        }
    }

    @Override
    public void update(Meal meal) {

    }

    @Override
    public List<Meal> readAll() {
        return mealRepository.getMeals();
    }

    @Override
    public Meal readById(int id) {
        return null;
    }
}
