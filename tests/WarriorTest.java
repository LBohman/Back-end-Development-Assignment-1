import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Warrior warrior;
    int defaultLevel;
    int defaultDexterity;
    int defaultIntelligence;
    int defaultStrength;

    int requiredLevel;
    itemSlot slot;
    String armorName;
    HeroAttribute armorAttribute;
    ArmorTypes armorType;
    String weaponName;
    int weaponDamage;
    WeaponTypes weaponType;

    @BeforeEach
    void setUp() {
        String name = "Aragorn";
        defaultLevel = 1;
        defaultDexterity = 2;
        defaultIntelligence = 1;
        defaultStrength = 5;
        warrior = new Warrior(name);
    }

    @Test
    void warriorCreation_setNameCorrectly() {
        String expected = "Aragorn";

        assertEquals(warrior.getName(), expected);
    }

    @Test
    void warriorCreation_setLevelCorrectly() {
        int expected = 1;

        assertEquals(warrior.getLevel(), expected);
    }

    @Test
    void warriorCreation_setDefaultAttributesCorrectly() {
        HeroAttribute expected = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);

        assertEquals(warrior.getHeroAttributes().getDexterity(), expected.getDexterity());
        assertEquals(warrior.getHeroAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(warrior.getHeroAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void warriorLevelUp_setLevelCorrectly() {
        int expected = 2;

        warrior.levelUp();

        assertEquals(expected, warrior.getLevel());
    }

    @Test
    void warriorLevelUp_setAttributesCorrectly() {
        int afterLevelUpDexterity = 4;
        int afterLevelUpIntelligence = 2;
        int afterLevelUpStrength = 8;

        warrior.levelUp();

        assertEquals(afterLevelUpDexterity, warrior.getHeroAttributes().getDexterity());
        assertEquals(afterLevelUpIntelligence, warrior.getHeroAttributes().getIntelligence());
        assertEquals(afterLevelUpStrength, warrior.getHeroAttributes().getStrength());
    }

    @Test
    void equipWeapon_SuccessfullyEquip() {
        weaponName = "Iron Sword";
        requiredLevel = 1;
        slot = itemSlot.Weapon;
        weaponDamage = 1;
        weaponType = WeaponTypes.Swords;

        Weapon expected = new Weapon(weaponName, requiredLevel, slot, weaponDamage, weaponType);
        warrior.equipWeapon(expected);

        assertEquals(expected, warrior.equipment.get(slot));
    }

    @Test
    void equipWeapon_failEquip_tooLowLevel() {
        weaponName = "Tempered Iron Sword";
        requiredLevel = 2;
        slot = itemSlot.Weapon;
        weaponDamage = 1;
        weaponType = WeaponTypes.Swords;
        boolean expected = false;

        Weapon ironSword = new Weapon(weaponName, requiredLevel, slot, weaponDamage, weaponType);

        assertEquals(expected, warrior.equipWeapon(ironSword));
    }

    @Test
    void equipWeapon_failEquip_invalidWeaponType() {
        weaponName = "Oak Staff";
        requiredLevel = 1;
        slot = itemSlot.Weapon;
        weaponDamage = 1;
        weaponType = WeaponTypes.Staffs;
        boolean expected = false;

        Weapon oakStaff = new Weapon(weaponName, requiredLevel, slot, weaponDamage, weaponType);

        assertEquals(expected, warrior.equipWeapon(oakStaff));
    }

    @Test
    void equipArmor_SuccessfullyEquip() {
        armorName = "Rusty Chainmail";
        requiredLevel = 1;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);
        armorType = ArmorTypes.Mail;

        Armor expected = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);
        warrior.equipArmor(expected);

        assertEquals(expected, warrior.equipment.get(slot));
    }

    @Test
    void equipArmor_failEquip_tooLowLevel() {
        armorName = "Blessed Chainmail";
        requiredLevel = 2;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);
        armorType = ArmorTypes.Mail;
        boolean expected = false;

        Armor blessedChainmail = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);

        assertEquals(expected, warrior.equipArmor(blessedChainmail));
    }

    @Test
    void equipArmor_failEquip_invalidArmorType() {
        armorName = "Plain Tunic";
        requiredLevel = 1;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);
        armorType = ArmorTypes.Cloth;
        boolean expected = false;

        Armor plainTunic = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);

        assertEquals(expected, warrior.equipArmor(plainTunic));
    }
}

