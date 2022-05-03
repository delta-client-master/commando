plugins {
    id("me.idriz.commando.java-conventions")
    id("me.idriz.commando.java-deploy")
}

dependencies {
    compileOnly("org.jetbrains:annotations:23.0.0")
}

description = "commando-core"

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