# Classes

## Declaring Member Variables
Member variables of a class are called fields. When declaring fields a name, the data type, and optionally a number of modifiers must be included. E.g. when declared with the `public` keyword, these fields become public members, making them accessible to any object that can access the class. Using `private` makes the field only accessible within it's own class.

By convention (data encapsulation) fields are made private and methods are provided to return the values of those fields.

## Declaring Methods
The First word in a methods name should be a verb and be lowercase.

Methods are declared like
```
public double calculateAnswer(double wingSpan, int numberOfEngines,
                              double length, double grossTons) {
    //do the calculation here
}
```

A method signature is the combination of name and parameter types. e.g. `calculateAnswer(double, int, double, couble)`.

Method overloading means using the same name for different methods within a class. This is allowed if the methods have different signatures, i.e. different parameter types.

## Constructors
Constructors are used to create objects from the class. They have the same name as the class and no return type.

```
BicycleBasic myBike = new BicycleBasic(30, 0, 8);
```

That line uses the constructor from the example code. It creates space in memory for the object and initializes it's fields.

As with methods another constructor with the same name could be added, as long as it takes different parameters. E.g.
```
public BicycleBasic() {
    gear = 1;
    cadence = 10;
    speed = 0;
}
```

When no constructor is provided for a class, the compiler will use the no-arguement constructor of the superclass. If the class does not have an explicit superclass, `Object` will become it's implicit superclass and the no-arguement constructor of `Object` is used.

## Passing Information to a Method or Constructor
Parameters refers to the list of variables in a method declaration. Arguements are the actual values that are passed in when the method is invoked. They need to match the parameters in type and order!

`varargs` allows you to pass an arbitrary number of arguements to a method. This only works for the last parameter, whose type needs to be followed by `...` (ellipsis). E.g.
```
public Polygon polygonFrom(Point... corners) {
    // method body
}
```

When the method is invoked, an array or a sequence of arguements can be passed. In any case, corners is treated and can be used like an array.

When a parameter of a method has the same name as a field in the class, the parameter is said to `shadow` the field. Inside the method, that name refers to the arguement passed in, not the field of the class.