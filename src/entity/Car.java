package entity;

public class Car extends Vehicle{
    private int fuelConsumption;
    private int reservoirVolume;
    private String fuelType;
    private int power;
    private String gearboxType;
    private int productionYear;
    private String registrationDate;
    private String insuranceDate;
    private String technicalTestDate;
    private String nextTiresChangeDate;
    private int nextOilChangeKm;

    public Car(String type, String registerNumber, String brand, String model, String imagePath, int fuelConsumption,
               int reservoirVolume, String fuelType, int power, String gearboxType, int productionYear,
               String registrationDate, String insuranceDate, String technicalTestDate, String nextTiresChangeDate,
               int nextOilChangeKm) {
        super(type, registerNumber, brand, model, imagePath);
        this.fuelConsumption = fuelConsumption;
        this.reservoirVolume = reservoirVolume;
        this.fuelType = fuelType;
        this.power = power;
        this.gearboxType = gearboxType;
        this.productionYear = productionYear;
        this.registrationDate = registrationDate;
        this.insuranceDate = insuranceDate;
        this.technicalTestDate = technicalTestDate;
        this.nextTiresChangeDate = nextTiresChangeDate;
        this.nextOilChangeKm = nextOilChangeKm;
    }

    public String getProperty(String property){
        return switch (property) {
            case "number" -> this.getRegisterNumber();
            case "brand" -> this.getBrand();
            case "model" -> this.getModel();
            case "insurance" -> this.getInsuranceDate();
            case "registration" -> this.getRegistrationDate();
            default -> "";
        };
    }

    // Getters and setters
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getReservoirVolume() {
        return reservoirVolume;
    }

    public void setReservoirVolume(int reservoirVolume) {
        this.reservoirVolume = reservoirVolume;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getTechnicalTestDate() {
        return technicalTestDate;
    }

    public void setTechnicalTestDate(String technicalTestDate) {
        this.technicalTestDate = technicalTestDate;
    }

    public String getNextTiresChangeDate() {
        return nextTiresChangeDate;
    }

    public void setNextTiresChangeDate(String nextTiresChangeDate) {
        this.nextTiresChangeDate = nextTiresChangeDate;
    }

    public int getNextOilChangeKm() {
        return nextOilChangeKm;
    }

    public void setNextOilChangeKm(int nextOilChangeKm) {
        this.nextOilChangeKm = nextOilChangeKm;
    }
}
