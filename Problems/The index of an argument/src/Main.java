import java.util.Arrays;

class Problem {
    public static void main(String[] args) {
        int k = -1;
       for (int i = 0; i < args.length; i++){
           if (args[i].equals("test")){
               k = i;
               break;
           }
           
       }
        System.out.println(k);



    }
}