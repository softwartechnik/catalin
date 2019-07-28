package de.softwartechnik.catalin.gui.swing.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.RowFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CatalinRowFilterTest {

  private static final String SEARCH_EMPTY = "";
  private static final String SEARCH = "3";

  @Mock
  private RowFilter.Entry entry;

  @Test
  void testWildcard() {

    // given
    RowFilter rowFilter = new CatalinRowFilter(SEARCH_EMPTY);

    // then
    boolean isIncluded = rowFilter.include(entry);

    assertTrue(isIncluded, "Wildcard should include everything");
  }

  @Test
  void testSpecific() {

    // given
    RowFilter rowFilter = new CatalinRowFilter(SEARCH);

    // when
    Mockito.doReturn(SEARCH).when(entry).getValue(Mockito.eq(0));

    // then
    boolean isIncluded = rowFilter.include(entry);

    assertTrue(isIncluded, "Specific matching if equals should return true");
  }

  @Test
  void testSpecificNonEquals() {

    // given
    RowFilter rowFilter = new CatalinRowFilter(SEARCH);

    // when
    Mockito.doReturn(SEARCH_EMPTY).when(entry).getValue(Mockito.eq(0));

    // then
    boolean isIncluded = rowFilter.include(entry);

    assertFalse(isIncluded, "Specific matching if non equals should return false");
  }
}
