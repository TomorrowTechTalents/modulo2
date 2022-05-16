package exercise04;

import java.util.Random;
import java.util.Scanner;

public class Exercise04 {
    static Random random = new Random();
    static final byte NUMBER_OF_ATTACK_TYPES = (byte) AttackType.values().length;
    static final int NUMBER_OF_ENEMY_TYPES = CharacterType.values().length;

    public static void main(String[] args) {
        while (true) {
            Character enemy;

            int nextCharacterTypeIndex = random.nextInt(NUMBER_OF_ENEMY_TYPES);

            CharacterType nextCharacterType = CharacterType.values()[nextCharacterTypeIndex];

            System.out.println(nextCharacterType.string);

            switch (nextCharacterType) {
                case GENERIC:
                    enemy = new Generic();
                    break;
                case VAMPIRE:
                    enemy = new Vampire();
                    break;
                case SNAKE:
                    enemy = new Snake();
                    break;
                case GIANT:
                    enemy = new Giant();
                    break;
                default:
                    throw new IllegalArgumentException("opção inválida");
            }

            int action = random.nextInt(3); // enum pras interactions? nem tudo precisa ser enum

            switch (action) {
                case 0:
                    System.out.println("o inimigo atacou");
                    enemy.attack();
                    break;
                case 1:
                    System.out.println("o inimigo recebeu um ataque");
                    AttackType attackType = AttackType.values()[random.nextInt(NUMBER_OF_ATTACK_TYPES)];
                    enemy.takeDamage(attackType, random.nextInt());
                    break;
                case 2:
                    System.out.println("você interagiu com o inimigo");
                    enemy.interact();
                    break;
                default:
                    throw new IllegalArgumentException("ação inválida");
            }

            System.out.print("nova rodada? ");
            Scanner scanner = new Scanner(System.in);
            char option = scanner.next().charAt(0);

            if (option == 'n') {
                break;
            }

            System.out.println("==========");
        }
    }
}
