package node;

import java.util.HashMap;
import java.util.Map;

public class TestIt{
    private  int id;
    private  String node;
    private  int pid;
  static  Map<Integer, String> print = new HashMap<>();

  TestIt(int id,String node,int pid){
      this.id = id;
      this.node = node;
      this.pid = pid;
  }

   TestIt(){

  }

    public String adding(int id,String node,int pid){

         print.put(id, (id +" "+node+" "+ pid));

        return print.toString();
    }



    public static void main(String[] args) {


        TestIt io = new TestIt();

        io.adding(4,"nodeA",0);
        io.adding(8,"nodeB",4);
        io.adding(5,"nodeC",4);
        io.adding(7,"nodeD",53);
        io.adding(10,"nodeC",56);

                System.out.println(print);


                for (int i=0;i<print.size(); i++){

                    System.out.println(print.keySet().iterator().next());
                }






//        System.out.println(io.print);
    }

}