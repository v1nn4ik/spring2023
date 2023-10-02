package org.spring2023;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.spring2023")
public class ArchitectureTest {
    private static final String PACKAGE_NAME = "org.spring2023";

    @ArchTest
    static final ArchRule LAYERS = layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("domain").definedBy(PACKAGE_NAME + ".domain..")
            .layer("app").definedBy(PACKAGE_NAME + ".app..")
            .layer("extern").definedBy(PACKAGE_NAME + ".extern.api..",
                    PACKAGE_NAME + ".extern.infrastructure..")

            .whereLayer("domain").mayOnlyBeAccessedByLayers("app", "extern")
            .whereLayer("app").mayOnlyBeAccessedByLayers("extern")
            .whereLayer("extern").mayNotBeAccessedByAnyLayer();
}
