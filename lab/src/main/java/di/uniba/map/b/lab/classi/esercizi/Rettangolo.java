/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.classi.esercizi;

/**
 *
 * @author pierpaolo
 */
public class Rettangolo extends FiguraComp {

    /**
     *
     * @param dim1
     * @param dim2
     */
    public Rettangolo(double dim1, double dim2) {
        super(dim1, dim2);
    }

    /**
     *
     * @return
     */
    @Override
    public double area() {
        return dim1 * dim2;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "Rettangolo di dimensioni " + dim1 + ", " + dim2;
    }

}
