plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.kotlinxSerialization)
	alias(libs.plugins.ksp)
}

group = "me.liusui"
version = "1.0"

repositories {
	mavenCentral()
}

kotlin {


	mingwX64("native_mingwX64") {
		binaries {
			executable {
				entryPoint = "main"
			}
			sharedLib {
				baseName = "libNative"
			}
		}
	}
//	js {
//		browser()
//	}


	sourceSets {
		nativeMain.dependencies {
			implementation(libs.kotlinxSerializationJson)
			implementation(libs.ktor.client.winhttp)

		}
//        jsMain{
//            dependencies {
//
//            }
//        }
		commonMain.dependencies {
			implementation(libs.ktor.client.core)
			implementation(libs.ktor.client.cio)
			implementation(libs.ktor.client.websockets)
			implementation(libs.ktor.serialization.kotlinx.json)

		}

	}
}