package web.controller;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarServiceImp;


import java.util.List;


@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Controller
public class CarController {

    CarServiceImp serviceImp = new CarServiceImp();

    @GetMapping("/car")
    public String returnCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {

        List<Car> carList = serviceImp.getCarCount(count);
        model.addAttribute("carList", carList);

        return "Cars/cars";
    }
}
