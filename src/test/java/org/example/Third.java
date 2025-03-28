package org.example;

import org.testng.annotations.Test;

public class Third {
@Test
    public void m1(){
        int[] a={1,2,5,3,7,8,12};
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
            if(a[i]<a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            }
        }
        for(int no:a){
            System.out.println(no);
        }
    }
}
