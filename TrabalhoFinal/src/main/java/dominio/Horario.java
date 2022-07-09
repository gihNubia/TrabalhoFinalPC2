package dominio;

import java.security.InvalidParameterException;

public class Horario implements Comparable, Salvable{
    private int segundos;
    private int minutos;
    private int horas;

    public Horario(){
        this.segundos = 0;
        this.minutos = 0;
        this.horas = 0;
    }

    public Horario(int horas) throws InvalidParameterException {
        String msg = validaDados(horas, 0, 0);
        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.segundos = 0;
        this.minutos = 0;
        this.horas = horas;
    }

    public Horario(int horas, int minutos) throws InvalidParameterException {
        String msg = validaDados(horas, minutos, 0);
        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.segundos = 0;
        this.minutos = minutos;
        this.horas = horas;
    }

    public Horario(int horas, int minutos, int segundos) throws InvalidParameterException {
        String msg = validaDados(horas, minutos, segundos);
        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public Horario(String horario) throws InvalidParameterException{
        String el[] = horario.split(":");

        if (el.length > 3)
            throw new InvalidParameterException("Horario invalido. Formato esperado: hh:mm:ss");

        // o usuario informou alguma coisa? entao a primeira sao as horas
        int horas = (el.length > 0) ? Integer.parseInt(el[0]) : 0;
        // o usuario informou mais que uma coisa? entao a segunda sao os minutos
        int minutos = (el.length > 1) ? Integer.parseInt(el[1]) : 0;
        // o usuario informou mais que duas coisas? entao a terceira sao os segundos
        int segundos = (el.length > 2) ? Integer.parseInt(el[2]) : 0;

        String msg = validaDados(horas, minutos, segundos);
        if (msg != "OK")
            throw new InvalidParameterException(msg);

        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    public String validaDados(int horas, int minutos, int segundos){
        if (horas < 0 || horas > 23)
            return "Hora deve estar entre 0 e 23";

        if (minutos < 0 || minutos > 59)
            return "Minuto deve estar entre 0 e 59";

        if (segundos < 0 || segundos > 59)
            return "Segundo deve estar entre 0 e 59";

        return "OK";
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }


    public int compareTo(Object ob) {
        Horario o = (Horario)ob;
        if (this.horas > o.getHoras())
            return 1;
        if (this.horas < o.getHoras())
            return -1;

        if (this.minutos > o.getMinutos())
            return 1;
        if (this.minutos < o.getMinutos())
            return -1;

        if (this.segundos > o.getSegundos())
            return 1;
        if (this.segundos < o.getSegundos())
            return -1;

        return 0;
    }

    @Override
    public String formatted() {
        return horas + ":" + minutos + ":" + segundos;
    }
}
