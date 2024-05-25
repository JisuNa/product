plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "musinsa-product"
include("product-api")
include("product-manager")
include("product-domain-rdb")
