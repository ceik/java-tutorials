# Enum Types

The `enum` data type is a special data type for variables that take a value from a set of predefined constants. Because they are constants the names of an enum type's fields are in caps.

```
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

The enum declaration defines a class (called an `enum type`). The enum class body can include methods and other fields. Also the compiler adds some special methods (like `values`, which returns an array of all the values in the enum) when it creates an enum.

```
for (Planet p : Planet.values()) {
    System.out.printf("Your weight on %s is %f%n",
                      p, p.surfaceWeight(mass));
}
```