package de.softwartechnik.catalin.core.repository.map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.softwartechnik.catalin.core.model.CatalinModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractMapRepositoryTest {

  private static final CatalinModel TEST_MODEL_1 = new Model(1);
  private static final CatalinModel TEST_MODEL_2 = new Model(2);
  private static final CatalinModel TEST_MODEL_3 = new Model(3);
  private static final long TEST_MODEL_COUNT = 3;
  private static final long ID_NOT_FOUND = 5;
  private final Map<Long, CatalinModel> storage = new HashMap<Long, CatalinModel>() {{
    put(TEST_MODEL_1.getId(), TEST_MODEL_1);
    put(TEST_MODEL_2.getId(), TEST_MODEL_2);
    put(TEST_MODEL_3.getId(), TEST_MODEL_3);
  }};
  public AbstractMapRepository myMapRep;

  @BeforeEach
  void setUp() {
    myMapRep = new AbstractMapRepository<>(storage, CatalinModel.class);
  }

  @Test
  void save() {
    CatalinModel TEST_MODEL_4 = new Model(4);
    assertEquals(TEST_MODEL_4, myMapRep.save(TEST_MODEL_4));
    //Teste ich hier storage.size? Weil mit MapRep.findAll() zu arbeiten wäre ja dumm. Weil nicht getestet.
    //#Testception
    assertEquals(TEST_MODEL_COUNT + 1, storage.size());
  }

  @Test
  void find() {
    assertEquals(TEST_MODEL_1, myMapRep.find(TEST_MODEL_1.getId()));
    assertEquals(TEST_MODEL_2, myMapRep.find(TEST_MODEL_2.getId()));
    assertNull(myMapRep.find(ID_NOT_FOUND));
    assertNotEquals(TEST_MODEL_1, myMapRep.find(TEST_MODEL_2.getId()));
  }

  @Test
  void findAll() {
    List<Model> resList = myMapRep.findAll();
    CatalinModel[] models = {TEST_MODEL_1, TEST_MODEL_2, TEST_MODEL_3};
    assertEquals(TEST_MODEL_COUNT, resList.size());

    //ArrayEquals prüft auf Gleichheit der Reihenfolge...das ist theoretisch nicht nötig bei unserem Repository
    assertArrayEquals(models, resList.toArray());
  }

  @Test
  void remove() {
    myMapRep.remove(TEST_MODEL_1);

    assertNull(myMapRep.find(TEST_MODEL_1.getId()));
    assertEquals(TEST_MODEL_COUNT - 1, storage.size());
  }

  public static class Model implements CatalinModel {

    private long id;

    public Model(long id) {
      this.id = id;
    }

    @Override
    public long getId() {
      return id;
    }

    @Override
    public void setId(long id) {
      this.id = id;
    }
  }


}
