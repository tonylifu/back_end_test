package controllers;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import models.CarDTO;
import models.CarMapper;
import com.encentral.test_project.commons.util.MyObjectMapper;
import models.JpaCar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import service.CarService;
import serviceImpl.DefaultCarService;
import javax.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import static play.mvc.Results.badRequest;

@Api(value = "Car")
@Transactional
public class CarsController extends Controller{

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    //@Inject
    DefaultCarService carService = new DefaultCarService();

    @ApiOperation(value = "Create a Car", notes = "", httpMethod = "POST")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    @ApiImplicitParams(
            {
                @ApiImplicitParam(
                        name = "Application",
                        dataType = "models.CarDTO",
                        required = true,
                        paramType = "body",
                        value = "Application"
                )
            }
    )
    public Result createCar(){
        Form<CarDTO> bindFromRequest = formFactory.form(CarDTO.class).bindFromRequest();
        if (bindFromRequest.hasErrors()) {
            return badRequest(bindFromRequest.errorsAsJson());

        }
        JpaCar create = carService.create(CarMapper.carDTotoJpaCar(bindFromRequest.get()));

        return ok(Json.toJson(CarMapper.jpaCarToCarDTO(create)));
    }

    public Result saveCar(){
        return TODO;
    }

    @ApiOperation(value = "Get Car", notes = "", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done", response = CarDTO.class)
            }
    )
    public Result findCarById(String carId){
        try {
            return ok(Json.toJson(CarMapper.jpaCarToCarDTO(carService.find(carId))));
        } catch (ResourceNotFound ex) {
            return notFound(ex.getMessage());
        }
    }

    public Result findAllCars(){
        return TODO;
    }

    public Result updateCar(String carId){
        return TODO;
    }

    @ApiOperation(value = "Delete Car", notes = "", httpMethod = "DELETE")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    public Result deleteCar(String carId){
        try {
            carService.delete(carId);
            return noContent();
        } catch (ResourceNotFound ex) {
            return notFound(ex.getMessage());
        }
    }
}