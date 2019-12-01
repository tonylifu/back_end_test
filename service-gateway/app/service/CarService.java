/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import models.JpaCar;

/**
 *
 * @author James Akinniranye
 */
public interface CarService {
    
    JpaCar find(String carId) throws ResourceNotFound;

    JpaCar create(JpaCar carDO) ;

    void delete(String carId) throws ResourceNotFound;

}
