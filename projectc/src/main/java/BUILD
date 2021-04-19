load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "projectc",
    srcs = [
        "samepackage/Entry.java",
    ],
    deps = [
        "//projectd/src/main/java:projectd",
        "//projectb/src/main/java:projectb",
    ],
)
