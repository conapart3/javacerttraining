package cat;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

abstract class Cat {
    //abstract void clean(); // compiles 1 - abstract class defines abstract method
    /*void clean()
    {
        System.out.println("abstract method implementation");
    }*/ // compiles 2 - Lion overrides this

    //void clean(String str){} // compiles 3? actually number 3 is just leaving the class blank!!

    //an abstract class IS NOT REQUIRED to have any methods! It doesn't even have to have abstract method!
    // I think a functional interface is what is required to have at least OR AT MOST (- not sure) one method

    //also: the method could throw an exception
    /*void clean() throws Exception {
//        throw new RuntimeException(); // this compiles, don't need to declare throws
        throw new Exception("adwad");
    }*/

    //if the method in Lion throws Exception:
    // in teh concrete class you can't throw an exception if the abstract class doesn't!
    // but you can throw a more restricted exception if the abstract one throws an exception
    /*void clean()
    {

    }*/ // does not compile with throws Exception on the method in Lion

    void clean() throws IOException{}

    void cleanMeImpl(){}

    static final int cleaned = 2;
}

