This example illustrates a potential issue with compiling ambiguous classes in Bazel.

Based on [this post in the Bazel Blog](https://blog.bazel.build/2017/06/28/sjd-unused_deps.html), 
"Bazel always passes the entire transitive classpath to javac, not only the direct classpath." 
The issue I'm running into is that when code imports using `*`, when a direct dependency is listed 
with the class that I want, but a transitive dependency has a class with the same name, then I'm getting 
resolved to the transitive dependency instead of the direct one.

In this sample (A,B,C,D are java_libraries) and:

    C depends on-> B depends on-> A
    C depends on-> D
    D and A both have a class with the same name, but different package names
    The main class in C and the ambiguous class in A have the same package name
    In the main class in C, all classes from D class are imported using *
    When the main class in C is compiled, we want to get the class from D, but we are getting it from A
    (The classes with the same name in A and D have different methods)

To try out, clone this repository and run: `bazel build //projectc/src/main/java:projectc`
The result is:

    projectc/src/main/java/samepackage/Entry.java:13: error: cannot find symbol
            a.setName( "MyName" );

This is because the AmbiguousClass (a) in Entry is getting resolved to samepackage.AmbiguousClass
instead of differentpackage.AmbiguousClass, even though differentpackage.AmbiguousClass is in
D and is a direct dependency of C.  