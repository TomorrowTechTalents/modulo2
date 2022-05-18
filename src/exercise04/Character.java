package exercise04;

abstract class Character {
    enum CharacterType {
        GENERIC_ENEMY, VAMPIRE, SNAKE, GIANT
    }

    // todos os metodos poderiam ser estaticos...
    abstract void attack();

    abstract void takeDamage(AttackType attackType, int damage);

    abstract void interact();
}
