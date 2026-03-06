package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva {

    // Atributs
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    // Constructor
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) {
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    // getters
    public Allotjament getAllotjament_() {
        return allotjament;
    }
    public Client getClient() {
        return client;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public LocalDate getDataSortida() {
        return dataSortida;
    }

    // setters

    public void setAllotjament_(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }
    public void setClient(Client client_) {
        this.client = client_;
    }
    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dataEntrada = dataEntrada_;
    }
    public void setDataSortida(LocalDate dataSortida_) { this.dataSortida = dataSortida_; }

    // Mètode 'toString'
    @Override
    public String toString() {
        return "Reserva{allotjament=" + allotjament.getId() +
                ", client=" + client.getDni() +
                ", entrada=" + dataEntrada +
                ", sortida=" + dataSortida+ "}";
    }

}
