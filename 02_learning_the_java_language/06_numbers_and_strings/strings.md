# Strings

## Characters

The primitive `char` type can be used most of the time for single characters. E.g.
```
char ch = 'a';
char uniChar = '\u03A9';
char[] charArray = { 'a', 'b', 'c' };
```

In some cases an object must be used, e.g. as a method argument. For these cases the wrapper class `Character` can be used, which has a single field, whose type is `char`. It also has a number of useful methods for manipulating chars. The `Character` class is `immutable`.

In some cases the compiler will convert a `char` to a `Character` for you. This is called `autoboxing` or `unboxing` if done in reverse.

`Escape sequences` are denoted with a `\`, e.g. for `\t` or `\n`.

## Creating Strings

In Java, strings are objects of the `String` class and can be created like `String greet = "Hello world!";`. In total the class has 13 constructors.

A `string literal` is a series of characters in your code enclosed by double quotes, e.g. `"Hello world!"` in the example above.

Even though the string class has a number of methods that appear to modify strings, they really create a new string that contains the result of that operation. This is because the `String` class is `immutable`.

The `String` class has a number of useful methods, like `length()`, or `concat()`. Concat is called like `string1.concat(string2)`). For brevity the  `+`  operator is also often used to concat strings.

Since Java does not permit string literals to span multiple lines, the `+` operator must be used.

The `String` class also has a `format()` method that works like the one in the `Number` class, but outputs a `String` object instead of a `PrintStream` object.

## Converting Strings to Numbers

Each of the `Number` subclasses provide a method `valueOf` that converts a string to an object of that type. E.g. `Float.valueOf("1.2324");` returns a `Float` object.

Alternatively they also have a `parseXXX()` methods that returns a primitive type. E.g. `float a = Float.parseFloat("1.2324");`.

## Converting Numbers to Strings

There are multiple ways to do this:
```
// Concat a number with an empty string
int i
String s1 = "" + i;

// Using String.valueOf()
String s2 = String.valueOf(i);

// Using the toString() method of the Number subclasses
String s3 = Integer.toString(i);
```

## String Methods

The character at a particular index can be retrieved via the `charAt()` String method. Substrings can be retrieved via `substring()`.

Various other methods for seraching, manipulating, comparing and replacing parts of strings are available in the `String` class.

## The StringBuilder Class

`StringBuilder` objects are like `String` object, except that they can be modified. Internally they are treated like variable-length arrays that contain a squence of chars.

Normal strings should be used, unless there is a reason not to. One reason would be having to concatenate a large number of strings, for which appending to a StringBuilder is more efficient.

Besides a length (`length()`) a StringBuilder also has a capacity, returned via `capacity()`, which is the number of char spaces that have been allocated to it. The capacity automatically expands as necessary.

The `append()` and `insert()` methods are available for StrinbBuilders, but not for Strings. They are heavily overloaded to accept any data type.

A StringBuilder can be converted to a String via the `toString()` method of the `StringBuilder` class. The reverse can be done via the `StringBuilder(String str)` constructor.
