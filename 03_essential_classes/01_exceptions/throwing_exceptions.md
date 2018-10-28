# Throwing Exceptions

Before an exception can be handled it must first be thrown by some code. This always happens with a `throw` statement.

Exception classes provided by the Java platform are descendants of the `Throwable` class. You can also create your own exception classes. Esp. when creating a new package you might have to do that, so that users can differentiate between errors in your package and those in the Java plaform/packages.

## The `throw` Statement

The `throw` statement requires a single argument, a `throwable object`. These are instances of any subclass of the `Throwable` class. E.g. some method might contain the following code:
```
public Object myMethod() {
    . . .
    if (size == 0) {
        throw new EmptyStackException();
    }
    . . .
}
```

## Throwable Class & Subclasses

While the objects thrown can be of a class that is a direct descendant of `java.lang.Throwable`, it can also be further down in the inheritance tree. `Throwable` descends from `Object`. Both `Error` and `Exception` descend from `Throwable`. `RuntimeException` descends from `Exception`.

## Chained Exceptions

It is common for an application to respond to an exception by throwing another exception. In these cases `chained exceptions` should be used. This is done by throwing another exception in the catch block. E.g.
```
try {
    . . .
} catch (IOException e) {
    throw new SampleException("Other IOException", e);
}
```
In that case when the `IOException` is caught, a new `SampleException` is thrown, which takes the initial exception as an argument.

## Accessing Stack Trace Information

The `stack trace` provides information on the execution history of the current thread and lists the names of the classes and methods that were called at the point when the exception occured. It is very useful for debugging and can be accessed via the `getStackTrace` method of the exception object. E.g.
```
catch (Exception cause) {
    StackTraceElement elements[] = cause.getStackTrace();
    for (int i = 0, n = elements.length; i < n; i++) {
        System.err.println(elements[i].getFileName()
            + ":" + elements[i].getLineNumber()
            + ">> " + elements[i].getMethodName() + "()");
    }
}
```

## Logging API

Instead of manually parsing the `stack trace` and sending the output to `System.err`, you can also send it to a file using the logging facility in `java.util.logging`. E.g.
```
try {
    Handler handler = new FileHandler("OutFile.log");
    Loggoer.getLogger("").addHandler(handler);
} catch (IOException e) {
    Logger logger = Logger.getLogger("package.name");
    StackTraceElement elements[] = e.getStackTrace();
    for (i = 0, n = elements.length; i < n; i++) {
        logger.log(Level.WARNING, elements[i].getMethodName());
    }
}
```

## Creating Exception Classes

You should create your own exception if:
- You need an exception type that is not represented by those in the Java platform
- It would help users if they could differentiate between your exceptions and those thrown by classes written by other vendors
- You codes throws more than one related exception
- Your users won't have access to someone else's exceptions
- Your package should be independant and self-contained

When creating exception classes the string `Exception` should be added to the names of all classes that inherit directly or indirectly from the `Exception` class.

E.g. when creating custom exceptions for the `Example` class, you could choose the following hierachy: A `ExampleException` that inherits from `Exception`. A `InvalidIndexException` and a `ObjectNotFoundException` that inherit from `ExampleException`. A `EmptyListException` that inherits from `ObjectNotFoundException`.