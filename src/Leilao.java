import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;

public class Leilao {
    private int idLeilao;
    private Date dataInicioLeilao;
    private Time horaInicioLeilao;
    private Date dataFimLeilao;
    private Time horaFimLeilao;
    private Boolean statusLeilao;

    public Leilao(int id,Date dataInicio,Time horaInicio,Date dataFim,Time horaFim,Boolean status){
        this.idLeilao = id;
        this.dataInicioLeilao = dataInicio;
        this.horaInicioLeilao = horaInicio;
        this.dataFimLeilao = dataFim;
        this.horaFimLeilao = horaFim;
        this.statusLeilao = status;
    }

    public int getId(){return idLeilao;}
    public void setId(int id){this.idLeilao = id;}

    public Date getDataInicio(){return dataInicioLeilao;}
    public void setDataInicio(Date dataIncio){this.dataInicioLeilao = dataIncio;}

    public Time getHoraInicio(){return horaInicioLeilao;}
    public void setHoraInicio(Time horaInicio){this.horaInicioLeilao = horaInicio;}

    public Date getDataFim(){return dataFimLeilao;}
    public void setDataFim(Date dataFim){this.dataFimLeilao = dataFim;}

    public Time getHoraFim(){return horaFimLeilao;}
    public void setHoraFim(Time horaFim){this.horaFimLeilao = horaFim;}

    public Boolean getStatus(){return statusLeilao;}
    public void setStatus(Boolean status){this.statusLeilao = status;}

    public void mostrar(){
        System.out.println("Data de início: " + dataInicioLeilao);
        System.out.println("Data de encerramento: " + dataFimLeilao);
        System.out.println("Horário do início: " + horaInicioLeilao);
        System.out.println("Horário de encerramento: " + horaFimLeilao);
        System.out.println("Status do leilão: " + statusLeilao);
        System.out.println("--------------------------");
    }

    public void inserir()throws Exception{
        FileWriter fw = new FileWriter("Leilao.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(idLeilao);
        bw.newLine();
        bw.close();
    }
    public Leilao consultarLeilao(Leilao l)throws Exception{
        FileReader fr = new FileReader("Leilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        
        while((linha = br.readLine()) != null){
            return l;
        }
        return null;
    }
}
