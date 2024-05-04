
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

class passwordGenerator{

    static <string> void LongP(int input, int input_length, int MAX, char[] char_arr1, int[] int_arr , int n1, String res , char[] char_arr2 ){
        try {
            if(input == 1  ){
                for(int i = 0; i<n1 ; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 2 ){
                for(int i = 0; i<n1 ; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 3 ){
                for(int i = 0; i<n1; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<n1 ; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 4 ){
                for(int i = 0; i<n1; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<n1 ; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<2 ; i++){
                    res = res + char_arr2[(int) (Math.random() *100 % MAX)];          
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Enter valid input");
            
        }

        System.out.println("Password generated : " + res);

        try {
            KeyGenerator keygenerator
                = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
 
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            byte[] text
                = res.getBytes("UTF8");
 
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);
 
            String s = new String(textEncrypted);
            System.out.println("Encrypted Password: " + s);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted
                = desCipher.doFinal(textEncrypted);

            s = new String(textDecrypted);
            System.out.println("Decrypted Password" + s);
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        
    } 


    static <string> void ShortP(int input, int input_length, int MAX, char[] char_arr1,int[] int_arr , int n2, String res, char[] char_arr2 ){
        try {
            if(input == 1 ){
                for(int i = 0; i<=n2 ; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 2 ){
                for(int i = 0; i<=n2 ; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 3 ){
                for(int i = 0; i<=n2 ; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<=n2; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
            }
    
            else if(input == 4 ){
                for(int i = 0; i<n2; i++){
                    res = res + int_arr[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<n2 ; i++){
                    res = res + char_arr1[(int) (Math.random() *100 % MAX)];
                }
                for(int i = 0; i<2 ; i++){
                    res = res + char_arr2[(int) (Math.random() *100 % MAX)];          
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Enter valid input");
            
        }

        System.out.println("Password generated : " + res);

        try {
            KeyGenerator keygenerator
                = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
 
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            byte[] text
                = res.getBytes("UTF8");
 
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);
 
            String s = new String(textEncrypted);
            System.out.println("Encrypted Password: " + s);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted
                = desCipher.doFinal(textEncrypted);

            s = new String(textDecrypted);
            System.out.println("Decrypted Password" + s);
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
    }
     

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] char_arr1 = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] int_arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        char[] char_arr2 = new char[]{' ','.',',','(',')','?','!','-'};

        int n1 = 3;
        int n2 = 2;
        
        int MAX = 6;
        String res = " ";
        
        System.out.println("Welcome to password Generator App");

        System.out.println("What kind of password you want ? \n1.Numeric \n2.alphabetical \n3.Mixed \n4.Strong");
        int input = sc.nextInt();
        if(input > 4){
            System.out.println("Choose a password type from the following options: numeric, alphabetical, mixed or strong.");
            System.exit(0);
        }
        

        System.out.println("Choose Password length :\n1.Long \n2.Short ");
        int input_length = sc.nextInt();

        if(input_length == 1){
            LongP(input, input_length, MAX, char_arr1, int_arr,n1, res,char_arr2);
        }
        else if(input_length == 2){
            ShortP(input, input_length, MAX, char_arr1, int_arr, n2,res,char_arr2);
        }
        else{
            System.out.println("Select either option 1 or option 2.");
        }   
    }
}