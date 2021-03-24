package org.skyrocket.mouse;

import java.util.ArrayList;
import java.util.List;

public class Input {

    static List<Interactable> interactables = new ArrayList<>();

    static double x;
    static double y;

    static boolean shouldUpdate = false;

    public static void update(){
        if(shouldUpdate){
            for(Interactable i:interactables){
                i.inputUpdate(x, y);
            }
            shouldUpdate = false;
        }
    }

    public static void add(Interactable i){
        interactables.add(i);
    }

    public static void setpos(double x, double y){
        Input.x =x;
        Input.y =y;
        shouldUpdate = true;
    }


}
