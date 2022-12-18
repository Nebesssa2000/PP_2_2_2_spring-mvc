package web.Service;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.Model.Car;
import web.dao.CarDAO;
import web.dao.CarDAOImp;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class CarServiceImp implements CarService {
    CarDAO carDAO = new CarDAOImp();

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
