package validation;

public class Validator {

    public boolean validateCarType(String type) {
        return !type.isEmpty() && type.length() <= 100;
    }

    public boolean validateCarRegistrationNumber(String registrationNumber) {
        return !registrationNumber.isEmpty() && registrationNumber.length() <= 10;
    }

    public boolean validateCarBrand(String brand) {
        return !brand.isEmpty() && brand.length() <= 20;
    }

    public boolean validateCarModel(String model) {
        return !model.isEmpty() && model.length() <= 20;
    }

    public boolean validateFuelConsumption(int fuelConsumption) {
        return fuelConsumption > 0;
    }

    public boolean validateReservoirVolume(int reservoirVolume) {
        return reservoirVolume > 0;
    }

    public boolean validatePower(int power) {
        return power > 0;
    }

    public boolean validateProductionYear(int year) {
        return year > 0 && year <= 2022;
    }

    public boolean validateRegistrationDate(String registrationDate) {
        String[] parts = registrationDate.split("\\.");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (year == 2022) {
            if (month == 11) {
                return day <= 11;
            } else return month <= 11;
        } else return year <= 2022;
    }

    public boolean validateInsuranceDate(String insuranceDate) {
        String[] parts = insuranceDate.split("\\.");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (year == 2022) {
            if (month == 11) {
                return day <= 11;
            } else return month <= 11;
        } else return year <= 2022;
    }

    public boolean validateTechnicalTestDate(String technicalTestDate) {
        String[] parts = technicalTestDate.split("\\.");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (year == 2022) {
            if (month == 11) {
                return day <= 11;
            } else return month <= 11;
        } else return year <= 2022;
    }

    public boolean validateNextTiresChangeDate(String nextTiresChangeDate) {
        String[] parts = nextTiresChangeDate.split("\\.");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (year == 2022) {
            if (month == 11) {
                return day > 11;
            } else return month > 11;
        } else return year > 2022;
    }

    public boolean validateNextOilChangeKm(int nextOilChangeKm) {
        return nextOilChangeKm > 0;
    }

}
