package Jobsheet1;

public class JamDinding extends Jam {
    private String bentukBingkai;
    private int diameterCm;

    public void setBentukBingkai(String bentuk) {
        this.bentukBingkai = bentuk;
    }

    public void setDiameter(int diameter) {
        this.diameterCm = diameter;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Bentuk Bingkai: " + bentukBingkai);
        System.out.println("Diameter: " + diameterCm + " cm");
    }
}