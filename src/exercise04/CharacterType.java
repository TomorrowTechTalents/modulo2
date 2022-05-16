package exercise04;

public enum CharacterType {
    GENERIC("você encontrou um inimigo genérico"), VAMPIRE("você encontrou um vampiro"),
    SNAKE("você encontrou uma cobra"), GIANT("você encontrou um gigante");

    final String string;

    CharacterType(String string) {
        this.string = string;
    }
}
