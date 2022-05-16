package exercise03;

import java.util.Scanner;

abstract class Person {
    String name;
    String CPF;
    String RG;

    Person() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nome: ");
        this.name = scanner.nextLine();

        System.out.print("CPF: ");
        this.CPF = scanner.nextLine();

        System.out.print("RG: ");
        this.RG = scanner.nextLine();
    }

    void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("novo CPF (o CPF antigo é " + this.CPF + "): ");
        this.CPF = scanner.nextLine();

        System.out.print("novo RG (o RG antigo é " + this.RG + "): ");
        this.RG = scanner.nextLine();
    }
}
