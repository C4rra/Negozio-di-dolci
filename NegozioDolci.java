import java.util.ArrayList;

public class NegozioDolci {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123", "Pippo");
        Cliente cliente2 = new Cliente("234", "Paperino");
        Cliente cliente3 = new Cliente("001", "Topolino");

        Dolce cheesecake = new Dolce("Cheesecake", 23);
        Dolce pannacotta = new Dolce("Pannacotta", 21);
        Dolce torta = new Dolce("Torta", 7);
        Dolce cannolo = new Dolce("Cannolo", 10);
        Dolce sacher = new Dolce("Sacher", 12);
        Dolce diplomatico = new Dolce("Diplomatico", 12);

        Negozio bakeryHouse  = new Negozio();
        bakeryHouse.aggiungiDolce(cheesecake);
        bakeryHouse.aggiungiDolce(pannacotta);
        bakeryHouse.aggiungiDolce(torta);
        bakeryHouse.aggiungiDolce(cannolo);
        bakeryHouse.aggiungiDolce(sacher);
        bakeryHouse.aggiungiDolce(diplomatico);

        bakeryHouse.stampaDolciDisponibili();

        bakeryHouse.aggiungiCliente(cliente1);
        bakeryHouse.aggiungiCliente(cliente2);
        bakeryHouse.aggiungiCliente(cliente3);
        bakeryHouse.stampaClienti();


        bakeryHouse.gestisciAcquisto("123", cheesecake);
        cliente1.stampaDolciAcquistati();
        bakeryHouse.stampaDolciDisponibili();

    }
}

class Dolce {
    String nomeDolce;
    int prezzo;
    public Dolce (String nomeDolce, int prezzo){
        this.nomeDolce = nomeDolce;
        this.prezzo = prezzo;
    }
}

class Cliente {
    String idCliente;
    String nomeCliente;
    ArrayList<Dolce> dolciAcquistati;
    public Cliente(String idCliente, String nomeCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        dolciAcquistati = new ArrayList<Dolce>();
    }

    void acquistaDolce(Dolce dolceAcquistato) {
        dolciAcquistati.add(dolceAcquistato);
    }

    void stampaDolciAcquistati() {
        System.out.println("I dolci acquistati da " + nomeCliente + " :");
        for(int i=0; i<dolciAcquistati.size(); i++) {
            System.out.println(dolciAcquistati.get(i).nomeDolce + " " + dolciAcquistati.get(i).prezzo);
        }
        
    }
}



class Negozio {
    ArrayList<Dolce> listaDolciDisponibili;
    ArrayList<Cliente> listaClienti;

    public Negozio() {
        listaDolciDisponibili = new ArrayList<Dolce>();
        listaClienti = new ArrayList<Cliente>();
    }

    void stampaDolciDisponibili () {
        for(int i=0; i<listaDolciDisponibili.size(); i++) {
            System.out.println("-" + listaDolciDisponibili.get(i).nomeDolce + " " + listaDolciDisponibili.get(i).prezzo); 
        }
    }

    void stampaClienti () {
        System.out.println("Clienti del negozio : ");
        for(int i=0; i<listaClienti.size(); i++) {
            System.out.println("-" + listaClienti.get(i).nomeCliente);
        }
    }
    
    void aggiungiDolce(Dolce dolceDaAggiungere) {
        listaDolciDisponibili.add(dolceDaAggiungere);
    }

    void rimuoviDolce(Dolce dolceDaRimuovere) {
        listaDolciDisponibili.remove(dolceDaRimuovere);
    }

    void aggiungiCliente(Cliente clienteDaAggiungere) {
        listaClienti.add(clienteDaAggiungere);
    }

    void gestisciAcquisto(String idCl, Dolce dolceDaAcquistare) {
        for(int i=0; i<listaClienti.size(); i++) {
            if(listaClienti.get(i).idCliente.equals(idCl)) {
                listaClienti.get(i).acquistaDolce(dolceDaAcquistare);
                listaDolciDisponibili.remove(dolceDaAcquistare);
                break;
            }
        }
    }

}
