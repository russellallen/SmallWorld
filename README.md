# SmallWorld

## What is it? 

SmallWorld 2015 is a version of Smalltalk running on the Java virtual machine. 
In particular, it is a continuation of Prof. Tim Budd's SmallWorld, which was a port of his seminal Little Smalltalk to the JVM. 
I am not currently working on SmallWorld. 

## What is it not? 

It isn't a version of Smalltalk-80, nor is it compatible with the Smalltalk ANSI standard. Where it is incompatible with a Smalltalk-80 system (such as Squeak) SmallWorld follows its Little Smalltalk heritage - for example in the area of cascades (;) and the current lack of Symbols (eg #Something). 

## Who wrote it? 

It is a modified version of the original SmallWorld, which was written by A Prof. Tim Budd and can be found [here](http://web.engr.oregonstate.edu/~budd/SmallWorld/ReadMe.html). 
Many thanks must go to Tim, whose work with SmallWorld and before that his pioneering Little Smalltalk form by far the major part of this system, and who was kind enough to allow the release of SmallWorld under the MIT Licence. 

## How fast is it? 

Very very slow :) SmallWorld is a very simple bytecode interpreter running on top of a complicated and sophisticated JIT virtual machine (ie Java). Two levels of indirection from the hardware will introduce slowness. On the other hand, because its development environment is mostly handled by Java's Swing code, SmallWorld is fast enough to be pleasant to play with. 

## What has changed?

### Version 2015.1 (February 2015)

* Code dumped on Github
* Fix to make work on modern Java

### Version 2007.2 (May 2007) 

*  added traditional Workspace 
*  added traditional 3 pane Class Browser 
*  added False to Class>>classes 
*  renamed 'Magnatude' to 'Magnitude' 
*  changed image saving to gracefully handle SmallJavaObjects (references replaced by nil) 
*  the image format now has a version number (as I realised it was likely to change again in the future) 
*  created Transcript as new starting point for image 
*  removed Image and Color classes (they'll be returned later) 
*  imported Squeak tinyBenchmark methods for fun 

### Version 2007.1 (January 2007) 

*  moved the image file into the jar file, so SmallWorld is now a single jar file 
*  moved the initial window from SmallWorld.java file into the image and cleaned up some code 
*  changed from using java object serialisation to custom image serialisation code 
*  moved code into package com.russell_allen.smallworld so new code does not conflict with old edition 
*  split sourcecode into separate files for each class 
*  created #doesNotUnderstand: mechanism 

### Original Edition 

Written by Tim Budd November 2004,  MIT Licence, Version 0.9 November 2004,  Version 0.8 November 2002
