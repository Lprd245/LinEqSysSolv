/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 04.09.2021
 * @author 
 */

import java.awt.*;
import java.io.*;

public class MatrixUtlt {
  public static final int ERROR_NO=0;
  public static final int ERROR_FILE_EXT=ERROR_NO+1;
  public static final int ERROR_FILE_STARTSTAMPMISSING=ERROR_FILE_EXT+1;
  public static final int ERROR_FILE_ENDSTAMPMISSING=ERROR_FILE_STARTSTAMPMISSING+1;  
  public static final int ERROR_FILE_NOTCREATED=ERROR_FILE_ENDSTAMPMISSING+1;
  public static final int ERROR_FILE_NOTLOADED=ERROR_FILE_NOTCREATED+1;
  public static final int ERROR_FILE_NOTSELECTED=ERROR_FILE_NOTLOADED+1;
  public static final int ERROR_FILE_NOENTRIES=ERROR_FILE_NOTSELECTED+1;
  public static final int ERROR_FILE_NOENTRIESAFTERSTAMP=ERROR_FILE_NOENTRIES+1;
  public static final int ERROR_FILE_2DIMENSIONSMISSING=ERROR_FILE_NOENTRIESAFTERSTAMP+1;
  public static final int ERROR_FILE_NOT_A_DOUBLE=ERROR_FILE_2DIMENSIONSMISSING+1;
  
  protected static final String STAMP="<MATRIX> [first line -> dimensions, rest -> entries per row]"; 
  protected static final String NO_FILENAME="no filename";
  protected static final String FILE_EXT=".data";
  protected static final String SEP=" ";
  
  protected static int error=ERROR_NO;
  protected static String errorAux="";
  protected static String errorToken="";
 
  protected static String actFileName="";
  protected static String actDirectory="";
  
  
  
  public static int getError() {
    return error;
  }
  
  public static String getErrorAux() {
    return errorAux;
  }
  
  public static String getErrorToken() {
    return errorToken;
  }
  
  public static boolean errorOccurred() {
    return error>ERROR_NO;
  }
  
  public static String getActualFileName() {
    return actFileName;
  }
  
  public static String getActualDirectory() {
    return actDirectory;
  }
  
  // - Fehlermeldung
  public static String errorMsg(int e) {
    String ret="Error "+getError()+": ";
    String strh="";
    switch (e) {
      case ERROR_NO : 
        ret=ret+"no error occurred";
        break;
      case ERROR_FILE_EXT :
        ret=ret+"file '"+errorToken+"' has not the extension "+FILE_EXT; 
        break;
      case ERROR_FILE_STARTSTAMPMISSING : 
        ret=ret+"file '"+errorToken+"' starts without the stamp '"+STAMP+"'";
        break;
      case ERROR_FILE_ENDSTAMPMISSING : 
        ret=ret+"file '"+errorToken+"' ends without the stamp '"+STAMP+"'";
        break;
      case ERROR_FILE_NOTCREATED : 
        if (errorToken.length()>0) {
          strh="'"+errorToken+"'";
        } // end of if
        ret=ret+"file "+strh+" has not been created";
        if (errorAux.length()>0) {
          ret=ret+"\n"+errorAux;
        } // end of if
        break;
      case ERROR_FILE_NOTLOADED : 
        if (errorToken.length()>0) {
          strh="'"+errorToken+"'";
        } // end of if
        ret=ret+"file "+strh+" has not been loaded";
        if (errorAux.length()>0) {
          ret=ret+"\n"+errorAux;
        } // end of if
        break;
      case ERROR_FILE_NOTSELECTED : 
        if (errorToken.length()>0) {
          strh="'"+errorToken+"'";
        } // end of if
        ret=ret+"file "+strh+" has not been selected";
        break;
      case ERROR_FILE_NOENTRIES : 
        ret=ret+"file '"+errorToken+"' has no entries";
        break;
      case ERROR_FILE_NOENTRIESAFTERSTAMP : 
        ret=ret+"file '"+errorToken+"' has no entries after stamp";
        break;
      case ERROR_FILE_2DIMENSIONSMISSING : 
        ret=ret+"first entry '"+errorToken+"' in the file after stamp is not 2 integer numbers";
        if (errorAux.length()>0) {
          ret=ret+"\n"+errorAux;
        } // end of if
        break;
      case ERROR_FILE_NOT_A_DOUBLE : 
        ret=ret+"entry '"+errorToken+"' in the file is not a double number";
        if (errorAux.length()>0) {
          ret=ret+"\n"+errorAux;
        } // end of if
        break;
      default: 
        
    } // end of switch
    return ret;
  }
  
  
  private static void saveAs(Matrix matr, String filename, boolean withStamp) {
    error=ERROR_NO;
    errorAux="";
    errorToken="";
    try { 
      BufferedWriter os = new BufferedWriter(new FileWriter(filename));
      if (withStamp) {
        os.write(STAMP);
        os.newLine();
      } // end of if    
      int amtRows=matr.getAmtRows();
      int amtClmns=matr.getAmtClmns();
      String line=""+amtRows+SEP+amtClmns;
      os.write(line);os.newLine(); 
      for (int i=0; i<amtRows; ++i) {
        line="";
        for (int j=0; j<amtClmns; ++j) {
          line=line+matr.elmt[i][j];
          if (j<amtClmns-1) {
            line=line+SEP;
          } // end of if
        } // end of for
        os.write(line);os.newLine();
      } // end of for
      if (withStamp) {
        os.write(STAMP); 
        os.newLine();
      } // end of if   
      os.close();
    } catch(IOException e) {
      // - Fehler: Datei konnte nicht erstellt werden
      error=ERROR_FILE_NOTCREATED;
      errorAux=e.toString();   
      errorToken=filename; 
    }
  }
  
