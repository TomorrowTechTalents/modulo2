package exercise04;

class Giant extends Enemy {
    private final AttackType weakness = AttackType.FIRE;

    @Override
    void attack() {
        System.out.println("causou 25 de dano");
        System.out.println("seu personagem está atordoado");
    }

    @Override
    void takeDamage(AttackType attackType, int damage) {
        if (attackType == this.weakness) {
            damage = (damage >= Integer.MAX_VALUE / 2) ? Integer.MAX_VALUE : damage * 2;
        }

        System.out.println("recebeu " + damage + " de dano");
    }

    @Override
    void interact() {
        System.out.println("Me desculpe");
    }

    static void displayEncounterNotice() {
        System.out.print("você encontrou um gigante");
    }
}
