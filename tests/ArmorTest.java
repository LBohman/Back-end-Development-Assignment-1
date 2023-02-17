import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void armorCreation_returnValidArmor() {
        String armorName = "Rusty Chainmail";
        int requiredLevel = 1;
        itemSlot armorSlot = itemSlot.Chest;

        int dexterityAttribute = 0;
        int intelligenceAttribute = 0;
        int strengthAttribute = 2;
        HeroAttribute armorAttribute = new HeroAttribute(dexterityAttribute, intelligenceAttribute, strengthAttribute);
        ArmorTypes armorType = ArmorTypes.Mail;


        Armor rustyChainmail = new Armor(armorName, requiredLevel, armorSlot, armorAttribute, armorType);


        assertEquals(rustyChainmail.getName(), armorName);
        assertEquals(rustyChainmail.getRequiredLevel(), requiredLevel);
        assertEquals(rustyChainmail.getSlot(), armorSlot);
        assertEquals(rustyChainmail.getArmorAttribute(), armorAttribute);
        assertEquals(rustyChainmail.getArmorType(), armorType);
    }



}