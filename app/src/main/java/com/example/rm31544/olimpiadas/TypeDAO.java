package com.example.rm31544.olimpiadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rm31544 on 17/10/2016.
 */
public class TypeDAO {
    public static List<Type> listAll() {
        List<Type> list = new ArrayList<Type>();
        list.add(new Type(1,"Natação"));
        list.add(new Type(1,"Corrida"));
        list.add(new Type(1,"Atletismo"));
        return list;
    }
}
