package ru.job4j.stream;

public class Unit {
    private String name;
    private byte health;
    private byte strong;
    private byte armor;
    private byte agility;

    static class Builder {
        private String name;
        private byte health;
        private byte strong;
        private byte armor;
        private byte agility;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildHealth(byte health) {
            this.health = health;
            return this;
        }

        Builder buildStrong(byte strong) {
            this.strong = strong;
            return this;
        }

        Builder buildArmor(byte armor) {
            this.armor = armor;
            return this;
        }

        Builder buildAgility(byte agility) {
            this.agility = agility;
            return this;
        }

        Unit build() {
            Unit unit = new Unit();
            unit.name = name;
            unit.health = health;
            unit.strong = strong;
            unit.armor = armor;
            unit.agility = agility;
            return unit;
        }
    }

    @Override
    public String toString() {
        return "Unit{"
                + "name='" + name + '\''
                + ", health=" + health
                + ", strong=" + strong
                + ", armor=" + armor
                + ", agility=" + agility
                + '}';
    }

    public static void main(String[] args) {
        Unit unit = new Builder().buildName("John")
                .buildHealth((byte) 10)
                .buildStrong((byte) 2)
                .buildArmor((byte) 1)
                .buildAgility((byte) 1)
                .build();
        System.out.println(unit);
    }
}
