package exercise03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Teacher extends Employee{
    private final List<String> classes = new ArrayList<>();
    private final List<String> disciplines = new ArrayList<>();

    // nao adicionei o field cargo por causa do enunciado
    Teacher() {
        super();
        //this.classes = classes;
        //this.disciplines = disciplines;
    }

    void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("novo CPF (o CPF antigo é " + this.CPF + "): ");
        this.CPF = scanner.nextLine();

        System.out.print("novo RG (o RG antigo é " + this.RG + "): ");
        this.RG = scanner.nextLine();

//        System.out.print("novas turmas (as turmas antigas são " + this.classes + "): ");
//        String schoolClass = scanner.nextLine();

        System.out.print("novo salário (o salário antigo é " + this.salary + "): ");
        this.salary = scanner.nextBigDecimal();

//        System.out.print("novas disciplinas (as disciplinas antigas são " + this.disciplines + "): ");
//        String discipline = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Professor = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG +
                ", salário: " + this.salary + ", turmas: " + this.classes +
                ", disciplinas: " + this.disciplines + "}";
    }
}