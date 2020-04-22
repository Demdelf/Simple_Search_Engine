/* Please, do not rename it */
class Problem {

    public static void main(String args[]) {
        String operator = args[0];
        // write your code here
        switch (operator){
            case "MAX":{
                int result = Integer.MIN_VALUE;
                for (int i = 1; i < args.length; i++){
                    int q = Integer.parseInt(args[i]);
                    if ( q > result) result = q;
                }
                System.out.println(result);
                break;
            }
            case "MIN":{
                int result = Integer.MAX_VALUE;
                for (int i = 1; i < args.length; i++){
                    int q = Integer.parseInt(args[i]);
                    if ( q < result) result = q;
                }
                System.out.println(result);
                break;
            }
            case "SUM":{
                int result = 0;
                for (int i = 1; i < args.length; i++){
                    int q = Integer.parseInt(args[i]);
                    result += q;
                }
                System.out.println(result);
                break;
            }

        }
    }
}