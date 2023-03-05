import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangerTest {
    Ranger ranger;
    int defaultLevel;
    int defaultDexterity;
    int defaultIntelligence;
    int defaultStrength;

    @BeforeEach
    void setUp() {
        String name = "Legolas";
        defaultLevel = 1;
        defaultDexterity = 7;
        defaultIntelligence = 1;
        defaultStrength = 1;
        ranger = new Ranger(name);
    }

    @Test
    void rangerCreation_setNameCorrectly() {
        String expected = "Legolas";

        assertEquals(ranger.getName(), expected);
    }

    @Test
    void rangerCreation_setLevelCorrectly() {
        int expected = 1;

        assertEquals(ranger.getLevel(), expected);
    }

    @Test
    void rangerCreation_setDefaultAttributesCorrectly() {
        HeroAttribute expected = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);

        assertEquals(ranger.getHeroAttributes().getDexterity(), expected.getDexterity());
        assertEquals(ranger.getHeroAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(ranger.getHeroAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void rangerLevelUp_setLevelCorrectly() {
        int expected = 2;

        ranger.levelUp();

        assertEquals(expected, ranger.getLevel());
    }

    @Test
    void rangerLevelUp_setAttributesCorrectly() {
        int afterLevelUpDexterity = 12;
        int afterLevelUpIntelligence = 2;
        int afterLevelUpStrength = 2;

        ranger.levelUp();

        assertEquals(afterLevelUpDexterity, ranger.getHeroAttributes().getDexterity());
        assertEquals(afterLevelUpIntelligence, ranger.getHeroAttributes().getIntelligence());
        assertEquals(afterLevelUpStrength, ranger.getHeroAttributes().getStrength());
    }
}