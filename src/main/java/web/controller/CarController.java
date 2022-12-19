package web.controller;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import web.Model.Car;
import web.Service.CarService;
import web.Service.CarServiceImp;
import web.config.WebConfig;


import java.util.List;


@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Controller
public class CarController {

    AnnotationConfigWebApplicationContext context
            = new AnnotationConfigWebApplicationContext();

    CarService service = context.getBean(CarService.class);

    @GetMapping("/car")
    public String returnCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {

        List<Car> carList = service.getCarCount(count);
        model.addAttribute("carList", carList);

        return "Cars/cars";
    }
}
