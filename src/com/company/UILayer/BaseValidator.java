package com.company.UILayer;

import com.company.ModelLayer.SockData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brainacad4 on 03.05.2018.
 */
public class BaseValidator {

    public static boolean validateSockField(String fieldName, String value) throws NoSuchFieldException
    {
        String validationType =
                SockData.class.getField(fieldName)
                        .getType().getSimpleName();
        return validateField(validationType,value);

    }

    public static boolean validateField(String fieldType, String value)
    {
        String validationMask ="";
        switch (fieldType)
        {
            case "int":
                validationMask = "\\d+";
                break;
            case "String":
                validationMask = "\\S+";
                break;
        }

        Pattern validationPattern =
                Pattern.compile(validationMask);
        Matcher matcher = validationPattern.matcher(value);
        return matcher.matches();
    }

}
