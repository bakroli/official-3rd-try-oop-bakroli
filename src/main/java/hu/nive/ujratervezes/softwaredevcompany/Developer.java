package hu.nive.ujratervezes.softwaredevcompany;

public class Developer extends Worker {

    public Developer(int experience) {
        super(experience);
    }

    public void doPairProgramming(Developer developer) {
        this.setExperience(this.getExperience() + 1);
        developer.setExperience(developer.getExperience() + 1);
    }


}
