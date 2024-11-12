import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SistemaDeReserva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeReservas gerenciador = new GerenciadorDeReservas();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data e Hora (dd/MM/yyyy HH:mm): ");
                    String dataHoraStr = scanner.nextLine();
                    try {
                        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);
                        System.out.print("Número de pessoas: ");
                        int numeroPessoas = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        Reserva reserva = new Reserva(nome, dataHora, numeroPessoas);
                        gerenciador.adicionarReserva(reserva);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data/hora inválido. Use o formato dd/MM/yyyy HH:mm.");
                    }
                    break;
                case 2:
                    gerenciador.listarReservas();
                    break;
                case 3:
                    System.out.print("Nome do cliente para cancelar: ");
                    String nomeCancelamento = scanner.nextLine();
                    System.out.print("Data e Hora da reserva a cancelar (dd/MM/yyyy HH:mm): ");
                    String dataHoraCancelamentoStr = scanner.nextLine();
                    try {
                        LocalDateTime dataHoraCancelamento = LocalDateTime.parse(dataHoraCancelamentoStr, formatter);
                        gerenciador.cancelarReserva(nomeCancelamento, dataHoraCancelamento);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data/hora inválido. Use o formato dd/MM/yyyy HH:mm.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("1. Adicionar Reserva");
        System.out.println("2. Listar Reservas");
        System.out.println("3. Cancelar Reserva");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
