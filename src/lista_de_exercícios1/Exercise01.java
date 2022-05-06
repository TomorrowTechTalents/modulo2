package lista_de_exercícios1;

import java.math.BigDecimal;

public class Exercise01 {
    public static void main(String[] args) {
        Funcionario novoFuncionario = new Funcionario("Luis", "Silva", 10, 25.50);

        novoFuncionario.nomeCompleto();

        novoFuncionario.calcularSalario();
    }
}

class Funcionario {
    private String nome;
    private String sobrenome;
    private Integer horasTrabalhadas;
    private double valorPorHora;

    Funcionario(String nome, String sobrenome, Integer horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    void nomeCompleto() {
        System.out.println(this.nome + this.sobrenome);
    }

    void calcularSalario() {
        BigDecimal salary = BigDecimal.valueOf(this.horasTrabalhadas * this.valorPorHora);

        System.out.println(salary);
    }

    void incrementarHoras(BigDecimal raise) {
        this.valorPorHora = BigDecimal.valueOf(this.valorPorHora).add(raise).doubleValue();
    }
}
