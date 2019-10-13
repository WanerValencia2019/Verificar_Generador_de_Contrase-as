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
                System.out.println("<----------------------><- VERIFICADOR Y GENERADOR DE CONTRASEÑAS SEGURAS -><---------------->");
                System.out.println("!------MENÚ----!");
                System.out.println("1. Verificar Contraseña");
                System.out.println("2. Generar Contraseña Segura");
                System.out.println("3. Salir");
                System.out.print("Opción-->");
                opc = write.nextByte();

                switch (opc) {
                    case 1:
                        String contraseña = "";
                        write.nextLine();
                        System.out.println("Digite la contraseña: ");
                        contraseña = write.nextLine();
                        if (pass.esFuerte(contraseña)) {
                            System.out.println(pass.verificaLongitud(contraseña));
                        } else {
                            System.out.println("Contraseña Insegura");
                        }
                        break;
                    case 2:
                        int longitud = 0;

                        System.out.println("Cual será la longitud de la contraseña(minimo 8): ");
                        longitud = write.nextInt();

                        String generada = pass.generarPassword(longitud);
                        if (longitud >= 8) {
                            do {
                                if (pass.esFuerte(generada)) {
                                    System.out.println("Contraseña Generada: " + generada);
                                } else {
                                    generada = pass.generarPassword(longitud);
                                    if (pass.esFuerte(generada)) {
                                        System.out.println("Contraseña Generada: " + generada);
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
