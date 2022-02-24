# Szoftverfejlesztő cég
Ebben a feladatban Szoftverfejlesztő cég működését fogjuk modellezni. 

Minden osztályodat a `hu.nive.ujratervezes.softwaredevcompany` package-ben kell létrehozni. 

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás
Implementáld az alábbi leírás szerinti programot:

### hu.nive.ujratervezes.softwaredevcompany.Worker
tulajdonságai:
- `int experience` megadja hogy mennyire tapasztalt a munkájában. Konstruktor segítségével beálítható kell legyen minden munkaválalónál.
Tartozik hozzá setter `void setExperience(int experience)` és getter `int getExperience()`.
- `boolean isBored` megadja hogy a munkaválaló megunta e a munkahelyét. Ha `false` akkor a munkaválaló motivált. 
Konstruktor segítségével nem állítható, minden munkaválaló motiváltan jöjjön létre.
Tartozik hozzá setter `void setBored(boolean bored)`, getter `boolean isBored()`.

Minden workeren meghívható kell legyen egy `void doWork(boolean isBoring)`
A metodus paramétere, hogy az elvégzendő munka unalmas e.
Amennyiben a munkaválaló motivált a metodus futásakor munkát fog végezni. Ha az elvégzendő munka unalmas akkor a munka elvégzése után a munkaválaló motivációját elveszti további munka elvégzésére.
Unalmas munka elvégzése esetén a munkaválaló tapasztalata `1`-el nő, míg ha a munka nem unalmas `2`-vel.

A munkaválalóknak két fajtája van `hu.nive.ujratervezes.softwaredevcompany.Developer` vagyis fejlesztő és `hu.nive.ujratervezes.softwaredevcompany.Manager`.

### hu.nive.ujratervezes.softwaredevcompany.Developer
Meghívható minden fejlesztőn a `void doPairProgramming(hu.nive.ujratervezes.softwaredevcompany.Developer otherDeveloper)` metodus. A metodus futásakor a fejlesztők pair programingoznak. Ezt végrehajtják motiváltságuktol függetlenül. 
Ilyenkor mindkét fejlesztő tapasztalata `1`-el nő.

### hu.nive.ujratervezes.softwaredevcompany.Manager
Meghívható minden manageren a `void motivateWorker(hu.nive.ujratervezes.softwaredevcompany.Worker worker)` metodus. Ennek hatására a manager motiválni fogja a paraméterben megadott munkaválalót függetlenül attol, hogy a manager motivált e.
A metodus futásakor a manager tapasztalati szintje nőjjön `1`-el és a paraméterben megadott munkaválaló váljon motiváltá ha eddig nem volt az.

### hu.nive.ujratervezes.softwaredevcompany.Company
Tárolni tudja a dolgozoi listáját amit a konstruktora paramétereként kap meg.
Meghívható minden cégen a `int companyExperience()` metódus ami `int`-ként vissza adja a cég dolgozoinak együtes tapasztalatát, vagyis az egyes dolgozok tapasztalatának összegét.

## Test-ek
```java
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
```
## Pontozás

A feladat 0 pontot ér, bármely alábbi esetben:
- le sem fordul az adott projekt.
- teszteset sem fut le sikeresen
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket
- ha kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg


Clean code-ra adható pontok: max 10

tesztekre adható pontok: 0.5 pont tesztenként.
