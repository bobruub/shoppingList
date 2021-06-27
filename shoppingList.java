import java.io.*;  
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class shoppingList {
  
  public shoppingList(){
  }
  
  public static void main(String[] args) {
    
    // open data file
    File file = new File("C:\\Users\\Tim\\Dropbox\\java\\shoppingList\\shoppingList.csv"); 
    try {
      FileInputStream fis=new FileInputStream(file);
    } catch(Exception e){    
      e.printStackTrace();  
    }
    
    // get a date for tagging output file
    Date now = new Date();
    Calendar c = Calendar.getInstance(); 
    c.setTime(now); 
    Date currDateTime = c.getTime();  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String currdate = sdf.format(currDateTime);

    // open output file
    FileWriter myWriter = null;
    try {
      File myObj = new File("C:\\Users\\Tim\\Dropbox\\java\\shoppingList\\" + currdate + "_list.csv");
      myWriter = new FileWriter("C:\\Users\\Tim\\Dropbox\\java\\shoppingList\\" + currdate + "_list.csv");
    } catch(Exception e){    
      e.printStackTrace();  
    }
    
    try {
      BufferedReader br=new BufferedReader(new FileReader(file));  
      String line = null;
      String splitLine = null;
      line=br.readLine();
      String[] itemsArray = null;
      while(line != null){  
        itemsArray = line.split(",");
        int lineVolume = Integer.parseInt(itemsArray[1]); 
        // if volume of item is greater than 0 write to file.
        if (lineVolume > 0){
          myWriter.write(" [  ] - " + itemsArray[1] + " - " + itemsArray[0] +  "\n");
          System.out.println("\t\t " + itemsArray[0]);
        }
        line=br.readLine();
      }
    } catch(Exception e){    
      e.printStackTrace();  
    }
    try{
      myWriter.close();
    } catch(Exception e){    
      e.printStackTrace();  
    }
    
  }
  
}