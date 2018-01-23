package by.tc.task01.entity;

public class VacuumCleaner extends Appliance {
    private int powerConsumption;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private String filterType;
    private int cleaningWidth;

    public int getCleaningWidth() {
        return cleaningWidth;
    }


    public int getpowerConsumption() {
        return powerConsumption;
    }

    public String getbagType() {
        return bagType;
    }

    public String getwandType() {
        return wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public String getfilterType() {
        return filterType;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    @Override
    public String toString() {
        return "\n\t\t\tVacuumCleaner\t\t\t\n" +
                "powerConsumption=" + powerConsumption +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", MotorSpeedRegulation=" + motorSpeedRegulation +
                ", filterType='" + filterType + '\'' +
                ", CleaningWidth=" + cleaningWidth
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (powerConsumption != that.powerConsumption) return false;
        if (motorSpeedRegulation != that.motorSpeedRegulation) return false;
        if (cleaningWidth != that.cleaningWidth) return false;
        if (bagType != null ? !bagType.equals(that.bagType) : that.bagType != null) return false;
        if (wandType != null ? !wandType.equals(that.wandType) : that.wandType != null) return false;
        return filterType != null ? filterType.equals(that.filterType) : that.filterType == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + (bagType != null ? bagType.hashCode() : 0);
        result = 31 * result + (wandType != null ? wandType.hashCode() : 0);
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        result = 31 * result + cleaningWidth;
        return result;
    }
}