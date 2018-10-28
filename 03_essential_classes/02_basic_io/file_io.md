# File I/O

## Paths & Links

Most file systems store files in a tree (or hierarchical) structure, at the top of which sits one (or more) `root nodes`.

Files are identified by their path through the filesystem. They can be either relative or absolute. Absolute paths contian the root element, e.g. `/home/ceik/stuff/poems.md`. Relative paths, e.g. `stuff/poems.md`, need to be combined with another path to be usable.

### Symbolic Links

Besides directories and files, many filesystems also support `symbolic links`, aka `symlinks` or `soft links`. They are special files that serve as a reference to another file or directory, called the `target` of the link. Operations on symbolic linsk are mostly automatically redirected to the target. However deleting or renaming does not affect the target.

Substituting the actual location of the target with the symbolic link is called `resolving` the link.

Beware of (even indirect) circular references. They mess with recursively walking throught he directory structure.

## The `Path` Class

The `Path` class is a programmatic representation of a path in the filesystem. It contains the file name and directory list used to construct the path. It is used to examine, locate, and manipulate files.

The file or directory corresponding to the `Path` might not exist. The `Files` class' methods can be used to check the existance of a file, create a file, open it, delete it, change permissions, etc. Methods of `Path` are also called `syntactic` operations because they operate on the path itself and don't access the file system.

### Creating a Path

When defining a `Path` a series of one or more names need to be provided. The root element and file names are optional. A `Path` can be just a single directory or file name. They can be created with the `get` method from the `Paths` (note the s!) helper class like:
```
Path p1 = Paths.get("/tmp/foo");
Path p2 = Paths.get(args[0]);
Path p3 = Paths.get(URI.create("file:///Users/ceik/FileTest.java"));
```
`Paths.get` is shorthand for `Path p4 = FileSystem.getDefault().getPath("/tmp/foo");`

### Retrieving Path Info

Paths are stores as sequential name elements, with the highest elements stored at index 0. `Path` offers several methods to obtain info about it, some of them using the index. Some of them work differently depending on whether an absolute or relative path is used.

## File Operations

The `Files` class has a bunch of methods for reading, writing, and manipulating files and directories. The `Files` methods work on `Path` objects.

The tutorial goes through a number of them, providing examples of their usage.

### General Principles

System resources must be closed when done with them. Many of these resources implement the `java.io.Closeable` interface and the `close` method can be used to release the resource. `try`-with-resource statements also work, because the methods to close the resource are automatically invoked. This also helps with `IOExceptions`, which are very common when dealing with files.

Many `Files` methods can also perform certain actions `atomically`, meaning they can not be interrupted of partially performed.

Some methods also accept `glob`s. A `glob` helps with pattern matching. It is essentially a simplified, easy to use regex. See docs for the rules.

### File Metadata

`metadata` = "data about other data". The filesystem typically refers to this as `file attributes`. The `Files` class includes methods to retrieve or set these attributes, either individually or all at the same time (`readAttributes`), which is often more efficient.

Different filesystems store different metadata. `View`s are used to group attributes according to what metadata is available on which platforms.

## Reading, Writing, and Creating Files

Many of the following methods take the optional `OpenOptions` parameter. This lets you specify a few helpful options like `WRITE`, `APPEND`, `CREATE`, `CREATE_NEW`, `TRUNCATE_EXISTING`, etc. See the API docs for the default for each function if this parameter isn't supplied.

### The `readAll/write` Methods

Small files can be read in one go via the `readAllBytes(Path)` or `readAllLines(Path, Charset)` methods. They take care of a lot of work, like opening and closing the stream, but are not intended for large files.

Similarly the `write` method can be used to write bytes or lines to a file: E.g. `write(Path, byte[], OpenOption...)` or `write(Path, Iterable<extends CharSequence>, Charset,OpenOption...)`.

### Channel I/O Methods for Text Files

Channel I/O moves data in buffers, which bypasses some of the layers that can bottleneck stream I/O.

The `newBufferedReader(Path, Charset)` method opens a file for reading and returns a `BufferedReader`, that can be used to read text from a file in an efficient manner.

Similarly `newBufferedWriter(Path, Charset, OpenOption...)` can be used to write to a file using a `BufferedReader`.

### Unbuffered Streams

To open a file, returning an unbuffered input stream, use `newInputStream(Path, OpenOption...)`. To create, append to, or otherwise write to a file, use `newOutputStream(Path, OpenOption...)`, which opens or creates a file and returns an unbuffered output stream.

### Methods for Channels and ByteBuffers

While stream I/O reads a character at a time, channel I/O reads a buffer at a time.

A `SeekableByteChannel` implements the `ByteChannel` interface and is able to maintain and change a position in the channel. This makes random access of a file possible. The `newByteChannel` actually returns an instance of `SeekableByteChannel`. This method also supports `READ` as an OpenOption, because `SeekableByteChannel`s support both read and write.

### Creating Files

Empty files with an initial set of attributes ca be created by using `createFile(Path, FileAttribute<?>)` method. If no attributes are provided, the files is created with default attributes.

Some of the methods described above also create new files.

Temporary files can be created via the `createTempFile` method.

## Random Access Files

Random access files permit nonsequential, or random, access to a file's content. As mentioned above, the `SeekableByteChannel` interface, which extends channel I/O with the notion of a current position, allows you to do this. An instance of `SeekableByteChannel` can be created via `Path.newByteChannel`. This object can be used directly or turned into a `FileChannel`, which gives access to more advanced features.