package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private final int caloriesPerDay = 2000;
    private static final Logger log = getLogger(MealServlet.class);
    private MealRepository mealRepository;

    @Override
    public void init() throws ServletException {
        mealRepository = new MealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        request.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealRepository.getMeals(),
                LocalTime.MIN, LocalTime.MAX, caloriesPerDay));
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
