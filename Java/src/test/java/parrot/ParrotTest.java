package parrot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParrotTest {

    // --- EUROPEAN PARROT ---

    @Test
    public void europeanParrot_hasBaseSpeed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void europeanParrot_cryIsCorrect() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals("Sqoork!", parrot.getCry());
    }

    // --- AFRICAN PARROT ---

    @Test
    public void africanParrot_noCoconuts_hasBaseSpeed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_oneCoconut_hasReducedSpeed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals(3.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_twoCoconuts_speedZero() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 2, 0, false);
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_negativeCoconuts_doesNotReduceSpeed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, -10, 0, false);
        assertTrue(parrot.getSpeed() >= 12.0);
    }

    @Test
    public void africanParrot_manyCoconuts_speedNotNegative() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 1000, 0, false);
        assertTrue(parrot.getSpeed() >= 0.0);
    }

    @Test
    public void africanParrot_cryIsCorrect() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 3, 0, false);
        assertEquals("Sqaark!", parrot.getCry());
    }

    // --- NORWEGIAN BLUE PARROT ---

    @Test
    public void norwegianBlue_nailed_speedZero() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 3.0, true);
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_voltage15_speedCorrect() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_highVoltage_speedCapped() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4.0, false);
        assertEquals(24.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_negativeVoltage_allowsNegativeSpeed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, -5.0, false);
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_voltageAboveCap_speedMax24() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 100.0, false);
        assertEquals(24.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_cryWithVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 2.0, false);
        assertEquals("Bzzzzzz", parrot.getCry());
    }

    @Test
    public void norwegianBlue_cryNoVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 0.0, false);
        assertEquals("...", parrot.getCry());
    }
}
