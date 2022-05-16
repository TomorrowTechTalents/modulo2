package exercise04;

public class Snake extends Character { // botar os oveerrides
    void attack() {
        System.out.println("causou 10 de dano");
        System.out.println("seu personagem está envenenado");
    }

    void takeDamage(AttackType attackType, int damage) {
        if (attackType == AttackType.BLOW) {
            damage *= 2;
        }

        System.out.println("recebeu " + damage + " de dano");
    }

    void interact() {
        System.out.println("Se você acender a chama a maldição acaba.");
    }
}
