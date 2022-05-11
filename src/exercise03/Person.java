package exercise03;

import java.util.Scanner;

class Person { //lembrar de trazer algumas coisas tipo do update pra essa classe
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
}
