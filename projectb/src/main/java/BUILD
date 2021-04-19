load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "projectb",
    srcs = ["otherpackage/OtherClass.java"],
    deps = [
        "//projecta/src/main/java:projecta",
    ],
)
