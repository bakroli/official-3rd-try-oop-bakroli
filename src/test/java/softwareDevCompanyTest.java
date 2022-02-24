import hu.nive.ujratervezes.softwaredevcompany.Company;
import hu.nive.ujratervezes.softwaredevcompany.Developer;
import hu.nive.ujratervezes.softwaredevcompany.Manager;
import hu.nive.ujratervezes.softwaredevcompany.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class softwareDevCompanyTest {

    @Test
    void test_developerMotivatedByDefault(){
        Worker developer = new Developer(3);
        assertFalse(developer.isBored());
    }

    @Test
    void test_workerMotivatedByDefault(){
        Worker manager = new Manager(3);
        assertFalse(manager.isBored());
    }

    @Test
    void test_developerCanBeSetToBeBored(){
        Worker developer = new Developer(3);
        developer.setBored(true);
        assertTrue(developer.isBored());
    }

    @Test
    void test_workerCanBeSetToBeBored(){
        Worker manager = new Manager(3);
        manager.setBored(true);
        assertTrue(manager.isBored());
    }

    @Test
    void test_workerConstructorWorks(){
        Worker manager = new Manager(5);
        Assertions.assertEquals(5,manager.getExperience());
    }

    @Test
    void test_boredDeveloperDoBoringWork(){
        Worker developer = new Developer(3);
        developer.setBored(true);
        developer.doWork(true);
        Assertions.assertEquals(3,developer.getExperience());
        assertTrue(developer.isBored());
    }

    @Test
    void test_boredDeveloperDoInterestingWork(){
        Worker developer = new Developer(3);
        developer.setBored(true);
        developer.doWork(false);
        Assertions.assertEquals(3,developer.getExperience());
        assertTrue(developer.isBored());
    }

    @Test
    void test_motivatedDeveloperDoInterestingWork(){
        Worker developer = new Developer(3);
        developer.setBored(false);
        developer.doWork(false);
        Assertions.assertEquals(5,developer.getExperience());
        assertFalse(developer.isBored());
    }

    @Test
    void test_motivatedDeveloperDoBoringWork(){
        Worker developer = new Developer(3);
        developer.setBored(false);
        developer.doWork(true);
        Assertions.assertEquals(4,developer.getExperience());
        assertTrue(developer.isBored());
    }

    @Test
    void test_boredManagerDoBoringWork(){
        Worker manager = new Manager(3);
        manager.setBored(true);
        manager.doWork(true);
        Assertions.assertEquals(3,manager.getExperience());
        assertTrue(manager.isBored());
    }

    @Test
    void test_boredManagerDoInterestingWork(){
        Worker manager = new Manager(3);
        manager.setBored(true);
        manager.doWork(false);
        Assertions.assertEquals(3,manager.getExperience());
        assertTrue(manager.isBored());
    }

    @Test
    void test_motivatedManagerDoInterestingWork(){
        Worker manager = new Manager(3);
        manager.setBored(false);
        manager.doWork(false);
        Assertions.assertEquals(5,manager.getExperience());
        assertFalse(manager.isBored());
    }

    @Test
    void test_motivatedManagerDoBoringWork(){
        Worker manager = new Manager(3);
        manager.setBored(false);
        manager.doWork(true);
        Assertions.assertEquals(4,manager.getExperience());
        assertTrue(manager.isBored());
    }

    @Test
    void test_managerMotivatesBoredDeveloper(){
        Worker developer = new Developer(2);
        Manager manager = new Manager(3);
        developer.setBored(true);
        manager.motivateWorker(developer);
        assertFalse(developer.isBored());
        Assertions.assertEquals(4,manager.getExperience());
    }

    @Test
    void test_managerMotivatesAlreadyMotivatedDeveloper(){
        Worker developer = new Developer(2);
        Manager manager = new Manager(3);
        developer.setBored(false);
        manager.motivateWorker(developer);
        assertFalse(developer.isBored());
        Assertions.assertEquals(4,manager.getExperience());
    }

    @Test
    void test_managerMotivatesBoredManager(){
        Manager boredManager = new Manager(2);
        Manager manager = new Manager(3);
        boredManager.setBored(true);
        manager.motivateWorker(boredManager);
        assertFalse(boredManager.isBored());
        Assertions.assertEquals(4,manager.getExperience());
    }

    @Test
    void test_managerMotivatesAlreadyMotivatedManager(){
        Manager motivatedManager = new Manager(2);
        Manager manager = new Manager(3);
        motivatedManager.setBored(false);
        manager.motivateWorker(motivatedManager);
        assertFalse(motivatedManager.isBored());
        Assertions.assertEquals(4,manager.getExperience());
    }

    @Test
    void test_twoBoredDevelopersDoPairProgramming(){
        Developer navigator = new Developer(5);
        Developer driver = new Developer(3);
        navigator.setBored(true);
        driver.setBored(true);
        navigator.doPairProgramming(driver);
        Assertions.assertEquals(6, navigator.getExperience());
        Assertions.assertEquals(4, driver.getExperience());
    }

    @Test
    void test_twoMotivatedDevelopersDoPairProgramming(){
        Developer navigator = new Developer(5);
        Developer driver = new Developer(3);
        navigator.setBored(false);
        driver.setBored(false);
        navigator.doPairProgramming(driver);
        Assertions.assertEquals(6, navigator.getExperience());
        Assertions.assertEquals(4, driver.getExperience());
    }

    @Test
    void test_companyExperience(){
        List<Worker> workers = new ArrayList<>(){{
            add(new Manager(3));
            add(new Developer(6));
            add(new Developer(10));
        }};
        Company company = new Company(workers);
        Assertions.assertEquals(19, company.companyExperience());
    }
}
