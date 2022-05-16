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

    @Override
    void update() {
        super.update();

        Scanner scanner = new Scanner(System.in);

        System.out.println("novas turmas (a(s) turma(s) antiga(s) é(são) " + this.classes + "): ");
        this.classes.clear();
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

        System.out.println("novas disciplinas (a(s) disciplina(s) antiga(s) é(são) " + this.disciplines + "): ");
        this.disciplines.clear();
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
        return "Professor = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG + ", salário: " +
                             this.salary + ", turmas: " + this.classes + ", disciplinas: " + this.disciplines + "}";
    }
}
