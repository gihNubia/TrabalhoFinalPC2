package dominio;

import java.security.InvalidParameterException;

public class Tarefa implements Comparable, Salvable{
    private String nome;
    private String descricao;
    private Data data;
    private Horario horario;

    public Tarefa(String nome, String descricao, Data data, Horario horario){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
    }

    public Tarefa (String nome, String descricao, String data, String horario) throws InvalidParameterException{
        this.nome = nome;
        this.descricao = descricao;
        this.data = new Data(data);
        this.horario = new Horario(horario);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Data getData() {
        return data;
    }

    public Horario getHorario() {
        return horario;
    }


    @Override
    public int compareTo(Object ob) {
        Tarefa o = (Tarefa)ob;
        if (this.data.compareTo(o.getData()) != 0)
            return this.data.compareTo(o.getData());

        return this.horario.compareTo(o.getHorario());
    }

    @Override
    public String formatted() {
        return nome + "§" + descricao + "§" + data.formatted() + "§" + horario.formatted();
    }
}
