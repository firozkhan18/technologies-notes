Java design patterns are solutions to common software design problems and provide reusable templates for building robust applications. These patterns are broadly categorized into three types: **Creational**, **Structural**, and **Behavioral**. Below is a detailed explanation of each pattern, including code examples, real-time applications, and potential interview questions.

### 1. Creational Design Patterns

**Creational Design Patterns** deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. These patterns abstract the instantiation process and make it more flexible.

#### **1.1 Singleton Pattern**

**Definition**: Ensures that a class has only one instance and provides a global point of access to it.

**Code Example**:
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**Real-Time Example**: Database connection pool management, where only one instance manages connections.

**Interview Questions**:
1. How does the Singleton pattern ensure that only one instance of a class is created?
2. What are the potential issues with the Singleton pattern, and how can they be addressed?

#### **1.2 Factory Method Pattern**

**Definition**: Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.

**Code Example**:
```java
// Product interface
interface Product {
    void create();
}

// Concrete Product A
class ConcreteProductA implements Product {
    public void create() {
        System.out.println("ConcreteProductA created");
    }
}

// Concrete Product B
class ConcreteProductB implements Product {
    public void create() {
        System.out.println("ConcreteProductB created");
    }
}

// Creator interface
abstract class Creator {
    public abstract Product factoryMethod();
}

// Concrete Creator A
class ConcreteCreatorA extends Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// Concrete Creator B
class ConcreteCreatorB extends Creator {
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
```

**Real-Time Example**: UI libraries where different operating systems may have different button styles.

**Interview Questions**:
1. How does the Factory Method pattern differ from the Singleton pattern?
2. Can you describe a scenario where using the Factory Method pattern would be advantageous?

#### **1.3 Abstract Factory Pattern**

**Definition**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Code Example**:
```java
// Abstract Factory
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
    public ProductA createProductA() {
        return new ProductA1();
    }
    public ProductB createProductB() {
        return new ProductB1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements AbstractFactory {
    public ProductA createProductA() {
        return new ProductA2();
    }
    public ProductB createProductB() {
        return new ProductB2();
    }
}

// Abstract Products
interface ProductA {}
interface ProductB {}

// Concrete Products
class ProductA1 implements ProductA {}
class ProductB1 implements ProductB {}
class ProductA2 implements ProductA {}
class ProductB2 implements ProductB {}
```

**Real-Time Example**: Creating different types of user interfaces for different platforms (Windows, macOS).

**Interview Questions**:
1. How does the Abstract Factory pattern differ from the Factory Method pattern?
2. In what situations would you use the Abstract Factory pattern?

#### **1.4 Builder Pattern**

**Definition**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

**Code Example**:
```java
// Product
class Product {
    private String partA;
    private String partB;

    public void setPartA(String partA) { this.partA = partA; }
    public void setPartB(String partB) { this.partB = partB; }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + "]";
    }
}

// Builder Interface
interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}

// Concrete Builder
class ConcreteBuilder implements Builder {
    private Product product = new Product();

    public void buildPartA() {
        product.setPartA("PartA");
    }

    public void buildPartB() {
        product.setPartB("PartB");
    }

    public Product getResult() {
        return product;
    }
}

// Director
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
    }
}
```

**Real-Time Example**: Building a complex document with different sections.

**Interview Questions**:
1. How does the Builder pattern improve the creation of complex objects?
2. What are the advantages of using the Builder pattern over other creational patterns?

#### **1.5 Prototype Pattern**

**Definition**: Creates new objects by copying an existing object, known as the prototype.

**Code Example**:
```java
// Prototype interface
interface Prototype extends Cloneable {
    Prototype clone();
}

// Concrete Prototype
class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }

    @Override
    public String toString() {
        return "ConcretePrototype [field=" + field + "]";
    }
}
```

**Real-Time Example**: Cloning objects in a drawing application, where each shape can be cloned.

**Interview Questions**:
1. How does the Prototype pattern handle object cloning?
2. What are the advantages and potential issues of using the Prototype pattern?

### 2. Structural Design Patterns

**Structural Design Patterns** deal with object composition, creating relationships between objects to form larger structures.

#### **2.1 Adapter Pattern**

**Definition**: Allows incompatible interfaces to work together by wrapping an existing class with a new interface.

**Code Example**:
```java
// Target Interface
interface Target {
    void request();
}

// Adaptee
class Adaptee {
    void specificRequest() {
        System.out.println("Specific request");
    }
}

// Adapter
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}
```

**Real-Time Example**: Adapting legacy systems to work with modern interfaces.

**Interview Questions**:
1. How does the Adapter pattern work in converting one interface to another?
2. Can you provide an example of when the Adapter pattern would be useful?

#### **2.2 Bridge Pattern**

**Definition**: Separates abstraction from implementation, allowing the two to vary independently.

