package src.profesiones;

import src.personas.Persona;

public class Bombero extends Persona {
    private boolean en_servicio;
    private int horas_trabajadas;
    private int horas_descansadas;
    private int dinero;
    private final int valor_hora;

    public Bombero(String pNombre,int pEdad,int pValor_hora) {
        super(pNombre, (byte)pEdad);
        this.dinero = 0;
        this.en_servicio = false;
        this.horas_descansadas = 8;
        this.horas_trabajadas= 0;
        this.valor_hora = pValor_hora;
    }

    public void trabajando(int horas) {
        this.en_servicio = true;
        if (this.horas_descansadas > -6){
            this.horas_descansadas -= horas;
            this.horas_trabajadas += horas;
        }
        
    }
    public void Descansando(int horas) {
        this.en_servicio = false;
        if (!en_servicio){
            this.horas_descansadas += horas;
        }
    }
    public void DiaDePago() {
        this.dinero += this.horas_trabajadas*this.valor_hora;
        this.horas_trabajadas = 0;
    }
    public int GetDinero(){
        return this.dinero;
    }
}