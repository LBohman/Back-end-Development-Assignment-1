import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    Mage mage;
    int defaultLevel;
    int defaultDexterity;
    int defaultIntelligence;
    int defaultStrength;

    @BeforeEach
    void setUp() {
        String name = "Gandalf";
        defaultLevel = 1;
        defaultDexterity = 1;
        defaultIntelligence = 8;
        defaultStrength = 1;
        mage = new Mage(name);
    }

    @Test
    void mageCreation_setNameCorrectly() {
        String expected = "Gandalf";

        assertEquals(mage.getName(), expected);
    }

    @Test
    void mageCreation_setLevelCorrectly() {
        int expected = 1;

        assertEquals(mage.getLevel(), expected);
    }

    @Test
    void mageCreation_setDefaultAttributesCorrectly() {
        HeroAttribute expected = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);

        assertEquals(mage.getHeroAttributes().getDexterity(), expected.getDexterity());
        assertEquals(mage.getHeroAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(mage.getHeroAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void mageLevelUp_setLevelCorrectly() {
        int expected = 2;

        mage.levelUp();

        assertEquals(expected, mage.getLevel());
    }

    @Test
    void mageLevelUp_setAttributesCorrectly() {
        int afterLevelUpDexterity = 2;
        int afterLevelUpIntelligence = 13;
        int afterLevelUpStrength = 2;

        mage.levelUp();

        assertEquals(afterLevelUpDexterity, mage.getHeroAttributes().getDexterity());
        assertEquals(afterLevelUpIntelligence, mage.getHeroAttributes().getIntelligence());
        assertEquals(afterLevelUpStrength, mage.getHeroAttributes().getStrength());
    }
}