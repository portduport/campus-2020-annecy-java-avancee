package com.campus2020.projetJavaAvancee.controller;
 
import java.util.ArrayList;
import java.util.List;

import com.campus2020.projetJavaAvancee.form.CarForm;
import com.campus2020.projetJavaAvancee.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car("Audi", "Q7"));
        cars.add(new Car("BMW", "325i"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", cars);

        return "carList";
    }

    /**
     * @param modele
     * @return
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model modele) {

        CarForm carForm = new CarForm();
        modele.addAttribute("carForm", carForm);

        return "addCar";
    }

    /**
     * @param modele
     * @param carForm
     * @return
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model modele, //
            @ModelAttribute("carForm") CarForm carForm) {
        String brand = carForm.getBrand();
        String model = carForm.getModel();

        if (brand != null && brand.length() > 0 //
                && model != null && model.length() > 0) {
            Car newCar = new Car(brand, model);
            cars.add(newCar);

            return "redirect:/carList";
        }

        modele.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }
 
}