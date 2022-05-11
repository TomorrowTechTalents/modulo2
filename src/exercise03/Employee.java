package exercise03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee extends Person {
    private Position position;
    BigDecimal salary;

    Employee(Position position) {
        super();

        Scanner scanner = new Scanner(System.in);

        System.out.print("cargo: ");
        this.position = position;

        System.out.print("salário: ");
        this.salary = scanner.nextBigDecimal();
    }

    Employee() {
        super(); // mudar a ordem e fazer 1 constructor chamar o outro

        Scanner scanner = new Scanner(System.in);

        this.salary = scanner.nextBigDecimal();
    }

    void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("novo CPF (o CPF antigo é " + this.CPF + "): ");
        this.CPF = scanner.nextLine();

        System.out.print("novo RG (o RG antigo é " + this.RG + "): ");
        this.RG = scanner.nextLine();

        System.out.print("novo cargo (o cargo antigo é " + this.position + "): ");
        this.position = Position.valueOf(scanner.nextLine());

        System.out.print("novo salário (o salário antigo é " + this.salary + "): ");
        this.salary = scanner.nextBigDecimal();
    }


    @Override
    public String toString() {
        return "Funcionário = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG +
                ", salário: " + this.salary + ", cargo: " + this.position + "}";
    }
}
