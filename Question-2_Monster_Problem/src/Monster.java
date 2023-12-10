import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
public class Monster {
    public String eye_color;
    public String feather_color;
    public String magical_ability;
    public String size;
    public String strength;
    public String durability;
    public String weakness;
    public String aggression_level;

    public Monster() {
    }

    public Monster(String eye_color, String feather_color, String magical_ability, String size, String strength, String durability, String weakness, String aggression_level) {
        this.eye_color = eye_color;
        this.feather_color = feather_color;
        this.magical_ability = magical_ability;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggression_level = aggression_level;
    }
    public Monster(Monster parent){
        this.eye_color = parent.eye_color;
        this.feather_color = parent.feather_color;
        this.magical_ability = parent.magical_ability;
        this.size = parent.size;
        this.strength = parent.strength;
        this.durability = parent.durability;
        this.weakness = parent.weakness;
        this.aggression_level = parent.aggression_level;
    }


    public void displayProperty() {
        System.out.println("Eye Color: " + eye_color);
        System.out.println("Feather Color: " + feather_color);
        System.out.println("Magical Abilities: " + magical_ability);
        System.out.println("Size: " + size);
        System.out.println("Strength: " + strength);
        System.out.println("Durability: " + durability);
        System.out.println("Weakness: " + weakness);
        System.out.println("Aggression Level: " + aggression_level);
    }

    public static Object giverandomproperty(Object value1,Object value2) {
        return Math.random()<0.6? value1:value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster monster)) return false;
        return Objects.equals(eye_color, monster.eye_color) && Objects.equals(feather_color, monster.feather_color) && Objects.equals(magical_ability, monster.magical_ability) && Objects.equals(size, monster.size) && Objects.equals(strength, monster.strength) && Objects.equals(durability, monster.durability) && Objects.equals(weakness, monster.weakness) && Objects.equals(aggression_level, monster.aggression_level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eye_color, feather_color, magical_ability, size, strength, durability, weakness, aggression_level);
    }


    public static List<Monster> createbabymonster(Monster papa, Monster mom) throws IllegalAccessException {
        List<Monster> babymonster=new ArrayList<>();
        Field[] fields = Monster.class.getFields();
            for(int i=0;i< fields.length;i++){
                Monster baby1=new Monster(papa);
                Monster baby2=new Monster(mom);
                Object property1=fields[i].get(papa);
                Object property2=fields[i].get(mom);
                fields[i].setAccessible(true);
                fields[i].set(baby1,giverandomproperty(property1,property2));
                fields[i].set(baby2,giverandomproperty(property1,property2));
                babymonster.add(baby1);
                babymonster.add(baby2);
            }
        return babymonster;
    }
}

