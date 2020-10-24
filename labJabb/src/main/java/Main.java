import DAO.daoCategoryG;
import DAO.daoGoods;
import Model.CategoryG;
import Model.Goods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        daoGoods daog = new daoGoods();
        daoCategoryG daoc=new daoCategoryG();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Create good");
        System.out.println("2 - Read good");
        System.out.println("3 - Update good");
        System.out.println("4 - Delete good");
        System.out.println("5 - Create cat");
        System.out.println("6 - Read cat");
        System.out.println("7 - Update cat");
        System.out.println("8 - Delete cat");
        System.out.println("9 - Exit");
        boolean k = true;
        while(k){
            System.out.println("Write down a command");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.print("set cat: ");
                    int cat = scanner.nextInt();
                    System.out.print("set man: ");
                    String man = scanner.next();
                    System.out.print("set Price: ");
                    float pri = scanner.nextFloat();
                    daog.add(new Goods(man,cat,pri));
                    break;
                case 2:
                    System.out.println("Input id");
                    int id = scanner.nextInt();
                    Goods g = daog.getOneById(id);
                    System.out.print("man : ");
                    System.out.println(g.getCategory());
                    System.out.print("cat : ");
                    System.out.println(g.getPrice());
                    System.out.print("Price: ");
                    System.out.println(g.getManufactor());
                    break;
                case 3:
                    System.out.println("Input id");
                    int idd = scanner.nextInt();
                    System.out.println("new man");
                    String updcat = scanner.next();
                    System.out.println("new cat ");
                    int updmn = scanner.nextInt();
                    System.out.println("new price: ");
                    float updpr = scanner.nextFloat();
                    daog.update(idd,new Goods(updcat, updmn, updpr));
                    break;
                case 4:
                    System.out.println("Input id");
                    int delId = scanner.nextInt();
                    daog.delete(delId);
                    break;
                case 5:
                    System.out.print("Set country ");
                    String nameS = scanner.next();
                    System.out.print("set Name ");
                    String addr = scanner.next();
                    daoc.add(new CategoryG(addr, nameS));
                    break;

                case 6:
                    System.out.println("Input id");
                    int idCat = scanner.nextInt();
                    CategoryG c = daoc.getOneById(idCat);
                    System.out.print("Country: ");
                    System.out.println(c.getCountry());
                    System.out.print("Name: ");
                    System.out.println(c.getName());
                    break;
                case 7:
                    System.out.println("Input id");
                    int idS = scanner.nextInt();
                    System.out.println("upd country: ");
                    String updCountry = scanner.next();
                    System.out.println("upd name ");
                    String updName = scanner.next();
                    daoc.update(idS,new CategoryG(updCountry, updName));
                    break;
                case 8:
                    System.out.println("Input id");
                    int deleteId = scanner.nextInt();
                    daoc.delete(deleteId);
                    break;
                case 9:
                    k = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
