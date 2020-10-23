package FactoryDesignPattern;

public class FactoryImplementation {
    OS getInstance(String str) {

        if (str.equals("famous")) {
            return new Android();
        } else if (str.equals("secure")) {
            return new IOS();
        } else if (str.equals("neutral")) {
            return new Windows();
        }
        return null;
    }
}
