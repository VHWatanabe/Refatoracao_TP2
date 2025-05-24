package parrot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import parrot.ParrotTypeEnum;

public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }
    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals(3.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 2, 0, false);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, true);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4, false);
        assertEquals(24.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getCryOfEuropeanParrot() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals("Sqoork!", parrot.getCry());
    }

    @Test
    public void getCryOfAfricanParrot() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals("Sqaark!", parrot.getCry());
    }
    @Test
    public void getCryOfNorwegianBlueHighVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4, false);
        assertEquals("Bzzzzzz", parrot.getCry());
    }

    @Test
    public void getCryOfNorwegianBlueNoVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 0, false);
        assertEquals("...", parrot.getCry());
    }

    //NOVOS TESTES A PARTIR DAQUI

    @Test
    public void testSpeedZeroCoconuts() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 0, 0.0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0001, "Velocidade com 0 cocos deve ser base");
    }

    @Test
    public void testSpeedNegativeCoconuts() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, -10, 0.0, false);
        assertTrue(parrot.getSpeed() >= 12.0, "Cocos negativos devem ser tratados (não reduzir velocidade)");
    }

    @Test
    public void testSpeedHighVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 100.0, false);
        assertEquals(24.0, parrot.getSpeed(), 0.0001, "Velocidade máxima para alta voltagem é 24");
    }

    @Test
    public void testNegativeVoltage() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, -5.0, false);
        assertTrue(parrot.getSpeed() < 0, "Voltagem negativa gera velocidade negativa (atualmente)");
    }


    @Test
    public void testHighNumberOfCoconuts() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 1000, 0.0, false);
        assertTrue(parrot.getSpeed() >= 0, "Mesmo com muitos cocos, a velocidade não deve ser negativa");
    }

    @Test
    public void testEuropeanParrotCry() {
        Parrot parrot = new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0.0, false);
        assertEquals("Sqoork!", parrot.getCry());
    }

    @Test
    public void testAfricanParrotCry() {
        Parrot parrot = new Parrot(ParrotTypeEnum.AFRICAN, 0, 0.0, false);
        assertEquals("Sqaark!", parrot.getCry());
    }

    @Test
    public void testNorwegianBlueWithVoltageCry() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.0, false);
        assertEquals("Bzzzzzz", parrot.getCry());
    }

    @Test
    public void testNorwegianBlueNoVoltageCry() {
        Parrot parrot = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 0.0, false);
        assertEquals("...", parrot.getCry());
    }
}
