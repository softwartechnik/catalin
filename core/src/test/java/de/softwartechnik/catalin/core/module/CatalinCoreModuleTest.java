package de.softwartechnik.catalin.core.module;

import com.google.inject.Guice;
import de.softwartechnik.catalin.core.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CatalinCoreModuleTest {

    @Inject
    private PersonService injectedPersonService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new CatalinCoreModule()).injectMembers(this);
    }

    @Test
    void testConfigure() {

        assertNotNull(injectedPersonService, "Person service couldn't be injected properly.");
    }
}
