package web.Service;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Model.Car;
import web.dao.CarDAO;

import java.util.List;

@Getter
@Setter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class CarServiceImp implements CarService {
    CarDAO carDAO;

    @Autowired
    public CarServiceImp(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> addList() {
        return carDAO.addList();
    }

    // list сюда
    @Override
    public List<Car> getCarCount(int count) {
        return carDAO.getCarCount(carDAO.addList(), count);

    }
}
