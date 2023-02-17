public class Ranger extends Hero {

    public Ranger(String _name) {
        super(_name);
        heroAttributes = new HeroAttribute(7, 1, 1);
        levelUpAttributes = new HeroAttribute(5, 1, 1);
        damagingAttribute = attributeTypes.Dexterity;
        equipableArmorTypes = new ArmorTypes[]{ArmorTypes.Leather, ArmorTypes.Mail};
        equipableWeaponTypes = new WeaponTypes[]{WeaponTypes.Bows};
    }
}
