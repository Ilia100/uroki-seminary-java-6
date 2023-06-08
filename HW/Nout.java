package HW;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Nout {

    private String compName;
    private String compManufacturer;
    private LocalDate dateOfManufacture;
    private Integer RAMSize;
    private Integer hardDriveCapacity;
    private String CPUManufacturer;
    private String CPUModel;
    private String GPUManufacturer;
    private String GPUModel;
    private Integer vRAM;
    private String operatingSystem;
    private String color;
    


    public Nout(String compName, String compManufacturer, LocalDate dateOfManufacture, Integer RAMSize,
            Integer hardDriveCapacity, String CPUManufacturer, String CPUModel, String GPUManufacturer,
            String GPUModel, Integer vRAM, String operatingSystem, String color) {

        this.compName = compName;
        this.compManufacturer = compManufacturer;
        this.dateOfManufacture = dateOfManufacture;
        this.RAMSize = RAMSize;
        this.hardDriveCapacity = hardDriveCapacity;
        this.CPUManufacturer = CPUManufacturer;
        this.CPUModel = CPUModel;
        this.GPUManufacturer = GPUManufacturer;
        this.GPUModel = GPUModel;
        this.vRAM = vRAM;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompManufacturer() {
        return compManufacturer;
    }

    public void setCompManufacturer(String compManufacturer) {
        this.compManufacturer = compManufacturer;
    }

    public LocalDate getDateOfManufacture() {
            return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {

        this.dateOfManufacture = dateOfManufacture;
    }

    public Integer getRAMSize() {
        return RAMSize;
    }

    public void setRAMSize(Integer RAMSize) {
        RAMSize = RAMSize;
    }

    public Integer getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(Integer hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public String getCPUManufacturer() {
        return CPUManufacturer;
    }

    public void setCPUManufacturer(String CPUManufacturer) {
        CPUManufacturer = CPUManufacturer;
    }

    public Integer getCPUModel() {
        return CPUModel;
    }

    public void setCPUModel(Integer CPUModel) {
        CPUModel = CPUModel;
    }

    public String getGPUManufacturer() {
        return GPUManufacturer;
    }

    public void setGPUManufacturer(String GPUManufacturer) {
        GPUManufacturer = GPUManufacturer;
    }

    public String getGPUModel() {
        return GPUModel;
    }

    public void setGPUModel(String GPUModel) {
        GPUModel = GPUModel;
    }

    public Integer getvRAM() {
        return vRAM;
    }

    public void setvRAM(Integer vRAM) {
        this.vRAM = vRAM;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "\n\n Computer Specification: \n Model = " + compName + " , Brand = " + compManufacturer +
        ", Date Of manufacture = " + dateOfManufacture.format(dtf) + ", \n RAM Size = " + RAMSize + 
        " GB, Hard drive size = " + hardDriveCapacity + " GB, \n CPU Manufacturer = " + CPUManufacturer + 
        ", CPU Model = " + CPUModel + ",\n GPU Manufacturer = " + GPUManufacturer + ", GPU Model = " + GPUModel +
        ", GPU Memory = " + vRAM + " GB, \n Operating system instaled = " + operatingSystem + ", Color = " + color;
    }





}
