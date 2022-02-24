package hu.nive.ujratervezes.softwaredevcompany;

import java.util.ArrayList;
import java.util.List;

public class Company {
    List<Worker> workerList = new ArrayList<>();

    public Company(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public int companyExperience() {
        int sumExperience = 0;
        for (Worker worker : workerList) {
            sumExperience += worker.getExperience();
        }
        return sumExperience;
    }
}
