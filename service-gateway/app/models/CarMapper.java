/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author James Akinniranye
 */
public class CarMapper {

    public static CarDTO jpaCarToCarDTO(JpaCar jpaCar) {
        CarDTO dTO = new CarDTO();
        dTO.setDateCreated(jpaCar.getDateCreated());
        dTO.setDateModified(jpaCar.getDateModified());
        dTO.setCarId(jpaCar.getCarId());
        dTO.setLicensePlate(jpaCar.getLicensePlate());
        dTO.setSeatCount(jpaCar.getSeatCount());
        dTO.setConvertible(jpaCar.getConvertible());
        dTO.setRating(jpaCar.getRating());
        dTO.setEngineType(jpaCar.getEngineType());
        dTO.setManufacturer(jpaCar.getManufacturer());
        return dTO;
    }

    public static JpaCar carDTotoJpaCar(CarDTO dTO) {
        JpaCar jpaCar = new JpaCar();
        jpaCar.setDateCreated(dTO.getDateCreated());
        jpaCar.setDateModified(dTO.getDateModified());
        jpaCar.setCarId(dTO.getCarId());
        jpaCar.setLicensePlate(dTO.getLicensePlate());
        jpaCar.setSeatCount(dTO.getSeatCount());
        jpaCar.setConvertible(dTO.getConvertible());
        jpaCar.setRating(dTO.getRating());
        jpaCar.setEngineType(dTO.getEngineType());
        jpaCar.setManufacturer(dTO.getManufacturer());
        return jpaCar;
    }
}