  // - Speichert die Matrix matr. Falls "" f�r actfname1 �bergeben wird, so erscheint
  // - der FileSelection-Dialog, sonst wird matr in eine Datei mit dem in actfname1 
  // - �bergebenen Namen gespeichert.  
  private static void save(Matrix matr, String actfname1, boolean withStamp, boolean isCompletePath) {
    error=ERROR_NO;
    errorAux="";
    errorToken="";
    String fname="";
    int pos=-1;
    actFileName="";
    if (actfname1.equals(NO_FILENAME)) {
      actfname1="";
    } // end of if
    if (actfname1=="") {
      Frame parFrame=new Frame();
      parFrame.setVisible(true);
      parFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().getSize().height/2);
      parFrame.requestFocus();      
      FileDialog fd=new FileDialog(parFrame, "save matrix as", FileDialog.SAVE);
      fd.setVisible(true);   
      fd.setLocation(10,10);      
      if ( !(fd.getDirectory()==null || fd.getDirectory()=="") ) {
        actDirectory=fd.getDirectory();
      } // end of if      
      fname=fd.getFile();
      parFrame.setVisible(false);
      parFrame.dispose();
    } else {
      fname=actfname1;
      if (isCompletePath) {
        if ( !((pos=fname.lastIndexOf(System.getProperty("file.separator","\\")))==-1) ) {
          actDirectory=fname.substring(0,pos);
          fname=fname.substring(pos+1);
        }        
      } // end of if
    } // end of if-else
    if ( !(fname==null || fname=="") ) {
      String erw="";
      if (fname.length()>FILE_EXT.length()) {
        erw=fname.substring(fname.length()-FILE_EXT.length());
      } // end of if
      if ( erw.equals(FILE_EXT) || fname.lastIndexOf('.')==-1 ) {        
        if (fname.lastIndexOf('.')==-1) {
          fname=fname+FILE_EXT;
        }  
        actFileName=fname;          
        saveAs(matr,actDirectory+System.getProperty("file.separator","\\")+fname,withStamp);  //true
      } else {
        // - Fehler: Dateinamen hat die falsche Dateierweiterung
        error=ERROR_FILE_EXT;
        errorAux="";
        errorToken=fname;     
      } // end of if-else
      
    } else {
      // - Fehler: Dateiname leer, Matrix wurde nicht gespeichert
      error=ERROR_FILE_NOTSELECTED;
      errorAux=""; 
      errorToken=actfname1; 
    } // end of if-else
  }
    
  private static Matrix loadFrom(String filename, boolean withStamp) {
    Matrix ret=new Matrix();
    error=ERROR_NO;
    errorAux="";
    errorToken="";
    boolean loadGoOn=true;      
    try { 
      String line=null;
      BufferedReader is = new BufferedReader(new FileReader(filename));
      if (withStamp) {
        if ((line = is.readLine()) != null) {
          if (!(line.equals(STAMP))) { 
            error=ERROR_FILE_STARTSTAMPMISSING;
            errorAux=""; 
            errorToken=filename;          
            loadGoOn=false; 
          } // end of if
        } else {
          error=ERROR_FILE_NOENTRIES;
          errorAux="";
          errorToken=filename;
          loadGoOn=false;
        } // end of if-else
      } // end of if
      if (loadGoOn) {
        String[] part;
        int amtRows=0, amtClmns=0;
        if ((line = is.readLine()) != null) {
          part=line.split(SEP);
          if (part.length==2) {
            try {
              amtRows=Integer.parseInt(part[0]);
              try {
                amtClmns=Integer.parseInt(part[1]);
                ret.init(amtRows,amtClmns);
              } catch(Exception e) {
                // - Fehler: zweiter Eintrag in erster Zeile nach ev. Stamp ist kein int
                error=ERROR_FILE_2DIMENSIONSMISSING;
                errorAux=e.toString();
                errorToken=line;
                loadGoOn=false;
              } // end of try
            } catch(Exception e) {
              // - Fehler: erster Eintrag in erster Zeile nach ev. Stamp ist kein int
              error=ERROR_FILE_2DIMENSIONSMISSING;
              errorAux=e.toString();
              errorToken=line;
              loadGoOn=false;
            } // end of try
          } else {
            // - Fehler: erste Zeile nach ev. Stamp enth�lt nicht genau 2 Eintr�ge
            error=ERROR_FILE_2DIMENSIONSMISSING;
            errorAux="";
            errorToken=line;
            loadGoOn=false;
          } // end of if-else
        } else {
          // - Fehler: keine Eintr�ge nach ev. Stamp
          error=ERROR_FILE_NOENTRIESAFTERSTAMP;
          errorAux="";
          errorToken=filename;
          loadGoOn=false;
        } // end of if-else
        int amt=0;
        double entry=0;
        int i=0;
        while (loadGoOn && i<amtRows && (line = is.readLine()) != null && !line.trim().equals(STAMP) ) { // 
          part=line.split(SEP);
          amt=amtClmns;
          if (part.length<amt) {
            amt=part.length;  
          } // end of if  
          for (int j=0; j<amt; ++j) {
             try {
              entry=Double.parseDouble(part[j]);
              ret.elmt[i][j]=entry;
             } catch(Exception e) {
              // - Fehler: aktueller Eintrag ist kein double  
              error=ERROR_FILE_NOT_A_DOUBLE;
              errorAux=e.toString();
              errorToken=part[j];
              loadGoOn=false; 
             } // end of try
          } // end of for
          ++i;
        } // end of while
      } // end of if
      is.close();
      if (loadGoOn) {
        if (withStamp) {
          if (line == null) { 
            error=ERROR_FILE_ENDSTAMPMISSING;
            errorAux="";  
            errorToken=filename;         
            loadGoOn=false;
          } // end of if-else
        } // end of if
      } // end of if
    } catch(Exception e) {
      // - Fehler: Datei konnte nicht ge�ffnet werden
      error=ERROR_FILE_NOTLOADED;
      errorAux=e.toString();
      errorToken=filename;
      loadGoOn=false; 
    } // end of try
    return ret;
  }
  
  // - L�dt eine Matrix-Datei und gibt die Matrix zur�ck, die mit den in der Datei 
  // - gespeicherten Eintr�gen gef�llt ist. Falls "" f�r actfname1 �bergeben wird, so erscheint
  // - der FileSelection-Dialog, sonst wird die Datei mit dem in actfname1 �bergebenen Namen geladen. 
  private static Matrix load(String actfname1, boolean withStamp, boolean isCompletePath) {
    Matrix ret=new Matrix();
    error=ERROR_NO;
    errorAux="";
    errorToken="";
    String fname="";
    int pos=-1;
    actFileName="";
    if (actfname1=="") {
      Frame parFrame=new Frame();
      parFrame.setVisible(true);
      parFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().getSize().height/2);
      parFrame.requestFocus();      
      FileDialog fd=new FileDialog(parFrame,"load matrix from", FileDialog.LOAD);    
      fd.setVisible(true); 
      if ( !(fd.getDirectory()==null || fd.getDirectory()=="") ) {
        actDirectory=fd.getDirectory();
      } // end of if     
      fname=fd.getFile();
      parFrame.setVisible(false);
      parFrame.dispose();
    } else {
      fname=actfname1;
      if (isCompletePath) {
        if ( !((pos=fname.lastIndexOf(System.getProperty("file.separator","\\")))==-1) ) {
          actDirectory=fname.substring(0,pos);
          fname=fname.substring(pos+1);
        }        
      } // end of if
    } // end of if-else
    if ( !(fname==null || fname=="" || fname.length()<=FILE_EXT.length()) ) {
      String erw=fname.substring(fname.length()-FILE_EXT.length());
      if (erw.equals(FILE_EXT)) {
        actFileName=fname;        
        ret=loadFrom(actDirectory+System.getProperty("file.separator","\\")+actFileName,withStamp);
      } else {
        error=ERROR_FILE_EXT;
        errorAux="";
        errorToken=fname;
      } // end of if-else
    } else {
      // - Fehler: Datei wurde nicht geladen
      error=ERROR_FILE_NOTSELECTED;
      errorAux="";
      errorToken=actfname1;
    } // end of if-else
    return ret;
  }
  
  
  private static void save(Matrix matr, String actfname1, boolean isCompletePath) {
    save(matr,actfname1,true,isCompletePath);
  }
    
  private static Matrix load(String actfname1, boolean isCompletePath) {
    return load(actfname1,true,isCompletePath);
  }  
    
  
  public static void save(Matrix matr) {
    save(matr,"",false);
  }
    
  public static Matrix load() {
    return load("",false);
  }  
      
    
} // end of class MatrixUtlt

