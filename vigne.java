import java.util.Scanner;
/**
 * Write a description of class vigne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vigne
{
    private String word, key;
    private String finish = "";
    private String[] alphabet = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","_"};
    private String[][] solver = new String[27][27];
    /**
     * Constructor for objects of class vigne
     */
    public vigne(){
    }
    
    public void setUp(){
        int count = -1;
        //sets up 27x27 alphabet matrix
        for(int i =0; i<27; i++){
            count = -1;
            for(int j = i; j<27;j++){
                count++;
                solver[i][count] = alphabet[j];
            }
            count = -1;
            for(int k = (27-i); k<27; k++){
                count++;
                solver[i][k] = alphabet[count];
            }
        }
        for(int row = 0; row<27; row++){
            for(int col = 0; col<27; col++){
                System.out.print(solver[row][col]);
            }
            System.out.println();
        }
        System.out.println("Encrypt or decrypt");
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        if(a.equals("e")){
            encrypt();
        }
        else if(a.equals("d")){
            decrypt();
        }
        
    }
    
    public void encrypt(){
        finish ="";
        System.out.println("Enter word to be encrypted");
        Scanner scan = new Scanner(System.in);
        word = scan.nextLine();
        System.out.println("Enter key to encrypt word with");
        key = scan.nextLine();
        key = key.toUpperCase();
        word = word.toUpperCase();
        System.out.println("encrypting "+word);
        System.out.println("with key "+key);
        int vindex, keyin, kindex;
        keyin = 0;
        kindex = 0;
        vindex = 0;
        for(int i = 0; i<word.length();i++){
            if(keyin>=key.length()) keyin=0;
            for(int k = 0; k<27; k++){
                if(word.substring(i,i+1).equals(alphabet[k])){
                    vindex = k;
                    break;
                }
            }
            for(int j = 0; j<27; j++){
                if(key.substring(keyin,keyin+1).equals(solver[j][0])){
                    kindex = j;
                    keyin++;
                    break;
                }
            }
            System.out.println("hor: "+kindex+" vert: "+vindex);
            finish+=solver[kindex][vindex];
            System.out.println(finish);
        }
        System.out.println("last: "+finish);
    }
    
    public void decrypt(){
        finish = "";
        System.out.println("Enter encrypted word");
        Scanner scan = new Scanner(System.in);
        word = scan.nextLine();
        System.out.println("Enter key");
        key = scan.nextLine();
        word=word.toUpperCase();
        key=key.toUpperCase();
        System.out.println("encrypted word: "+word);
        System.out.println("key "+key);
        int vindex, keyin, kindex;
        keyin = 0;
        kindex = 0;
        vindex = 0;
        for(int i = 0; i<word.length();i++){
            if(keyin>=key.length()) keyin=0;
            for(int j = 0; j<27; j++){
                if(key.substring(keyin,keyin+1).equals(solver[j][0])){
                    kindex = j;
                    keyin++;
                    break;
                }
            }
            for(int k = 0; k<27; k++){
                if(word.substring(i,i+1).equals(solver[kindex][k])){
                    vindex = k;
                    break;
                }
            }
            finish+=alphabet[vindex];
            System.out.println(finish);
            
        }
        System.out.println("last: "+finish);
    }
}
