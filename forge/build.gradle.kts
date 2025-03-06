architectury.forge()

loom {
    val common = project(":common")
    accessWidenerPath = common.loom.accessWidenerPath

    forge {
        mixinConfig("bloodisfuel-common.mixins.json")
        mixinConfig("bloodisfuel.mixins.json")

        convertAccessWideners = true
        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
    }
}

repositories {
    // mavens for Forge-exclusives
    maven("https://maven.terraformersmc.com/releases/") // EMI
    maven("https://jitpack.io/") // Mixin Extras, Fabric ASM
    maven("https://maven.tterrag.com/") { // Create Forge and Registrate Forge
        content {
            includeGroup("com.tterrag.registrate")
            includeGroup("com.simibubi.create")
        }
    }
}

dependencies {
    forge("net.minecraftforge:forge:${"minecraft_version"()}-${"forge_version"()}")
    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionForge")) { isTransitive = false }

    // Create and its dependencies
    modImplementation("com.simibubi.create:create-${"minecraft_version"()}:${"create_forge_version"()}:slim") { isTransitive = false }
    modImplementation("net.createmod.ponder:Ponder-Forge-${"minecraft_version"()}:${"ponder_version"()}")
    modImplementation("com.tterrag.registrate:Registrate:${"registrate_forge_version"()}")
    modCompileOnly("dev.engine-room.flywheel:flywheel-forge-api-${"minecraft_version"()}:${"flywheel_version"()}")
    modRuntimeOnly("dev.engine-room.flywheel:flywheel-forge-${"minecraft_version"()}:${"flywheel_version"()}")

    // Development QOL
    modLocalRuntime("dev.emi:emi-forge:${"emi_version"()}")

    compileOnly("io.github.llamalad7:mixinextras-common:${"mixin_extras_version"()}")
    annotationProcessor(implementation(include("io.github.llamalad7:mixinextras-forge:${"mixin_extras_version"()}")!!)!!)
}

operator fun String.invoke(): String {
    return rootProject.ext[this] as? String
        ?: throw IllegalStateException("Property $this is not defined")
}