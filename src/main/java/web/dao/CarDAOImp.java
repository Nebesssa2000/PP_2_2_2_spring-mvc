package web.dao;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.Model.Car;
import web.config.WebConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Component
@Repository
public class CarDAOImp implements CarDAO{

    WebConfig webConfig;

    @Autowired
    public CarDAOImp(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public List<Car> addList() {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("Cadillac", "metallic", "TX6"));
        carList.add(new Car("Alpine", "blue", "A110"));
        carList.add(new Car("Alfa Romeo", " black", "159"));
        carList.add(new Car("Ferrari", "red", "Spider"));
        carList.add(new Car("lamborghini", "yellow", "Huracan"));


        return carList;
    }
    @Override
    public List<Car> getCarCount(List<Car> carList, int count) {
        return (count == 0 || count > 5) ? carList
                : carList.stream().limit(count).
                collect(Collectors.toList());

    }
}
