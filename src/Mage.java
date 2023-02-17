public class Mage extends Hero {

    public Mage(String _name) {
        super(_name);
        heroAttributes = new HeroAttribute(1, 8, 1);
        levelUpAttributes = new HeroAttribute(1, 5, 1);
        damagingAttribute = attributeTypes.Intelligence;
        equipableArmorTypes = new ArmorTypes[]{ArmorTypes.Cloth};
        equipableWeaponTypes = new WeaponTypes[]{WeaponTypes.Staffs, WeaponTypes.Wands};
    }
}
