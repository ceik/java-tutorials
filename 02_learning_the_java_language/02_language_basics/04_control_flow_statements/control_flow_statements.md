# Control Flow Statements

## Switch Statements
A `switch` works with byte, short, char, int, enumerated, Strings, and a few other special classes.

A statement in the switch block can have one or more `case` or `default` labels.

`break` statements terminate the enclosing switch block. If they are not included the statements in the switch block will fall through (see example).

## While Statements
The `while` statement continually executes a block of statments as long as the given expression is true. The `do-while` statement works very similar. The only difference is that the expression is evaluated at the end of the loop and therefore the block inside is executed at least once.

## For Statements
The general pattern is:
```
for (initialization; termination; increment) {
    statement(s)
}
```
Variables that are initalized in the initialization are only available in the `for` statement.

Infinite loops can be created like:
```
for ( ; ; ) {
    statement(s);
}
```

Enhanced for loops iterate through Collections or Arrays (see example). These are recommended over the normal for loops.

## Branching Statements

Unlabeled `break` statements terminate the innermost `for`, `switch`, `while`, or `do-while` statement. Labeled `break` statements can be used to terminate a statement of choice and transfer control to the statement immediately following the terminated statement.

The `continue` statement skips the current iteration of a `for`, `while`, or `do-while` loop. If it is unlabeled it skips to the end of the innermost loop's body and evaluates the expression that controls the loop. If the statement is labeled it skips the current iteration of the corresponding loop.

The `return` keyword is used to exit the current method. It can return a value (`return x;`), in which case the data type of that value must match the method's declared return value. If the method is declared void, `return` must be used without a value (`reutrn;`).