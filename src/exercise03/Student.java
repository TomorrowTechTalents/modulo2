package exercise03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student extends Person {
    private int age;
    private String schoolClass;
    private final List<Float> grades = new ArrayList<>();

    Student() {
        super();

        Scanner scanner = new Scanner(System.in);

        System.out.print("idade: ");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("turma: ");
        this.schoolClass = scanner.nextLine();

        byte gradesCounter = 0;
        while (true) {
            gradesCounter++;

            System.out.print("nota " + gradesCounter + ": ");
            String grade = scanner.nextLine();

            if (grade.isEmpty()) {
                break;
            }

            this.grades.add(Float.valueOf(grade));
        }
    }

    float getGradesAverage() {
        float sum = 0;

        for (float grade : this.grades) {
            sum += grade;
        }

        return sum / this.grades.size();
    }

    void update() {
        super.update();

        Scanner scanner = new Scanner(System.in);

        System.out.print("nova idade (a idade antiga é " + this.age + "): ");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("nova turma (a turma antiga é " + this.schoolClass + "): ");
        this.schoolClass = scanner.nextLine();

        System.out.println("novas notas (a(s) nota(s) antiga(s) é(são) " + this.grades + "): ");
        this.grades.clear();
        byte gradesCounter = 0;
        while (true) {
            gradesCounter++;

            System.out.print("nota " + gradesCounter + ": ");
            String grade = scanner.nextLine();

            if (grade.isEmpty()) {
                break;
            }

            this.grades.add(Float.valueOf(grade));
        }
    }

    @Override
    public String toString() {
        return "Aluno = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG + ", idade: " + this.age +
                      ", turma: " + this.schoolClass + ", notas por disciplina: " + this.grades + "}";
    }
}
