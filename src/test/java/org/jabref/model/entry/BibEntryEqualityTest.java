package org.jabref.model.entry;

import org.jabref.model.entry.field.UnknownField;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BibEntryEqualityTest {
    @Test
    public void identicObjectsareEqual() throws Exception {
        BibEntry e1 = new BibEntry();
        BibEntry e2 = e1;
        assertTrue(e1.equals(e2));
    }

    @Test
    public void compareToNullObjectIsFalse() throws Exception {
        BibEntry e1 = new BibEntry();
        assertFalse(e1.equals(null));
    }

    @Test
    public void compareToDifferentClassIsFalse() throws Exception {
        BibEntry e1 = new BibEntry();
        Object e2 = new Object();
        assertFalse(e1.equals(e2));
    }

    @Test
    public void compareIsTrueWhenIdAndFieldsAreEqual() throws Exception {
        BibEntry e1 = new BibEntry();
        e1.setId("1");
        e1.setField(new UnknownField("key"), "value");
        BibEntry e2 = new BibEntry();
        e2.setId("1");
        assertNotEquals(e1, e2);
        e2.setField(new UnknownField("key"), "value");
        assertEquals(e1, e2);
    }
}
