package exercise04;

public class Giant extends Character {
    void attack() {
        System.out.println("causou 25 de dano");
        System.out.println("seu personagem está atordoado");
    }

    void takeDamage(AttackType attackType, int damage) {
        if (attackType == AttackType.FIRE) {
            damage *= 2;
        }

        System.out.println("recebeu " + damage + " de dano");
    }

    void interact() {
        System.out.println("Me desculpe");
    }
}
