import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

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

    public Leilao consultarLeilao(int id)throws Exception{
        FileReader fr = new FileReader("Leilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while((linha = br.readLine()) != null){
            String[] dados = linha.split(";");
            if(Integer.parseInt(dados[0]) == id){
                System.out.println("leilão encontrado!");
                return new Leilao(Integer.parseInt(dados[0]),Date.valueOf(dados[1]),Time.valueOf(dados[2]),Date.valueOf(dados[3]),Time.valueOf(dados[4]),Boolean.valueOf(dados[5]));
            }
        }
        br.close();
        System.out.println("leilão não encontrado!");
        return null;
    }

    public Boolean registrarLeilao(Leilao l)throws Exception{
        Leilao resultado = consultarLeilao(l.getId());

        if(resultado != null){
            System.out.println("Erro: Leilão já existente!");
            return false;
        }else{
            FileWriter fw = new FileWriter("Leilao.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(idLeilao +";"+ dataInicioLeilao +";"+ horaInicioLeilao +";"+ dataFimLeilao +";"+ horaFimLeilao +";"+statusLeilao);
        bw.newLine();
        bw.close();
     
            System.out.println("Leilão cadastrado com sucesso!");
            return true;
        }
    }
    public Boolean iniciarLeilao(Leilao l)throws Exception{
        FileReader fr = new FileReader("Leilao.txt");
        BufferedReader br = new BufferedReader(fr); //perguntar como devo alterar o arquivo

        Leilao resultado = consultarLeilao(l.getId());

        if(resultado != null){
            resultado.setStatus(true);
            System.out.println("Leilão iniciado");
            return getStatus();
        }else{
            System.out.println("leilão não encontrado!");
        }
        return null;
    }

    public Boolean finalizarLeilao(Leilao l)throws Exception{
        Leilao resultado = consultarLeilao(l.getId());

        if(resultado != null){
            resultado.setStatus(false);
            System.out.println("Leilão finalizado");
            return getStatus();
        }else{
            System.out.println("leilão não encontrado!");
        }
        return null;
    }
     public ArrayList<Leilao> listarLeiloes(){
        ArrayList<Leilao> leiloes = new ArrayList<>();
        for( Leilao l :leiloes){
            l.mostrar();
        }
        return leiloes;
     }
}
