# Prototype Design Pattern

The Prototype Design Pattern is a creational pattern that enables the creation of new objects by copying an existing object. This pattern allows us to hide the complexity of making new instances from the client. The concept is to copy an existing object rather than create a new instance from scratch, which may involve costly operations. The existing object acts as a prototype and contains the state of the object.

![Prototype Pattern Copy](prototype-pattern-copy)

The newly copied object may change the same properties only if required. This approach saves costly resources and time, especially when object creation is a heavy process. The Prototype pattern is required when object creation is time-consuming and costly, allowing for the creation of objects based on existing objects.

One of the best ways to create an object from existing objects is through the `clone()` method. The `clone` method is the simplest approach to implementing the Prototype pattern. However, it is up to the developer to decide how to copy existing objects based on their business model.

For instance, suppose a user creates a document with a specific layout, fonts, and styling, and wishes to create similar documents with slight modifications. Instead of starting from scratch each time, the user can use the Prototype pattern. The original document becomes the prototype, and new documents are created by cloning this prototype. This approach ensures that the new documents inherit the structure and styling of the original document while allowing for customization.

## Important Topics for the Prototype Design Pattern
- Components of Prototype Design Pattern
- Prototype Design Pattern example in Java
- When to use the Prototype Design Pattern 
- When not to use the Prototype Design Pattern 

## Components of Prototype Design Pattern
The Prototype Design Pattern consists of the following components:
1. **Prototype Interface or Abstract Class**: Declares the method(s) for cloning an object and provides a blueprint for creating new objects.
2. **Concrete Prototype**: A class that implements the prototype interface or extends the abstract class, representing a specific type of object to be cloned.
3. **Client**: The code or module that requests the creation of new objects by interacting with the prototype.
4. **Clone Method**: Declared in the prototype interface or abstract class, it specifies how an object should be copied or cloned.

Here's a UML class diagram for the Prototype Design Pattern based on the provided Java classes:

```plaintext
+-----------------+
|    <<interface>>|
|      Shape      |
+-----------------+
| + clone(): Shape |
| + draw(): void   |
+-----------------+
         ^
         |
         |
+-----------------+
|    Circle       |
+-----------------+
| - color: String |
+-----------------+
| + Circle(color: String) |
| + clone(): Shape        |
| + draw(): void          |
+-----------------+
         ^
         |
         |
+-----------------+
|    ShapeClient  |
+-----------------+
| - shapePrototype: Shape |
+-----------------+
| + ShapeClient(prototype: Shape) |
| + createShape(): Shape          |
+-----------------+
```

### Description:
- **Shape**: An interface that declares the `clone()` and `draw()` methods.
- **Circle**: A concrete class that implements the `Shape` interface, defining the `clone()` method for cloning itself and the `draw()` method to display the shape.
- **ShapeClient**: The client class that uses a `Shape` prototype to create new shapes by calling the `createShape()` method.

This diagram captures the essence of the Prototype Design Pattern, showing the relationship between the prototype interface, concrete prototype, and client.

### 1. Prototype Interface or Abstract Class
The Prototype Interface or Abstract Class declares the method(s) for cloning an object. It defines a common interface that concrete prototypes must implement, ensuring that all prototypes can be cloned in a consistent manner.

```java
// This is like a blueprint for creating shapes.
// It says every shape should be able to clone itself and draw.
public interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
}
```

### 2. Concrete Prototype
The Concrete Prototype is a class that implements the prototype interface or extends the abstract class. It represents a specific type of object that you want to clone.

```java
// This is a specific shape, a circle, implementing the Shape interface.
// It can create a copy of itself (clone) and draw in its own way.
public class Circle implements Shape {
    private String color;

    // When you create a circle, you give it a color.
    public Circle(String color) {
        this.color = color;
    }

    // This creates a copy of the circle.
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    // This is how a circle draws itself.
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}
```

### 3. Client
The Client is the code or module that requests the creation of new objects by interacting with the prototype.

```java
// This is like a user of shapes.
// It uses a prototype (a shape) to create new shapes.
public class ShapeClient {
    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}
```

### 4. Complete Code Example
In the main class, we create a concrete prototype (circlePrototype) of a red circle. We then create a ShapeClient and provide it with the red circle prototype. The client uses the prototype to create a new shape (redCircle) using the `createShape()` method.

```java
// Prototype interface
interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
}

// Concrete prototype
class Circle implements Shape {
    private String color;

    // When you create a circle, you give it a color.
    public Circle(String color) {
        this.color = color;
    }

    // This creates a copy of the circle.
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    // This is how a circle draws itself.
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

// Client code
class ShapeClient {
    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

// Main class
public class PrototypeExample {
    public static void main(String[] args) {
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");

        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);

        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();

        // Draw the newly created red circle.
        redCircle.draw();
    }
}
```

**Output:**
```
Drawing a red circle.
```

## When to use the Prototype Design Pattern
- **Creating Objects is Costly**: Use the Prototype pattern when creating objects is more expensive or complex than copying existing ones.
- **Variations of Objects**: Use the Prototype pattern when your system needs to support a variety of objects with slight variations.
- **Dynamic Configuration**: Use the Prototype pattern when your system requires dynamic configuration and you want to create objects with configurations at runtime.
- **Reducing Initialization Overhead**: Use the Prototype pattern when you want to reduce the overhead of initializing an object.

## When not to use the Prototype Design Pattern
- **Unique Object Instances**: Avoid using the Prototype pattern when your application predominantly deals with unique object instances.
- **Simple Object Creation**: If object creation is simple and does not involve significant resource consumption, using the Prototype pattern might be unnecessary complexity.
- **Immutable Objects**: If your objects are immutable and do not need variations, the benefits of cloning may not be significant.
- **Clear Object Creation Process**: If your system has a clear and straightforward object creation process, introducing the Prototype pattern may add unnecessary complexity.
- **Limited Object Variations**: If there are only a few variations of objects, the Prototype pattern might be overkill.
