/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kalender;


class sepedah{
    String merk;
    int jumlahroda;
    String warna;

    sepedah(String a, int b, String c){
        merk = a;
        jumlahroda = b;
        warna = c;
        System.out.println("Sepedah Merk = " +merk+ " Jumlah Roda = " +jumlahroda+ " berwarna = " +warna);
    
    }
}
 
public class Latihan {
     
    public static void main(String[] args)throws Exception {
        sepedah sepedah1 = new sepedah("Poligon",2,"putih");
        sepedah sepedah2 = new sepedah("BMX",2,"Merah");
        motor1 motor2 = new motor1 ("Honda", 2, "Merah");
    }
}
