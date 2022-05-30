package exercise04;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Exercise04 {
    private static final Random random = new Random();
    private static final byte NUMBER_OF_ATTACK_TYPES = (byte) AttackType.values().length;
    private static final int NUMBER_OF_ENEMY_TYPES = Character.CharacterType.values().length;

    private static Enemy meetEnemy() {
        Enemy enemy;

        int nextCharacterTypeIndex = random.nextInt(NUMBER_OF_ENEMY_TYPES);
        Character.CharacterType nextCharacterType = Character.CharacterType.values()[nextCharacterTypeIndex];

        switch (nextCharacterType) {
            case GENERIC_ENEMY:
                enemy = new Enemy();
                Enemy.displayEncounterNotice();
                break;
            case VAMPIRE:
                enemy = new Vampire();
                Vampire.displayEncounterNotice();
                break;
            case SNAKE:
                enemy = new Snake();
                Snake.displayEncounterNotice();
                break;
            case GIANT:
                enemy = new Giant();
                Giant.displayEncounterNotice();
                break;
            default:
                throw new IllegalArgumentException("opção inválida");
        }

        return enemy;
    }

    private static void takeAction(Enemy enemy) {
        int action = random.nextInt(3); // enum pras interactions? nem tudo precisa ser enum

        switch (action) {
            case 0:
                System.out.println("o inimigo atacou");
                enemy.attack();
                break;
            case 1:
                System.out.println("o inimigo recebeu um ataque:");
                AttackType attackType = AttackType.values()[random.nextInt(NUMBER_OF_ATTACK_TYPES)];
                enemy.takeDamage(attackType, Math.abs(random.nextInt()));
                break;
            case 2:
                System.out.println("você interagiu com o inimigo");
                enemy.interact();
                break;
            default:
                throw new IllegalArgumentException("ação inválida");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Enemy enemy = meetEnemy();

            Scanner scanner = new Scanner(System.in);

            //scanner.nextLine();
            System.out.println();
            Thread.sleep(1000);

            takeAction(enemy);

            TimeUnit.SECONDS.sleep(1);

            System.out.print("nova rodada? ");
            String option = scanner.nextLine();

            if (option.equals("n")) {
                break;
            }

            System.out.println("==========");
        }
    }
}
