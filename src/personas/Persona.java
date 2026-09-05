package src.personas;
 
import src.poderes.IPower;

public class Persona {
    private byte edad;
    protected String nombre;
    private IPower power;

    // Un segundo constructor que si recibe parámetros
    public Persona (byte pEdad, String pNombre) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }
    
    public Persona (String pNombre, byte pEdad) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }

    public Persona (String pNombre) {
        this.edad = 0; // asigna un valor por default
        this.nombre = pNombre;
    }

    // constructor no tiene valor de retorno, y debe llamarse igual que la clase
    public Persona() {
        // inicializar persona con sus datos, edad y nombre.
        edad = 18;
        nombre= "Martín Francisco Rojas Barrios";
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getedad(){
        return (int) this.edad;
    }
    public void cantar() {
        // impriman un verso de no más de 4 lineas, de una canción que les guste y el autor.
        System.out.println( 
                            "There's a beat in the breeze, a sway in the trees \n" + //
                            "A rhythm in the night that ignites your feet \n" + //
                            "Four on the floor, fire in the sky \n" + //
                            "So why'd the world stop spinning when your hand met mine? \n" + //
                            "Oh, the city's alive, but I'm in a trance \n" +
                            "Zak Azoury");
    }
    public void setPower(IPower pPower){
        this.power = pPower;
    }
    public void atacar(){
        this.power.DispararPoder();
    }
}