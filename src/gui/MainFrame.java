package gui;

import entity.Car;
import entity.Garage;
import entity.Vehicle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MainFrame extends JFrame {

    public Car selectedCar=null;

    public Garage garage = new Garage("Professor's garage");

    public Border blackline = BorderFactory.createLineBorder(Color.black);

    public JComboBox vehiclesDropdown;

    // Methods
    public JPanel makeCarDetailsPanel(Car car) {
        JPanel detailsPanel = new JPanel(new BorderLayout());
        JLabel detailsLabel = new JLabel("Car details");
        detailsLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        detailsPanel.add(detailsLabel, BorderLayout.PAGE_START);

        JPanel detailsFieldsPanel = new JPanel(new GridLayout(8, 3));

        JLabel typeLabel = new JLabel("Type: " + car.getType());
        detailsFieldsPanel.add(typeLabel);

        JLabel registerNumberLabel = new JLabel("Register number: " + car.getRegisterNumber());
        detailsFieldsPanel.add(registerNumberLabel);

        JLabel brandLabel = new JLabel("Brand: " + car.getBrand());
        detailsFieldsPanel.add(brandLabel);

        JLabel modelLabel = new JLabel("Model: " + car.getModel());
        detailsFieldsPanel.add(modelLabel);

//        JLabel imagePathLabel = new JLabel("Image Path: " + car.getImagePath());
//        detailsFieldsPanel.add(imagePathLabel);

        JLabel fuelConsumptionLabel = new JLabel("Fuel Consumption: " + car.getFuelConsumption());
        detailsFieldsPanel.add(fuelConsumptionLabel);

        JLabel reservoirVolumeLabel = new JLabel("Reservoir Volume: "+car.getReservoirVolume());
        detailsFieldsPanel.add(reservoirVolumeLabel);

        JLabel fuelTypeLabel = new JLabel("Fuel Type: "+car.getFuelType());
        detailsFieldsPanel.add(fuelTypeLabel);

        JLabel powerLabel = new JLabel("Power: "+car.getPower());
        detailsFieldsPanel.add(powerLabel);

        JLabel gearboxTypeLabel = new JLabel("Gearbox Type: "+car.getGearboxType());
        detailsFieldsPanel.add(gearboxTypeLabel);

        JLabel productionYearLabel = new JLabel("Production Year: "+car.getProductionYear());
        detailsFieldsPanel.add(productionYearLabel);

        JLabel registrationDateLabel = new JLabel("Registration Date: "+car.getRegistrationDate());
        detailsFieldsPanel.add(registrationDateLabel);

        JLabel insuranceDateLabel = new JLabel("Insurance Date: "+car.getInsuranceDate());
        detailsFieldsPanel.add(insuranceDateLabel);

        JLabel technicalTestDateLabel = new JLabel("Technical Test Date: "+car.getTechnicalTestDate());
        detailsFieldsPanel.add(technicalTestDateLabel);

        JLabel nextTiresChangeDateLabel = new JLabel("Next Tires Change Date: "+car.getNextTiresChangeDate());
        detailsFieldsPanel.add(nextTiresChangeDateLabel);

        JLabel nextOilChangeKmLabel = new JLabel("Next Oil Change Km: "+car.getNextOilChangeKm());
        detailsFieldsPanel.add(nextOilChangeKmLabel);

        detailsPanel.add(detailsFieldsPanel);

        return detailsPanel;
    }

    public JPanel makeTitlePanel() {
        JPanel garageNamePanel = new JPanel(new BorderLayout());
        JLabel garageNameLabel = new JLabel(garage.getName(), SwingConstants.CENTER);
        garageNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        garageNameLabel.setBorder(blackline);
        garageNamePanel.setSize(600, 200);
        garageNameLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        garageNamePanel.add(garageNameLabel);

        return garageNamePanel;
    }

    public JComboBox makeDropdownListWithCars(JPanel right, JPanel updateDeleteButtonsPanel, JPanel welcomePanel) {
        ArrayList<Car> vehicles =new ArrayList<>();
        vehicles.add(null);
        vehicles.addAll(garage.getVehicles());
        JComboBox vehiclesDropdown = new JComboBox(vehicles.toArray());
        vehiclesDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (vehiclesDropdown.getSelectedItem() != null) {
                    System.out.println("Changed to " + e.getItem());
                    selectedCar=(Car) vehiclesDropdown.getSelectedItem();
                    updateDeleteButtonsPanel.setVisible(true);
                    JPanel detailsPanel = makeCarDetailsPanel((Car) vehiclesDropdown.getSelectedItem());
                    right.removeAll();
                    right.add(detailsPanel);
                }else {
                    selectedCar=null;
                    updateDeleteButtonsPanel.setVisible(false);
                    right.removeAll();
                    right.add(welcomePanel);
                }
                right.repaint();
                pack();
            }
        });
        vehiclesDropdown.setPreferredSize(new Dimension(200, 50));

        return vehiclesDropdown;
    }

    public JPanel makeWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Hello! Please, choose a car from the garage.");
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        welcomePanel.add(welcomeLabel, BorderLayout.PAGE_START);
        return welcomePanel;
    }

    public JPanel makeAddPanel(JPanel right, JPanel welcomePanel, JComboBox vehiclesDropdown) {
        JPanel addPanel = new JPanel(new BorderLayout());
        JLabel addLabel = new JLabel("Add car");
        addLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        addPanel.add(addLabel, BorderLayout.PAGE_START);

        JPanel inputFieldsPanel = new JPanel(new GridLayout(8, 3));

        JLabel typeLabel = new JLabel("Type:");
        JTextField typeInput = new JTextField();
        inputFieldsPanel.add(typeLabel);
        inputFieldsPanel.add(typeInput);

        JLabel registerNumberLabel = new JLabel("Register number:");
        JTextField registerNumberInput = new JTextField();
        inputFieldsPanel.add(registerNumberLabel);
        inputFieldsPanel.add(registerNumberInput);

        JLabel brandLabel = new JLabel("Brand:");
        JTextField brandInput = new JTextField();
        inputFieldsPanel.add(brandLabel);
        inputFieldsPanel.add(brandInput);

        JLabel modelLabel = new JLabel("Model:");
        JTextField modelInput = new JTextField();
        inputFieldsPanel.add(modelLabel);
        inputFieldsPanel.add(modelInput);

//        JLabel imagePathLabel = new JLabel("Image Path:");
//        JTextField imagePathInput = new JTextField();
//        inputFieldsPanel.add(imagePathLabel);
//        inputFieldsPanel.add(imagePathInput);

        JLabel fuelConsumptionLabel = new JLabel("Fuel Consumption:");
        JTextField fuelConsumptionInput = new JTextField();
        inputFieldsPanel.add(fuelConsumptionLabel);
        inputFieldsPanel.add(fuelConsumptionInput);

        JLabel reservoirVolumeLabel = new JLabel("Reservoir Volume:");
        JTextField reservoirVolumeInput = new JTextField();
        inputFieldsPanel.add(reservoirVolumeLabel);
        inputFieldsPanel.add(reservoirVolumeInput);

        JLabel fuelTypeLabel = new JLabel("Fuel Type:");
        JComboBox fuelTypeInput = new JComboBox(new String[]{"diesel", "gas", "gasoline"});
        inputFieldsPanel.add(fuelTypeLabel);
        inputFieldsPanel.add(fuelTypeInput);

        JLabel powerLabel = new JLabel("Power:");
        JTextField powerInput = new JTextField();
        inputFieldsPanel.add(powerLabel);
        inputFieldsPanel.add(powerInput);

        JLabel gearboxTypeLabel = new JLabel("Gearbox Type:");
        JComboBox gearboxTypeInput = new JComboBox(new String[]{"manual", "automatic"});
        inputFieldsPanel.add(gearboxTypeLabel);
        inputFieldsPanel.add(gearboxTypeInput);

        JLabel productionYearLabel = new JLabel("Production Year:");
        JTextField productionYearInput = new JTextField();
        inputFieldsPanel.add(productionYearLabel);
        inputFieldsPanel.add(productionYearInput);

        JLabel registrationDateLabel = new JLabel("Registration Date (dd.mm.yyyy):");
        JTextField registrationDateInput = new JTextField();
        inputFieldsPanel.add(registrationDateLabel);
        inputFieldsPanel.add(registrationDateInput);

        JLabel insuranceDateLabel = new JLabel("Insurance Date (dd.mm.yyyy):");
        JTextField insuranceDateInput = new JTextField();
        inputFieldsPanel.add(insuranceDateLabel);
        inputFieldsPanel.add(insuranceDateInput);

        JLabel technicalTestDateLabel = new JLabel("Technical Test Date (dd.mm.yyyy):");
        JTextField technicalTestDateInput = new JTextField();
        inputFieldsPanel.add(technicalTestDateLabel);
        inputFieldsPanel.add(technicalTestDateInput);

        JLabel nextTiresChangeDateLabel = new JLabel("Next Tires Change Date (dd.mm.yyyy):");
        JTextField nextTiresChangeDateInput = new JTextField();
        inputFieldsPanel.add(nextTiresChangeDateLabel);
        inputFieldsPanel.add(nextTiresChangeDateInput);

        JLabel nextOilChangeKmLabel = new JLabel("Next Oil Change Km:");
        JTextField nextOilChangeKmInput = new JTextField();
        inputFieldsPanel.add(nextOilChangeKmLabel);
        inputFieldsPanel.add(nextOilChangeKmInput);

        addPanel.add(inputFieldsPanel);

        JButton addBtn = new JButton("Add car");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> carInfo = new HashMap<>();
                carInfo.put("type", typeInput.getText());
                carInfo.put("registerNumber", registerNumberInput.getText());
                carInfo.put("brand", brandInput.getText());
                carInfo.put("model", modelInput.getText());
//                carInfo.put("imagePath", imagePathInput.getText());
                carInfo.put("fuelConsumption", fuelConsumptionInput.getText());
                carInfo.put("reservoirVolume", reservoirVolumeInput.getText());
                carInfo.put("fuelType", fuelTypeInput.getSelectedItem().toString());
                carInfo.put("power", powerInput.getText());
                carInfo.put("gearboxType", gearboxTypeInput.getSelectedItem().toString());
                carInfo.put("productionYear", productionYearInput.getText());
                carInfo.put("registrationDate", registrationDateInput.getText());
                carInfo.put("insuranceDate", insuranceDateInput.getText());
                carInfo.put("technicalTestDate", technicalTestDateInput.getText());
                carInfo.put("nextTiresChangeDate", nextTiresChangeDateInput.getText());
                carInfo.put("nextOilChangeKm", nextOilChangeKmInput.getText());

                if (garage.isValidInfo(carInfo)) {
                    Car car = garage.addCar(carInfo);
                    vehiclesDropdown.addItem(car);
                    right.remove(addPanel);
                    right.add(welcomePanel);
                    right.repaint();
                    pack();

                    typeInput.setText("");
                    registerNumberInput.setText("");
                    brandInput.setText("");
                    modelInput.setText("");
//                    imagePathInput.setText("");
                    fuelConsumptionInput.setText("");
                    reservoirVolumeInput.setText("");
                    powerInput.setText("");
                    productionYearInput.setText("");
                    registrationDateInput.setText("");
                    insuranceDateInput.setText("");
                    technicalTestDateInput.setText("");
                    nextTiresChangeDateInput.setText("");
                    nextOilChangeKmInput.setText("");
                } else {
                    JDialog dialog = new JDialog();
                    JLabel l = new JLabel("Invalid input!");
                    dialog.add(l, SwingConstants.CENTER);
                    dialog.setSize(100, 100);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }

            }
        });
        addPanel.add(addBtn, BorderLayout.PAGE_END);

        return addPanel;
    }

    public JPanel makeUpdatePanel(Car selectedCar, JPanel right){
        JPanel updatePanel=new JPanel();
        JLabel updateLabel = new JLabel("Update car");
        updateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        updatePanel.add(updateLabel, BorderLayout.PAGE_START);

        JPanel updateFieldsPanel = new JPanel(new GridLayout(8, 3));

        JLabel typeLabel = new JLabel("Type:");
        JTextField typeInput = new JTextField();
        typeInput.setText(selectedCar.getType());
        updateFieldsPanel.add(typeLabel);
        updateFieldsPanel.add(typeInput);

        JLabel registerNumberLabel = new JLabel("Register number:");
        JTextField registerNumberInput = new JTextField();
        registerNumberInput.setText(selectedCar.getRegisterNumber());
        updateFieldsPanel.add(registerNumberLabel);
        updateFieldsPanel.add(registerNumberInput);

        JLabel brandLabel = new JLabel("Brand:");
        JTextField brandInput = new JTextField();
        brandInput.setText(selectedCar.getBrand());
        updateFieldsPanel.add(brandLabel);
        updateFieldsPanel.add(brandInput);

        JLabel modelLabel = new JLabel("Model:");
        JTextField modelInput = new JTextField();
        modelInput.setText(selectedCar.getModel());
        updateFieldsPanel.add(modelLabel);
        updateFieldsPanel.add(modelInput);

//        JLabel imagePathLabel = new JLabel("Image Path:");
//        JTextField imagePathInput = new JTextField();
//        imagePathInput.setText(selectedCar.getImagePath());
//        updateFieldsPanel.add(imagePathLabel);
//        updateFieldsPanel.add(imagePathInput);

        JLabel fuelConsumptionLabel = new JLabel("Fuel Consumption:");
        JTextField fuelConsumptionInput = new JTextField();
        fuelConsumptionInput.setText(String.valueOf(selectedCar.getFuelConsumption()));
        updateFieldsPanel.add(fuelConsumptionLabel);
        updateFieldsPanel.add(fuelConsumptionInput);

        JLabel reservoirVolumeLabel = new JLabel("Reservoir Volume:");
        JTextField reservoirVolumeInput = new JTextField();
        reservoirVolumeInput.setText(String.valueOf(selectedCar.getReservoirVolume()));
        updateFieldsPanel.add(reservoirVolumeLabel);
        updateFieldsPanel.add(reservoirVolumeInput);

        JLabel fuelTypeLabel = new JLabel("Fuel Type:");
        JComboBox fuelTypeInput = new JComboBox(new String[]{"diesel", "gas", "gasoline"});
        fuelTypeInput.setSelectedItem(selectedCar.getFuelType());
        updateFieldsPanel.add(fuelTypeLabel);
        updateFieldsPanel.add(fuelTypeInput);

        JLabel powerLabel = new JLabel("Power:");
        JTextField powerInput = new JTextField();
        powerInput.setText(String.valueOf(selectedCar.getPower()));
        updateFieldsPanel.add(powerLabel);
        updateFieldsPanel.add(powerInput);

        JLabel gearboxTypeLabel = new JLabel("Gearbox Type:");
        JComboBox gearboxTypeInput = new JComboBox(new String[]{"manual", "automatic"});
        gearboxTypeInput.setSelectedItem(selectedCar.getGearboxType());
        updateFieldsPanel.add(gearboxTypeLabel);
        updateFieldsPanel.add(gearboxTypeInput);

        JLabel productionYearLabel = new JLabel("Production Year:");
        JTextField productionYearInput = new JTextField();
        productionYearInput.setText(String.valueOf(selectedCar.getProductionYear()));
        updateFieldsPanel.add(productionYearLabel);
        updateFieldsPanel.add(productionYearInput);

        JLabel registrationDateLabel = new JLabel("Registration Date:");
        JTextField registrationDateInput = new JTextField();
        registrationDateInput.setText(selectedCar.getRegistrationDate());
        updateFieldsPanel.add(registrationDateLabel);
        updateFieldsPanel.add(registrationDateInput);

        JLabel insuranceDateLabel = new JLabel("Insurance Date:");
        JTextField insuranceDateInput = new JTextField();
        insuranceDateInput.setText(selectedCar.getInsuranceDate());
        updateFieldsPanel.add(insuranceDateLabel);
        updateFieldsPanel.add(insuranceDateInput);

        JLabel technicalTestDateLabel = new JLabel("Technical Test Date:");
        JTextField technicalTestDateInput = new JTextField();
        technicalTestDateInput.setText(selectedCar.getTechnicalTestDate());
        updateFieldsPanel.add(technicalTestDateLabel);
        updateFieldsPanel.add(technicalTestDateInput);

        JLabel nextTiresChangeDateLabel = new JLabel("Next Tires Change Date:");
        JTextField nextTiresChangeDateInput = new JTextField();
        nextTiresChangeDateInput.setText(selectedCar.getNextTiresChangeDate());
        updateFieldsPanel.add(nextTiresChangeDateLabel);
        updateFieldsPanel.add(nextTiresChangeDateInput);

        JLabel nextOilChangeKmLabel = new JLabel("Next Oil Change Km:");
        JTextField nextOilChangeKmInput = new JTextField();
        nextOilChangeKmInput.setText(String.valueOf(selectedCar.getNextOilChangeKm()));
        updateFieldsPanel.add(nextOilChangeKmLabel);
        updateFieldsPanel.add(nextOilChangeKmInput);

        JScrollPane scrollPane = new JScrollPane(updateFieldsPanel);

        updatePanel.add(scrollPane, BorderLayout.CENTER);

        JButton updateBtn = new JButton("Update car");
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> carInfo = new HashMap<>();
                carInfo.put("type", typeInput.getText());
                carInfo.put("registerNumber", registerNumberInput.getText());
                carInfo.put("brand", brandInput.getText());
                carInfo.put("model", modelInput.getText());
//                carInfo.put("imagePath", imagePathInput.getText());
                carInfo.put("fuelConsumption", fuelConsumptionInput.getText());
                carInfo.put("reservoirVolume", reservoirVolumeInput.getText());
                carInfo.put("fuelType", fuelTypeInput.getSelectedItem().toString());
                carInfo.put("power", powerInput.getText());
                carInfo.put("gearboxType", gearboxTypeInput.getSelectedItem().toString());
                carInfo.put("productionYear", productionYearInput.getText());
                carInfo.put("registrationDate", registrationDateInput.getText());
                carInfo.put("insuranceDate", insuranceDateInput.getText());
                carInfo.put("technicalTestDate", technicalTestDateInput.getText());
                carInfo.put("nextTiresChangeDate", nextTiresChangeDateInput.getText());
                carInfo.put("nextOilChangeKm", nextOilChangeKmInput.getText());

                if (garage.isValidInfo(carInfo)) {
                    garage.updateCar(selectedCar, carInfo);
                    right.remove(updatePanel);
                    JPanel detailsPanel = makeCarDetailsPanel(selectedCar);
                    right.add(detailsPanel);
                    right.repaint();
                    pack();
                } else {
                    JDialog dialog = new JDialog();
                    JLabel l = new JLabel("Invalid input!");
                    dialog.add(l, SwingConstants.CENTER);
                    dialog.setSize(100, 100);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }

            }
        });
        updatePanel.add(updateBtn, BorderLayout.PAGE_END);


        return updatePanel;
    }

    public JPanel makeSearchPanel(JPanel updateDeleteButtonsPanel, JPanel right){
        JPanel searchPanel=new JPanel(new BorderLayout());

        JPanel top=new JPanel(new BorderLayout());
        top.setPreferredSize(new Dimension(700, 200));

        JPanel titleCriteriaPanel=new JPanel(new BorderLayout());
        JLabel titleCriteria=new JLabel("Choose criteria:", SwingConstants.CENTER);
        titleCriteria.setFont(new Font("Serif", Font.PLAIN, 24));
        titleCriteriaPanel.add(titleCriteria, BorderLayout.CENTER);
        top.add(titleCriteriaPanel, BorderLayout.PAGE_START);

        JPanel infoCriteriaPanel=new JPanel(new BorderLayout());
        JLabel infoCriteria=new JLabel("<html>1) Register number<br/>2) Brand<br/>3) Model<br/>4) Insurance date<br/>5) Registration date<br/></html>", SwingConstants.CENTER);
        infoCriteria.setFont(new Font("Serif", Font.PLAIN, 20));
        infoCriteriaPanel.add(infoCriteria, BorderLayout.CENTER);
        top.add(infoCriteriaPanel, BorderLayout.CENTER);

        JPanel inputCriteriaPanel=new JPanel(new BorderLayout());
        JTextField inputCriteria=new JTextField();
        inputCriteria.setPreferredSize(new Dimension(400, 50));
        inputCriteriaPanel.add(inputCriteria);
        top.add(inputCriteriaPanel, BorderLayout.PAGE_END);

        searchPanel.add(top, BorderLayout.PAGE_START);


        JPanel bottom=new JPanel(new BorderLayout());
        bottom.setPreferredSize(new Dimension(700, 80));

        JPanel titleInputValuePanel=new JPanel(new BorderLayout());
        JLabel titleInputValue=new JLabel("Enter value:", SwingConstants.CENTER);
        titleInputValue.setFont(new Font("Serif", Font.PLAIN, 24));
        titleInputValuePanel.add(titleInputValue, BorderLayout.CENTER);
        bottom.add(titleInputValuePanel, BorderLayout.PAGE_START);

        JPanel inputValuePanel=new JPanel(new BorderLayout());
        JTextField inputValue=new JTextField();
        inputValue.setPreferredSize(new Dimension(400, 50));
        inputValuePanel.add(inputValue, BorderLayout.CENTER);
        bottom.add(inputValuePanel);

        searchPanel.add(bottom, BorderLayout.CENTER);


        JButton searchButton=new JButton("Search");
        searchButton.setPreferredSize(new Dimension(400, 50));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criteriaNumberInput=inputCriteria.getText();
                String valueInput=inputValue.getText();
                String criteria = switch (criteriaNumberInput) {
                    case "1" -> "number";
                    case "2" -> "brand";
                    case "3" -> "model";
                    case "4" -> "insurance";
                    case "5" -> "registration";
                    default -> "";
                };

                Car[] foundCars= garage.findCar(criteria, valueInput).toArray(new Car[0]);
                JScrollPane table=makeTableWithAllCars(foundCars);

                updateDeleteButtonsPanel.setVisible(false);
                right.removeAll();
                right.add(table, BorderLayout.CENTER);
                right.repaint();
                pack();

            }
        });


        searchPanel.add(searchButton, BorderLayout.PAGE_END);

        return searchPanel;
    }

    public JPanel makeUpdateDeleteButtonsPanel(JPanel right, JPanel left){
        JPanel updateDeleteButtonsPanel=new JPanel(new BorderLayout());
        JButton update=new JButton("Update car");
        JButton delete=new JButton("Delete car");
        update.setPreferredSize(new Dimension(200, 30));
        delete.setPreferredSize(new Dimension(200, 30));

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Update");
                JPanel updatePanel= makeUpdatePanel(selectedCar, right);
                right.removeAll();
                right.add(updatePanel);
                right.repaint();
                pack();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete");
                garage.removeCar(selectedCar);
                vehiclesDropdown.removeAllItems();
                for(Car c:garage.getVehicles()){
                    vehiclesDropdown.addItem(c);
                }
                selectedCar=null;
                left.repaint();
                right.repaint();
                pack();

            }
        });

        updateDeleteButtonsPanel.add(update, BorderLayout.PAGE_START);
        updateDeleteButtonsPanel.add(delete, BorderLayout.PAGE_END);

        updateDeleteButtonsPanel.setVisible(false);

        return updateDeleteButtonsPanel;
    }

    public JScrollPane makeTableWithAllCars(Car[] cars) {
        String[] columnNames = {"Type", "Register Number", "Brand", "Model", "Fuel Consumption", "Reservoir Volume",
                "Fuel Type", "Power", "Gearbox Type", "Production Year", "Registration Date", "Insurance Date",
                "Technical Test Date", "Next Tires Change Date", "Next Oil Change Km"};

        String[][] data = new String[cars.length][columnNames.length];

        int count = 0;
        for (Car car : cars) {
            String[] info = new String[columnNames.length];
            info[0] = car.getType();
            info[1] = car.getRegisterNumber();
            info[2] = car.getBrand();
            info[3] = car.getModel();
            info[4] = String.valueOf(car.getFuelConsumption());
            info[5] = String.valueOf(car.getReservoirVolume());
            info[6] = car.getFuelType();
            info[7] = String.valueOf(car.getPower());
            info[8] = car.getGearboxType();
            info[9] = String.valueOf(car.getProductionYear());
            info[10] = car.getRegistrationDate();
            info[11] = car.getInsuranceDate();
            info[12] = car.getTechnicalTestDate();
            info[13] = car.getNextTiresChangeDate();
            info[14] = String.valueOf(car.getNextOilChangeKm());

            data[count] = info;
            count += 1;
        }

        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setBorder(blackline);
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);

        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(60);
        tcm.getColumn(1).setPreferredWidth(120);
        tcm.getColumn(2).setPreferredWidth(60);
        tcm.getColumn(3).setPreferredWidth(60);
        tcm.getColumn(4).setPreferredWidth(130);
        tcm.getColumn(5).setPreferredWidth(130);
        tcm.getColumn(6).setPreferredWidth(80);
        tcm.getColumn(7).setPreferredWidth(60);
        tcm.getColumn(8).setPreferredWidth(110);
        tcm.getColumn(9).setPreferredWidth(140);
        tcm.getColumn(10).setPreferredWidth(140);
        tcm.getColumn(11).setPreferredWidth(140);
        tcm.getColumn(12).setPreferredWidth(140);
        tcm.getColumn(13).setPreferredWidth(140);
        tcm.getColumn(14).setPreferredWidth(140);


        return new JScrollPane(table);
    }

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);

        // title
        this.add(makeTitlePanel(), BorderLayout.NORTH);


        //Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel left = new JPanel(new BorderLayout());
        left.setPreferredSize(new Dimension(200, 500));
        left.setBorder(blackline);
        mainPanel.add(left, BorderLayout.LINE_START);

        JPanel right = new JPanel(new BorderLayout());
        right.setPreferredSize(new Dimension(700, 500));
        right.setBorder(blackline);
        mainPanel.add(right, BorderLayout.LINE_END);

        // Buttons panel
        JPanel addUpdateDeleteButtonsPanel = new JPanel(new BorderLayout());

        // Welcome panel and label for right panel
        JPanel welcomePanel = makeWelcomePanel();
        right.add(welcomePanel);

        // Update and delete buttons
        JPanel updateDeleteButtonsPanel=makeUpdateDeleteButtonsPanel(right, left);
        addUpdateDeleteButtonsPanel.add(updateDeleteButtonsPanel, BorderLayout.CENTER);

        // Dropdown
        vehiclesDropdown = makeDropdownListWithCars(right, updateDeleteButtonsPanel, welcomePanel);
        left.add(vehiclesDropdown, BorderLayout.PAGE_START);


        // Add car panel
        JPanel addPanel = makeAddPanel(right, welcomePanel, vehiclesDropdown);

        // Add button
        JButton add = new JButton("Add car");
        add.setPreferredSize(new Dimension(200, 30));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                updateDeleteButtonsPanel.setVisible(false);
                right.removeAll();
                right.add(addPanel);
                right.repaint();
                pack();
            }
        });
        addUpdateDeleteButtonsPanel.add(add, BorderLayout.PAGE_START);

        JPanel searchShowAllButtonsPanel=new JPanel(new BorderLayout());
        //Search button
        JButton search=new JButton("Search");
        search.setPreferredSize(new Dimension(200, 30));
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Search");
                JPanel searchPanel= makeSearchPanel(updateDeleteButtonsPanel, right);
                right.removeAll();
                right.add(searchPanel);
                right.repaint();
                pack();
            }
        });
        searchShowAllButtonsPanel.add(search, BorderLayout.PAGE_START);


        // Show all cars button
        JButton showAll = new JButton("Show all");
        showAll.setPreferredSize(new Dimension(200, 30));
        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show all clicked");
                updateDeleteButtonsPanel.setVisible(false);
                right.removeAll();
                right.add(makeTableWithAllCars(garage.getVehicles().toArray(new Car[0])), BorderLayout.CENTER);
                right.repaint();
                pack();
            }
        });
        searchShowAllButtonsPanel.add(showAll, BorderLayout.PAGE_END);

        JPanel buttonsPanel=new JPanel(new BorderLayout());
        buttonsPanel.add(addUpdateDeleteButtonsPanel, BorderLayout.PAGE_START);
        buttonsPanel.add(searchShowAllButtonsPanel, BorderLayout.PAGE_END);

        left.add(buttonsPanel, BorderLayout.PAGE_END);


        this.add(mainPanel);
        this.setVisible(true);
    }
}
