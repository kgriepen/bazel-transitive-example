package samepackage;

import differentpackage.*;

public class Entry {
    public static void main(String[] args) {
        Entry e = new Entry();
        System.exit(e.execute());
    }

    public int execute() {
        AmbiguousClass a = new AmbiguousClass();
        a.setName( "MyName" );
        return 0;
    }
}
