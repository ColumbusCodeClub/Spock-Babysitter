Spock's JUnit runner is Sputnik

Static fields should only be used for constants. Otherwise shared fields are preferable, because their semantics with respect to sharing are more well-defined.

Fixture Methods
def setup() {}          // run before every feature method
def cleanup() {}        // run after every feature method
def setupSpec() {}     // run before the first feature method
def cleanupSpec() {}   // run after the last feature method

PHASES
Feature Methods are the actual tests (def "test name")
Conceptually, a feature method consists of four phases:
- Set up the feature’s fixture
- Provide a stimulus to the system under specification
- Describe the response expected from the system
- Clean up the feature’s fixture

BLOCKS
1.) Setup - any setup work for the individual test
- The given: label is an alias for setup:, and sometimes leads to a more readable feature method description
2.) When/Then - always go together
- They describe a stimulus and the expected response. Whereas when blocks may contain arbitrary code, then blocks are restricted to conditions, exception conditions, interactions, and variable definitions. A feature method may contain multiple pairs of when-then blocks.
2.5) Expect
- As a guideline, use when-then to describe methods with side effects, and expect to describe purely functional methods.
3.) Where
- Where block always comes last in a method, and may not be repeated. It is used to write data-driven feature methods. 

EXTENSIONS
@Timeout    
Sets a timeout for execution of a feature or fixture method.

@Ignore 
Ignores a feature method.

@IgnoreRest 
Ignores all feature methods not carrying this annotation. Useful for quickly running just a single method.

@FailsWith  
Expects a feature method to complete abruptly. @FailsWith has two use cases: First, to document known bugs that cannot be resolved immediately. Second, to replace exception conditions in certain corner cases where the latter cannot be used (like specifying the behavior of exception conditions). In all other cases, exception conditions are preferable.



