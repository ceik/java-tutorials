# Packages

A `package` is a grouping of related types providing access protetion and name space management. A `type` is a `class`, `interface`, `enumeration`, or `annotation` type. Enumerations and annotation types are special kinds of classes and interfaces, respectively, so types are often referred to as simply classes and interfaces.

Packages bundle classes by function. Fundamental classes are in `java.lang`, classes for reading and writing are in `java.io`.

## Creating Packages

Packages are created by putting a `package statement`, e.g. `package graphics;` at the top of every source file that contains the types that should be part of the package. It must be the first line in the source file and there can only be one package statement in every source file.

Only one type in each source file can be public and it must have the same name as the source file. E.g. `public class Circle` in `Circle.java`. Including non-public classes is possible but strongly discouraged.

If no package statement is used, the type ends up in an `unnamed package`. This should only be used for very small or temporary apps or at the beginning of the development process.

## Package Naming

The compiler allows two classes to have the same name, as long as they are in a different package. E.g. a `graphics.Rectangle` class is ok, even though there already is a `java.awt.Rectangle` class.

### Naming Conventions

Packages in the Java language itself start with `java.` or `javax.`. Companies use their reserved domain name to name classes to avoid conflict. E.g. `com.example.mypackage` for the `mypackage` created by `example.com` employees. Reserved keywords or otherwise not permitted parts of names are replaced by `_`s.

Package names are written in all lower case.

## Using Package Members

The types in a package are called `package members`.

The java compiler automatically imports the `java.lang` package and the package of the current file for convenience.

There are three ways to use them:

### 1. Using Its Fully Qualified Name

If your code is in the same package as the member you are using or if that member has been imported, you can use the simple name. Otherwise the fully qualified name must be used. E.g. `graphics.Rectangle` instead of just `Rectangle`.

This approach is good if the name is used infrequently

### 2. Importing a Package Member

Specific members of a package can be imported via an `import` statement at the beginning of the file before any type definitions, but after a `package` statement. E.g. after doing `import graphics.Rectangle;`, `Rectangle` can be used via it's simple name.

This approach is good if only a few members of a package need to be used.

### 3. Importing an Entire Package

The `import` statement for entire packages looks like `import graphics.*;` This makes all members of the package available via their simple names.

The asterisk can **not** be used for partial matching.

This approach is appropriate when many members of a package need to be used.

The asterisk can also be used to import nested classes of an enclosing class. E.g. `import graphics.Rectangle.*;`. This does not import the enclosing class (Rectangle) itself!

## Package Names Are Not Hierachical

The `java.awt` package does not include packages like `java.awt.color` or `java.awt.font`. The naming is only to make clear that they are related. Doing `import java.awt.*` does not import anything from the color or font package.

## Static Imports

Static fields and methods can be imported with a `static import statement`. If done, the static methods and constants of that package become available without having to add a prefix. E.g. `import static java.lang.Math.*` lets you do `con(PI * theta)`. This should be used very sparingly though!

## Managing Source and Class Files

The source code for a class, interface, enumeration, or annotation type should be put in a file whose name is simply the name of the type + the `.java` extension. This file should then be in a folder that has the name of the package.

E.g. the `graphics.Rectange` class should be in `.../graphics/Rectangle.java` or in `.../com/example/graphics/Rectangle.java` if created by the company behind `example.com`.

When a source file is compiled the compiler will create a different output file for each type defined in it. E.g. if the Rectangle class also contains a class called `Helper`, the compiler will create `.../graphics/Rectangle.class` and `.../graphics/Helper.class`.

### Classpath

A separate path can be set to contain the classes. This can be done if you want to give people access to your classes, but not the source code. The compiler uses the `CLASSPATH` system variable for this, e.g. `/abc/classes`. When compiling it will then add the package names to the the class path, e.g. to construct `/abc/classes/com/example/graphics`.

The classpath can contain more than one path. By default the current directory and the JAR file containing the java platform classes are automatically in your class path.
```
// display current CLASSPATH variable
$ echo $CLASSPATH
// to delete current contents of CLASSPATH variable
$ unset CLASSPATH; export CLASSPATH
// to set the CLASSPATH variable
$ CLASSPATH=/home/george/java/classes; export CLASSPATH
```




