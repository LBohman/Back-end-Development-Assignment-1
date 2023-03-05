import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RougeTest {
    Rogue rogue;
    int defaultLevel;
    int defaultDexterity;
    int defaultIntelligence;
    int defaultStrength;

    @BeforeEach
    void setUp() {
        String name = "Gollum";
        defaultLevel = 1;
        defaultDexterity = 6;
        defaultIntelligence = 1;
        defaultStrength = 2;
        rogue = new Rogue(name);
    }

    @Test
    void rogueCreation_setNameCorrectly() {
        String expected = "Gollum";

        assertEquals(rogue.getName(), expected);
    }

    @Test
    void rogueCreation_setLevelCorrectly() {
        int expected = 1;

        assertEquals(rogue.getLevel(), expected);
    }

    @Test
    void rogueCreation_setDefaultAttributesCorrectly() {
        HeroAttribute expected = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);

        assertEquals(rogue.getHeroAttributes().getDexterity(), expected.getDexterity());
        assertEquals(rogue.getHeroAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(rogue.getHeroAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void rogueLevelUp_setLevelCorrectly() {
        int expected = 2;

        rogue.levelUp();

        assertEquals(expected, rogue.getLevel());
    }

    @Test
    void rogueLevelUp_setAttributesCorrectly() {
        int afterLevelUpDexterity = 10;
        int afterLevelUpIntelligence = 2;
        int afterLevelUpStrength = 3;

        rogue.levelUp();

        assertEquals(afterLevelUpDexterity, rogue.getHeroAttributes().getDexterity());
        assertEquals(afterLevelUpIntelligence, rogue.getHeroAttributes().getIntelligence());
        assertEquals(afterLevelUpStrength, rogue.getHeroAttributes().getStrength());
    }
}