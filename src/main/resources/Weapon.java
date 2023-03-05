enum WeaponTypes {
    Axes, Bows, Daggers, Hammers, Staffs, Swords, Wands
}
public class Weapon extends Item{

    int weaponDamage;
    WeaponTypes weaponType;

    Weapon(String _name, int _requiredLevel, itemSlot _slot, int _weaponDamage, WeaponTypes _weaponType) {
        super(_name, _requiredLevel, _slot);
        weaponDamage = _weaponDamage;
        weaponType = _weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public WeaponTypes getWeaponType() {
        return weaponType;
    }

}
