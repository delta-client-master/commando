plugins {
    id("me.idriz.commando.java-conventions")
    id("me.idriz.commando.java-deploy")
}

dependencies {
    implementation("org.javacord:javacord:3.4.0")
    implementation(project(":commando-core"))
    implementation("org.jetbrains:annotations:21.0.0")
}

description = "commando-javacord"

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        register<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}