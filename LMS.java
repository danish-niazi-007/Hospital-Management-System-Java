import java.io.*;
import java.util.*;
interface Report{
    void display_rep();
}
abstract class user {
    protected int age;
    protected String name;

    user(int age, String name) {
        this.age = age;
        this.name = name;

    }

    abstract void display_detail();


}
class Vistors extends user implements Report{

    protected int id;
    Vistors(int age,String name, int id){
        super(age, name);
        this.id=id;
    }

    @Override
    void display_detail() {
        System.out.println("|ID ::"+id+"| |Name ::"+name+"| |Age ::"+age+"|");
    }

    @Override
    public void display_rep() {
        System.out.println("The Report is Generating For......");

        display_detail();
    }
}
class Book{
    Queue<Vistors> queue=new ArrayDeque<>();
    protected  int b_id ;
    protected  String author;
    protected String b_n;
    Book(int b_id,String b_n,String author){
        this.b_id=b_id;
        this.b_n=b_n;
        this.author=author;
    }
    void display_detail(){
        System.out.println("ID ::"+b_id+" Book Name ::"+b_n+" Auhtor ::"+author);
    }
}
// Half Program Ended
public class LMS {
    public static void main( String[] args){
        Scanner scanner=new Scanner(System.in);
        List<Vistors> vistors=new ArrayList<>();
        List<Book> books= new ArrayList<>();

        boolean exit=false;
        while(!exit){
            System.out.println("1. Add a book");
            System.out.println("2. Add a Vistor");
            System.out.println("3. Add a Request");
            System.out.println("4. Serve a Request");
            System.out.println("5. Exit");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                {System.out.println("Enter a Book Name");
                    String bookname=scanner.nextLine();
                    System.out.println("Enter Book ID");
                    int bookid=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter a Author a Name");
                    String authorname=scanner.nextLine();
                    Book b=new Book(bookid,bookname,authorname);
                    books.add(b);
                    break;}
                case 2:
                {
                    System.out.println("Enter The Name of the Vistor");
                    String name=scanner.nextLine();
                    System.out.println("Enter Id of the Vistor");
                    int id =scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Age of the Vistor");
                    int age =scanner.nextInt();
                    scanner.nextLine();
                    Vistors vistors1=new Vistors(age,name,id);
                    vistors.add(vistors1);
                    break;


                }
                case 3:{
                    System.out.println("Enter your ID Please.......");
                    int id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(" Checking your Authorization....");
                    Vistors cv=null;
                    for(Vistors v: vistors){
                        if(v.id==id){
                            cv=v;
                            System.out.println("Thanks For Patience");
                            break;
                        }
                    }
                    if(cv==null){
                        System.out.println("You are Unauthorized....");
                        System.out.println("PLease Register First");
                    }
                    System.out.println("Enter Book ID...");
                    int id1=scanner.nextInt();
                    scanner.nextLine();
                    Book b1=null;
                    for(Book b:books){
                        if(b.b_id==id1){
                            b.queue.add(cv);
                            b1=b;
                            break;

                        }
                    }
                    if(b1==null){
                        System.out.println("Book Not Found...");
                    }
                    else{
                        System.out.println("Book Added Successfully");
                    }
                    break;

                }
                case 4:{
                    Book selectedbook=null;
                    System.out.println("Serving a Request.....");
                    for(Book b:books){
                        System.out.println("Book ID ::"+b.b_id+" Book Name "+b.b_n+" Author Name "+b.author+" Requests["+b.queue.size()+"]");

                    }
                    System.out.println("Enter Book ID you want to serve....");
                    int id2=scanner.nextInt();
                    scanner.nextLine();
                    for(Book b:books){
                        if(b.b_id==id2){
                            selectedbook=b;

                            break;
                        }
                    }
                    if (selectedbook==null){
                        System.out.println("Book Not Found...");
                    }
                    else if(selectedbook.queue.isEmpty()){
                        System.out.println("Book Request is Empty");
                    }
                    else{
                        Vistors v=selectedbook.queue.poll();
                        System.out.println("Request is Served");
                        System.out.println("Vistor ID "+v.id+" Vistor Name "+v.name+" Book name "+selectedbook.b_n+" Book ID "+selectedbook.b_id);
                    }
                    break;
                }







                case 5:{
                    exit=true;
                    System.out.println("Thanks...");
                    break;
                }
                default:
                    System.out.println("Invalid Choice....");






            }















        }








    }





}
