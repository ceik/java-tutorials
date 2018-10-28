# Objects

Object creation example: `Point originOne = new Point(23, 94);`

## Declaring a variable to refer to an object

`Point originOne` declares a variable. It can also be used by itself, without the assignment that follows in the example above. However that would not yet create an object.

## Instantiating a class (aka creating an object)

The `new` operator invokes the object constructor, thereby instantiating the class and allocating memory. The `new` operator returns a reference to the object created by it and is usually assigned to a variable. It can also be used directly in an expression though (see later).

## Initializing an Object

An object is initialized by calling the constructor of a class. The constructor always has the same name as the class and has no return type. A class can have multiple constructors with the same name, however in those cases their signature must be different.

## Referencing an Object's Fields & Methods

If an expression returns an object reference you can access the fields and methods of this. E.g. `int height = new Rectangle().height;` Here a Rectangle object is created and it's height is returned and stored in a variable. However the rectangle is not stored, no reference to it is created, and it is unavailable after this statement has been executed.

## The Garbage Collector

Garbage collection means deleting objects when they are no longer being used. The JRE does this automatically when there are no more references to an object. References held in variables are usually dropped when the variable goes out of scope. Also it can be explicitly dropped by setting the variable to `null`. If there are multiple references to the same object all those references must be dropped before the object becomes eligible for garbage collection.