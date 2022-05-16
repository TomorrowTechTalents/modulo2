package exercise04;

public class Vampire extends Character { // ou expands generic? hun
    void attack() {
        System.out.println("causou 20 de dano");
        System.out.println("seu personagem está sangrando");
    }

    void takeDamage(AttackType attackType, int damage) {
        if (attackType == AttackType.PIERCING) {
            damage *= 2;
        }

        System.out.println("recebeu " + damage + " de dano");
    }

    void interact() {
        System.out.println("O que é um homem?");
    }
}
