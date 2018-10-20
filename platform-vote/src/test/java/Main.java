
import java.util.Arrays;
import java.util.Scanner;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/9<br>
 * 描述: <br>
 */
public class Main {

    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int target=in.nextInt();
        in=new Scanner(System.in);
        int[] data=new int[num];
        for(int i=0;i<num;i++){
            data[i]=in.nextInt();
        }
        Arrays.sort(data);
        int sum=0;
        for(int i=0;i<num;i++){
            sum+=data[i];
            if(sum>=target){

                break;
            }
        }
        System.out.println(sum);

    }

}
