package hu.nive.ujratervezes.softwaredevcompany;

public class Manager extends Worker{
    public Manager(int experience) {
        super(experience);
    }

    public void motivateWorker(Worker worker) {
        worker.setBored(false);
        this.setExperience(this.getExperience() + 1);
    }

}
