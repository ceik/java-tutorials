# I/O Streams

An I/O stream represents an input source or an output destination. They can be of different kinds, like disk files, devices, other programs, memory arrays, etc. They can also support many different kinds of data, starting from simple bytes, to objects. Some just pass on data, others also manipulate it.

No matter the details, all streams are based on the simple model of a sequence of data.

## Byte Streams

Byte streams perform input and output on 8-bit bytes. All byte stream classes descend from `InputStream` and `OutputStream`. The `CopyBytes` program shows how to use them in the case of file I/O streams. Other kinds of byte streams are used in much the same way.

This is actually not a good example because a byte stream should not be used for characters. The point is to illustrate byte streams because all other types of streams are built on them.

## Character Streams

The Java platform stores characters using Unicode. Character stream I/O automatically translates this internal format to and from the local character set.

All character stream classes descend from `Reader` and `Writer`. See `CopyCharacter` for an example in file I/O. Also they work on 16 bit integers instead of the 8 bit integers used by byte streams.

### Line-Oriented I/O

It often makes sense to read text in lines, instead of single characters. See `CopyLines` for an example. There `readLine` returns an entire line, while `println` outputs the line and appends the line terminator for the current OS (which might be different that the one used in the input file).

## Buffered Streams

If I/O is unbuffered, the read or write requests are handled directly by the underlying OS, which is inefficient because these requests often trigger disk access, network activity, etc. Buffered I/O on the other hand reads/writes from/to a buffer and only uses the native API when the buffer is empty/full.

An unbuffered stream can be converted into a buffered one by wrapping it like:
```
inputStream = new BufferedReader(new FileReader("xanadu.txt"));
outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
```
Similarly `BufferedInputStream` and `BufferedOutputStream` can be used for byte streams.

Writing out a buffer is also known as `flushing`. This can be manually done by invocing the `flush` method. Some buffered output classes also support `autoflush`, which needs to be specified by a constructor argument. If enabled, certain events cause the buffer to be flushed. E.g. `PrintWriter` flushes the buffer on every invocation of `println` or `format`

## Scanning

Scanners break down formatted input into tokens. By default white space characters (blanks, tabs, line terminators) are used. To use a different delimiter, `useDelimiter()` can be called on the scanner with a regex as an argument.

See `ScanXan` for an example of how to use a scanner.

`Scanner` also supports tokens that are not strings: All primitive types except `char`s, `BigInteger`s, and `BigDecimal`s. This works via functions like `hasNextDouble()` and `nextDouble`.

A `Scanner` needs to be closed because it is based on a stream.

## Formatting

Stream objects that implement formatting are instances of either `PrintWriter`, a character stream class, or `PrintStream`, a byte stream class. `System.out` and `System.err` are usually the only relevant cases for `PrintStream` objects. In addition to implementing the standard `write` methods, these also provide two levels of formatting: `print`/`println` and `format`.

`print` and `println` convert the values passed to it using the `toString` method. E.g.
```
i = 5;
double r = Math.sqrt(i);
System.out.print(i);
System.out.println("The square root of " + i + " is " + r + ".");
```

The `format` method formats multiple arguments based on a format string, which consists of static text embedded with `format specifiers`, which always begin with a `%`. E.g.
```
int i = 2;
double r - Math.sqrt(i);
System.out.format("The square root of %d is %f.%n", i, r);
```

The example above uses the `format specifiers` `%d` (integer to decimal), `%f` (floating point to decimal), and `%n` (platform specific line terminator). There are many others, for example `%x` (integer to hexadecimal), `%s` (any value to string), and `%tb` (integer to locale-specific month name).

Besides `%%` and `%n` all format specifiers must have matching arguments.

There are additional, optional elements for `format`, like `Precision`, `Width`, and `Flags`.

## I/O from the Command Line

## Standard Streams

Standard streams are features of many operating systems. By default they read input from the keyboard and write output to the display. Java supports three `standard streams`: `Standard Input` via `System.in`, `Standard Output` via `System.out`, and `Standard Error` via `System.err`. These are defined automatically and do not need to be opened.

For historical reasons they are actually byte streams. `System.out` and `System.err` are defined as `PrintStream` object, which emulates many fetures of character streams. `System.in` can be used as a character stream by wrapping it in `InputStreamReader`.

## The Console

The console is a single predefined object of type `Console`. It comes with input and output streams, that are character streams, via it's `reader` and `writer` methods.

Before the console can be used, it must be retrieved by invoking `System.console()`. If available it is returned, otherwise `NULL` is returned, which means that console operations are not permitted. THis can be because the OS doesn't support them or the program was launched in a non-interactive environment.

One good use-case is secure password entry. Through it's `readPassword` method it suppresses echoing and returns a character arry (not a String), which makes sure the password is removed from memory as soon as it is no longer needed.

## Data Streams

Data streams support binary I/O of primitive data type values and strings. For this all data streams implement either the `DataInput` or `DataOutput` interfaces. The most common ones are `DataInputStream` and `DataOutputStream`. They can both only be used as a wrapper for an existing byte stream object.

## Object Streams

Object streams are possible via the `ObjectInputStream` and `ObjectOutputStream` classes. Most standard classes support serialization, indicated by implementing the `Serializable` interface. Extra care needs to be taken when streaming objects because they can themselves contain references to other objects. These other objects (and their references, etc.) will also be written/read to/from the stream.