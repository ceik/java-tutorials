# Exceptions

An `exception` is defined as an event which occurs during the execution of a program, that disrupts the normal flow of the programs instructions.

When an error occurs within a method, the method creates an object and hands it off to the runtime system. Doing this is called `throwing an exception`. The object, called an exception object, contains information about the error, including its type and the state of the program when the error occurred.

When a method throws an exception, the runtime system goes through the ordered list of methods that had been called to get to the method where the error occurred. It tries to find a block of code that can handle the exception (called an `exception handler`). This list is also called the `call stack`.

         The Call Stack
==============================
| Method where error occured | <-
|                            |  |
==============================  |
============================== _|
|      Method without an     |
|      exception handler     | <-
==============================  |
============================== _|
|  Method with an exception  |
|          handler           | <-
==============================  |
============================== _|
|          main              |
|                            |
==============================

An exception handler is considered appropriate if the type of the exception object thrown matches the type that can be handled by the handler. When the runtime system finds such an appropriate handler, the exception is passed to the handler. It is said to `catch the exception`. If the call stack is exhaustively searched and no appropriate handler is found, the runtime system (and, consequently, the program) terminates.

## The Catch or Specify Requirement

Valid Java code must adhere to the `Catch or Specify Requirement`. This means that code that might throw exceptions must be enclosed by either of the following:

- A `try` statement that catches the exception
- A method that specifies that it can throw the exception, which means it must provide a `throws` clause that lists the exception

This requirement only applies to `checked exceptions` though, see below.

## The Three Kinds of Exceptions

1. `Checked Exception`: Exceptional conditions that a well-written application should anticipate and revocer from. E.g. when a user provides an invalid filename to an input. All exceptions besides those indicated by `Error`, `RuntimeException`, and their subclasses are checked exceptions.

2. `Error`: Exceptional conditions that are external to the application and that the app usually cannot anticipate or recover from. E.g. hardware or system malfunctions. While theoretically they could be anitcipated it often makes more sense to print a stack trace and exit. Errors are those exceptions indicated by `Error` and its subclasses.

3. `Runtime Exceptions`: Exceptional conditions that are internal to the app and that the app usually cannot anticipate or recover from. These are usually programming bugs, like logic errors or improper use of an API. While it is theoretically possible to catch this exception, it makes more sense to eliminate the bug that caused it. Runtime exceptions are those indicated by RuntimeException and its subclasses.

Errors and runtime exceptions are collectively known as `unchecked exceptions`.