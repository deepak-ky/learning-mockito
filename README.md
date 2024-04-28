# learning-mockito

1. **TodoBusinessImpl** is SUT or System Under Test
2. **todoService** is a Dependency

### Stub Method

1. Create a stub of the dependency and use that dependency, in this case we used `TodoServiceStub` in `TodoBusinessImplStubTest`
- Issues with Stubs 
* **Dynamic Conditions :** When writing new test cases , more logic needs to be written in the `TodoServiceStub` ( a list with no "spring" todos).  
   The stub class would start growing a lot.
* **Service Definition :** In this case, whenever a new method is added in the `TodoService` interface , the `TodoServiceStub` needs to implement that.
2. Stubs are useful in very simple scenarios.

### Mocking

1. Mocking is creating objects **that simulate the behaviour of real objects.**
2. Unlike stubs, mocks can be dynamically created from code - at runtime.
3. Mocks offer more functionality than stubbing.

### Behaviour Driven Development (BDD)

1. Given (`given` and `willReturn`)
2. When - actual method call
3. Then (`assertThat` and `is`)

### Points
- Mockito Mocks are nice, if you don't tell them what to do, they return defaults
- When a expectation for a method is not set and that particular method is invoked on a mock object,  
  default values are returned.