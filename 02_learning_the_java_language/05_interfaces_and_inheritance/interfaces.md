# Interfaces

Interfaces can be thought of like contracts that specify how software interacts. They are useful for large groups and when multiple pieces of (potentially proprietary) software needs to interact.

An interface is a reference type in Java, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot be instantiated, only implemented by classes or extended by other interfaces.


## Defining an Interface

Interface declarations consist of modifiers, the `interface` keyword, the interface name, a comma-separated list of parent interfaces, and the interface body. For example:
```
public interface GroupedInterface extends Interface1, Interface2, Interface3 {
    // Nat log base
    double E = 2.718282

    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);
}
```

Note that method signatures have no braces and are terminated with a semicolon. The bodies for the methods is provided when a class implements an interface. These are called `abstract methods`. All abstract, default, and static methods are by default public, unless declared otherwise. Also constants are implicitly public, static, and final.

## Implementing and Interface

Declaring a class that implements an interface works via the `implements` keyword. If a class implements multiple interfaces, `implements` is followed by a comma-separated list.

```
public interface Relatable {
    // this (object calling isLargerThan) and other must be
    // instances of the same class. Returns 1, 0, -1 if this
    // is greater than, equal, or less than other
    public int isLargerThan(Relatable other);
}
```

The example interface `Relatable` can be implemented by a variety of classes, as long as there is a way to compare the relative size of objects instantiated from that class.

## Using an Interface as a Type

Because interfaces are reference data types, interface names can be used anywhere you can use any other data type names. If you define a reference variable whose type is an interface, any object you assign to it must be an instance of a class that implements the interface.

```
public Object findLargest(Object object1, Object object2) {
    Relatable obj1 = (Relatable)object1;
    Relatable obj2 = (Relatable)object2;
    if ((obj1).isLargerThan(obj2) > 0)
        return object1;
    else
        return object2;
}
```

The method above works for any pairs of objects that are instantiated from a class that implements `Relatable`. `object1` can invoce `isLargerThan` because it is casted to a `Relatable` type: `(Relatable)object1`

## Evolving Interfaces

When a new methods needs to be added to an interface, doing so wiil break all classes that implemented this interface (because they don't yet implement that new method).

A better option can be to extend the old interface giving users the chance to upgrade or not:
```
public interface DoItPlus extends DoIt {
    boolen didItWork(int i, double x, String s);
}
```

Alternatively the new method can be added as a `default method` or a `static method`, for which an implementation must be provided.

```
public interface DoIt {
    void doSomething(int i, double x);
    int doSomethingElse(String s);
    default boolean didItWork(int i, double x, String s) {
        // Method body
    }
}
```

When extending an interface that contais a default method you can:
- Not mention the default method, in which case it is inherited
- Redeclare the default method, which makes it abstract
- Redefine the default method, which overrides it

## Static Methods

Static methods are associated with the class in which it is defined rather than with any object. Every instance of the class shares its static methods. Static methods are by default public.