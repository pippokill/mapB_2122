/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.io;

import java.io.Serializable;

/**
 *
 * @author pierpaolo
 */
public class Car implements Serializable {

    private String nome;

    private int cilindrata;

    private int porte;

    /**
     *
     * @param nome
     * @param cilindrata
     * @param porte
     */
    public Car(String nome, int cilindrata, int porte) {
        this.nome = nome;
        this.cilindrata = cilindrata;
        this.porte = porte;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public int getCilindrata() {
        return cilindrata;
    }

    /**
     *
     * @param cilindrata
     */
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    /**
     *
     * @return
     */
    public int getPorte() {
        return porte;
    }

    /**
     *
     * @param porte
     */
    public void setPorte(int porte) {
        this.porte = porte;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Car{" + "nome=" + nome + ", cilindrata=" + cilindrata + ", porte=" + porte + '}';
    }

}
