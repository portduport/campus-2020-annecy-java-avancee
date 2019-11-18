package com.campus2020.projetJavaAvancee.controller;
 
import java.util.ArrayList;
import java.util.List;

import com.campus2020.projetJavaAvancee.form.CarForm;
import com.campus2020.projetJavaAvancee.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * @param model
     * @return
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    /**
     * @param model
     * @param carForm
     * @return
     */
    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
                          @ModelAttribute("carForm") CarForm carForm) {
        String brand = carForm.getBrand();
        String version = carForm.getVersion();

        if (brand != null && brand.length() > 0 //
                && version != null && version.length() > 0) {
            Car newCar = new Car(brand, version);
            cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }
 
}