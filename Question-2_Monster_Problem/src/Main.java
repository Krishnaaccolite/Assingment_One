import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner data=new Scanner(System.in);
        System.out.println("Creating Monster1");
        Monster monster_1= createMonster(data);
        System.out.println("Creating Monster2");
        Monster monster_2= createMonster(data);
        System.out.println("Creating Baby Monster");
        List<Monster> babyMonsters=Monster.createbabymonster(monster_1,monster_2);
        int val=1;
        for(Monster baby:babyMonsters){
        System.out.println("BabyMonster: " + val++);
        baby.displayProperty();
        System.out.println();
        }
    }
    private static Monster createMonster(Scanner sc) {
        System.out.print("Eye Color: ");
        String eyeColor = sc.nextLine();
        System.out.print("Feather Color: ");
        String featherColor = sc.nextLine();
        System.out.print("Magical Abilities: ");
        String magicalAbilities = sc.nextLine();
        System.out.print("Size: ");
        String size = sc.nextLine();
        System.out.print("Strength: ");
        String strength = sc.nextLine();
        System.out.print("Durability: ");
        String durability = sc.nextLine();
        System.out.print("Weakness: ");
        String weakness = sc.nextLine();
        System.out.print("Aggression Level: ");
        String aggressionLevel = sc.nextLine();
        return new Monster(eyeColor, featherColor, magicalAbilities, size,
                strength, durability, weakness, aggressionLevel);
    }
}

