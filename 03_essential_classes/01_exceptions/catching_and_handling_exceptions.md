# Catching & Handling Exceptions

## The `try` Block

The code that might throw an exception should be enclosed ina `try` block, which looks like:
```
try {
    code
}
catch and finally blocks . . .
```

You could put each line of code that might throw an exception within its own `try` block and provide separate exception handlers for each. Or you can put all the code within a single `try` block and associate multiple handlers with it. To associate an exception handler with a `try` block, a `catch` block must follow it.

## The `catch` Block

The `catch` block must follow directly after the `try` block. E.g.
```
try {
    code
} catch(ExceptionType name) {
    code
} catch(ExceptionType name) {
    code
}
```

Each catch block is an exception hander that handles the type of exception indicated by its arguement. The argument type, `ExceptionType`, declares the type of exception that the handler can handle and must be the name of a class that inherits from the `Throwable` class. The handler can refer to the exception with `name`.

The runtime system invokes, and thereby executes the code in the `catch` block of, the first exception handler in the call stack whose `ExceptionType` matches the type of the exception thrown. When invoked, the code in the `catch` block is executed. It considers it a match if the thrown object can legally be assigned to the exception handlers argument. Note that this means that subclasses will also be a match if their parent class is specified in the `catch` statement. E.g. a `catch (Exception e) {...}` will handle all exceptions (this is usually bad practice!).

Besides printing messages, exception handlers can do error recovery, prompt the user to make decisions, or propagate the error up to a higher level handler using chained exceptions (see Chained Exceptions).

One handler can also catch multiple exceptions. In that case each exception type needs to be separated with a `|` and the catch parameter is implicitly `final`. E.g.
```
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
```

## The `finally` Block

The `finally` block always executes when the `try` block exits, no matter what happens in the `try` block. This ensures it is executed even if an unexpected exception occurs. This makes it very good practice to put cleanup code into `finally` blocks, which is then prevented from being accidentally bypassed by a `return`, `continue`, or `break` statement.

See the `ListOfNumbersFixed.java` class as an example.

## The `try`-with-resources Statement

Instead of closing resources in a finally block, they can be declared in the `try` statement, which leads to them automatically being closed at the end of the statement. Any object that implements `java.lang.AutoCloseable` can be used. E.g.
```
static String readFirstLineFromFile(String path) throws IOExceptio {
    try (BufferedReader br =
        new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
}
```
instead of
```
static String readFirstLineFromFileWithFinallyBlock(String path)
    throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }
```

Multiple resources can be declared in the `try` statement. They must be separated by a `;` and when the `try` block terminates their `close` methods are called in the opposite order of their creation.

A `try`-with-resources statement can also have `catch` and `finally` blocks, which are run after the resources have been closed.

### Suppressed Exceptions

If both the `try` block and the `try`-with-resource statement throw exceptions, the exception(s) from the `try`-with-resource statement are `suppressed` and only those thrown by the `try` block are being thrown by the method. Suppressed exceptions can be retrieves by calling the `Throwable.getSuppressed` method.

## Specifying Exceptions Thrown by Methods

Instead of catching and handling exceptions, it can be more appropriate for a method to let a method further up the call stack handle it. In that case the method must specify that it can throw a particular exception.

In that case a `throws` clause needs to be added to the method declaration. E.g. `public void writeList() throws IOException, IndexOutOfBoundsException{ . . . }` for the example in ListOfNumbers.java. Including unchecked exceptions like `IndexOutOfBoundsException` is optional.