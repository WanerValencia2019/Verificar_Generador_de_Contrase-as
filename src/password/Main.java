package password;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);
        Password pass;
        byte opc=0;
        pass = new Password();
        try {


            while (opc != 3) {
                System.out.println("<----------------------><- VERIFICADOR Y GENERADOR DE CONTRASE�AS SEGURAS -><---------------->");
                System.out.println("!------MEN�----!");
                System.out.println("1. Verificar Contrase�a");
                System.out.println("2. Generar Contrase�a Segura");
                System.out.println("3. Salir");
                System.out.print("Opci�n-->");
                opc = write.nextByte();

                switch (opc) {
                    case 1:
                        String contrase�a = "";
                        write.nextLine();
                        System.out.println("Digite la contrase�a: ");
                        contrase�a = write.nextLine();
                        if (pass.esFuerte(contrase�a)) {
                            System.out.println(pass.verificaLongitud(contrase�a));
                        } else {
                            System.out.println("Contrase�a Insegura");
                        }
                        break;
                    case 2:
                        int longitud = 0;

                        System.out.println("Cual ser� la longitud de la contrase�a(minimo 8): ");
                        longitud = write.nextInt();

                        String generada = pass.generarPassword(longitud);
                        if (longitud >= 8) {
                            do {
                                if (pass.esFuerte(generada)) {
                                    System.out.println("Contrase�a Generada: " + generada);
                                } else {
                                    generada = pass.generarPassword(longitud);
                                    if (pass.esFuerte(generada)) {
                                        System.out.println("Contrase�a Generada: " + generada);
                                    }
                                }
                            } while (!pass.esFuerte(generada));
                        }
                        break;
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }



    }
}
