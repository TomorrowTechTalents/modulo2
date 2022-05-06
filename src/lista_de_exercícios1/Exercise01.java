package lista_de_exercícios1;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exercise01 {
    static final int TEAM_SIZE = 11;

    public static void main(String[] args) throws ParseException {
        Jogador[] team = new Jogador[TEAM_SIZE];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.print("código de identificação: ");
            int idCode = scanner.nextInt();
            scanner.nextLine();

            System.out.print("nome: ");
            String name = scanner.nextLine();

            System.out.print("apelido: ");
            String nickname = scanner.nextLine();

            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("data de nascimento: ");
            Date birthdate = format.parse(scanner.nextLine());

            System.out.print("número: ");
            int number = scanner.nextInt();
            scanner.nextLine();

            System.out.print("posição: ");
            String position = scanner.nextLine();

            System.out.print("grau de habilidade: ");
            int ability = scanner.nextInt();

            System.out.print("número de cartões amarelos recebidos: ");
            int numberOfYellowCards = scanner.nextInt();

            System.out.print("número de cartões vermelhos recebidos: ");
            int numberOfRedCards = scanner.nextInt();

            System.out.print("encontra-se suspenso: ");
            Boolean isSuspended = scanner.nextBoolean();

            team[i] = new Jogador(idCode, name, nickname, birthdate, number, position,
                                  ability, numberOfYellowCards, numberOfRedCards, isSuspended);
        }

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.println(team[i]);
        }
    }
}

class Jogador {
    private int id;
    private String nome;
    private String apelido;
    private Date dataNascimento;
    private int numero;
    private String posicao;
    private int qualidade;
    private int cartoesAmarelos;
    private int cartaoVermelho;
    private Boolean suspenso;
    private boolean trainedYet;

    Jogador(int idCode, String name, String nickname, Date birthdate, int number, String position,
            int ability, int numberOfYellowCards, int numberOfRedCards, Boolean isSuspended) {
        this.id = idCode;
        this.nome = name;
        this.apelido = nickname;
        this.dataNascimento = birthdate;
        this.numero = number;
        this.posicao = position;
        this.qualidade = ability;
        this.cartoesAmarelos = numberOfYellowCards;
        this.cartaoVermelho = numberOfRedCards;
        this.suspenso = isSuspended;
    }

    boolean verificarCondicaoDeJogo() {
        return !this.suspenso;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdate = dateFormat.format(dataNascimento);

        String openingString = this.posicao + ": " + this.id + " - " + this.nome + " (" +
                               this.apelido + ")" + " - " + birthdate + " CONDIÇÃO: ";

        if (this.suspenso) {
            return openingString + "NÃO PODE JOGAR";
        }

        return openingString + "PODE JOGAR";
    }

    void aplicarCartaoAmarelo(int quantidade) {
        final int NUMBER_OF_YELLOW_CARDS_TO_BE_SUSPENDED = 3;

        this.cartoesAmarelos += quantidade;

        if (this.cartoesAmarelos >= NUMBER_OF_YELLOW_CARDS_TO_BE_SUSPENDED) {
            this.suspenso = true;
        }
    }

    void aplicarCartaoVermelho() {
        this.cartaoVermelho++;

        this.suspenso = true;
    }

    void cumprirSuspensao() {
        this.cartaoVermelho = 0;
        this.cartoesAmarelos = 0;
        this.suspenso = false;
    }

    void sofrerLesao() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if (randomNumber < 5) {
            this.qualidade = (int) Math.ceil(this.qualidade * 0.85);
        } else if (randomNumber < 15) {
            this.qualidade *= 0.90;
        } else if (randomNumber < 30) {
            this.qualidade *= 0.95;
        } else if (randomNumber < 60) {
            this.qualidade -= 2;
        } else {
            this.qualidade--;
        }

        if (this.qualidade < 0) {
            this.qualidade = 0;
        }
    }

    void executarTreinamento() {
        if (trainedYet) {
            return;
        }

        this.trainedYet = true;

        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;

        this.qualidade += randomNumber;
    }
}
