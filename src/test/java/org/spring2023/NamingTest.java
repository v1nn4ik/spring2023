package org.spring2023;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "org.spring2023")
public class NamingTest {
    @ArchTest
    static final ArchRule CONTROLLER_NAMING = classes()
            .that().areAnnotatedWith(Controller.class)
            .or().haveSimpleNameEndingWith("Controller")
            .should().beAnnotatedWith(Controller.class)
            .andShould().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule SERVICE_NAMING = classes()
            .that().areAnnotatedWith(Service.class)
            .or().haveSimpleNameEndingWith("Service")
            .should().beAnnotatedWith(Service.class)
            .andShould().haveSimpleNameEndingWith("Service");

    @ArchTest
    static final ArchRule REPOSITORY_NAMING = classes()
            .that().areAnnotatedWith(Repository.class)
            .or().haveSimpleNameEndingWith("Repository")
            .should().beAnnotatedWith(Repository.class)
            .andShould().haveSimpleNameEndingWith("Repository");
}
