package hu.petrik.eloadasprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EloadasTest {

    Eloadas eloadas;
    @BeforeEach
    void setUp() {
        eloadas = new Eloadas(4, 5);
    }

    @Test
    void Eloadas() {
        assertThrows(IllegalAccessException.class, () -> new Eloadas(0, 5));
        assertThrows(IllegalAccessException.class, () -> new Eloadas(4, 0));
        assertThrows(IllegalAccessException.class, () -> new Eloadas(4, -3));
        assertThrows(IllegalAccessException.class, () -> new Eloadas(-7, 5));
        assertThrows(IllegalAccessException.class, () -> new Eloadas(-7, -3));
        assertThrows(IllegalAccessException.class, () -> new Eloadas(0, 0));
    }
    @Test
    void lefoglal() {
        for (int i = 0; i < 20; i++) {
            assertTrue(eloadas.lefoglal());
        }
       assertFalse(eloadas.lefoglal());
       assertFalse(eloadas.lefoglal());
    }

    @Test
    void getSzabadHelyek() {
        assertEquals(20, eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(19, eloadas.getSzabadHelyek());
        for (int i = 0; i < 18; i++) {
            eloadas.lefoglal();
        }
        assertEquals(1,eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(0,eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(0,eloadas.getSzabadHelyek());

    }

    @Test
    void getTeli() {
        eloadas.lefoglal();

        assertFalse(eloadas.getTeli());
        for (int i = 0; i < 18; i++) {
            eloadas.lefoglal();
        }
        assertFalse(eloadas.getTeli());
        eloadas.lefoglal();
        assertFalse(eloadas.getTeli());
        eloadas.lefoglal();
        assertFalse(eloadas.getTeli());
    }

    @Test
    void foglalt() {
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(0, 5));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(4, 0));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(4, -3));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(-7, 5));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(-7, -3));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(0, 0));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(5, 3));
        assertThrows(IllegalAccessException.class, () -> eloadas.foglalt(3, 6));

        assertFalse(eloadas.foglalt(1,1));
        eloadas.lefoglal();
        assertTrue(eloadas.foglalt(1,1));
        assertFalse(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));
        eloadas.lefoglal();
        assertTrue(eloadas.foglalt(1,1));
        assertFalse(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));
        for (int i = 0; i < 3; i++) {
            eloadas.lefoglal();
        }
        assertTrue(eloadas.foglalt(1,1));
        assertTrue(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));
    }
}