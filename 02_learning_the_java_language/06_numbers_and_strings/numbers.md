# Numbers

The `Number` class is part of the `java.lang` package. It's instantiations can be used instead of the primitive number types.

## The Numbers Classes

Normally the primitive data types are used like:
```
int i = 500;
float gpa = 3.65f;
byte mask = 0xff;
```

The `Number` class has subclasses for each of the primitive data types: `Byte`, `Integer`, `Double`, `Short`, `Float`, `Long`. These classes basically wrap the primitive in an object. Often the wrapping is done by the compiler: If a primitive is used where an object is expected, the compiler `boxes` the primitive in its wrapper. The reverse also happens and is called `unboxing`.

There are three reasons to use a `Number` object instead of the primitive:
1. As an argument of a method that expects an object
2. To use constants defined by that class, e.g. `MIN_VALUE` or `MAX_VALUE`
3. To use class methods, e.g. for converting values to and from other primitives, converting to and from strings, and converting between number systems (decimal, octal, hexadecimal, binary).

## Formatting Numeric Print Output

Besides `print` and `println` there are other option for printing strings to standard output. The `java.io` package contains a `PrintStream` class that has two formatting methods that are equivalent to each other and can be used to print: `format` and `printf`. `System.out` happens to be a `PrintStream` object, so these two methods can be used on it.

The syntax is `System.out.format(stringToBeFormatted, Object... args)`. The stringToBeFormatted contains plain text and `format specifiers`.

`Object... args` is also called varargs, which means the number of arguments may vary. `format specifiers` begin with a `%` and end with a converter, indicating the type of argument to be formatted. E.g. `%d` for decimal integers, `%f` for floats, `%s` for strings.

```
int i = 461012;
System.out.format("The value of i is: %d%n", i);
```

The `%n` is a newline character that should be used instead of `\n`.

The `java.text.DecimalFormat` is a class that allows a lot of control for the display of numbers.

## Beyond Basic Arithmetic

Basic arithmatic operators are `+`, `-`, `*`, `/`, and `%`.

The `Math` class provides two constants (`Math.E`, and `Math.PI`) as well as more advanced methods that can be called in two ways:
```
// Directly
Math.cos(angle);

// Doing a static import first
import static java.lang.Math.*;
cos(angle);
```

## Random Numbers

Single random numbers are best generated via `Math.random()`. The result is `0.0 <= Math.random() < 1.0`. Multiply the result to get numbers in different ranges.

For series of random numbers it is advised to use `java.util.Random`.