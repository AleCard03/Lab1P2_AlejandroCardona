
package lab1p2_alejandrocardona;

import java.util.Scanner;


public class Lab1P2_AlejandroCardona {
    
    static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        while ( continuar ){
            
            System.out.println("""
                               ---Menu---
                               1. Ejercicio 1
                               2. Ejercicio 2
                               3. Salir""");
            
            String opcion = read.nextLine();
            
            if(Character.isDigit(opcion.charAt(0))){
                char z= opcion.charAt(0);
                String y = Character.toString(z);
                int option = Integer.parseInt(y);
                
                switch (option){
                
                case 1 : {
                    double a;
                    
                    do{
                        System.out.println("Ingrese un valor \"a\" diferente a 0");
                        a  = read.nextDouble();
                    }while(a == 0);
                    
                    System.out.println("Ingrese un valor\"b\"");
                    Double b = read.nextDouble();
                    
                    System.out.println("Ingrese un valor \"c\"");
                    Double c = read.nextDouble();
                    
                    double vertx = -b/(2*a);
                    double verty = a*Math.pow(vertx,2 )+b*vertx+c;
                    
                    double dx = 2*a*(vertx)+b;
                    
                    double raiz1 = calculos(a,b,c,vertx-200, dx , 100);
                    double raiz2 = calculos(a,b,c,vertx+200,dx,100);
                    System.out.println(raiz1);
                    System.out.println(raiz2);
                    
                }//fin case 1
                read.nextLine();
                break;
                
                case 2 : {
                    
                    System.out.println("Ingrese un limite");
                    int n = read.nextInt();
                    System.out.println("Ingrese \"x\"");
                    double x = read.nextDouble();
                    double acum = 0;
                    System.out.println(sin(n,x,acum));
                    System.out.println(cos(n,x,acum));
                    System.out.println(tan(n,x,acum));
                    read.nextLine();
                    
                }//fin case 2
                break;
                
                case 3 : {
                    
                    continuar = false;
                    
                }//fin case 3
                
                }//fin switch opcion
                
            }//fin if
            else{
                System.out.println("No ingreso una entrada valida");
            }
            
            
        }//fin while ocntinuar
    }//fin while main
    
    static double calculos ( double a, double b, double c, double vertx, double dx , int lim){
        
        if(lim > 0){
            vertx -= (a*Math.pow(vertx,2 )+b*vertx+c)/(2*a*(vertx)+b);
            return calculos(a,b,c,vertx,dx,lim-1);
        }
        else{
            return vertx;
        }
        
    }
    
    static double sin (int n , double x , double acum){
        
        if(n > -1){
            acum+=(Math.pow(-1, n)/factorial(2*n+1))*Math.pow(x,2*n+1);
            return (sin(n-1,x,acum));
        }
        else{
            return  acum;
        }
                
        
    }
    
    static double cos (int n , double x , double acum){
        
        if(n > -1){
            acum+=(Math.pow(-1, n)/factorial(2*n))*Math.pow(x,2*n);
            return cos(n-1, x, acum);
        }
        else{
            return acum;
        }
        
    }
    
    static double tan ( int n , double x , double acum){
        
        if(cos(n,x,acum)!= 0){
            if(n > 0){
                acum+=(Math.pow(2,n)*Math.pow(-4,n))/factorial(2*n);
                return acum;
            }
            else{
                return acum;
            }
        }
        else{
            System.out.println("El valor ingresado no es valido");
        }
        
        return acum;
    }
    
    static int factorial ( int a ){
        
        if (a == 0){
            return 1;
        }
        if (a > 0){
            return a*=factorial(a-1);
        }
        
        else{
            return a;
        }
    }
    
}
