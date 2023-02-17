import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {
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
    void totalAttributes_noEquipment() {
        HeroAttribute expected = new HeroAttribute(defaultDexterity, defaultIntelligence, defaultStrength);

        assertEquals(warrior.totalAttributes().getDexterity(), expected.getDexterity());
        assertEquals(warrior.totalAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(warrior.totalAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void totalAttributes_oneArmorPieceEquipped() {
        // Arrange
        int armorDexterity = 0;
        int armorIntelligence = 0;
        int armorStrength = 1;

        int expectedDexterity = 2;
        int expectedIntelligence = 1;
        int expectedStrength = 6;

        armorName = "Rusty Chainmail";
        requiredLevel = 1;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(armorDexterity, armorIntelligence, armorStrength);
        armorType = ArmorTypes.Mail;

        // Act
        Armor rustyChainmail = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);
        warrior.equipArmor(rustyChainmail);

        // Assert
        HeroAttribute expected = new HeroAttribute(expectedDexterity, expectedIntelligence, expectedStrength);
        assertEquals(warrior.totalAttributes().getDexterity(), expected.getDexterity());
        assertEquals(warrior.totalAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(warrior.totalAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void totalAttributes_twoArmorPiecesEquipped() {
        // Arrange
        int armorDexterity = 0;
        int armorIntelligence = 0;
        int armorStrength = 1;

        int secondArmorDexterity = 1;
        int secondArmorIntelligence = 0;
        int secondArmorStrength = 2;

        int expectedDexterity = 3;
        int expectedIntelligence = 1;
        int expectedStrength = 8;

        armorName = "Rusty Chainmail";
        requiredLevel = 1;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(armorDexterity, armorIntelligence, armorStrength);
        armorType = ArmorTypes.Mail;

        String secondArmorName = "Plate Boots";
        itemSlot secondArmorSlot = itemSlot.Legs;
        HeroAttribute secondArmorAttribute = new HeroAttribute(secondArmorDexterity, secondArmorIntelligence, secondArmorStrength);
        ArmorTypes secondArmorType = ArmorTypes.Plate;

        // Act
        Armor rustyChainmail = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);
        Armor plateBoots = new Armor(secondArmorName, requiredLevel, secondArmorSlot, secondArmorAttribute, secondArmorType);
        warrior.equipArmor(rustyChainmail);
        warrior.equipArmor(plateBoots);

        // Assert
        HeroAttribute expected = new HeroAttribute(expectedDexterity, expectedIntelligence, expectedStrength);
        assertEquals(warrior.totalAttributes().getDexterity(), expected.getDexterity());
        assertEquals(warrior.totalAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(warrior.totalAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void totalAttributes_replaceArmorInSameSlot() {
        // Arrange
        int armorDexterity = 0;
        int armorIntelligence = 0;
        int armorStrength = 1;

        int replaceArmorDexterity = 1;
        int replaceArmorIntelligence = 0;
        int replaceArmorStrength = 2;

        int expectedDexterity = 3;
        int expectedIntelligence = 1;
        int expectedStrength = 7;

        armorName = "Rusty Chainmail";
        requiredLevel = 1;
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(armorDexterity, armorIntelligence, armorStrength);
        armorType = ArmorTypes.Mail;

        String replaceArmorName = "Tempered Chainmail";
        HeroAttribute replaceArmorAttribute = new HeroAttribute(replaceArmorDexterity, replaceArmorIntelligence, replaceArmorStrength);

        // Act
        Armor rustyChainmail = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);
        Armor temperedChainmail = new Armor(replaceArmorName, requiredLevel, slot, replaceArmorAttribute, armorType);
        warrior.equipArmor(rustyChainmail);
        warrior.equipArmor(temperedChainmail);

        // Assert
        HeroAttribute expected = new HeroAttribute(expectedDexterity, expectedIntelligence, expectedStrength);
        assertEquals(warrior.totalAttributes().getDexterity(), expected.getDexterity());
        assertEquals(warrior.totalAttributes().getIntelligence(), expected.getIntelligence());
        assertEquals(warrior.totalAttributes().getStrength(), expected.getStrength());
    }

    @Test
    void totalAttributes_baseDamageNoWeaponNoArmor() {
        double expected = 1.05;

        assertEquals(expected, warrior.damage());
    }

    @Test
    void heroDamage_damageEquipWeaponNoArmor() {
        // Arrange
        String weaponName = "Iron Broad Sword";
        int requiredLevel = 1;
        itemSlot weaponSlot = itemSlot.Weapon;
        int weaponDamage = 3;
        WeaponTypes weaponType = WeaponTypes.Swords;

        double expected = 3.1500000000000004;

        // Act
        Weapon ironBroadSword = new Weapon(weaponName, requiredLevel, weaponSlot, weaponDamage, weaponType);
        warrior.equipWeapon(ironBroadSword);

        // Arrange
        assertEquals(expected, warrior.damage());
    }

    @Test
    void heroDamage_damageEquipAndReplaceWeaponNoArmor() {
        // Arrange
        String weaponName = "Iron Broad Sword";
        int requiredLevel = 1;
        itemSlot weaponSlot = itemSlot.Weapon;
        int weaponDamage = 3;
        WeaponTypes weaponType = WeaponTypes.Swords;

        String secondWeaponName = "Steel Hammer";
        int secondWeaponDamage = 5;
        WeaponTypes secondWeaponType = WeaponTypes.Hammers;

        double expected = 5.25;

        // Act
        Weapon ironBroadSword = new Weapon(weaponName, requiredLevel, weaponSlot, weaponDamage, weaponType);
        Weapon steelHammer = new Weapon(secondWeaponName, requiredLevel, weaponSlot, secondWeaponDamage, secondWeaponType);
        warrior.equipWeapon(ironBroadSword);
        warrior.equipWeapon(steelHammer);

        // Arrange
        assertEquals(expected, warrior.damage());
    }

    @Test
    void heroDamage_damageEquipWeaponAndArmor() {
        // Arrange
        String weaponName = "Iron Broad Sword";
        int requiredLevel = 1;
        itemSlot weaponSlot = itemSlot.Weapon;
        int weaponDamage = 3;
        WeaponTypes weaponType = WeaponTypes.Swords;

        int armorDexterity = 0;
        int armorIntelligence = 0;
        int armorStrength = 1;

        armorName = "Rusty Chainmail";
        slot = itemSlot.Chest;
        armorAttribute = new HeroAttribute(armorDexterity, armorIntelligence, armorStrength);
        armorType = ArmorTypes.Mail;

        double expected = 3.18;

        // Act
        Weapon ironBroadSword = new Weapon(weaponName, requiredLevel, weaponSlot, weaponDamage, weaponType);
        Armor rustyChainmail = new Armor(armorName, requiredLevel, slot, armorAttribute, armorType);
        warrior.equipWeapon(ironBroadSword);
        warrior.equipArmor(rustyChainmail);

        // Assert
        assertEquals(expected, warrior.damage());
    }


}