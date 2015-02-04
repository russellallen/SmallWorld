package com.russell_allen.smallworld;

class SmallObject {
    public SmallObject objClass;
    public SmallObject [ ] data;
    public int id; // used to speed up image save, usually null

    public SmallObject() { objClass = null; data = null; }
    
    public SmallObject(SmallObject cl, int size) {
        objClass = cl; data = new SmallObject [size]; }
    
    public SmallObject copy(SmallObject cl) { return this; }
    
    public SmallObject duplicate() {
        SmallObject d = new SmallObject();
        d.objClass = objClass;
        d.data = data;
        return d;
    }
    
}

class SmallInt extends SmallObject {
    public int value;
    
    public SmallInt(SmallObject IntegerClass, int v) {
        super(IntegerClass, 0); value = v; }
    
    public SmallInt() {super();}
    
    public String toString() { return "SmallInt: "+ value; }
    
    public Integer toInteger() { return Integer.valueOf(value); }
}

class SmallByteArray extends SmallObject {
    public byte [ ] values;
    
    public SmallByteArray(SmallObject cl, int size) {
        super(cl, 0); values = new byte[size]; }
    
    public SmallByteArray(SmallObject cl, String text) {
        super(cl, 0);
        values = text.getBytes();
    }
    
    public SmallByteArray() {super();}
    
    public String toString() {
        // we assume its a string, tho not always true...
        return new String(values);
    }
    
    public SmallObject copy(SmallObject cl) {
        SmallByteArray newObj = new SmallByteArray(cl, values.length);
        for (int i = 0; i < values.length; i++) {
            newObj.values[i] = values[i];
        }
        return newObj;
    }
}

class SmallJavaObject extends SmallObject {
    public SmallJavaObject(SmallObject cls, Object v) {
        super(cls, 0); value = v; }
    
    public SmallJavaObject() {super();}
    
    public Object value;
}

class SmallException extends Exception {
    SmallException(String gripe, SmallObject c) {
        super(gripe); context = c;}
    public SmallObject context;
}

class Sema {
    public synchronized SmallObject get() { if (! hasBeenSet) try {
        wait();
    } catch(Exception e) { System.out.println("Sema got exception " + e); }
    return value; }
    public synchronized void set(SmallObject v) {
        value = v; hasBeenSet = true; notifyAll(); }
    private SmallObject value;
    private boolean hasBeenSet = false;
}
