# Sistema de Personas, Profesiones y Poderes

Este proyecto es una aplicación orientada a objetos escrita en Java que modela personas con diferentes profesiones y habilidades/poderes especiales utilizando patrones de diseño básicos como la polimorfismo e interfaces.

------------------------------------------------------------
## Función del programa
------------------------------------------------------------

El sistema permite:
1. Representar entidades base del tipo `Persona` con atributos comunes (nombre, edad) y comportamientos como cantar o asignar un poder especial.
2. Extender el comportamiento de una `Persona` mediante **herencia** para especializarse en distintas profesiones (`Bombero`, `OIJ`, `Quiropractico`), gestionando sus jornadas de trabajo, descanso y cobro/dinero ganado.
3. Asignar de forma dinámica comportamientos de ataque/poderes mediante la interfaz `IPower` y sus implementaciones concretas (patrón Strategy/Asociación).

------------------------------------------------------------
## Descripción de las Clases y Paquetes
------------------------------------------------------------
### Paquete `personas`
- **`Persona`**: Clase base que representa a un individuo. Contiene constructores sobrecargados, atributos protegidos/privados (`nombre`, `edad`), métodos generales (`cantar`) y la capacidad de poseer y ejecutar un poder mediante la interfaz `IPower`.

### Paquete `profesiones`
Todas estas clases heredan de `personas.Persona`:
- **`Bombero`**: Representa a un bombero. Controla el estado de servicio, horas trabajadas/descansadas y el cálculo del sueldo base por hora.
- **`OIJ`**: Representa a un investigador judicial. Asigna e investiga casos según horas acumuladas para liquidar pagos.
- **`Quiropractico`**: Representa a un profesional en quiropráctica. Agenda citas, realiza consultas y acumula el cobro según el precio acordado por consulta.

### Paquete `poderes`
- **`IPower`** *(Interfaz)*: Define la firma del método `DispararPoder()`.
- **`PoderAtaqueEspiral`**: Implementación de `IPower` que dispara un ataque en forma de espiral (`@@@@@@@@@@@@@@@@@@@@@>`).
- **`PoderAtaqueZigZag`**: Implementación de `IPower` que dispara un ataque en zigzag (`/\/\/\/\/\/\/\/\`).
- **`PoderCirculosDeEnergia`**: Implementación de `IPower` que dispara un ataque circular (`OoOoOoOoOoOoOoOoO`).
- **`PoderKPOW`**: Implementación de `IPower` que dispara un ataque de ráfaga (`KPOW KPOW...`).
- **`PoderRayoLaser`**: Implementación de `IPower` que dispara un rayo láser (`--------------->`).

------------------------------------------------------------
## Diagrama de Clases (PlantUML)
------------------------------------------------------------

@startuml
package personas {
    class Persona {
        - edad: byte
        # nombre: String
        - power: IPower
        + Persona(pEdad: byte, pNombre: String)
        + Persona(pNombre: String, pEdad: byte)
        + Persona(pNombre: String)
        + Persona()
        + getNombre(): String
        + getedad(): int
        + cantar(): void
        + setPower(pPower: IPower): void
        + atacar(): void
    }
}

package poderes {
    interface IPower {
        + DispararPoder(): void
    }

    class PoderAtaqueEspiral implements IPower {
        + PoderAtaqueEspiral()
        + DispararPoder(): void
    }

    class PoderAtaqueZigZag implements IPower {
        + PoderAtaqueZigZag()
        + DispararPoder(): void
    }

    class PoderCirculosDeEnergia implements IPower {
        + PoderCirculosDeEnergia()
        + DispararPoder(): void
    }

    class PoderKPOW implements IPower {
        + PoderKPOW()
        + DispararPoder(): void
    }

    class PoderRayoLaser implements IPower {
        + PoderRayoLaser()
        + DispararPoder(): void
    }
}

package profesiones {
    class Bombero extends personas.Persona {
        - en_servicio: boolean
        - horas_trabajadas: int
        - horas_descansadas: int
        - dinero: int
        - valor_hora: int
        + Bombero(pNombre: String, pEdad: int, pValor_hora: int)
        + trabajando(horas: int): void
        + Descansando(horas: int): void
        + DiaDePago(): void
        + GetDinero(): int
    }

    class OIJ extends personas.Persona {
        - libre: boolean
        - horas_trabajadas: int
        - horas_investigacion: int
        - dinero: int
        - valor_hora: int
        + OIJ(pNombre: String, pEdad: int, pValor_hora: int)
        + AsignarInvestigacion(horas: int): void
        + InvestigarCaso(): void
        + DiaDePago(): void
        + GetHorasTrabajadas(): int
        + GetDinero(): int
    }

    class Quiropractico extends personas.Persona {
        - libre: boolean
        - horas_trabajadas: int
        - horas_consulta: int
        - dinero: int
        - precio_consulta: int
        + Quiropractico(pNombre: String, pEdad: int, pprecio_consulta: int)
        + AgendarCita(horas: int): void
        + Consulta(): void
        + GetDinero(): int
    }
}

personas.Persona "1" --> "0..1" poderes.IPower : power

@enum
