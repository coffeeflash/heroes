package ch.bfh.coffeeflash.promoter.model;

/*
    We do not need any persistence here...
 */
public class Hero {

    private String name;
    private int atk;
    private int def;
    private double hp;

    public Hero() {}

    public Hero(String name, int atk, int def, double hp) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
