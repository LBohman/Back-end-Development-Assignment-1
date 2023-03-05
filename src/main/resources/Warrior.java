public class Warrior extends Hero {

    public Warrior(String _name) {
        super(_name);

        heroAttributes = new HeroAttribute(2,1,5);
        levelUpAttributes = new HeroAttribute(2,1,3);
        damagingAttribute = attributeTypes.Strength;
        equipableArmorTypes = new ArmorTypes[]{ArmorTypes.Plate, ArmorTypes.Mail};
        equipableWeaponTypes = new WeaponTypes[]{WeaponTypes.Axes, WeaponTypes.Swords, WeaponTypes.Hammers};
    }
}
