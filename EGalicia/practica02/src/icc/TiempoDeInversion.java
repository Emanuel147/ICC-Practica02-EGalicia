import java.util.Scanner;

/**
 * Simulador de inversiones
 * A partir de una fecha inicial, fecha final y un monto, calcula el rendimiento al 12%.
 * Se asume que las fechas ingresadas son validas.
 * Se asume que la fecha inicial es menor que la fecha final.
 * @author Galicia Rosas Emanuel Tonahuayoltzin
 * @version 1a edicion
*/
public class TiempoDeInversion{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    do{
      System.out.println("Hola, sea bienvenido a TiempoDeInversion");
      System.out.println("Por favor, introduzca su nombre:");
      String nombre;
      nombre = in.nextLine();
      System.out.println("Hola, " + nombre  + " ¿Cual es su monto a invertir?");
      double monto = in.nextDouble();

      int dia, mes, year;
      System.out.println("Introduzca el dia de inicio de la inversion");
      dia = in.nextInt();
      System.out.println("Introduzca el mes de inicio de la inversion");
      mes = in.nextInt();
      System.out.println("Introduzca el año de inicio de la inversion");
      year = in.nextInt();
      Fecha inicio = new Fecha(dia, mes, year);

      System.out.println("Introduzca el dia del fin de la inversion");
      dia = in.nextInt();
      System.out.println("Introduzca el mes del fin de la inversion");
      mes = in.nextInt();
      System.out.println("Introduzca el año del fin de la inversion");
      year = in.nextInt();
      Fecha fin = new Fecha(dia, mes, year);
      in.nextLine();

      System.out.println("Dias de la inversion: " + inicio.diferencia(fin));
      System.out.println("Rendimiento 12%: " + (monto * (.12/365) * inicio.diferencia(fin)));
      System.out.println("Desea hacer otra simulacion? y/n: ");
      String respuesta;
      respuesta = in.nextLine();
      if (respuesta.equals("n"))
        return;
    }while(true);
  }
}
