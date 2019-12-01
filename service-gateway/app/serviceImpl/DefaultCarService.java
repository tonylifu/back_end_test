/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImpl;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import models.JpaCar;
import service.CarService;
import java.util.Date;
import javax.inject.Inject;
import play.db.jpa.JPAApi;

/**
 *
 * @author James Akinniranye
 */
public class DefaultCarService implements CarService {

    @Inject
    JPAApi jPAApi;

    @Override
    public JpaCar find(String carId) throws ResourceNotFound {
        JpaCar car = jPAApi.em().find(JpaCar.class, carId);
        if (car == null) {
            throw new ResourceNotFound(String.format("Car with id %s not found", carId));
        }
        return car;
    }

    @Override
    public JpaCar create(JpaCar carDO) {
        carDO.setCarId(java.util.UUID.randomUUID().toString());
        carDO.setDateCreated(new Date());
        carDO.setDateModified(new Date());
        carDO.setLicensePlate("AGL 242 AA");
        carDO.setSeatCount(5);
        carDO.setConvertible(true);
        carDO.setRating(4);
        carDO.setEngineType("Automatic");
        carDO.setManufacturer("Toyota");
        jPAApi.em().persist(carDO);
        return carDO;
    }

    @Override
    public void delete(String carId) throws ResourceNotFound {
        jPAApi.em().detach(find(carId));
    }

}
