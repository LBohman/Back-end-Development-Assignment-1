enum ArmorTypes {
    Cloth, Leather, Mail, Plate
}
public class Armor extends Item {

    HeroAttribute armorAttribute;
    ArmorTypes armorType;

    Armor(String _name, int _requiredLevel, itemSlot _slot, HeroAttribute _armorAttribute, ArmorTypes _armorType) {
        super(_name, _requiredLevel, _slot);
        armorAttribute = _armorAttribute;
        armorType = _armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public ArmorTypes getArmorType() { return armorType; }

}
