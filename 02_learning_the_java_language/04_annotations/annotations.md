# Annotations

Annotations are a form of metadata that provide data about a program that is not part of the program itself. Some use cases are:
* Information for the compiler, e.g. to detect or supress errors
* Compile-time and deployment-time processing, e.g. some software tools use them to generate code, XML files, etc.
* Runtime-processing

## Syntax

Annotations are declared with an `@` sign and in their simplest form look like:

```
@Override
void mySuperMethod() {....}
```

They can also include elements with values:
```
@Author(
    name = "Christian Eik",
    date = "10/08/2018"
)
class MyClass() {....}
```

If there is only one elements named `value`, the name can be omitted: `@SuppressWarning("unchecked")` instead of `@SuppressWarning(value = "unchecked")`.

The possible annotation types are defined in `java.lang` and `java.lang.annotation`. They can be predefined (like `Override` or `SuppressWarning`) or custom (like `Author`).

## Where they can be used

Annotations can be applied to declarations (of classes, fields, methods, and other program elements). They can also be applied to types in the form of `type annotations` (see below).

## Declaring an Annotation Type

Annotation Types are defined with an `@interface` like:
```
@Documented
@interface ClassPreamble {
    String author();
    String date();
    int version() default: 1;
}
```
This annotation could be used instead of standardized comments at the start of each class.

The `@Documented` is optional and makes the information appear in Javadoc-generated documentation.

## Predefined Annotation Types Used by the Compiler

`@Depreciated` means an element is depreciated. The compiler will generate a warning whenever a program uses a method, class, or field with the depreciated annotation. When used, the element should also be documented using the `@depreciated` Javadoc tag.
```
/**
 * @depreciated
 * explaination why it was depreciated
 */
@Depreciated
statid void depreciatedMethod() {...}
```

The @Override annotation informs the compiler that the element is meant to override an element declared in a superclass. (See overriding methods in the Interfaces and Inheritance section).

The `@SuppressWarnings` annotation tells the compiler to suppress certain warnings it would otherwise generate. Warnings belong to either the `depreciation` or the `unchecked` (for some legacy code stuff) category.
```
@SuppressWarnings("depreciation")
void useDepreciatedMethod() {
    objectOne.depreciatedMethod();
}
```

See the docs for other compiler-relevant annotations.

## Annotations That Apply to Other Annotations

These so called `meta-annotations` are defined in `java.lang.annotation`. Some examples are:
- `@Documented`: Indicates that the annotation should be documented using the Javadoc tool (which by default ignored annotations).
- `@Target`: Used to limit the kind of Java elements the annotation could be applied to.
- `@Repeatable`: Indicates that the annotation can be applied multiple times to the saem declaration or type use (see below).

## Type Annotations

Type annotations are applied to any type use, see examples below. They are used in combination with type checking frameworks to ensure stronger type checking.

Some examples:
```
// Class instance creation expression:
new @Interned MyObject();

// Type cast:
myString = (@NonNull String) str;

// implements clause:
class UnmodifiableList<T> implements
    @Readonly List<@Readonly T> {....}

// Thrown exception declaration:
void monitorTemperature() throws
    @Critical TemperatureException {....}
```

## Repeatable Annotations

In some cases it makes sense to apply the same annotation (with different values) multiple times to the same element. For these uses an repeatable annotation type needs to be created and then applied.