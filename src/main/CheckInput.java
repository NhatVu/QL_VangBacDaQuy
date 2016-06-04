/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Minh Nhat
 */
public class CheckInput {
    public static boolean isDouble(String a){
        try{
            Double.parseDouble(a);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    public static boolean isCharacter(String a){
        return a.matches("\\D");
    }
}
