# More on Classes

## Returning a Value from a Method

A method returns to the code that invoked it when it:
- completes all the statements in the method
- reaches a `return` statement
- throws an exception (see later)
whichever happens first.

A `return` statement must be included in the method unless it is decleared `void` (in which case an empty `return;` statement can be used).

The data type that is returned must match the method's declared return type. This can be a reference type like `Point` or `Bicycle`.

If the return type of a method is a class, the returned object must be of that class or a direct subclass. Imagine this class hierachy: `Object -> java.lang.Number -> ImaginaryNumber`. A method with the declared return type number can return a number or a ImaginaryNumber (which is a number), but not a Object (which is not a number). This is because the object could be something totally different (e.g. a string).

## The `this` Keyword

Within an instance method or a constructor, `this` is a reference to the current object (whose method or constructor is being called).

It can be used with a field if it is shadowed by a method/constructor parameter. E.g. the `Point` constructor
```
public Point(int a, int b) {
    x = a;
    y = b;
}
```
could have been written like
```
public Point(int x, int y) {
    this.x = x;
    this.y = y;
}
```

From within a constructor it can be used to call another constructor of the same class. This is called explicit constructor invocation. E.g.
```
public Rectangle() {
    this(0, 0, 1, 1);
}
public Rectangle(int width, int height) {
    this(0, 0, width, height);
}
public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
}
```

If present the invocation of another constructor must be the first line in the constructor.

## Controlling Access to Members of a Class

Access control happens on two levels, top (class) and member level.

The class can be set to:
- `public`, in which case that class is visible to all classes everywhere
- package-private (done by including no modifier), in which case it is only visible within it's own package.

Members can be set to:
- `public`
- package-private (no modifier)
- `private`: Member can only be accessed by it's own class
- `protected`: Like package-private, but with the addition that it can also be accessed by a subclass of it's class in another package.

In practice it is recommended to use `private` unless there is a good reason not to. Public fields can link you to a certain implementation and limit the flexibility in changing the code.

## Class Variables

Class variable are declared witht he `static` keyword. As opposed to instance variables, each object of that class shares that class variable. The class variable can be changed by any of the objects that have it or without creating an object at all. E.g.
```
public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;
    private int id;
    private static int numberOfBicycles = 0;

    public Bicycle(int startCadence, int startSpeed, int startGear){
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

        // increment number of Bicycles
        // and assign ID number
        id = ++numberOfBicycles;
    }
}
```

Class variables should be referenced by the class name (`Bicycle.numberOfBicycles`) instead of with an object refernce (`myBike.numberOfBicycles`). The latter works as well, but makes the code much harder to read.

## Class Methods

Static methods can also be created with the `static` keyword and should also be invoked with the class name, not an object reference. A common use case if to have static methods for accessing static fields, e.g. :
```
public static in getNumberOfBicycles() {
    return numberOfBicycles;
}
```

Class methods cannot access instance variables or instance methods directly. Also they can not use the `this` keyword (since there is no object to refer to).

## Constants

`static` in combination with the `final` keyword creates constants. `final` indicates that the value of this field can not change. Constants are named in all uppercase, with underscores separating words. E.g. `static final double PI = 3.141592653589793;`.

## Compile-Time Constant

If a constant is of primitive or type string, the compiler will replace all it's occurences in the code with the value. If the constant changes, all classes that use it must be recompiled.

## Initializing Fields

If the initial value is available and the initialization fits in one line, it makes sense to provide an initial value in the declaration, e.g. `private boolean full = false;`

### Static Initialization Blocks

Static initializaiton blocks can be used to to initialized more complicated class variables, e.g.
```
private static final int x;

static {
    a = 123;
    b = 321;
    x = a + b;
}
```

### Static Private Methods

They can be used instead of static initialization blocks. In case the class variable needs to be reinitialized, the static private method can be reused. E.g.
```
private static final int x = getX();

static int getX() {
    a = 123;
    b = 321;
    return a + b;
}
```

### Initializing Instance Members

Normally the code for this belongs in the constructor.

If the code for this should be shared between multiple constructors, it can be put in an initializer block, which the compiler copies into every constructor:
```
{
    // code
}
```

Alternatively a final method can be used, e.g. if a subclass might want to reuse the initialization method. Final methods can not be overridden in a subclass. E.g.
```
private varType myVar = initializeInstanceVariable();

protected final varType initializeInstanceVariable() {

    // initialization code goes here
}
```