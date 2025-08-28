
rootProject.name = "my-multi-module-project"

// Eklenecek modülleri manuel olarak belirleyebilirsin
include(":app")
include(":domain")
include(":data")
include(":presentation")

// Ya da otomatik tarama ile alt modülleri eklemek istersen:
rootDir.walkTopDown()
    .filter { it.isDirectory && File(it, "build.gradle.kts").exists() || File(it, "build.gradle").exists() }
    .forEach { dir ->
        val path = dir.relativeTo(rootDir).path
        if (path.isNotEmpty()) {
            // eğer zaten ekli değilse ekle
            val alreadyIncluded = settings.findProject(":$path") != null
            if (!alreadyIncluded) {
                include(":$path")
            }
        }
    }
