import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponTest {

    @Test
    void weaponCreation_returnValidWeapon() {
        String weaponName = "Iron Broad Sword";
        int requiredLevel = 1;
        itemSlot weaponSlot = itemSlot.Weapon;
        int weaponDamage = 3;
        WeaponTypes weaponType = WeaponTypes.Swords;

        Weapon ironBroadSword = new Weapon(weaponName, requiredLevel, weaponSlot, weaponDamage, weaponType);

        assertEquals(ironBroadSword.getName(), weaponName);
        assertEquals(ironBroadSword.getRequiredLevel(), requiredLevel);
        assertEquals(ironBroadSword.getSlot(), weaponSlot);
        assertEquals(ironBroadSword.getWeaponDamage(), weaponDamage);
        assertEquals(ironBroadSword.getWeaponType(), weaponType);
    }
}