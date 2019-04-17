package de.softwartechnik.catalin.core.repository.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractRepositoryTest {

    private static final Class<AbstractRepositoryTest> TEST_CLASS = AbstractRepositoryTest.class;

    private AbstractRepository<AbstractRepositoryTest> abstractRepository;

    @BeforeEach
    void setUp() {

        abstractRepository = new AbstractRepository<AbstractRepositoryTest>(TEST_CLASS) {

            @Override
            public AbstractRepositoryTest save(AbstractRepositoryTest entity) {

                throw new UnsupportedOperationException();
            }

            @Override
            public AbstractRepositoryTest find(long entityId) {

                throw new UnsupportedOperationException();
            }

            @Override
            public void remove(AbstractRepositoryTest entity) {

                throw new UnsupportedOperationException();
            }
        };
    }

    @Test
    void testGetEntityClass() {

        Class<AbstractRepositoryTest> entityClass = abstractRepository.getEntityClass();
        assertEquals(TEST_CLASS, entityClass, "Inserted and extracted classes should match.");
    }

    @Test
    void testSave() {

        assertThrows(UnsupportedOperationException.class, () ->
                        abstractRepository.save(AbstractRepositoryTest.this),
                "Executing #save() without implementation should throw UnsupportedOperationException.");
    }

    @Test
    void testFind() {

        assertThrows(UnsupportedOperationException.class, () ->
                        abstractRepository.find(-1),
                "Executing #find() without implementation should throw UnsupportedOperationException.");
    }

    @Test
    void testRemove() {

        assertThrows(UnsupportedOperationException.class, () ->
                        abstractRepository.remove(AbstractRepositoryTest.this),
                "Executing #remove() without implementation should throw UnsupportedOperationException.");
    }
}