**Code Example**:
```java
// Abstraction
abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}

// Refined Abstraction
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    void operation() {
        implementor.implementation();
    }
}

// Implementor Interface
interface Implementor {
    void implementation();
}

// Concrete Implementor
class ConcreteImplementor implements Implementor {
    public void implementation() {
        System.out.println("Concrete implementation");
    }
}
```

**Real-Time Example**: Separating the abstraction of a user interface from the actual implementation.

**Interview Questions**:
1. How does the Bridge pattern facilitate the separation of concerns?
2. What are the benefits of using the Bridge pattern in complex systems?

#### **2.3 Composite Pattern**

**Definition**: Composes objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

**Code Example**:
```java
// Component
interface Component {
    void operation();
}

// Leaf
class Leaf implements Component {
    public void operation() {
        System.out.println("Leaf operation");
    }
}

// Composite
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
```

**Real-Time Example**: Filesystem where files and directories are treated uniformly.

**Interview Questions**:
1. How does the Composite pattern help manage hierarchical structures?
2. Can you describe a situation where the Composite pattern would be applied effectively?

#### **2.4 Decorator Pattern**

**Definition**: Allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

**Code Example**:
```java
// Component
interface Component {
    void operation();
}

// Concrete Component
class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

// Decorator
abstract class Decorator implements Component {
    protected Component component;

    protected Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

// Concrete Decorator
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);


    }

    public void operation() {
        super.operation();
        System.out.println("ConcreteDecorator additional operation");
    }
}
```

**Real-Time Example**: Adding additional responsibilities to a window or a stream object.

**Interview Questions**:
1. How does the Decorator pattern enhance the flexibility of adding features to objects?
2. What are the advantages of using the Decorator pattern compared to subclassing?

#### **2.5 Flyweight Pattern**

**Definition**: Reduces the cost of creating and manipulating a large number of similar objects by sharing common parts of state between them.

**Code Example**:
```java
// Flyweight Interface
interface Flyweight {
    void operation();
}

// Concrete Flyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String state) {
        this.intrinsicState = state;
    }

    public void operation() {
        System.out.println("ConcreteFlyweight with state " + intrinsicState);
    }
}

// Flyweight Factory
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}
```

**Real-Time Example**: Managing a large number of UI elements with shared properties.

**Interview Questions**:
1. How does the Flyweight pattern optimize memory usage?
2. Can you provide an example where the Flyweight pattern would be beneficial?

### 3. Behavioral Design Patterns

**Behavioral Design Patterns** focus on communication between objects, what goes on between objects and how they operate together.

#### **3.1 Chain of Responsibility Pattern**

**Definition**: Allows multiple objects to handle a request without the sender needing to know which object will handle the request. The request is passed along a chain of potential handlers.

**Code Example**:
```java
// Handler
abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(int request);
}

// Concrete Handler
class ConcreteHandlerA extends Handler {
    public void handleRequest(int request) {
        if (request < 10) {
            System.out.println("Handler A handled request " + request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

// Concrete Handler
class ConcreteHandlerB extends Handler {
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("Handler B handled request " + request);
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
```

**Real-Time Example**: Processing a sequence of validation checks on a user input.

**Interview Questions**:
1. How does the Chain of Responsibility pattern help in processing requests?
2. Can you describe a scenario where the Chain of Responsibility pattern would be useful?

#### **3.2 Command Pattern**

**Definition**: Encapsulates a request as an object, thereby allowing parameterization of clients with queues, requests, and operations.

**Code Example**:
```java
// Command Interface
interface Command {
    void execute();
}

// Concrete Command
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();
    }
}

// Receiver
class Receiver {
    public void action() {
        System.out.println("Receiver action performed");
    }
}

// Invoker
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
```

**Real-Time Example**: Implementing undo functionality in applications where actions can be reversed.

**Interview Questions**:
1. How does the Command pattern decouple the sender from the receiver of a request?
2. What are the advantages of using the Command pattern in a system?

#### **3.3 Interpreter Pattern**

**Definition**: Provides a way to evaluate language grammar or expression by defining a grammar and an interpreter to interpret sentences in the language.

**Code Example**:
```java
// Expression Interface
interface Expression {
    boolean interpret(String context);
}

// Terminal Expression
class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        return context.contains(data);
    }
}

// Or Expression
class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
```

**Real-Time Example**: Parsing and evaluating expressions or commands in a scripting language.

**Interview Questions**:
1. How does the Interpreter pattern help in evaluating expressions or languages?
2. Can you provide an example of a situation where the Interpreter pattern would be applicable?

#### **3.4 Iterator Pattern**

**Definition**: Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

