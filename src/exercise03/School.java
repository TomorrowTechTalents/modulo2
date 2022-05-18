package exercise03;

import java.util.ArrayList;
import java.util.List;

enum Role {
    STUDENT("aluno"), EMPLOYEE("funcionário"), TEACHER("professor");

    final String string;

    Role(String string) {
        this.string = string;
    }
}

class School {
    private final List<Person> teachers = new ArrayList<>();
    private final List<Person> students = new ArrayList<>();
    private final List<Person> employees = new ArrayList<>();

    void updatePerson(String CPF, List<Person> list) {
        Person personToUpdate = findPersonByCPF(CPF, list);

        personToUpdate.update();
    }

    void deletePerson(String CPF, List<Person> list) {
        Person person = findPersonByCPF(CPF, list);

        list.remove(person);
    }

    void listPeople(List<Person> list) {
        for (Person person : list) {
            System.out.println(person);
        }
    }

    Person findPersonByCPF(String CPF, List<Person> list) { // acho que era melhor receber o role e achar a lista aqui dentro do que ja receber a lista hein; talvez esse comentario seja para outro metodo
        for (Person person : list) {
            if (person.CPF.equals(CPF)) {
                return person;
            }
        }

        return null;
    }

    List<Person> getStudents() {
        return this.students;
    }

    List<Person> getEmployees() {
        return this.employees;
    }

    List<Person> getTeachers() {
        return this.teachers;
    }
}
