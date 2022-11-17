package entity;

import validation.Validator;

import java.util.ArrayList;
import java.util.HashMap;

public class Garage {

    private String name;
    private ArrayList<Car> vehicles = new ArrayList<>();

    public Garage(String name) {
        this.name = name;
    }

    public boolean isValidInfo(HashMap<String, String> carInfo){
        Validator val=new Validator();

        if (val.validateCarType(carInfo.get("type")) && val.validateCarRegistrationNumber(carInfo.get("registerNumber")) && val.validateCarBrand(carInfo.get("brand"))
                && val.validateCarModel(carInfo.get("model")) && val.validateFuelConsumption(Integer.parseInt(carInfo.get("fuelConsumption"))) &&
                val.validateReservoirVolume(Integer.parseInt(carInfo.get("reservoirVolume"))) && val.validatePower(Integer.parseInt(carInfo.get("power")))
                && val.validateProductionYear(Integer.parseInt(carInfo.get("productionYear"))) && val.validateRegistrationDate(carInfo.get("registrationDate"))
                && val.validateInsuranceDate(carInfo.get("insuranceDate")) && val.validateTechnicalTestDate(carInfo.get("technicalTestDate"))
                && val.validateNextTiresChangeDate(carInfo.get("nextTiresChangeDate")) && val.validateNextOilChangeKm(Integer.parseInt(carInfo.get("nextOilChangeKm")))) {
            return true;
        }

        return false;
    }

    public Car addCar(HashMap<String, String> carInfo){
        Car car=new Car(carInfo.get("type"), carInfo.get("registerNumber"), carInfo.get("brand"), carInfo.get("model"),
                carInfo.get("imagePath"),Integer.parseInt(carInfo.get("fuelConsumption")), Integer.parseInt(carInfo.get("reservoirVolume")),
                carInfo.get("fuelType"),Integer.parseInt(carInfo.get("power")), carInfo.get("gearboxType"), Integer.parseInt(carInfo.get("productionYear")),
                carInfo.get("registrationDate"), carInfo.get("insuranceDate"), carInfo.get("technicalTestDate"), carInfo.get("nextTiresChangeDate"),
                Integer.parseInt(carInfo.get("nextOilChangeKm")));
        this.vehicles.add(car);
        return car;
    }

    public void removeCar(Car car){
        int indexToDelete=0;
        for(int i=0; i<this.vehicles.size(); i++){
            if (this.vehicles.get(i).equals(car)){
                indexToDelete=i;
                break;
            }
        }

        this.vehicles.remove(indexToDelete);
    }

    public ArrayList<Car> findCar(String criteria, String value){
        ArrayList<Car> found = new ArrayList<>();
        for (Car vehicle : this.vehicles) {
            if (vehicle.getProperty(criteria).contains(value)) {
                found.add(vehicle);
            }
        }

        return found;
    }

    public boolean updateCar(Car car, HashMap<String, String> carInfo){

        Validator val=new Validator();

        if (isValidInfo(carInfo)){
            car.setType(carInfo.get("type"));
            car.setRegisterNumber(carInfo.get("registerNumber"));
            car.setBrand(carInfo.get("brand"));
            car.setModel(carInfo.get("model"));
            car.setImagePath(carInfo.get("imagePath"));
            car.setFuelConsumption(Integer.parseInt(carInfo.get("fuelConsumption")));
            car.setReservoirVolume(Integer.parseInt(carInfo.get("reservoirVolume")));
            car.setFuelType(carInfo.get("fuelType"));
            car.setPower(Integer.parseInt(carInfo.get("power")));
            car.setGearboxType(carInfo.get("gearboxType"));
            car.setProductionYear(Integer.parseInt(carInfo.get("productionYear")));
            car.setRegistrationDate(carInfo.get("registrationDate"));
            car.setInsuranceDate(carInfo.get("insuranceDate"));
            car.setTechnicalTestDate(carInfo.get("technicalTestDate"));
            car.setNextTiresChangeDate(carInfo.get("nextTiresChangeDate"));
            car.setNextOilChangeKm(Integer.parseInt(carInfo.get("nextOilChangeKm")));
            return true;
        }else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Car> vehicles) {
        this.vehicles = vehicles;
    }
}
