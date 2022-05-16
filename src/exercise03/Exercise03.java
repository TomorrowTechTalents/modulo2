package exercise03;

import java.util.Scanner;

class Exercise03 {
    static School school = new School();

    public static void main(String[] args) {
        System.out.println("Olá, este é o sistema da escola XPTO!");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("==========");
            System.out.println("escolha uma opção:");
            System.out.println("1 - adicionar");
            System.out.println("2 - modificar");
            System.out.println("3 - deletar");
            System.out.println("4 - listar");
            System.out.println("5 - exibir");
            System.out.println("6 - calcular média");
            System.out.println("7 - sair");

            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println("----------");

            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    list();
                    break;
                case 5:
                    check();
                    break;
                case 6:
                    System.out.print("CPF do aluno a ter média calculada: ");
                    String CPF = scanner.nextLine();
                    Student student = (Student) school.findPersonByCPF(CPF, school.getStudents());
                    float gradesAverage = student.getGradesAverage();
                    System.out.println("média das notas do aluno de cpf " + CPF + ": " + gradesAverage);
                    break;
                case 7:
                    System.out.println("até logo");
                    return;
                default:
                    throw new RuntimeException("opção inválida");
            }
        }
    }

    static void add() {
        Role option = getDesiredRole();

        switch (option) {
            case STUDENT:
                school.getStudents().add(new Student());
                break;
            case EMPLOYEE:
                school.getEmployees().add(new Employee());
                break;
            case TEACHER:
                school.getTeachers().add(new Teacher());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void update() {
        Scanner scanner = new Scanner(System.in);

        Role option = getDesiredRole();

        switch (option) {
            case STUDENT:
                System.out.print("CPF do aluno: ");
                String studentCPF = scanner.nextLine();
                school.updatePerson(studentCPF, school.getStudents());
                break;
            case EMPLOYEE:
                System.out.print("CPF do funcionário: ");
                String employeeCPF = scanner.nextLine();
                school.updatePerson(employeeCPF, school.getEmployees());
                break;
            case TEACHER:
                System.out.print("CPF do professor: ");
                String teacherCPF = scanner.nextLine();
                school.updatePerson(teacherCPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void delete() {
        Scanner scanner = new Scanner(System.in);

        Role option = getDesiredRole();

        switch (option) {
            case STUDENT:
                System.out.print("CPF do aluno a ser deletado: ");
                String studentCPF = scanner.nextLine();
                school.deletePerson(studentCPF, school.getStudents());
                break;
            case EMPLOYEE:
                System.out.print("CPF do funcionário a ser deletado: ");
                String employeeCPF = scanner.nextLine();
                school.deletePerson(employeeCPF, school.getEmployees());
                break;
            case TEACHER:
                System.out.print("CPF do professor a ser deletado: ");
                String teacherCPF = scanner.nextLine();
                school.deletePerson(teacherCPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void list() {
        Role option = getDesiredRole();

        switch (option) {
            case STUDENT:
                school.listPeople(school.getStudents());
                break;
            case EMPLOYEE:
                school.listPeople(school.getEmployees());
                break;
            case TEACHER:
                school.listPeople(school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha para listar alunos, funcionários, ou professores");
        }
    }

    static void check() {
        Scanner scanner = new Scanner(System.in);

        Role option = getDesiredRole();

        switch (option) {
            case STUDENT:
                System.out.print("CPF do aluno: ");
                String studentCPF = scanner.nextLine();
                school.checkPerson(studentCPF, school.getStudents());
                break;
            case EMPLOYEE:
                System.out.print("CPF do funcionário: ");
                String employeeCPF = scanner.nextLine();
                school.checkPerson(employeeCPF, school.getEmployees());
                break;
            case TEACHER:
                System.out.print("CPF do professor: ");
                String teacherCPF = scanner.nextLine();
                school.checkPerson(teacherCPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha para exibir detalhes de aluno, funcionário, ou professor");
        }
    }

    static Role getDesiredRole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("escolha uma categoria: ");

        for (Role role : Role.values()) {
            System.out.println(role.ordinal() + 1 + " - " + role.string);
        }

        int option = scanner.nextInt();
        return Role.values()[option - 1];
    }
}
