plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

nexusPublishing {
    repositories {
        create("deltaNexus") {
            nexusUrl.set(uri("https://nexus.deltaclient.com/repository/maven-releases/"))
            snapshotRepositoryUrl.set(uri("https://nexus.deltaclient.com/repository/maven-snapshots/"))

            useStaging.set(false)

            val deltaNxUser = System.getenv("DELTA_NX_USER")
            val deltaNxPass = System.getenv("DELTA_NX_PASS")

            username.set(deltaNxUser)
            password.set(deltaNxPass)
        }
    }
}