package exercise03;

import java.math.BigDecimal;
import java.util.Scanner;

class Employee extends Person {
    private Position position;
    BigDecimal salary;

    Employee() {
        super();

        Scanner scanner = new Scanner(System.in);

        System.out.print("salário: ");
        this.salary = scanner.nextBigDecimal();
        scanner.nextLine();

        if (this.getClass() == Employee.class) {
            System.out.print("cargo: ");
            this.position = Position.valueOf(scanner.nextLine());
        }
    }

    @Override
    void update() {
        super.update();

        Scanner scanner = new Scanner(System.in);

        System.out.print("novo salário (o salário antigo é " + this.salary + "): ");
        this.salary = scanner.nextBigDecimal();
        scanner.nextLine();

        if (this.getClass() == Employee.class) {
            System.out.print("novo cargo (o cargo antigo é " + this.position + "): ");
            this.position = Position.valueOf(scanner.nextLine());
        }
    }

    @Override
    public String toString() {
        return "Funcionário = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG +
                            ", salário: " + this.salary + ", cargo: " + this.position + "}";
    }
}
