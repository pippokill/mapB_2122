/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection.esercizi;

/**
 *
 * @author pierpaolo
 */
public class Articolo {

    private int id;

    private String desc;

    private double prezzo;

    private double peso;

    /**
     *
     * @param id
     */
    public Articolo(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param desc
     * @param prezzo
     * @param peso
     */
    public Articolo(int id, String desc, double prezzo, double peso) {
        this.id = id;
        this.desc = desc;
        this.prezzo = prezzo;
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     *
     * @param prezzo
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     *
     * @return
     */
    public double getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articolo other = (Articolo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return id + ", " + desc + ", prezzo=" + prezzo + ", peso=" + peso;
    }

}
