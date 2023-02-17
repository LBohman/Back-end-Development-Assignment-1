 public class Rogue extends Hero {

    public Rogue(String _name) {
        super(_name);
        heroAttributes = new HeroAttribute(6, 1, 2);
        levelUpAttributes = new HeroAttribute(4, 1, 1);
        damagingAttribute = attributeTypes.Dexterity;
        equipableArmorTypes = new ArmorTypes[]{ArmorTypes.Leather, ArmorTypes.Mail};
        equipableWeaponTypes = new WeaponTypes[]{WeaponTypes.Daggers, WeaponTypes.Swords};
    }
}
