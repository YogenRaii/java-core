package com.eprogrammerz.examples.general.toString;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User extends Model {
    private String firstName;
    private String lastName;
    private long id;
    private static Integer count;
}
