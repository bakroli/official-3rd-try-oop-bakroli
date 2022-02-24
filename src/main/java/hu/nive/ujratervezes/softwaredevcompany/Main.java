package hu.nive.ujratervezes.softwaredevcompany;

public class Main {

    public static void main(String[] args) {
        Worker roli = new Worker(12);
        System.out.println(roli.getExperience() + ", " + roli.isBored());
        roli.doWork(false);
        System.out.println(roli.getExperience() + ", " + roli.isBored());
        roli.doWork(true);
        System.out.println(roli.getExperience() + ", " + roli.isBored());
    }
}
