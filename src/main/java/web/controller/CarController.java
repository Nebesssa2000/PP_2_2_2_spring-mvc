package web.controller;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarService;
import web.Service.CarServiceImp;


import java.util.List;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
public class CarController {

    CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/car")
    public String returnCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {

        List<Car> carList = service.getCarCount(count);
        model.addAttribute("carList", carList);

        return "Cars/cars";
    }
}
