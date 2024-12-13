import Collection.LinkedList;
import Custom.BigInt;

import java.util.Scanner;

public class test {
    public static Scanner sc=new Scanner(System.in);
    static void nhapday (LinkedList<Integer> a){
        int x;
        System.out.println("Nhap day: ");
        do {
            x = sc.nextInt();
            if (x>0)
                a.addLast(x);
        }while (x>0);
    }
    public static void inDay(LinkedList<Integer> linkedList){
        linkedList.startFirst();
        while (!linkedList.endList()){
            System.out.printf("%4d", linkedList.get());
            linkedList.next();
        }
        System.out.println();
    }
    public static LinkedList<Integer> sapXep(LinkedList<Integer> linkedList){
        LinkedList<Integer> temp = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            linkedList.startFirst();
            int data = linkedList.get();
            if (temp.isEmpty()) {
                temp.addFirst(data);
            } else {
                temp.searchOrderList(data);
                temp.addPos(data);
            }
            linkedList.removeFirst();
        }
        return temp;
    }
    public static String add(String a,String b){
        BigInt numA=new BigInt(a);
        BigInt numB=new BigInt(b);
        return numA.add(numB).toString();
    }
    public static String multiply(String a,String b){
        BigInt numA=new BigInt(a);
        BigInt numB=new BigInt(b);
        return numA.multiply(numB).toString();
    }
    public static String gt(String num){
        BigInt res=new BigInt(1);
        BigInt i=new BigInt(1);
        while (!i.toString().equals(num)){
            res=res.multiply(i);
            i=i.add(1);

        }
        return res.toString();
    }
    public static BigInt luyThua(BigInt x,int n){
        BigInt lt = new BigInt(1);
        for(int i = 1; i<=n;i++){
        lt = lt.multiply(x);
        }
        return lt;
    }
    public static BigInt luyThuaW(BigInt x, int n){
        BigInt lt = new BigInt(1);
        BigInt l =x.multiplyWithOneNumber(1);
        while(n>0){
            if(n%2==1) lt = lt.multiply(l);
            l = luyThua(l, 2);
            n = n/2;
        }
        return lt;
    }


    public static void main(String[] args) {
        int choice=0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        do{
            System.out.println("1. nhap ");
            System.out.println("2. xuat");
            System.out.println("3. sap xep");
            System.out.println("4. Cộng 2 số lớn");
            System.out.println("5. Nhân 1 số lớn và 1 số ");
            System.out.println("6. gia thua cua 1 so: ");
            System.out.println("7. Luy Thua: ");

            choice = sc.nextInt();
            switch (choice){
                case 1->nhapday(linkedList);
                case 2->inDay(linkedList);
                case 3->linkedList=sapXep(linkedList);
                case 4-> {
                    System.out.println("Nhap so a: ");
                    String a = sc.next();
                    System.out.println("nhap so b: ");
                    String b=sc.next();
                    System.out.println("Ket qua: " + add(a,b));
                }
                case 5-> {
                    System.out.println("Nhap so a: ");
                    String a = sc.next();
                    System.out.println("nhap so b: ");
                    String b=sc.next();
                    System.out.println("Ket qua: " + multiply(a,b));
                }
                case 6->{
                    System.out.printf("nhap 1 so: ");
                    var a=sc.next();
                    System.out.println(gt(a));
                }
                case 7->{
                    System.out.printf("nhap a: ");
                    var a=sc.next();
                    System.out.printf("nhap n: ");
                    int n=sc.nextInt();
                    System.out.println("Ket qua: " + luyThuaW(new BigInt(a), n));
                }
            }
        }while (choice!=0);
    }
}
