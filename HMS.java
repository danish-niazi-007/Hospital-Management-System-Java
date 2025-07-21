import java.io.*;
import java.util.*;
interface report{
    void generate_r();}
abstract class User{
    protected String name;
    protected  int age;
    User(String name,int age){
        this.age=age;
        this.name=name;

    }
    abstract String display_d();
}
class Patient1 extends User implements report{
    private String type;
    private static int id=0;
    Patient1(String name,int age,String type){
        super(name,age);
        this.type=type;
      this.id=++id;
    }
    public String get_t(){
        return type;
    }
    public int get_id(){
        return id;
    }

    @Override
    String display_d() {
        StringBuilder sb=new StringBuilder();
        sb.append("ID:: ").append(id).append(" Name:: ").append(name).append("Type of Patient").append(type);
        return sb.toString();
    }

    @Override
    public void generate_r() {
        System.out.println("The report is Generating for the Patient::\n "+name+"__ Type:: "+type);
    }
   public String  tofileS(){
        StringBuilder sb=new StringBuilder();
        sb.append("Name::").append(name).append(" ID :: ").append(id).append(" Age :: ").append(age).append(" ||").append(type).append("||");
        return sb.toString();


   }
}
class HileHandler {
    public static void write1(String filename1,List<Patient1> p)throws IOException{
        FileWriter fw=new FileWriter(filename1);
        for(Patient1 pat: p){

            fw.write(pat.tofileS()+'\n');
        }
        fw.close();
    }


}

public class HMS {
    public static void main( String[] args){
        Scanner sc=new Scanner(System.in);
        String fn="Hospital_Data.txt";
        Deque<Patient1> queue=new ArrayDeque<>();
        List<Patient1> all_pt=new ArrayList<>();
        boolean b=true;
        while(b){
            System.out.println("____Hospital Management System____");
            System.out.println("1. Add an Emergency Patient");
            System.out.println("2. Add an Normal Patient");
            System.out.println("3. Serve next Patient ");
            System.out.println("4. View All Patient ");
            System.out.println("5. Exit/Save");
            System.out.println("Choice::");
            int choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                {
                    System.out.println("Enter the Name of The Patient::");
                    String name=sc.nextLine();

                    System.out.println("Enter the Age of The Patient::");
                    int age=sc.nextInt();
                    Patient1 emergenncy=new Patient1(name,age,"Emergency");
                    queue.addFirst(emergenncy);
                    all_pt.add(emergenncy);
                    System.out.println("Patient Added Sucessfully");
break;


                }
                case 2:
                {

                    System.out.println("Enter the Name of The Patient::");
                    String name=sc.nextLine();

                    System.out.println("Enter the Age of The Patient::");
                    int age=sc.nextInt();
                    Patient1 normal=new Patient1(name,age,"normal");
                    queue.addFirst(normal);
                    all_pt.add(normal);
                    System.out.println("Patient Added Sucessfully");
                    break;

                }
                case 3:{
                    if(!queue.isEmpty()){
                        Patient1 serve=queue.poll();
                        System.out.println("___ Serving Patient ___");
                        serve.display_d();
                        serve.generate_r();

                    }
                    else {
                        System.out.println("Not Any Patient to Serve");
                    }
                    break;
                }
                case 4:{

                    System.out.println("___ Waiting List of the Patient ___");
                    for(Patient1 p:queue){
                        p.display_d();
                        p.generate_r();
                    }
                    break;
                }
                case 5:
                {
                    try{
                        HileHandler.write1(fn,all_pt);
                        System.out.println("....Data is Stored in File....");

                    }catch (IOException e){
                        System.out.println("Error::"+e.getMessage());
                    }
                    b=false;

                    break;


                }
                default:
                    System.out.println("Invalid Choice");






            }






        }


    }
}
