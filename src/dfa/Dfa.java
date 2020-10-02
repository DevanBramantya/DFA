/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa;

import java.util.Scanner;

/**
 *
 * @author User
 */
class L1{
    public L1(String input){
        Dfa obj=new Dfa();
        int[][] table_transisi={{0,1},//delta(q0,0)=q0 dan delta(q0,1)=q1
                                {2,1},//delta(q1,0)=q2 dan delta(q1,1)=q1
                                {0,3},//delta(q2,0)=q0 dan delta(q2,1)=q3
                                {3,3}};//delta(q3,0)=q3 dan delta(q3,1)=q3
        int finalstate=3;
        int hasil=obj.deltatopi(0,input,table_transisi);//panggil method deltatopi
        if(hasil==finalstate){
            System.out.println("Inputan Valid");
        }else{
            System.out.println("Inputan Tidak Valid");
        }
    }
}
class L2{
    public L2(String input){
        Dfa obj=new Dfa();
        int[][] table_transisi={{4,1},//delta(q0,0)=q4 dan delta(q0,1)=q1
                                {2,4},//delta(q1,0)=q2 dan delta(q1,1)=q4
                                {4,3},//delta(q2,0)=q4 dan delta(q2,1)=q3
                                {3,3},//delta(q3,0)=q3 dan delta(q3,1)=q3
                                {4,4}};//delta(q4,0)=q4 dan delta(q4,1)=q4
        int finalstate=3;
        int hasil=obj.deltatopi(0,input,table_transisi);//panggil method deltatopi
        if(hasil==finalstate){
            System.out.println("Inputan Valid");
        }else{
            System.out.println("Inputan Tidak Valid");
        }
    }
}
class L3{
    public L3(String input){
        Dfa obj=new Dfa();
        int[][] table_transisi={{0,1},//delta(q0,0)=q0 dan delta(q0,1)=q1
                                {2,1},//delta(q1,0)=q2 dan delta(q1,1)=q1
                                {0,3},//delta(q2,0)=q0 dan delta(q2,1)=q3
                                {2,1}};//delta(q3,0)=q2 dan delta(q3,1)=q1
        int finalstate=3;
        int hasil=obj.deltatopi(0,input,table_transisi);//panggil method deltatopi
        if(hasil==finalstate){
            System.out.println("Inputan Valid");
        }else{
            System.out.println("Inputan Tidak Valid");
        }
    }
}
class L4{
    public L4(String input){
        Dfa obj=new Dfa();
        int[][] table_transisi={{1,0},//delta(q0,0)=q1 dan delta(q0,1)=q0
                                {0,1}};//delta(q1,0)=q0 dan delta(q1,1)=q1
        int finalstate=0;
        int hasil=obj.deltatopi(0,input,table_transisi);//panggil method deltatopi
        if(hasil==finalstate){
            System.out.println("Inputan Valid");
        }else{
            System.out.println("Inputan Tidak Valid");
        }
    }
}
class L5{
    public L5(String input){
        Dfa obj=new Dfa();
        int[][] table_transisi={{0,1},//delta(q0,0)=q0 dan delta(q0,1)=q1
                                {1,0}};//delta(q1,0)=q1 dan delta(q1,1)=q0
        int finalstate=1;
        int hasil=obj.deltatopi(0,input,table_transisi);//panggil method deltatopi
        if(hasil==finalstate){
            System.out.println("Inputan Valid");
        }else{
            System.out.println("Inputan Tidak Valid");
        }
    }
}
public class Dfa {
    String[] simbol={"0","1"};//simbol2 yang bisa diterima
    int deltatopi(int state,String input,int[][] arr){
        int length=input.length();
        String stringawal=input.substring(0,length-1);//string dari awal sampai length-1
        String stringakhir=input.substring(length-1,length);//string angka terakhir
        if(length>1){//kalau panjang stringnya masih lebih dari 1
                     //panggil lagi deltatopi untuk dipecah lagi stringnya
            state=deltatopi(state,stringawal,arr);
        }
        int hasil=delta(state,stringakhir,arr);
        return hasil;
    }
    int search(String[] arr, String value){//cari apakah string ada di array simbol
        for (int i=0;i<arr.length;i++) {
            if (arr[i].equals(value)) {
                return i;//kalau ada return indeksnya
            }
        }
        return -1;//kalau tidak return -1
    }
    int delta(int state,String input,int[][] arr){
        int kolom=search(simbol,input);//cari stringnya di array simbol
        if(kolom!=-1){//kalau ada
            return arr[state][kolom];//return hasil deltanya
        }
        return -1;//kalau tidak return -1
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.print("Input String : ");
        String input=scan.nextLine();
        System.out.println("1. Semua String yang mengandung substring 101");
        System.out.println("2. Semua String yang mengandung prefiks 101");
        System.out.println("3. Semua String yang mengandung sufiks 101");
        System.out.println("4. Semua String yang mengandung jumlah simbol 0 genap");
        System.out.println("5. Semua String yang mengandung jumlah simbol 1 ganjil");
        System.out.print("Pilihan : ");
        int pil=scan.nextInt();
        switch(pil){
            case 1:
                L1 l1=new L1(input);
                break;
            case 2:
                L2 l2=new L2(input);
                break;
            case 3:
                L3 l3=new L3(input);
                break;
            case 4:
                L4 l4=new L4(input);
                break;
            case 5:
                L5 l5=new L5(input);
                break;
        }
    }
}
