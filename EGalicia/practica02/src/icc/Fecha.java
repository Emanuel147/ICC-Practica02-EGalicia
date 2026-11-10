import java.util.Scanner;
/**
 * Sistema manejador de fechas.
 * Se asume que el nombre del mes es valido y empieza con mayuscula.
 * @author Galicia Rosas Emanuel Tonahuayoltzin
 * @version 1a edicion
*/
public class Fecha{
  private int dia, mes, year;

  // a
  /** Constructor de una fecha sin parametros
   * La fecha por defecto es 1 de Enero del 2026.
  */
  public Fecha() {
    dia = 1;
    mes = 1;
    year = 2026;
  }

  /** Constructor de una fecha con parametros enteros
   * @param dia Entero para representar los dias de la fecha en el mes.
   * @param mes Entero para representar el mes de la fecha del 1 al 12.
   * @param year Entero para representar el año de la fecha.
  */
  public Fecha(int dia, int mes, int year) {
    this.dia = dia;
    this.mes = mes;
    this.year = year;
  }

  /** 
   * Constructor de una fecha con el nombre del mes.
   * @param dia Entero para representar los dias de la fecha en el mes.
   * @param year Entero para representar el año de la fecha.
   * @param mes Cadena del nombre del mes.
  */
  public Fecha(int dia, int year, String mes){
    this.dia = dia;
    this.year = year;
    this.mes = mesNombre(mes);
  }

  // b
  /** Asigna un nuevo valor a los dias de la fecha.
   * @param newdia Entero que se asigna como nuevo valor para el dia.
  */
  public void setDia(int newdia){
    dia = newdia;
  }

  /** Asigna un nuevo valor a los meses de la fecha.
   * @param newmes Entero que se asigna como nuevo valor para el mes.
  */
  public void setMes(int newmes){
    mes = newmes;
  }

  /**
   * Asigna un nuevo valor entero para los años de una fecha.
   * @param newyear Entero que se asigna como nuevo valor para el año.
  */
  public void setYear(int newyear){
    year = newyear;
  }

  // c
  /**
   * Devuelve el dia de la fecha.
   * @return dia de la fecha.
  */
  public int getDia(){
    return dia;
  }

  /**
   * Devuelve el mes de la fecha.
   * @return el mes, entre 1 y 12.
  */
  public int getMes(){
    return mes;
  }

  /**
   * Devuelve el año de la fecha.
   * @return año.
  */
  public int getYear(){
    return year;
  }

  // d
  /**
   * Metodo para Calcular la diferencia entre dos fechas.
   * @param fecha2 Recibe un objeto fecha.
   * @return la diferencia en dias entre la fecha y fecha2.
  */
  public int diferencia(Fecha fecha2){
    int diferencia = fechaEnDias() - fecha2.fechaEnDias();
    if (diferencia < 0)
      return -1 * diferencia;
    else
      return diferencia;
  }

  // f
  /**
   * Metodo para determinar si dos fechas son iguales
   * @param fecha2 Recibe un objeto fecha.
   * @return true si las fechas son iguales, false en otro caso.
  */
  public boolean equals(Fecha fecha2){
    if (dia == fecha2.dia && mes == fecha2.mes && year == fecha2.year)
      return true;
    else
      return false;
  }

  /**
   * Metodo para convertir cualquier fecha en dias.
   * Incluidos los años bisiestos.
   * @return la fecha convertida en dias.
  */
  public int fechaEnDias(){
    int diasTotales = 0;
    int y = year - 1;
    int bisiestos = y/4 - y/100 + y/400;
    diasTotales += diasPasados();
    diasTotales += bisiestos * 366;
    diasTotales += (y - bisiestos) * 365;
    return diasTotales;
  }


  /**
   * Metodo para determinar si un año es bisiesto.
   * @return true si el año es bisiesto, false en otro caso.
  */
  public boolean bisiesto(){
    if (year % 4 == 0){
      if (year % 100 != 0 || year % 400 == 0)
        return true;
      else
        return false;
    }
    else
      return false;
  }

