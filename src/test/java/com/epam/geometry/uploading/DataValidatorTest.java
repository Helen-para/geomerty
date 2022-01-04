package com.epam.geometry.uploading;

import com.epam.geometry.uploading.DataValidator;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.validation.Validator;

public class DataValidatorTest {

    private final static DataValidator validator = new DataValidator();

    @Test
    public void testIsValidLineWhenSpecifiedFormatString() {
        //given
        String line = "(1.1  ; 2.1 ) ( -1.1 ;  -2.1 )  ( 1.1;-2.1     )";

        //when
        boolean result = validator.isValidLine(line);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsValidLineWhenNotSpecifiedFormatString() {
        //given
        String line = "(1.1;2.1) ( -1.1 ;  -2.1 )";

        //when
        boolean result = validator.isValidLine(line);

        //then
        Assert.assertFalse(result);
    }
}
