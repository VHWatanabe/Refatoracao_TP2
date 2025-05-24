package parrot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParrotTest {

    // --- EUROPEAN PARROT ---

    @Test
    public void europeanParrot_hasBaseSpeed() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.EUROPEAN)
                .build();
        assertEquals(12.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void europeanParrot_cryIsCorrect() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.EUROPEAN)
                .build();
        assertEquals("Sqoork!", parrot.getCry());
    }

    // --- AFRICAN PARROT ---

    @Test
    public void africanParrot_noCoconuts_hasBaseSpeed() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(0)
                .build();
        assertEquals(12.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_oneCoconut_hasReducedSpeed() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(1)
                .build();
        assertEquals(3.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_twoCoconuts_speedZero() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(2)
                .build();
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void africanParrot_negativeCoconuts_doesNotReduceSpeed() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(-10)
                .build();
        assertTrue(parrot.getSpeed() >= 12.0);
    }

    @Test
    public void africanParrot_manyCoconuts_speedNotNegative() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(1000)
                .build();
        assertTrue(parrot.getSpeed() >= 0.0);
    }

    @Test
    public void africanParrot_cryIsCorrect() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.AFRICAN)
                .numberOfCoconuts(3)
                .build();
        assertEquals("Sqaark!", parrot.getCry());
    }

    // --- NORWEGIAN BLUE PARROT ---

    @Test
    public void norwegianBlue_nailed_speedZero() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(3.0)
                .isNailed(true)
                .build();
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_voltage15_speedCorrect() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(1.5)
                .build();
        assertEquals(18.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_highVoltage_speedCapped() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(4.0)
                .build();
        assertEquals(24.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_notNailed_negativeVoltage_allowsNegativeSpeed() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(-5.0)
                .build();
        assertEquals(0.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_voltageAboveCap_speedMax24() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(100.0)
                .build();
        assertEquals(24.0, parrot.getSpeed(), 0.001);
    }

    @Test
    public void norwegianBlue_cryWithVoltage() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(2.0)
                .build();
        assertEquals("Bzzzzzz", parrot.getCry());
    }

    @Test
    public void norwegianBlue_cryNoVoltage() {
        Parrot parrot = new Parrot.Builder()
                .type(ParrotTypeEnum.NORWEGIAN_BLUE)
                .voltage(0.0)
                .build();
        assertEquals("...", parrot.getCry());
    }
}
