package com.student;
class strb
{

    static public void main(String...string)
    {
         StringBuilder s1 = new StringBuilder("Test");
         StringBuilder s2 = new StringBuilder("Test");

         System.out.println(s1); // output: Test
         System.out.println(s2); // Test
         System.out.println(s1==s2); // false
         System.out.println(s1.equals(s2)); //Line 1 output: false
         System.out.println(s1.toString()==s2.toString()); //Line 2 output: false
    }
}