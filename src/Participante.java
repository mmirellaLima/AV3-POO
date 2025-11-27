import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Participante{
    private int idParticipante;
    private String nomeParticipante;
    private String loginParticipante;
    private String senhaParticipante;
    private String emailParticipante;
    private String enderecoParticipante;
    private String telefoneParticipante;

    public Participante(int id,String nome,String login,String senha,String email,String endereco,String telefone){
        this.idParticipante = id;
        this.nomeParticipante = nome;
        this.loginParticipante = login;
        this.senhaParticipante = senha;
        this.emailParticipante = email;
        this.enderecoParticipante = endereco;
        this.telefoneParticipante = telefone; 
    }

    public int getId(){return idParticipante;}
    public void setId(int id){this.idParticipante = id;}

    public String getNome(){return nomeParticipante;}
    public void setNome(String nome){this.nomeParticipante = nome;}

    public String getLogin(){return loginParticipante;}
    public void setLogin(String login){this.loginParticipante = login;}

    public String getSenha(){return senhaParticipante;}
    public void setSenha(String senha){this.senhaParticipante = senha;}

    public String getEmail(){return emailParticipante;}
    public void setEmail(String email){this.emailParticipante = email;}

    public String getEndereco(){return enderecoParticipante;}
    public void setEndereco(String endereco){this.enderecoParticipante = endereco;}

    public String getTelefone(){return telefoneParticipante;}
    public void setTelefone(String telefone){this.telefoneParticipante = telefone;}

    public void mostrar(){
        System.out.println("Nome: " + nomeParticipante);
        System.out.println("Login: " + loginParticipante);
        System.out.println("Email: " + emailParticipante);
        System.out.println("Telefone: " + telefoneParticipante);
        System.out.println("Id: " + idParticipante);
        System.out.println("--------------------------");
    }

    public Participante loginParticipante()throws Exception{
        FileReader fr = new FileReader("Participante.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null){
            String[] dados = linha.split(";");
            if(loginParticipante.equals(dados[2]) && senhaParticipante.equals(dados[3])){
                System.out.println("login realizado com sucesso!");

                return new Participante(Integer.parseInt(dados[0]),dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
            }
        }
        br.close();
        System.out.println("Login inválido. Participante não encontrado!");
         return null;
    }

    public Boolean registrarParticipantes(Participante p)throws Exception{
        FileReader fr = new FileReader("Participante.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null){
            String[] dados = linha.split(";");

            String emailArquivo = dados[4];

            if(p.getEmail().equals(emailArquivo)){
            System.out.println("Erro: Participante já existente!");
            br.close();
            return false;
        }  
    }
        br.close();
        FileWriter fw = new FileWriter("Participante.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(p.getId() +";"+ p.getNome() +";"+ p.getLogin() +";"+ p.getSenha() +";"+ p.getEmail() +";"+ p.getEndereco() +";"+ p.getTelefone());
        bw.newLine();
        bw.close();

    System.out.println("Participante registrado com sucesso!");
    return true;
}

    public ArrayList<Participante> listarParticipantes()throws Exception{
        ArrayList<Participante> participantes = new ArrayList<>();

        FileReader fr = new FileReader("Participante.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null){
            String[] dados = linha.split(";");
            Participante p = new Participante(Integer.parseInt(dados[0]),dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
            participantes.add(p);
        }
        br.close();
        for(Participante p :participantes){
            p.mostrar();
        }
            return participantes;
    }
}