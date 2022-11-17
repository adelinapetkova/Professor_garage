package entity;

public abstract class Vehicle {

    private String type;
    private String registerNumber;
    private String brand;
    private String model;
    private String imagePath;
//    BufferedImage photo = ImageIO.read(new File(imagePath));


    public Vehicle(String type, String registerNumber, String brand, String model, String imagePath) {
        this.type = type;
        this.registerNumber = registerNumber;
        this.brand = brand;
        this.model = model;
        this.imagePath = imagePath;
    }

    public abstract String getProperty(String property);

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return this.getBrand() + " " + this.getModel() + " " + this.getRegisterNumber();
    }
}
