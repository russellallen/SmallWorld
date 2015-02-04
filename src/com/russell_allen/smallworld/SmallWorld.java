package com.russell_allen.smallworld;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 * I am the entry point for the SmallWorld system.  
 * 
 * All I do is to set up the SmallInterpreter, tell it 
 * to load the image from the jar file and then to find 
 * an entry point to start an initial doIt of 
 * "SmallWorld startUp".
 */

public class SmallWorld {
    static public void main(String [] args) {
        world = new SmallWorld(args);
    }
    
    private static SmallWorld world;
    private SmallInterpreter theInterpreter = new SmallInterpreter();
    
    public SmallWorld(String [ ] args) {
        boolean done = false;
        
        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream("image");
            theInterpreter = new SmallInterpreter();
            done = theInterpreter.loadImageFromInputStream(input);
            input.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(new JFrame("X"), "Exception: " + e.toString());}
        
        
        if (done) {
            doIt("SmallWorld startUp");
        }
    }
      
    private void doIt(String task) {
        // start from the basics
        SmallObject TrueClass = theInterpreter.trueObject.objClass;
        SmallObject name = TrueClass.data[0]; // a known string
        SmallObject StringClass = name.objClass;
        // now look for the method
        SmallObject methods = StringClass.data[2];
        SmallObject doItMeth = null;
        for (int i = 0; i < methods.data.length; i++) {
            SmallObject aMethod = methods.data[i];
            if ("doIt".equals(aMethod.data[0].toString()))
                doItMeth = aMethod;
        }
        if (doItMeth == null)
            System.out.println("can't find do it!!");
        else {
            SmallByteArray rec = new SmallByteArray(StringClass, task);
            SmallObject args = new SmallObject(theInterpreter.ArrayClass, 1);
            args.data[0] = rec;
            SmallObject ctx = theInterpreter.buildContext(theInterpreter.nilObject, args, doItMeth);
            try {
                theInterpreter.execute(ctx, null, null);
            } catch(Exception ex) {
                System.out.println("caught exeception " + ex);
            }
        }
        
    }
}
