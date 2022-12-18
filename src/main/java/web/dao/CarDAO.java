package web.dao;

import web.Model.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> addList();

    List<Car> getCarCount(List<Car> carList, int count);
}
