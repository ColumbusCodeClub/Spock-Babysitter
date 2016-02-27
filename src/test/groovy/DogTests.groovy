import org.junit.*

class DogTests {

    @Test
    void 'You can write Groovy tests using Java syntax (without semicolons!)'() {    // Note test names
        Dog dog = new Dog()
        dog.name = 'Billy the Dog'
        dog.age = 2

        Assert.assertEquals('Billy the Dog', dog.getName())
        Assert.assertEquals(2, dog.getAge())
    }

    @Test
    void 'Groovy with blocks are groovy'() {
        def dog = new Dog()
        dog.with {
            name = 'General Woofmeister'
            age = 4
            getOlder()
        }

        assert dog.name == 'General Woofmeister'       // Power assertions
        assert dog.age == 5                            // Accessing private fields
    }

    @Test
    void 'Groovy has named parameter constructors'() {
        def dog = new Dog(name: 'Sir Poops-a-lot', age: 17)

        assert dog.name == 'Sir Poops-a-lot'
        assert dog.age == 17
    }

    @Test
    void 'Groovy has map coercion()'() {
        def dog = [name: 'Madam Muddy Paws', age: 52] as Dog

        assert dog.name == 'Madam Muddy Paws'
        assert dog.age == 52
    }

    @Test
    void 'Groovy has easy method mocking'() {
        def dog = [bark: { 'newBarkValue' }, dig: { 'newDigValue' }] as Dog

        assert dog.bark() == 'newBarkValue'
        assert dog.dig() == 'newDigValue'
    }

    @Test
    void 'mock ALL method behaviors'() {
        def dog = { 'returnValueForAllMethods' } as Dog

        assert dog.bark() == 'returnValueForAllMethods'
        assert dog.dig() == 'returnValueForAllMethods'
    }

}
