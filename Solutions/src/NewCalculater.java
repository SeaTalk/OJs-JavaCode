import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewCalculater {

    static String nums[][] = 
    {   { " - ", "   ", " - ", " - ", "   ", " - ", " - ", " - ", " - ", " - " },
        { "| |", "|  ", "  |", "  |", "| |", "|  ", "|  ", "  |", "| |", "| |" },
        { "   ", "   ", " - ", " - ", " - ", " - ", " - ", "   ", " - ", " - " },
        { "| |", "|  ", "|  ", "  |", "  |", "  |", "| |", "  |", "| |", "  |" },
        { " - ", "   ", " - ", " - ", "   ", " - ", " - ", "   ", " - ", " - " } };

    public static ArrayList<Integer> getPrims(int n){
        if(n<2)return null;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=2;i<=n;i++){
            while (n!=i){
                if(n%i==0) {
                    n = n / i;
                    al.add(i);
                }
                else break;;
            }
        }
        al.add(n);
        return al;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()) {
            n = sc.nextInt();
            List<Integer> list = getPrims(n);
            if(list==null)continue;
            for(int i=0;i<5;i++){
                int j=0;
                for(int a : list){
                    if(j!=0){
                        if(i==2)System.out.print("*");
                        else System.out.print(" ");
                    }
                    ++j;
                    String prim = a+"";
                    for(int k = 0; k<prim.length();++k){
                        System.out.print(nums[i][prim.charAt(k)-'0']);
                    }
                }
                System.out.println();
            }
        }
        
    }
}