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
    public void setEndenco(String endereco){this.enderecoParticipante = endereco;}

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

    public Participante loginParticipante(){
        if(loginParticipante){
            return participante;
        }
    }

    public Boolean registrarParticipantes(){
        
    }

    public ArrayList<Participante> listarParticipantes(){
        ArrayList<Participante> participantes = new ArrayList<>();
        for(participante p :participantes){
            p.mostrar();
        }
    }
}