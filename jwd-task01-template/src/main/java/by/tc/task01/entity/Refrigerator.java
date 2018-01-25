package by.tc.task01.entity;

public class Refrigerator extends Appliance {
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private int height;
    private int width;

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refrigerator that = (Refrigerator) o;

        if (powerConsumption != that.powerConsumption) return false;
        if (weight != that.weight) return false;
        if (freezerCapacity != that.freezerCapacity) return false;
        if (Double.compare(that.overallCapacity, overallCapacity) != 0) return false;
        if (height != that.height) return false;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + freezerCapacity;
        temp = Double.doubleToLongBits(overallCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }
}