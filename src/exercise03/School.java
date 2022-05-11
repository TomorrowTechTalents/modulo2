package exercise03;

import java.util.ArrayList;
import java.util.List;

// depois ver se pode ser um enum
class School {
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();

    void updateStudent(String CPF) {
        Student studentToUpdate = findStudentByCPF(CPF);

        studentToUpdate.update();
    }

    void updateEmployee(String CPF) {
        Employee employeeToUpdate = findEmployeeByCPF(CPF);

        employeeToUpdate.update();
    }

    void updateTeacher(String CPF) {
        Teacher teacherToUpdate = findTeacherByCPF(CPF);

        teacherToUpdate.update();
    }

    Student findStudentByCPF(String CPF) {
        for (Student student : this.students) {
            if (student.CPF.equals(CPF)) {
                return student;
            }
        }

        return null;
    }

    Employee findEmployeeByCPF(String CPF) {
        for (Employee employee : this.employees) {
            if (employee.CPF.equals(CPF)) {
                return employee;
            }
        }

        return null;
    }

    Teacher findTeacherByCPF(String CPF) {
        for (Teacher teacher : this.teachers) {
            if (teacher.CPF.equals(CPF)) {
                return teacher;
            }
        }

        return null;
    }

    void deleteStudent(String CPF) {
        Student student = findStudentByCPF(CPF);

        this.students.remove(student);
    }

    void deleteEmployee(String CPF) {
        Employee employee = findEmployeeByCPF(CPF);

        this.employees.remove(employee);
    }

    void deleteTeacher(String CPF) {
        Teacher teacher = findTeacherByCPF(CPF);

        this.teachers.remove(teacher);
    }

    void listStudent() {
        for (Student student : this.students) {
            System.out.println(student);
        }
    }

    void listEmployee() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }

    void listTeacher() {
        for (Teacher teacher : this.teachers) {
            System.out.println(teacher);
        }
    }

    void checkStudent(String CPF) {
        for (Student student : this.students) {
            if (student.CPF.equals(CPF)) {
                System.out.println(student);

                break;
            }
        }
    }

    void checkEmployee(String CPF) {
        for (Employee employee : this.employees) {
            if (employee.CPF.equals(CPF)) {
                System.out.println(employee);

                break;
            }
        }
    }

    void checkTeacher(String CPF) {
        for (Teacher teacher : this.teachers) {
            if (teacher.CPF.equals(CPF)) {
                System.out.println(teacher);

                break;
            }
        }
    }
}