  /**
   * Metodo que obtiene los dias en el mes de la fecha.
   * Si el mes es invalido, imprime "Entero fuera de rango 1-12".
   * @param m representa el mes en enteros.
   * @return los dias en el mes de la fecha.
   * Si el año es bisiesto regresa 29 en febrero.
   * Si el entero no esta en el rango 1-12, regresa -1.
  */
  public int diasMes(int m){
    if (!validarMes(m)){
      System.out.println("Entero fuera de rango 1-12");
      return -1;
    }
    if (m == 2){
      if (bisiesto())
        return 29;
      else
        return 28;
    }
    else if (m <= 7){
      if (m%2 == 1)
        return 31;
      else
        return 30;
    }
    else {
      if (m%2 == 1)
        return 30;
      else
        return 31;
    }
  }

  //e
  /**
   * Metodo que suma o resta dias a la fecha.
   * @param n los dias a agregar o restar a la fecha.
  */
  public void agregarDias(int n){
    int dmes = diasMes(mes);
    if(dmes == -1)
      return;
    dia = dia + n;
    if (dia > 0){
      while (dia > dmes){
        dia = dia - dmes;
        if (mes % 12 == 0){
          year = year + (mes / 12);
          mes = 1;
        }
        else
          mes += 1;
        dmes = diasMes(mes);
      }
    }
    else{
      while (dia <= 0){
        if (mes == 1){
          mes = 12;
          year = year -1;
        }
        else
          mes -= 1;
        dia = diasMes(mes) + dia ;
      }
    }
  }

  // j
  /**
   * Metodo Mostrar la fecha en el formato dd/mes/aaaa.
  */
  public void showDate(){
    System.out.println(dia + "/" + mesNombre(mes) + "/" + year);
  }

  // h
  /**
   * Metodo que obtiene el mes a partir de una cadena.
   * @param m Cadena del nombre del mes.
   * @return el valor del mes en enteros. Si la cadena no esta en el rango, regresa -2.
  */
  public int mesNombre(String m){
    m = m.trim();
    if (m.equals("Enero"))
      return 1;
    else if (m.equals("Febrero"))
      return 2;
    else if (m.equals("Marzo"))
      return 3;
    else if (m.equals("Abril"))
      return 4;
    else if (m.equals("Mayo"))
      return 5;
    else if (m.equals("Junio"))
      return 6;
    else if (m.equals("Julio"))
      return 7;
    else if (m.equals("Agosto"))
      return 8;
    else if (m.equals("Septiembre"))
      return 9;
    else if (m.equals("Octubre"))
      return 10;
    else if (m.equals("Noviembre"))
      return 11;
    else if (m.equals("Diciembre"))
      return 12;
    else{
      System.out.println("Mes invalido");
      return -2;
    }
  }

  // g
  /**
   * Metodo que obtiene el nombre del mes a partir de un entero.
   * @param m Entero del mes.
   * @return la cadena del nombre del mes. Si el entero no esta en el rango 1-12, regresa "Mes invalido".
  */
  public String mesNombre(int m){
    if (m == 1){
      return "Enero";
    }
    else if (m == 2){
      return "Febrero";
    }
    else if (m == 3){
      return "Marzo";
    }
    else if (m == 4){
      return "Abril";
    }
    else if (m == 5){
      return "Mayo";
    }
    else if (m == 6){
      return "Junio";
    }
    else if (m == 7){
      return "Julio";
    }
    else if (m == 8){
      return "Agosto";
    }
    else if (m == 9){
      return "Septiembre";
    }
    else if (m == 10){
      return "Octubre";
    }
    else if (m == 11){
      return "Noviembre";
    }
    else if (m == 12){
      return "Diciembre";
    }
    else return "Mes invalido";
  }

  // i
  /**
   * Metodo que calcula los dias que han pasado en el año de la fecha.
   * @return los dias pasados durante el año de la fecha.
  */
  public int diasPasados(){
    int diasCount = 0;
    int i = 1;
    while(i < mes){
      diasCount += diasMes(i);
      i++;
    }
    diasCount += dia;
    return diasCount;
  }

  /**
   * Metodo que evalua si un mes es valido, es decir, esta en el rango del 1 al 12.
   * @param m Entero mes
   * @return true si el mes es valido esta en el rango 1 a 12, en otro caso false.
   */
  public boolean validarMes(int m){
    if (m <= 0 || m > 12){
      return false;
    }
    else
      return true;
  }

  // TODO validar fecha

  public static void main(String[] args){
  }
}
