import java.util.HashMap;

enum itemSlot {
    Head, Chest, Legs, Weapon
}
enum attributeTypes {
    Dexterity, Intelligence, Strength
}
public abstract class Hero {
    private String name;
    private int level;
    ArmorTypes equipableArmorTypes[];
    WeaponTypes equipableWeaponTypes[];
    HashMap<itemSlot, Item> equipment = new HashMap<itemSlot, Item>();
    attributeTypes damagingAttribute;

    HeroAttribute heroAttributes = new HeroAttribute();
    HeroAttribute levelUpAttributes = new HeroAttribute();
    Hero(String _name) {
        name = _name;
        level = 1;
        equipment.put(itemSlot.Head, null);
        equipment.put(itemSlot.Chest, null);
        equipment.put(itemSlot.Legs, null);
        equipment.put(itemSlot.Weapon, null);
    }

    private boolean checkArmorType(Armor item) {
        for (int i = 0; i < equipableArmorTypes.length; i++) {
            if (equipableArmorTypes[i] == item.armorType) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWeaponType(Weapon item) {
        for (int i = 0; i < equipableWeaponTypes.length; i++) {
            if (equipableWeaponTypes[i] == item.weaponType) {
                return true;
            }
        }
        return false;
    }

    boolean equipArmor(Armor item) {
        try {
            if (!checkArmorType(item)) {
                throw new InvalidArmorException("Your hero cannot equip armor of type: " + item.armorType);
            } else if (level < item.getRequiredLevel()) {
                throw new InvalidArmorException("This armor requires a level of " + item.getRequiredLevel() + " to equip it");
            } else {
                equipment.put(item.getSlot(), item);
                System.out.println("Successfully equipped Armor.");
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /* boolean equipArmor(Armor item) throws InvalidArmorException {
        if (!checkArmorType(item)) {
            throw new InvalidArmorException("Your hero cannot equip armor of type: " + item.armorType);
        } else if (level < item.getRequiredLevel()) {
            throw new InvalidArmorException("This armor requires a level of " + item.getRequiredLevel() + " to equip it");
        } else {
            equipment.put(item.getSlot(), item);
            System.out.println("Successfully equipped Armor.");
            return true;
        }
    } */


    /* boolean equipWeapon(Weapon item) throws InvalidWeaponException {
        if (!checkWeaponType(item)) {
            throw new InvalidWeaponException("Your hero cannot equip a weapon of type: " + item.weaponType);
        } else if (level < item.getRequiredLevel()) {
            throw new InvalidWeaponException("This weapon requires a level of " + item.getRequiredLevel() + " to wield it");
        } else {
            equipment.put(item.getSlot(), item);
            System.out.println("Successfully equipped Weapon.");
            return true;
        }
    } */

    boolean equipWeapon(Weapon item) {
        try {
            if (!checkWeaponType(item)) {
                throw new InvalidWeaponException("Your hero cannot equip a weapon of type: " + item.weaponType);
            } else if (level < item.getRequiredLevel()) {
                throw new InvalidWeaponException("This weapon requires a level of " + item.getRequiredLevel() + " to wield it");
            } else {
                equipment.put(item.getSlot(), item);
                System.out.println("Successfully equipped Weapon.");
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    void levelUp() {
        level++;
        heroAttributes.addAttribute(levelUpAttributes);
    }

    void display() {
        StringBuilder sb = new StringBuilder();
        //totalAttributes().printAttribute();

        sb.append("Name: " + name + "\n");
        sb.append("Class: " + this.getClass().getName() + "\n");
        sb.append("Level: " + level + "\n");
        sb.append("Total strength: " + totalAttributes().getStrength() + "\n");
        sb.append("Total dexterity: " + totalAttributes().getDexterity() + "\n");
        sb.append("Total intelligence: " + totalAttributes().getIntelligence() + "\n");
        sb.append("Damage: " + damage());

        System.out.println(sb);
    }

    double damage() {
        double heroDamage;
        HeroAttribute attributes = totalAttributes();
        // attributes.printAttribute();
        heroDamage = getWeaponDamage() * (1 + ((double) getDamagingAttribute(attributes) / 100));
        return heroDamage;
    }

    private int getWeaponDamage() {
        if (equipment.get(itemSlot.Weapon) == null) {
            return 1;
        } else {
            return ((Weapon) equipment.get(itemSlot.Weapon)).getWeaponDamage();
        }
    }

    private int getDamagingAttribute(HeroAttribute attHero) {
        switch (damagingAttribute) {
            case Dexterity :
                return attHero.getDexterity();
            case Intelligence:
                return attHero.getIntelligence();
            case Strength:
                return attHero.getStrength();
            default:
                return 0;
        }
    }

    public HeroAttribute getHeroAttributes() {
        return heroAttributes;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    HeroAttribute totalAttributes() {
        HeroAttribute totalAttributes = new HeroAttribute(heroAttributes);

        for (Item item : equipment.values()) {
            if (item != null && item instanceof Armor) {
                Armor armorItem = (Armor) item;
                totalAttributes.addAttribute(armorItem.getArmorAttribute());
            }
        }

        return totalAttributes;
    }
}

