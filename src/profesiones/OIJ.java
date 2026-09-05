package src.profesiones;

import src.personas.Persona;

public class OIJ extends Persona {
    private boolean libre;
    private int horas_trabajadas;
    private int horas_investigacion;
    private int dinero;
    private final int valor_hora;

    public OIJ(String pNombre, int pEdad,int pValor_hora) {
        super(pNombre, (byte)pEdad);
        this.libre = true;
        this.horas_trabajadas = 0;
        this.horas_investigacion = 0;
        this.valor_hora = pValor_hora;
    }

    public void AsignarInvestigacion(int horas) {
        if (libre) {
            this.libre = false;
            this.horas_investigacion = horas;
        }
    }

    public void InvestigarCaso() {
        if (horas_investigacion > 0) {
            this.libre = true;
            this.horas_trabajadas += this.horas_investigacion;
            this.horas_investigacion = 0;
        }
    }
    public void DiaDePago() {
        this.dinero += this.horas_trabajadas*this.valor_hora;
        this.horas_trabajadas = 0;
    }

    public int GetHorasTrabajadas() {
        return this.horas_trabajadas;
    }
    public int GetDinero() {
        return this.dinero;
    }
}

