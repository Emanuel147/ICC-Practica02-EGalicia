# ICC-Practica02-EGalicia

- Autor: Galicia Rosas Emanuel Tonahuayoltzin
- Introduccion a Ciencias de la Computacion
- Profesor: Salvador López Mendoza
- Ayudante: Yanahı́ Demerio Torres
- Ayudante de Laboratorio: Rosa Victoria Villa Padilla

Fecha de entrega: 13 de Noviembre del 2026.

---
Se elaboraron dos clases. La clase Fecha.java es un programa manejador de fechas y la clase TiempoDeInversion.java es un programa simulador de inversiones.

## Estructura del Proyecto.
``` shell
.
├── EGalicia
│   └── practica02
│       └── src
│           └── icc
│               ├── Fecha.java
│               └── TiempoDeInversion.java
└── README.md
```

---
## Clase Fecha.java
La clase Fecha es un manejador de fechas que crea objetos fechas e incluyen varios metodos para hacer distintos calculos con la fecha.
### Metodos:
- Constructores: Incluye tres constructores (sin parametros, con dia/mes/año y con dia, año y el nombre del mes).
- Acceso: getters y setters para los parametros de la fecha (dia, mes y año).
- Calculadores: `agregarDias` (acepta dias negativos), `diasPasados`,  `fechaEnDias`.
- Conversion: nombre del mes a numero y viceversa, `showDate`. Para mas informacion revisar [Documentacion javadoc](#Documentacion) 
### Caracteristicas:
- Se asume que la entrada String de `mesNombre()` es valida (Mayuscula en la inicial)
- Se asume que la entrada entera de `mesNombre()` es valida (rango 1-12).
- Se asume en la asignacion de la fecha, la fecha introducida sea valida.
### Compilar y Ejecutar:
- Compilar: `javac Fecha.java`
- Ejecutar: `java Fecha`
### Demo
Como en el `main()` de Fecha no hay codigo, no imprime nada.
```shell
❯ javac Fecha.java && java Fecha
```

---
## Clase TiempoDeInversion.java
Esta clase es un simulador de inversiones. Da la bienvenida al usuario y le saluda, le pide un monto de inversion, una fecha inicial, una fecha final e imprime los dias de la inversion, el rendimiento de la inversion al 12%.
### Metodos:
No incluye metodos adicionales. El programa esta contenido en el main(). Sin embargo, para manejar las fechas utiliza la clase Fecha, asi que es necesario tener la clase Fecha.java
### Caracteristicas
- Se asume que la fecha inicial es 'menor' que la fecha final
- Se asume que el monto es positivo.
- Al terminar de hacer la simulacion para salir del programa teclear 'n', para continuar 'y' u otra tecla.
### Compilar y Ejecutar
Para compilar `javac TiempoDeInversion.java` es necesario tener `Fecha.java`
- Compilar: `javac TiempoDeInversion.java`
- Ejecutar: `java TiempoDeInversion`
### Demo
```shell
❯ javac TiempoDeInversion.java && java TiempoDeInversion
Hola, sea bienvenido a TiempoDeInversion
Por favor, introduzca su nombre:
Emanuel
Hola, Emanuel ¿Cual es su monto a invertir?
1000
Introduzca el dia de inicio de la inversion
1
Introduzca el mes de inicio de la inversion
1
Introduzca el año de inicio de la inversion
2025
Introduzca el dia del fin de la inversion
1
Introduzca el mes del fin de la inversion
1
Introduzca el año del fin de la inversion
2026
Dias de la inversion: 365
Rendimiento 12%: 120.0
Desea hacer otra simulacion? y/n: 
n
```

## Documentacion
El codigo esta documentado con el formato javadoc.
Para obtener la documentacion de la clase Fecha:
`javadoc -d docs Fecha.java`
Para obtener la documentacion de la TiempoDeInversion.java
`javadoc -d docs TiempoDeInversion.java`

