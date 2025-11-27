import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Lance {
    private int idLance;
    private Participante participante;
    private ItemLeilao itemLeilao;
    private Double valorLance;
    private Date dataLance;
    private Time horaLance;

    public Lance(int id,Participante participante,ItemLeilao item,Double valor,Date data,Time hora){
        this.idLance = id;
        this.participante = participante;
        this.itemLeilao = item;
        this.valorLance = valor;
        this.dataLance = data;
        this.horaLance = hora;
    }
     public Lance(){
        this.idLance = 0;
        this.participante = null;
        this.itemLeilao = null;
        this.valorLance = 0.0;
        this.dataLance = null;
        this.horaLance = null;
    }

    public int getId(){return idLance;}
    public void setId(int id){this.idLance = id;}

    public Participante getParticipante(){return participante;}
    public void setParticipante(Participante participante){this.participante = participante;}

    public ItemLeilao getItemLeilao(){return itemLeilao;}
    public void setItemLeilao(ItemLeilao itemLeilao){this.itemLeilao = itemLeilao;}

    public Double getValor(){return valorLance;}
    public void setValor(Double valor){this.valorLance = valor;}

    public Date getData(){return dataLance;}
    public void setData(Date data){this.dataLance = data;}

    public Time getHora(){return horaLance;}
    public void setHora(Time hora){this.horaLance = hora;}

    public void mostrar(){
        System.out.println("Nome do Participante: " + participante);
        System.out.println("Item leiloado: " + itemLeilao);
        System.out.println("Valor do lance: " + valorLance);
        System.out.println("Data do lance: " + dataLance);
        System.out.println("Horário do lance: " + horaLance);
        System.out.println("--------------------------");
    }

    public Boolean registrarLance()throws Exception{
        Boolean existe = false;

        try(FileReader fr = new FileReader("Lance.txt");
            BufferedReader br = new BufferedReader(fr);){

            String linha = "";
            while ((linha = br.readLine())!= null) {
            String [] dados = linha.split(";");
            if(Integer.parseInt(dados[0]) == this.idLance){
                existe = true;
                break;
                }
            }
        }

         if(existe){
            System.out.println("Erro: Lance já existente!");
            return false;
        }
        try(FileWriter fw = new FileWriter("Lance.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);){
            bw.write(idLance +";"+ participante +";"+ itemLeilao +";"+ valorLance +";"+ dataLance +";"+ horaLance);
            bw.newLine();
            bw.close();
        }
        System.out.println("Leilão cadastrado com sucesso!");
            return true ; 
    }

    public ArrayList<Lance> listarLances()throws Exception{
        ArrayList<Lance> lances = new ArrayList<>();
        
        FileReader fr = new FileReader("Lance.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        
        while((linha = br.readLine()) != null){
                String[] dados = linha.split(";");
                int idLance = Integer.parseInt(dados[0]);
                String nomeParticipante = dados[1];
                int idItem = Integer.parseInt(dados[2]);
                Double valor = Double.valueOf(dados[3]);
                Date data = Date.valueOf(dados[4]);
                Time hora = Time.valueOf(dados[5]);

                Participante objParticipante = new Participante(nomeParticipante);
                ItemLeilao objItem = new ItemLeilao(idItem);
                lances.add(new Lance(idLance, objParticipante, objItem, valor, data, hora));
            
        }
        for(Lance l : lances) l.mostrar();
        return lances;
    }
}
