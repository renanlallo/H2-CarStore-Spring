package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SecuredController {

    private final CarService carService;

    public SecuredController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/secured-page")
    public String securedPage() {
        return "redirect:/secured-cars";
    }

    @GetMapping("/secured-cars")
    public String securedCars(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("carDTO", new CarDTO());
        return "secured/secured-page";
    }

    @PostMapping("/secured-cars")
    public String createCar(@ModelAttribute @Valid CarDTO car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<CarDTO> cars = carService.findAll();
            model.addAttribute("cars", cars);
            model.addAttribute("carDTO", car);
            return "secured/secured-page";
        }
        carService.save(car);
        return "redirect:/secured-cars";
    }

    @PostMapping("/secured-delete/{id}")
    public String deleteCar(@PathVariable String id) {
        carService.deleteById(id);
        return "redirect:/secured-cars";
    }

    @PostMapping("/secured-update/{id}")
    public String updateCar(@PathVariable String id, @ModelAttribute @Valid CarDTO car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<CarDTO> cars = carService.findAll();
            model.addAttribute("cars", cars);
            model.addAttribute("carDTO", car);
            return "secured/secured-page";
        }
        carService.update(id, car);
        return "redirect:/secured-cars";
    }
}