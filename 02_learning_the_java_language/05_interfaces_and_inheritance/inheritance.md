# Inheritance

A class that is derived from another calss is called a `subclass`, `derived class`, `extended class`, or `child class`. The class from which the subclass is derived is called a `superclass`, `base class`, or `parent class`.

Every class has exactly one direct superclass (`single inheritance`). The only exception is the `Object` class. If no superclass is explicitly mentioned, a class is implicitly a subclass of `Object`. A class is said to be `descended` from all the classes in the inheritance chain all the way back to `Object`.

The point of inheritance is that a class inherits all the members (fields, methods, and nested classes) from it's superclass. Constructors are not members and are therefore not inherited. The constructor of the direct superclass can be invoked from the subclass though.

## What Can Be Done in a Subclass

A subclass inherits all public and protected members of its parent. If is in the same package as the parent it also inherits its package-private members. Private members are not inherited, can be accessed via public or protected methods though.

## Casting Objects

If an object called `myBike` is of class `MountainBike`, which is descended from `Bicycle` and `Object`, `myBike` can be used whenever a `MountainBike`, `Bicycle`, or `Object` is called for. The reverse is not necessarily true. E.g.
```
Object obj = new MountainBike();

// this doesn't work:
MountainBike myBike = obj;

// this works:
MountainBike myBike = (MountainBike)obj;
```

In the first line obj is both an `Object` and a `MountainBike`. This is called `implicit casting`. The first example doesn't work because `obj` is not known to the compiler as a `MountainBike`. To fix this, `obj` can be `explicitly casted` like in the third line.

The operator `instanceof` can be used to test if an object is of a particular type.

## Multiple Inheritance of State, Implementation, and Type

Classes can have fields whereas interfaces can not. This is a main reason, why a class can only have one direct parent class, but can implement many interfaces. If a class could directly inherit from multiple classes there is a potential for conflicting fields. This is called `multiple inheritance of state` (because objects store their states in fields).

`Multiple inheritance of implementation` is the ability to inherit method definitions from multiple classes. This also isn't really supported, but there are some related concepts in Java (like a class implementing multiple interfaces).

`Multiple inheritance of type` refers to the ability of a class to impelement more than one interface, which leads to the object having multiple types. This is supported in Java.

## Overriding and Hiding Methods

### Instance Methods

An instance method in a subclass with the same signature and return type as an instance method in the superclass overrides the superclass' method. When doing this you might want to use the `@Override` annotation.

### Static Methods

If a subclass defines a static method with the same signature as a static method in the superclass, the method in the superclass is hidden. The difference is that a hidden static method can still be invoked from the superclass. E.g. via `superclass.testInstanceMethod();` in the subclass.

### Interface Methods

`Default methods` and `abstract methods` in interfaces are inherited like instance methods.  However when multiple methods with the same signature are inherited, the Java compiler will follow these rules:
* Instance methods are preferred over interface default methods
* Methods that are already overriden are ignored

If two or more independently defined default methods in interfaces conflict, or a default method conflicts with an abstact method, they must be explicitly overriden. Else the compiler will throw an error.

## Modifiers

The access specifier for an overriding method can allow more, but not less access than the overridden method. E.g. a protected instance methods in the superclass can be made public, but not private, in the subclass.

## The `super` Keyword

The `super` keyword can be used to invoke a method that has been overriden or hidden (hiding is discouraged). See `Subclass.java`.

It can also be used to call the constructor of a superclass, in which case it must be the first line in the subclass constructor. The syntax is either `super();` (for the no-argument constructor or `super(parameter list);`

## The Object Superclass

Since every class ultimately descends from `Object`, they all inherit its members.

Some useful examples are `equals()` or `getClass()`.

## Final Classes & Methods

Methods and entire classes can have the `final` keyword, which means they can not be overriden. In general it is recommended to make methods that are called by constructors final.

## Abstract Classes & Methods

Abstract classes can not be instantiated, but they can be subclassed.

Abstract methods are declared without and implementation, like `abstract void moveTo(double deltaX, double deltaY);`. Classes that include abstract methods must be declared abstract themselves, like:
```
public abstract class GraphicObject {
    // declare fields
    // non-abstract methods
    abstract void draw();
}
```

Methods in interfaces that are not declared `default` or `static` are implicitly `abstract`, see section on interfaces.

The difference between abstract classes and interfaces is that in abstract classes fields can be declared non-static and final. Also public, protected, and private concrete methods can be defined. With interfaces, all fields are automatically public, static, and final, and all methods that you declare or define are public. Also only one class can be used as a parent, whereas the number of interfaces of a class in unlimited.

### When to Use Abstract Classes

1. Code should be shared among several closely related classes.
2. Classes extending the abstract class have many common methods or fields, or require access modifiers other than public.
3. You want to declare non-static or non-final fields.

### When to Use Interfaces

1. You expect unrelated classes would implement your interface. Good examples are the `Comparable`, `Clonable`, or `Serializable` interfaces.
2. You want to specify the behavior of a particular data type, but are not concerned about who implements it's behavior.
3. You want to take advantage of multiple inheritance of type.