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

        Scanner scanner = new Scanner(System.in);

        byte classesCounter = 0;
        while (true) {
            classesCounter++;

            System.out.print("turma " + classesCounter + ": ");
            String schoolClass = scanner.nextLine();

            if (schoolClass.isEmpty()) {
                break;
            }

            this.classes.add(schoolClass);
        }

        byte disciplinesCounter = 0;
        while (true) {
            disciplinesCounter++;

            System.out.print("disciplina " + disciplinesCounter + ": ");
            String discipline = scanner.nextLine();

            if (discipline.isEmpty()) {
                break;
            }

            this.disciplines.add(discipline);
        }
    }

    void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("novo CPF (o CPF antigo é " + this.CPF + "): ");
        this.CPF = scanner.nextLine();

        System.out.print("novo RG (o RG antigo é " + this.RG + "): ");
        this.RG = scanner.nextLine();

        System.out.print("novas turmas (as turmas antigas são " + this.classes + "): ");
        byte classesCounter = 0;
        while (true) {
            classesCounter++;

            System.out.print("turma " + classesCounter + ": ");
            String schoolClass = scanner.nextLine();

            if (schoolClass.isEmpty()) {
                break;
            }

            this.classes.add(schoolClass);
        }

        System.out.print("novo salário (o salário antigo é " + this.salary + "): ");
        this.salary = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.print("novas disciplinas (as disciplinas antigas são " + this.disciplines + "): ");
        byte disciplinesCounter = 0;
        while (true) {
            disciplinesCounter++;

            System.out.print("disciplina " + disciplinesCounter + ": ");
            String discipline = scanner.nextLine();

            if (discipline.isEmpty()) {
                break;
            }

            this.disciplines.add(discipline);
        }
    }

    @Override
    public String toString() {
        return "Professor = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG +
                ", salário: " + this.salary + ", turmas: " + this.classes +
                ", disciplinas: " + this.disciplines + "}";
    }
}
