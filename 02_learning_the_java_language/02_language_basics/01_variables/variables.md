# Variables

Java uses both the term variable and fields, but they are not exactly the same.

Java variables:
    - Instance Variables (Non-static fields): Values are unique to each instance of a class. They are declared without the `static` keyword
    - Class Variables (Static fields): There will ever only be one copy of this variable, no matter how often a class has been instantiated. They are declared with the `static` keyword. Also the `final` keyword can be used if the value will never change.
    - Local Variables: They are declared without any special keyword in the defintion of a method. They are local to that method and are not accessible from the rest of the class.
    - Parameters: They are defined in the signature of a method (e.g. args in the hello world application) and are always considered variables.

Variable Naming: `gearRatio`, `currentGear`.
Constant values (static final) should be named like: `NUM_GEARS`

## Primitive Variables

Prmitive Data Types: byte, short, int, long, float, double, boolean, char (Unicode)

Literal: Source code representation of a fixed value. They are represented directly in the code without requiring computation. E.g. `byte b = 100;`

Use single quotes for char literals and doble quotes for string literals.

The special `null` literal can be assigned to any variable besides those of primitive type. The only use of `null` is to test for it's presence.

## Arrays

Arrays are container objects that hold a fixed number of values of a single type. They are declared like `type[] anArray;` where `type` is the data type and `[]` indicates that it is an array. The declaration does not actually create an array. It simply tells the compiler that this variable will hold an array of the specified type.

The array is created with the `new` keyword like `anArray = new int[10];` this creates an array with enough memory for 10 ints allocated to it and assigns it to `anArray`.

Arrays of arrays, aka multidimensional arrays, are created like `String[][] name;`. Arrays in a multidimensional array can be of different length.

The `java.util.Arrays` class provides many useful methods for array manipulation.

