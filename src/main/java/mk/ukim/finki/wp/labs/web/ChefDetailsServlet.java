package mk.ukim.finki.wp.labs.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.labs.model.Chef;
import mk.ukim.finki.wp.labs.model.Dish;
import mk.ukim.finki.wp.labs.service.ChefService;
import mk.ukim.finki.wp.labs.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "chefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final ChefService chefService;
    private final DishService dishService;

    public ChefDetailsServlet(SpringTemplateEngine springTemplateEngine, ChefService chefService, DishService dishService) {
        this.springTemplateEngine = springTemplateEngine;
        this.chefService = chefService;
        this.dishService = dishService;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String chefIdString=req.getParameter("chefId");
        Long chefId=Long.parseLong(chefIdString);
        String dishId = req.getParameter("dishId");

        Chef chef = chefService.findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        if (chef == null || dish == null) {
            throw new RuntimeException("Chef or Dish not found");
        }

        chefService.addDishToChef(chefId, dishId);

        String chefIdParam = req.getParameter("chefId");
        if (chefIdParam != null) {
             chefId = Long.parseLong(chefIdParam);
            Chef selectedChef = chefService.findById(chefId);
            addChefToRecentList(req, selectedChef);
        }
        context.setVariable("chef", chef);
        context.setVariable("dishes", dish);

        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());



    }

    private void addChefToRecentList(HttpServletRequest req, Chef chef) {
        List<Chef> recentChefs = (List<Chef>) req.getSession().getAttribute("recentChefs");

        if (recentChefs == null) {
            recentChefs = new ArrayList<>();
        }


        recentChefs.removeIf(c -> c.getId().equals(chef.getId()));

        if (recentChefs.size() >= 3) {
            recentChefs.remove(0);
        }

        recentChefs.add(chef);

        req.getSession().setAttribute("recentChefs", recentChefs);
    }
}
