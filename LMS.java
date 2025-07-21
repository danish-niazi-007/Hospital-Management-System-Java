import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

interface report{
    void report_g();

}
abstract class User{
    protected String name;
    protected int age;
    protected int id;
    User(String name,int age,int id){
        this.name=name;
        this.age=age;
        this.id=id;
    }
     abstract void diplay_detail();
}
class Vistor extends User implements report{
    private String interested_book;
Vistor(String name,int age,int id,String interested_book){
        super(name, age, id);
        this.interested_book=interested_book;}
    String getInterested_book(){
        return interested_book;
    }

    @Override
    void diplay_detail() {
        System.out.println("[Vistor]:: "+name+" [ID]:: "+id+" Interested In"+interested_book);
    }

    @Override
    public void report_g() {
        System.out.println("The Report is Generating for ::\n");
        diplay_detail();

    }
}
class Book{
     String title;
    String author;
     int bid;

    Queue<Vistor> queue=new ArrayDeque<>();
    Book(String title,String author,int bid){
        this.author=author;
        this.title=title;
        this.bid=bid;

    }
    void display_detail(){
        System.out.println(" Book ID::"+bid+" Book Name:: "+title+" Author Name:: "+author);
    }

}




public class LMS {
    public static void main( String[] args){
List<Book> books=new ArrayList<>();
List<Vistor> vistors=new ArrayList<>();
Scanner sc=new Scanner(System.in);

while(true){
        System.out.println("1. Add a book");
        System.out.println("2. Add a vistor");
        System.out.println("3. Add Borrow Request ");
        System.out.println("4. Serve a Request ");
        System.out.println("5. View All Book");
        System.out.println("6. View All Vistor");
        System.out.println("7. Save And Exit");
        int choice =sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
            {
                System.out.println("Enter Book Id ::");
                int bd= sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Book Name ::");
                String bname=sc.nextLine();
                System.out.println("Enter book Author ::");
                String author=sc.nextLine();
                books.add(new Book(bname,author,bd));
                System.out.println("__Book Added Successfully__");
                break;
            }
            case 2:
            {
                System.out.println("Enter Vistor Name :");
                String name=sc.nextLine();
                System.out.println("Enter age ::");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter id ::");
                int id= sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Interested Book::");
                String interest=sc.nextLine();
                vistors.add(new Vistor(name,age,id,interest));
                System.out.println("__Vistor Added Succesfully__");
                break;
            }
            case 3:
            {
                System.out.println(" Enter your Id ::");
                int bid=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter  A book name ::");
                String bbn=sc.nextLine();
                Vistor br=null;
                for(Vistor v:vistors){
                    if (v.id==bid){
                        br=v;
                        break;
                    }
                }
                  if(br==null){
                      System.out.println("User not found");}
                      for(Book b:books){
                          if(b.title.equalsIgnoreCase(bbn)){

                              b.queue.add(br);
                              System.out.println("Added Request:::");
                              break;
                      }
                      }
                      break;
                  }
                  case 4:{
                      for(Book b: books){

                          if (!b.queue.isEmpty()){

                              Vistor v=b.queue.poll();
                              System.out.println("Vistor ID ::"+v.id+" Book Title is ::"+b.title);
                      break;}
                      }
break;}
            case 5:{
                System.out.println("__ Book List __");
                for(Book b:books){
                    b.display_detail();


                }
                break;
            }
            case 6:{


                System.out.println("__ Vistor List __");
                for(Vistor v:vistors){

                    v.diplay_detail();
                }
                break;
            }
            default:
                System.out.println("Invalid Choice");



        }





        }}

    }


