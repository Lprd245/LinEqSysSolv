/**
  *
  * Beschreibung
  * Exportiert statische Methoden zum Einlesen von Tastatureingaben
  * �ber die Standard-Konsole:
  *
  *      String readString()
  *      char readChar()
  *      int readInt()
  *      long readLong()
  *      float readFloat()
  *      double readDouble()
  *
  *    Bei den numerischen Einlese-Methoden
  *         readInt(), readLong(), readFloat(), readDouble()
  *    kann ein 'type mismatch' eintreten, n�mlich genau dann, wenn die
  *    Tastatureingabe nicht dem R�ckgabetyp der Methode entspricht.
  *    In diesem Fall geben die numerischen Methoden eine Fehlermeldung in
  *    der Standard-Konsole aus und ihr R�ckgabewert ist eine spezielle
  *    Konstante ihres R�ckgabetyps:
  *         ----------------------------------------------------------
  *         Methode:                R�ckgabewert by 'type mismatch':
  *         ---------------------------------------------------------
  *         readInt()               Integer.MIN_VALUE
  *         readLong()              Long.MIN_VALUE
  *         readFloat()             Float.NaN
  *         readDouble()            Double.NaN
  *         ----------------------------------------------------------
  *
  *    Die numerischen Einlese-Methoden werden auch mit einem boolean-Parameter
  *    RepeatByTypeMisMatch �berladen bereitgestellt:
  *
  *      int readInt(boolean RepeatByTypeMisMatch)
  *      long readLong(boolean RepeatByTypeMisMatch)
  *      float readFloat(boolean RepeatByTypeMisMatch)
  *      double readDouble(boolean RepeatByTypeMisMatch)
  *
  *    Der boolean-Parameter RepeatByTypeMisMatch gibt an, ob die Eingabe bei
  *    'type mismatch' wiederholt werden darf. Falls er also true ist, so
  *    fordert die Methode nach der Ausgabe der Fehlermeldung die Eingabe noch
  *    einmal. Das wiederholt sich, bis die Eingabe dem R�ckgabetyp entspricht.
  *
  *    Tastatureingaben m�ssen mit der <Enter>-Taste abgeschlossen werden. Da-
  *    nach wird in der Standard-Konsole also auch immer eine Zeilenschaltung
  *    vorgenommen.
  * 
  * Zus�tzlich werden auch statische Methoden zur Ausgabe von Text in der  
  * Standard-Konsole exportiert:
  *       write(String s)
  *       writeln(String s)
  *       writeln()       
  * 
  * @version 1.0 vom 12.08.2013
  * @author: Yves G�rtner
  */

import java.util.*;
import java.io.*;


public class Kon {
  final static String Praefix1Str=">> ";
  final static String ErrDescr1="type mismatch";
  
  /* -- Hilfsmethode: Gibt eine Fehlermeldung in der Standard-Konsole aus */
  private static void ErrMsg1(String Obsvt, boolean RepeatByTypeMisMatch) {
    if (RepeatByTypeMisMatch) {
      System.out.print(Praefix1Str+ErrDescr1+": "+Obsvt+" Neue Eingabe: ");
    } else {
      System.out.println(Praefix1Str+ErrDescr1+": "+Obsvt);
    }
  }
  
  
  public static void write(String s) {
    System.out.print(s);
  }
  
  public static void writeln(String s) {
    System.out.println(s);
  }
  
  public static void writeln() {
    System.out.println();
  }
  
  /* EXPORTIERTE EINLESE-METHODEN */
  
  public static String readString() {
    String ret="";
    Scanner sc = new Scanner(System.in);   //.useDelimiter("\\n")
    ret = sc.nextLine();
    // sc.close(); sc nicht schliessen, da auch System.in geschlossen wird!
    return ret;
  }
  
