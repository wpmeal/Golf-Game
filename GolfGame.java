/*
 * GolfGame 
 * Created by Omar Mahrous
 * 01/07/2017
 */
package golfgame;

import java.util.Scanner;

/**
 *
 * @author omar
 */
public class GolfGame {

    /**
     * @param args the command line arguments
     */
    static float swingAngelDegree;
    static float swingVelocity;
    static double swingDistance;
    static double[] swingsArray = new double[5];
    static int swingsNums;
    static float swingDistanceToCup;
    static boolean SuccessMessage;
    static Scanner captureUsrInput = new Scanner(System.in);
    static double GRAVITY = 9.8;
    static int CUP = 900;
    // static float swingDistanceToCup;

    //static float angelInRadian;
    public static void main(String[] args) {
        System.out.println("Welcome To Golf Game");
        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Please Enter Swing Degree < 90");
                swingAngelDegree = captureUsrInput.nextFloat();
            } while (swingAngelDegree >= 90);
            System.out.println("Please Enter Swing Velocity");
            swingVelocity = captureUsrInput.nextFloat();
            double angelInRadian = convertAngelFrmDegreeToRadian(swingAngelDegree);
            swingDistance = calulateSwingDistance(angelInRadian, swingVelocity);
            swingDistanceToCup = (float) Math.abs(swingDistance - CUP);
            swingsArray[i] = swingDistanceToCup;
            swingsNums = i + 1;
            System.out.println("Swing number: " + swingsNums + " / Remaining Distance to cup: " + swingDistanceToCup);
            if (swingDistanceToCup > CUP) { // swing is too fararway from the cup
                System.out.println("Game Over ! the Swing is too faraway from the cup !");
                break;
            } else if (i == 4 && swingDistanceToCup != 0) { //   maximun swings without hitting the cup reached
                System.out.println("Game Over ! U reached the maximum swings allowed witch is 5!");
            } else if (swingDistanceToCup == 0) { // the swing reached the cup
                SuccessMessage = true;
            }
        }
        if (SuccessMessage) {
            System.out.println("********** Congratulation u win !************");
            System.out.println("Here's a summary of ur swings:");
            for (int i = 0; i < swingsArray.length; i++) {
                System.out.println("Swing Number " + i + "/Distance to Cup: " + swingsArray[i]);
            }
        }
    }

    public static double calulateSwingDistance(double angleInRadians, float velocity) {
        double swingDistance = Math.pow(velocity, 2) / GRAVITY * Math.sin(2 * angleInRadians);
        return swingDistance;
    }

    public static double convertAngelFrmDegreeToRadian(float angel) {
        double angelInRadian = (Math.PI / 180) * angel;
        return angelInRadian;
    }
}
