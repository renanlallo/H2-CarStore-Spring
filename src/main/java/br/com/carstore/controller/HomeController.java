package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "public/dashboard";
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "public/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String viewCarDetails(@PathVariable String id, Model model) {
        List<CarDTO> cars = carService.findAll();
        for (CarDTO car : cars) {
            if (car.getId().equals(id)) {
                model.addAttribute("carDTO", car);
                break;
            }
        }
        return "public/car-details";
    }
}