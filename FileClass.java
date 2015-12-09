/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itstep.android11.baidala;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileClass extends File {
    private String filePathname;
    private boolean isEnabled;
    
    FileClass() {
        super(Definitions.FILE_DEFAULT_NAME);
        if(this.exists()) {
            try {
                this.createNewFile();
                System.out.println("File created.");
            } catch (IOException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        filePathname = Definitions.FILE_DEFAULT_NAME;
        
    }
    
    FileClass(String pathname) {
        super(pathname);
        if(!this.exists()) {
            try {
                this.createNewFile();
                System.out.println("File created.");
            } catch (IOException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        filePathname = pathname;
    }
    
    FileClass(String pathname, String login, String password) {
        super(pathname);
        isEnabled = isPermition(login, password);
        if(!this.exists()) {
            try {
                this.createNewFile();
                System.out.println("File created.");
            } catch (IOException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File not created.");
        }
        filePathname = pathname;
        
    }
    
    void readFile (String from, int type) {
        FileOutputStream outStream = null;
        
        try {
            outStream = new FileOutputStream(filePathname);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch (type) {
            case Definitions.READ_CONSOLE_CASE:
                    System.out.println("Read console");
            {
                try {
                    outStream.write(readFromConsole().getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
            case Definitions.READ_FILE_CASE:
            		readFromFile(from);
             		System.out.println("File readed.");
            		break;
            case Definitions.COPY_FILE_CASE:
                 	copyFile(from, filePathname);
                    System.out.println("File copyed.");
                    break;
            case Definitions.READ_HTTP_CASE:
        {
            try {
                outStream.write(getHTTP(from).getBytes());
            } catch (IOException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    System.out.println("Read HTTP");
                    break;
            default: 
                System.out.println("Invalid type");
        }
        
        
        
    }
    
    private String readFromConsole() {
        BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string:");
        String res = "";
        try {
            res = brInput.readLine();
            //res = sc.nextLine();
        } catch (IOException ex) {
            
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    
    
    void readFromFile(String source) {
    	FileInputStream in = null;
    	BufferedWriter out = null;
    	//OutputStream outstr = new OutputStream(System.out); 
    	//BufferedWriter out = new BufferedWriter(new OutputStreamWriter());
    	
    	try {
			in = new FileInputStream(source);
			out = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int temp;
            while ( (temp = in.read()) != -1 ) {
                out.write(temp);
            }

            out.write("This will be printed on stdout!\n");
            out.flush();
            
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
    	
    	
    }
    
    static public void copyFile(String from, String to ) {
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            in = new FileInputStream(from);
            out = new FileOutputStream(to);
                    
            int temp;
            while ((temp = in.read()) != -1) {
                out.write(temp);
            }
            in.close();
            out.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public static String getHTTP(String urlStr) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            
            while( (line = br.readLine()) != null ){
                result.append(line);
            }
            br.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return result.toString();
    }

    private boolean isPermition(String login, String password) {
        String usersData = getHTTP("http://cityfinder.esy.es/getuser.php");
        System.out.println(usersData);
        
        HashMap<String, String> hmap = new HashMap<>();
        String[] usersArray = usersData.split(";");
        String[] arrayUser = null;
        for (int i = 0; i < usersArray.length; i++) {
            arrayUser = usersArray[i].split("-");
            hmap.put(arrayUser[0], arrayUser[2]);
        }
        if(!hmap.get(login).equals(password))  {
            return false;
        } else {
                return true;
                }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

