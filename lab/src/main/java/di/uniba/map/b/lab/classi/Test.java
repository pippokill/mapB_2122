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
package di.uniba.map.b.lab.classi;

/**
 *
 * @author pierpaolo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Esempio parmetri indefiniti
        ParametriIndefiniti pi = new ParametriIndefiniti();
        pi.print("Topilino", "Pippo");
        pi.print("Topilino", "Pippo", "Pluto", "Paperino");
        // Esempio di classe con attributo statico
        PersonStatic p1 = new PersonStatic("Marco", "Rossi");
        PersonStatic p2 = new PersonStatic("Francesca", "Bianchi");
        System.out.println(PersonStatic.numbOfPersons);
        // Esempio enum
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        System.out.println(Planet.EARTH.mass());
        System.out.println(Planet.EARTH.radius());
        
        // Esempio interfaccia
        Vat italianVat = new ItalianVat();
        System.out.println(italianVat.computeVat(10));
        Vat germanyVat = new GermanyVat();
        System.out.println(germanyVat.computeVat(10));
        // Esempio ereditarietà
        ScientificCalculator sc = new ScientificCalculator();
        System.out.println(sc.sin(4));
        System.out.println(sc.sum(3, 4));
        // Esempio ereditarietà + overriding
        ClassA a = new ClassA();
        ClassA b = new ClassB();
        a.sayHello();
        b.sayHello();
        a.printMe();
        b.printMe();
        ClassA bb = new ClassBB();
        bb.printMe();
        // Esempio classe astratta
        GraphicObject cerchio = new Circle(3, 4);
        cerchio.draw();
        cerchio.resize();
        GraphicObject rettangolo = new Rectangle(5, 10);
        rettangolo.draw();
        rettangolo.resize();
        // Esempio classe astratta + interfaccia
        AbstractClassX cx = new ClassXX();
        cx.methodOneOfY(3, 4);
        System.out.println(cx.methodTwoOfY(3));
    }

}
