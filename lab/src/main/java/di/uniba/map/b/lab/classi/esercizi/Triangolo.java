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
public class Triangolo extends FiguraComp {

    /**
     *
     * @param dim1
     * @param dim2
     */
    public Triangolo(double dim1, double dim2) {
        super(dim1, dim2);
    }

    /**
     *
     * @return
     */
    @Override
    public double area() {
        return dim1 * dim2 / 2;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Triangolo con dimensioni " + dim1 + ", " + dim2;
    }

}
