# Expressions, Statements, Blocks

## Expressions
An expression is a construct made up of variables, operators, and method invocations, that evaluate to a single value. E.g. `cadence = 1` or `value1 == value2`. Compound expressions like `x + y / 100` are also possible and get executed according to the precedence of the involved operators. It is recommended to write the code in a way that the order is clear, e.g. `x + (y / 100)`.

## Statements
Statements generally end with a `;`. There are expression statements (e.g. `aValue = 400`;), method invocation statements (e.g. `System.out.println("Hello World!");`), object creation statements (e.g. `Bicycle myBicycle = new Bicycle();`), declaration statements (e.g. `double aValue = 8334.888;`), and control flow statements (see later).

## Blocks
Blocks are groups of zero or more statements and are allowed wherever a statement is allowed.