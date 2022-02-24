package hu.nive.ujratervezes.softwaredevcompany;

public class Worker {
    private int experience;
    private boolean isBored;

    public Worker(int experience) {
        this.experience = experience;
        this.isBored = false;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isBored() {
        return isBored;
    }

    public void setBored(boolean bored) {
        isBored = bored;
    }

    public void doWork(boolean isBoring) {
        if (!this.isBored) {
            if (!isBoring) {
                this.experience += 2;
            } else {
                this.experience += 1;
            }
        }
        if (isBoring) {
            this.isBored = true;
        }
    }


}
