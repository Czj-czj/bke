import org.junit.Test;

import java.util.Scanner;

public class test {

    public static void main(String args[]){
        int sum=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            String s=Integer.toString(i);
            boolean flag= false;
            for(int j=0;j<s.length();j++){
                char ss=s.charAt(j);
                if(ss=='3'||ss=='4'||ss=='7'){
                    flag=false;
                    break;
                }
                else if(ss=='2'||ss=='5'||ss=='6'||ss=='9')
                    flag=true;
            }
            if(flag)
                sum++;
        }

    }

}
