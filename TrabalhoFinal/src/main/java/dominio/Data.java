package dominio;

import java.security.InvalidParameterException;

public class Data implements Comparable, Salvable{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) throws InvalidParameterException{
        String msg = validaDados(dia, mes, ano);
        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data (String data) throws InvalidParameterException{
        String[] el = data.split("/");
        if (el.length != 3)
            throw new InvalidParameterException("Data invalida. Formato esperado: dd/mm/aaaa");

        int dia = Integer.parseInt(el[0]);
        int mes = Integer.parseInt(el[1]);
        int ano = Integer.parseInt(el[2]);

        String msg = validaDados(dia, mes, ano);

        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String validaDados(int dia, int mes, int ano){
        if (mes < 1 || mes > 12)
            return "Mes deve estar entre 1 e 12";

        if (dia < 1 || dia > 31)
            return "O dia deve estar entre 1 e 31";

        if (mes == 2 && dia > 29)
            return "Fevereiro nunca tem mais que 29 dias";

        if (mes == 2 && dia > 28 && ano%4 != 0)
            return "Fevereiro nao tem mais que 28 dias neste ano";

        if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11))
            return "Esse mes nao tem mais que 30 dias";

        return "OK";
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int compareTo(Object ob) {
        Data o = (Data)ob;
        if (this.ano > o.getAno())
            return 1;
        if (this.ano < o.getAno())
            return -1;

        if (this.mes > o.getMes())
            return 1;
        if (this.mes < o.getMes())
            return -1;

        if (this.dia > o.getDia())
            return 1;
        if (this.dia < o.getDia())
            return -1;

        return 0;
    }

    @Override
    public String formatted() {
        return dia + "/" + mes + "/" + ano;
    }
}
