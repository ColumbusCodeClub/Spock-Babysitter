public class Dog {

    String name;
    int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String bark() {
        return "bark";
    }

    public String dig() {
        return "dig";
    }

    public int getOlder() {
        return ++age;
    }

    public int getAgeInDogYears() {
        return age*7;
    }

}
