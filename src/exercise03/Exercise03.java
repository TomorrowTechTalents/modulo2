package exercise03;

import java.util.Scanner;

class Exercise03 {
    private static final School school = new School();

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

    private static void add() {
        Role desiredRole = getDesiredRole();

        switch (desiredRole) {
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

    private static void update() {
        Scanner scanner = new Scanner(System.in);

        Role desiredRole = getDesiredRole();

        System.out.print("CPF do " + desiredRole.string + ": ");
        String CPF = scanner.nextLine();

        switch (desiredRole) {
            case STUDENT:
                school.updatePerson(CPF, school.getStudents());
                break;
            case EMPLOYEE:
                school.updatePerson(CPF, school.getEmployees());
                break;
            case TEACHER:
                school.updatePerson(CPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    private static void delete() {
        Scanner scanner = new Scanner(System.in);

        Role desiredRole = getDesiredRole();

        System.out.print("CPF do " + desiredRole.string + " a ser deletado: ");
        String CPF = scanner.nextLine();

        switch (desiredRole) {
            case STUDENT:
                school.deletePerson(CPF, school.getStudents());
                break;
            case EMPLOYEE:
                school.deletePerson(CPF, school.getEmployees());
                break;
            case TEACHER:
                school.deletePerson(CPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    private static void list() {
        Role desiredRole = getDesiredRole();

        switch (desiredRole) {
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

    private static void check() {
        Scanner scanner = new Scanner(System.in);

        Role desiredRole = getDesiredRole();

        System.out.print("CPF do " + desiredRole.string + ": ");
        String CPF = scanner.nextLine();

        Person person;

        switch (desiredRole) {
            case STUDENT:
                person = school.findPersonByCPF(CPF, school.getStudents());
                break;
            case EMPLOYEE:
                person = school.findPersonByCPF(CPF, school.getEmployees());
                break;
            case TEACHER:
                person = school.findPersonByCPF(CPF, school.getTeachers());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }

        System.out.println(person);
    }

    private static Role getDesiredRole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("escolha uma categoria: ");

        for (Role role : Role.values()) {
            System.out.println(role.ordinal() + 1 + " - " + role.string);
        }

        int option = scanner.nextInt();

        return Role.values()[option - 1];
    }
}
