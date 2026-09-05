package src.profesiones;

import src.personas.Persona;

public class Quiropractico extends Persona {
    private boolean libre;
    private int horas_trabajadas;
    private int horas_consulta;
    private int dinero;
    private final int precio_consulta;

    public Quiropractico(String pNombre,int pEdad,int pprecio_consulta) {
        super(pNombre, (byte)pEdad);
        this.dinero = 0;
        this.libre = true;
        this.horas_consulta = 0;
        this.precio_consulta = pprecio_consulta;
    }

    public void AgendarCita(int horas) {
        if (libre){
            this.libre = false;
            this.horas_consulta = horas;
        }
    }
    public void Consulta() {
        if (horas_consulta>=0){
            this.libre = true;
            this.horas_trabajadas += this.horas_consulta;
            this.dinero += (this.horas_trabajadas*this.precio_consulta);
        }
    }
    public int GetDinero(){
        return this.dinero;
    }
}
