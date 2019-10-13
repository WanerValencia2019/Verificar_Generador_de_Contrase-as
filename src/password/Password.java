package password;

import java.util.Random;

public class Password {
    private String contrase�a;


    public void setcontrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
    }

    public boolean esFuerte(String contrase�a){
        byte mayusculas=0,minusculas=0,numeros=0;
        for (int i = 0; i <contrase�a.length() ; i++) {
            if(contrase�a.charAt(i)>=65 && contrase�a.charAt(i)<=90){
                mayusculas++;
            }
            if(contrase�a.charAt(i)>=97 && contrase�a.charAt(i)<=122){
                minusculas++;
            }
            if(contrase�a.charAt(i)>=48 && contrase�a.charAt(i)<=57){
                numeros++;
            }
        }
        if(mayusculas>=2 && minusculas>=1 && numeros>=5){
            return true;
        }else{
            return false;
        }
    }
    public String verificaLongitud(String contrase�a){
        String estado="";
        if(contrase�a.length()>8){
            return estado="contrase�a muy segura";
        }
        //NUNCA VA A TOMAR ESTA CONDICION EN EL MAIN
        else{
            if(contrase�a.length()>=5 && contrase�a.length()<=8){
                return estado=" contrase�a segura";
             }else{
                return estado="contrase�a totalmente insegura";
            }
        }
    }

    public String generarPassword(int longitud){
        char[] caracteres={'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i','#','j','k','l','m','n','n','o','p','q','r','s','t',
                'u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','n','O','P','Q','R','$','@','S','T','U','V','W','X','Y','Z'};
        String contrase�a="";
        Random numero=new Random();
        for (int i = 0; i < longitud ; i++) {
            int indiceAleatorio=(int)numero.nextInt(65);
            contrase�a+=caracteres[indiceAleatorio];
            if(contrase�a.length()==longitud){
                break;
            }
        }


        return contrase�a;
    }


}
