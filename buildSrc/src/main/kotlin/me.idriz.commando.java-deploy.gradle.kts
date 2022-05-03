plugins {
    `java-library`
    `maven-publish`
}

publishing {
    repositories {
        maven {
            credentials {
                username = System.getenv("DELTA_NX_USER")
                password = System.getenv("DELTA_NX_PASS")
            }

            url = if (project.version.toString().endsWith("-SNAPSHOT")) {
                uri("https://nexus.deltaclient.com/repository/maven-snapshots/")
            } else {
                uri("https://nexus.deltaclient.com/repository/maven-releases/")
            }
        }
    }
}