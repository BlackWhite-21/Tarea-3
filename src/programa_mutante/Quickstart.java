package programa_mutante;

import personas.Persona;

import poderes.IPower;
import poderes.PoderAtaqueEspiral;
import poderes.PoderAtaqueZigZag;
import poderes.PoderCirculosDeEnergia;
import poderes.PoderKPOW;

import profesiones.Bombero;
import profesiones.OIJ;
import profesiones.Quiropractico;

public class Quickstart {
    public static void main(String[] args) {
        System.out.println("Hello clase de Poo");
        Persona rodri = new Persona();
        Persona p1 = new Persona("Juliana", (byte)22);

        rodri.cantar();
        rodri.getNombre();

        p1.cantar();
        p1.getNombre();

        Persona profesionales[] = new Persona[10];
        IPower poderesDisponibles[] = {new PoderAtaqueEspiral(), new PoderAtaqueZigZag(), new PoderCirculosDeEnergia(), new PoderKPOW()};

        for (int i = 0; i < 10; i++) {
            int tipoProfesion = (int)(Math.random()*2);
            switch (tipoProfesion) {
                case 0:
                    profesionales[i] = new Bombero("Gato "+i, 27, 4500);
                    break;
                case 1:
                    profesionales[i] = new OIJ("Baruch "+i, 32,5500);
                    break;
                case 2:
                    profesionales[i] = new Quiropractico("Pedro Oscobar "+i, 26,10000);
                    break;
                default:
                    profesionales[i] = new Bombero("Gato "+i, 27, 4500);
            }
            profesionales[i].setPower(poderesDisponibles[(int)(Math.random()*4)]);
        }

        for(Persona p : profesionales) {
            System.out.println("Ataca "+p.getNombre());
            p.atacar();
        }
    }
}