  public static int readInt(boolean RepeatByTypeMisMatch) {
    int ret=Integer.MIN_VALUE;
    String defStr="";
    boolean ok;
    Scanner sc = new Scanner(System.in);
    do {                       // Schleife zur Wiederholung der Eingabe
      ok=false;                // bei InputMismatchException, falls der
      try {                    // Parameter RepeatByTypeMisMatch true ist.
        ret = sc.nextInt();
        ok=true;
      } catch (InputMismatchException e) {
        defStr= sc.next(); // ungelesene Eingabe sicher einlesen
        ErrMsg1("Keine ganze Zahl!",RepeatByTypeMisMatch);
        ok=!RepeatByTypeMisMatch;
      }
    } while (!ok);
    // sc.close(); sc nicht schliessen, da auch System.in geschlossen wird!
    return ret;
  }
  
  public static int readInt() {
    return readInt(false);
  }
  
  public static long readLong(boolean RepeatByTypeMisMatch) {
    long ret=Long.MIN_VALUE;
    String defStr="";
    boolean ok;
    Scanner sc = new Scanner(System.in);
    do {                       // Schleife zur Wiederholung der Eingabe
      ok=false;                // bei InputMismatchException, falls der
      try {                    // Parameter RepeatByTypeMisMatch true ist.
        ret = sc.nextLong();
        ok=true;
      } catch (InputMismatchException e) {
        defStr= sc.next(); // ungelesene Eingabe sicher einlesen
        ErrMsg1("Keine ganze Zahl!",RepeatByTypeMisMatch);
        ok=!RepeatByTypeMisMatch;
      }
    } while (!ok);
    // sc.close(); sc nicht schliessen, da auch System.in geschlossen wird!
    return ret;
  }
  
  public static long readLong() {
    return readLong(false);
  }
  
  public static float readFloat(boolean RepeatByTypeMisMatch) {
    float ret=Float.NaN;
    String defStr="";
    boolean ok;
    Scanner sc = new Scanner(System.in);
    do {                       // Schleife zur Wiederholung der Eingabe
      ok=false;                // bei InputMismatchException, falls der
      try {                    // Parameter RepeatByTypeMisMatch true ist.
        ret = sc.nextFloat();
        ok=true;
      } catch (InputMismatchException e) {
        defStr= sc.next(); // ungelesene Eingabe sicher einlesen
        ErrMsg1("Keine Fliesskommazahl!",RepeatByTypeMisMatch);
        ok=!RepeatByTypeMisMatch;
      }
    } while (!ok);
    // sc.close(); sc nicht schliessen, da auch System.in geschlossen wird!
    return ret;
  }
  
  public static float readFloat() {
    return readFloat(false);
  }
  
  public static double readDouble(boolean RepeatByTypeMisMatch) {
    double ret=Double.NaN;
    String defStr="";
    boolean ok;
    Scanner sc = new Scanner(System.in);
    do {                       // Schleife zur Wiederholung der Eingabe
      ok=false;                // bei InputMismatchException, falls der
      try {                    // Parameter RepeatByTypeMisMatch true ist.
        ret = sc.nextDouble();
        ok=true;
      } catch (InputMismatchException e) {
        defStr= sc.next(); // ungelesene Eingabe sicher einlesen
        ErrMsg1("Keine Fliesskommazahl!",RepeatByTypeMisMatch);
        ok=!RepeatByTypeMisMatch;
      }
    } while (!ok);
    // sc.close(); sc nicht schliessen, da auch System.in geschlossen wird!
    return ret;
  }
  
  public static double readDouble() {
    return readDouble(false);
  }
  
  // Wird mehr als ein Zeichen eingegeben, so wird nur das erste ber�cksichtigt.
  public static char readChar() {
    char ret=' ';
    int c=0;
    try {
      InputStreamReader in = new InputStreamReader(System.in);
      c =in.read();
      ret = (char) c;
    } catch (IOException e) {
      System.out.println("IOException: "+e.toString());
    }
    return ret;
  }
  
}
