package exercise04;

public class Generic extends Character {

    void attack() {
        System.out.println("causou 10 de dano");
    }

    void takeDamage(AttackType attackType, int damage) {
        System.out.println("recebeu " + damage + " de dano");
    }

    void interact() {
        System.out.println("Por que eu responderia meu inimigo???");
    }
}
