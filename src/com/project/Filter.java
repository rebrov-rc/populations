package com.project;

public interface Filter {

    static boolean flt(Person x) {
        boolean result = false;
        int age = x.getAge();
        if (x.getSex().equals(Sex.WOMAN) && (age >= 18 && age < 60)) {
            result = true;
        } else if (x.getSex().equals(Sex.MAN) && (age >= 18 && age < 65)) {
            result = true;
        }
        return (result);
    }
}
