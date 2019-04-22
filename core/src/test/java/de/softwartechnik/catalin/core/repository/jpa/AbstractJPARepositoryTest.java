package de.softwartechnik.catalin.core.repository.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AbstractJPARepositoryTest {

    private static final Class<AbstractJPARepositoryTest> TEST_CLASS = AbstractJPARepositoryTest.class;

    @Mock
    AbstractJPARepositoryTest testObject;

    @Mock
    private EntityManager entityManager;

    private AbstractJPARepository<AbstractJPARepositoryTest> abstractJPARepository;

    @BeforeEach
    void setUp() {

        abstractJPARepository = new AbstractJPARepository<AbstractJPARepositoryTest>(TEST_CLASS, new Provider<EntityManager>() {
            @Override
            public EntityManager get() {
                return entityManager;
            }
        }) {
        };
    }

    @Test
    void testSave() {

        // Given

        // When
        AbstractJPARepositoryTest returnedObject = abstractJPARepository.save(testObject);

        // Then
        verify(entityManager).persist(testObject);
        verify(entityManager).flush();

        assertEquals(testObject, returnedObject, "The saved object and the returned object from JPA should be the same.");
    }

    @Test
    void testFind() {

        // Given

        // When
        doReturn(testObject).when(entityManager).find(AbstractJPARepositoryTest.TEST_CLASS, 0L);

        AbstractJPARepositoryTest result = abstractJPARepository.find(0L);

        // Then
        assertEquals(testObject, result, "The returned object and returned object from JPA should be the same.");
    }

    @Test
    void testRemove() {

        // Given

        // When
        abstractJPARepository.remove(testObject);

        // Then
        verify(entityManager).remove(testObject);
    }
}
