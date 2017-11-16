package com.eprogrammerz.examples.general.toString;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Model {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(newLine);
        result.append("Object {");
        result.append(newLine);

        Field[] fields = this.getClass().getDeclaredFields();

        AccessibleObject.setAccessible(fields, true);

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                result.append("    ");
                try {
                    result.append(field.getName());
                    result.append(": ");
                    result.append(field.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                result.append(newLine);
            }
        }

        result.append("}");

        return result.toString();
    }
}
