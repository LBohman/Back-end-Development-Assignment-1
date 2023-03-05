public abstract class Item {
    private String name;
    private int requiredLevel;
    private itemSlot slot;

    Item(String _name, int _requiredLevel, itemSlot _slot) {
        name = _name;
        requiredLevel = _requiredLevel;
        slot = _slot;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public itemSlot getSlot() {
        return slot;
    }

}
