package exercise04;

class Enemy extends Character {
    @Override
    void attack() {
        System.out.println("causou 10 de dano");
    }

    @Override
    void takeDamage(AttackType attackType, int damage) {
        System.out.println("recebeu " + damage + " de dano");
    }

    @Override
    void interact() {
        System.out.println("Por que eu responderia meu inimigo???");
    }

    static void displayEncounterNotice() {
        System.out.print("você encontrou um inimigo genérico");
    }
}