**Code Example**:
```java
// Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Aggregate Interface
interface Aggregate {
    Iterator createIterator();
}

// Concrete Iterator
class ConcreteIterator implements Iterator {
    private ConcreteAggregate aggregate;
    private int index = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    public boolean hasNext() {
        return index < aggregate.getSize();
    }

    public Object next() {
        return aggregate.getElement(index++);
    }
}

// Concrete Aggregate
class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    public void addItem(Object item) {
        items.add(item);
    }

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int getSize() {
        return items.size();
    }

    public Object getElement(int index) {
        return items.get(index);
    }
}
```

**Real-Time Example**: Traversing a collection of items like elements in a list or nodes in a tree.

**Interview Questions**:
1. How does the Iterator pattern facilitate the traversal of a collection?
2. Can you describe a situation where the Iterator pattern would be useful?

#### **3.5 Mediator Pattern**

**Definition**: Defines an object that encapsulates how a set of objects interact, promoting loose coupling by preventing objects from referring to each other explicitly.

**Code Example**:
```java
// Mediator Interface
interface Mediator {
    void send(String message, Colleague colleague);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private ColleagueA colleagueA;
    private ColleagueB colleagueB;

    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    public void send(String message, Colleague colleague) {
        if (colleague == colleagueA) {
            colleagueB.receive(message);
        } else {
            colleagueA.receive(message);
        }
    }
}

// Colleague Interface
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

// Concrete Colleague A
class ColleagueA extends Colleague {
    public ColleagueA(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println("ColleagueA received: " + message);
    }
}

// Concrete Colleague B
class ColleagueB extends Colleague {
    public ColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println("ColleagueB received: " + message);
    }
}
```

**Real-Time Example**: Coordinating communication between components in a chat application.

**Interview Questions**:
1. How does the Mediator pattern help in managing communication between objects?
2. What are the advantages of using the Mediator pattern in a complex system?

#### **3.6 Memento Pattern**

**Definition**: Allows capturing and restoring an object's internal state without violating encapsulation.

**Code Example**:
```java
// Originator
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

// Memento
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Caretaker
class Caretaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}
```

**Real-Time Example**: Implementing undo functionality in a text editor.

**Interview Questions**:
1. How does the Memento pattern

 enable object state restoration?
2. What are the benefits of using the Memento pattern for undo operations?

#### **3.7 Observer Pattern**

**Definition**: Defines a dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

**Code Example**:
```java
// Observer Interface
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}
```

**Real-Time Example**: Implementing event listeners in GUI applications.

**Interview Questions**:
1. How does the Observer pattern facilitate communication between objects?
2. Can you describe a real-world scenario where the Observer pattern is particularly useful?

#### **3.8 Strategy Pattern**

**Definition**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

**Code Example**:
```java
// Strategy Interface
interface Strategy {
    int execute(int a, int b);
}

// Concrete Strategies
class ConcreteStrategyAdd implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

class ConcreteStrategySubtract implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}

// Context
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
```

**Real-Time Example**: Implementing different sorting algorithms in a sorting application.

**Interview Questions**:
1. How does the Strategy pattern promote flexibility and reusability?
2. Can you describe a use case where the Strategy pattern would be advantageous?

#### **3.9 Template Method Pattern**

**Definition**: Defines the skeleton of an algorithm in a base class but lets subclasses override specific steps of the algorithm without changing its structure.

**Code Example**:
```java
// Abstract Class
abstract class AbstractClass {
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();
    protected abstract void step2();

    private void step3() {
        System.out.println("Common step");
    }
}

// Concrete Class
class ConcreteClass extends AbstractClass {
    protected void step1() {
        System.out.println("Step 1 implementation");
    }

    protected void step2() {
        System.out.println("Step 2 implementation");
    }
}
```

**Real-Time Example**: Defining a general workflow in a data processing application where specific steps may vary.

**Interview Questions**:
1. How does the Template Method pattern ensure that certain steps of an algorithm remain unchanged while others can be customized?
2. Can you provide an example of when the Template Method pattern would be useful?

#### **3.10 Visitor Pattern**

**Definition**: Represents an operation to be performed on elements of an object structure without changing the classes of the elements on which it operates.

**Code Example**:
```java
// Visitor Interface
interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}

// Element Interface
interface Element {
    void accept(Visitor visitor);
}

// Concrete Element A
class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("ConcreteElementA operation");
    }
}

// Concrete Element B
class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("ConcreteElementB operation");
    }
}

// Concrete Visitor
class ConcreteVisitor implements Visitor {
    public void visit(ConcreteElementA elementA) {
        elementA.operationA();
    }

    public void visit(ConcreteElementB elementB) {
        elementB.operationB();
    }
}
```

**Real-Time Example**: Applying operations on different types of documents (PDF, Word) without changing their classes.

**Interview Questions**:
1. How does the Visitor pattern support adding new operations to existing object structures?
2. Can you provide an example where the Visitor pattern would be particularly useful?

---

These design patterns are fundamental for solving common software design issues. Familiarity with these patterns and their appropriate use cases can significantly enhance the design and maintainability of your applications.
