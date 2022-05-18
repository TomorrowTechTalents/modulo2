package exercise04;

class Vampire extends Enemy {
    private final AttackType weakness = AttackType.PIERCING;

    @Override
    void attack() {
        System.out.println("causou 20 de dano");
        System.out.println("seu personagem está sangrando");
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
        System.out.println("O que é um homem?");
    }

    static void displayEncounterNotice() {
        System.out.print("você encontrou um vampiro");
    }
}
