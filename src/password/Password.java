package password;

import java.util.Random;

public class Password {
    private String contraseña;


    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean esFuerte(String contraseña){
        byte mayusculas=0,minusculas=0,numeros=0;
        for (int i = 0; i <contraseña.length() ; i++) {
            if(contraseña.charAt(i)>=65 && contraseña.charAt(i)<=90){
                mayusculas++;
            }
            if(contraseña.charAt(i)>=97 && contraseña.charAt(i)<=122){
                minusculas++;
            }
            if(contraseña.charAt(i)>=48 && contraseña.charAt(i)<=57){
                numeros++;
            }
        }
        if(mayusculas>=2 && minusculas>=1 && numeros>=5){
            return true;
        }else{
            return false;
        }
    }
    public String verificaLongitud(String contraseña){
        String estado="";
        if(contraseña.length()>8){
            return estado="contraseña muy segura";
        }
        //NUNCA VA A TOMAR ESTA CONDICION EN EL MAIN
        else{
            if(contraseña.length()>=5 && contraseña.length()<=8){
                return estado=" contraseña segura";
             }else{
                return estado="contraseña totalmente insegura";
            }
        }
    }

    public String generarPassword(int longitud){
        char[] caracteres={'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i','#','j','k','l','m','n','n','o','p','q','r','s','t',
                'u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','n','O','P','Q','R','$','@','S','T','U','V','W','X','Y','Z'};
        String contraseña="";
        Random numero=new Random();
        for (int i = 0; i < longitud ; i++) {
            int indiceAleatorio=(int)numero.nextInt(65);
            contraseña+=caracteres[indiceAleatorio];
            if(contraseña.length()==longitud){
                break;
            }
        }


        return contraseña;
    }


}
