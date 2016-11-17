package br.com.renanzalheiros.agenda.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrepereira on 16/11/16.
 */

public class Prova implements Serializable{

    private String materia;
    private String data;
    private List<String> provas;

    public Prova(String materia, String data, List<String> provas) {
        this.materia = materia;
        this.data = data;
        this.provas = provas;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getProvas() {
        return provas;
    }

    public void setProvas(List<String> provas) {
        this.provas = provas;
    }

    @Override
    public String toString() {
        return this.materia;
    }
}
