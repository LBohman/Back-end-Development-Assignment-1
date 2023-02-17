public class HeroAttribute {
    private int dexterity;
    private int intelligence;
    private int strength;

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    HeroAttribute() {
        dexterity = 0;
        intelligence = 0;
        strength = 0;
    }

    HeroAttribute(int _dex, int _int, int _str) {
        dexterity = _dex;
        intelligence = _int;
        strength = _str;
    }

    HeroAttribute(HeroAttribute att) {
        dexterity = att.getDexterity();
        intelligence = att.getIntelligence();
        strength = att.getStrength();
    }

    void addAttribute(HeroAttribute att) {
        dexterity += att.getDexterity();
        intelligence += att.getIntelligence();
        strength += att.getStrength();
    }

    void printAttribute() {
        System.out.println("dex: " + dexterity + ", int: " + intelligence + ", str:" + strength);
    }
}
