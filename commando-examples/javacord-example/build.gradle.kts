plugins {
    id("me.idriz.commando.java-conventions")
}

dependencies {
    implementation("org.javacord:javacord:3.4.0")
    implementation(project(":commando-javacord"))
    implementation(project(":commando-core"))
    implementation("org.jetbrains:annotations:23.0.0")
}

group = "me.idriz.commando.examples"
description = "javacord-example"