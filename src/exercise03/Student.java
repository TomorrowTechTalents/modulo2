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

        // this.grades = grades; // ver se funciona a contento
    }

    float getGradesAverage() {
        float sum = 0;

        for (float grade : this.grades) {
            sum += grade;
        }

        return sum / this.grades.size();
    }

    void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("novo CPF (o CPF antigo é " + this.CPF + "): ");
        this.CPF = scanner.nextLine();

        System.out.print("novo RG (o RG antigo é " + this.RG + "): ");
        this.RG = scanner.nextLine();

        System.out.print("nova idade (a idade antiga é " + this.age + "): ");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("nova turma (a turma antiga é " + this.schoolClass + "): ");
        this.schoolClass = scanner.nextLine();

//        System.out.print("novas notas (as notas antigas são " + this.grades + "): ");
//        float grade = scanner.nextFloat();
    }

    @Override
    public String toString() {
        return "Aluno = {nome: " + this.name + ", CPF: " + this.CPF + ", RG: " + this.RG +
                ", idade: " + this.age + ", turma: " + this.schoolClass +
                ", notas por disciplina: " + this.grades + "}";
    }
}
