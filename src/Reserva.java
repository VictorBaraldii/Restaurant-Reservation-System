import java.time.LocalDateTime;

public class Reserva {
    private String nomeCliente;
    private LocalDateTime dataHora;
    private int numeroPessoas;

    public Reserva(String nomeCliente, LocalDateTime dataHora, int numeroPessoas) {
        this.nomeCliente = nomeCliente;
        this.dataHora = dataHora;
        this.numeroPessoas = numeroPessoas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }
    @Override
    public String toString() {
        return "Reserva: " + nomeCliente + ", Data e Hora: " + dataHora + ", Pessoa: " + numeroPessoas;
    }
}

