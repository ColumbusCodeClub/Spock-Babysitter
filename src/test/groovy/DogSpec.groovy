import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class DogSpec extends Specification {

    def setup() {
        // Before each test runs
    }

    // No @Test annotation!
    def "dog can bark"() {         // feature method
        setup:                     // block
          Dog dog = new Dog()

        expect:
          dog.bark() == 'bark'      // No asserts needed!
    }

    def "dog can change names"() {
        given:                        // given is alias for setup
          Dog dog = new Dog(age:2)

        expect:
          dog.getOlder() == 3
    }

    def "a dog is 7 in dog years when it is 1 in human years"() {
        setup: "I create a dog"
          Dog dog = new Dog()

        when: "his age is set to 1"
          dog.age = 1

        then: "his age is 7 in dog years"
          dog.getAgeInDogYears() == 7
    }

    def "a dog is 14 in dog years when it is 2 in human years"() {
        setup: "I create a dog"
          Dog dog = new Dog()

        when: "his age is set to 2"
          dog.age = 2

        then: "his age is 7 in dog years"
          dog.getAgeInDogYears() == 14
    }

    def "a dog is 70 in dog years when it is 10 in human years"() {
        setup: "I create a dog"
          Dog dog = new Dog()

        when: "his age is set to 10"
          dog.age = 10

        then: "his age is 70 in dog years"
          dog.getAgeInDogYears() == 70
    }

    def "let's combine these all into one test"() {
        setup:
          Dog dog = new Dog()

        when:
          dog.age = 1

        then:
          dog.getAgeInDogYears() == 7

        when:
          dog.age = 2

        then:
          dog.getAgeInDogYears() == 14

        when:
          dog.age = 10

        then:
          dog.getAgeInDogYears() == 70
    }

    // Data driven testing!
    @Unroll
    def "a dog is #y in dog years when he is #x in human years"() {
        expect:
          new Dog(age: x).getAgeInDogYears() == y

        where:
          x  |  y                  // table header
          1  |  7                  // table rows -> iteration
          2  |  returnsAnswer()    // private methods are allowed here
          5  |  { -> 35}()         // and closure calls
          10 |  (70*2/2)           // and other Groovy code
    }

    def returnsAnswer() {
        14
    }

    def "throws an NPE"() {
        setup: "my dog has a null name"
          Dog dog = new Dog(name: null)

        when: "I call a method on a null object"
          dog.name.toLowerCase()

        then: "an NPE is thrown"
          thrown(NullPointerException)
    }

}
