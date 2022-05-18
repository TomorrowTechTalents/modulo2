package exercise04;

class Snake extends Enemy {
    private final AttackType weakness = AttackType.BLOW;

    @Override
    void attack() {
        System.out.println("causou 10 de dano");
        System.out.println("seu personagem está envenenado");
    }

    @Override
    void takeDamage(AttackType attackType, int damage) {
        if (attackType == this.weakness) {
            damage = (damage > Integer.MAX_VALUE / 2) ? Integer.MAX_VALUE : damage * 2;
        }

        System.out.println("recebeu " + damage + " de dano");
    }

    @Override
    void interact() {
        System.out.println("Se você acender a chama a maldição acaba.");
    }

    static void displayEncounterNotice() {
        System.out.print("você encontrou uma cobra");
    }
}
