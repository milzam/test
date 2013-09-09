/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milzam.hoiio;

import com.hoiio.sdk.HoiioService;
import com.hoiio.sdk.exception.HoiioException;
import com.hoiio.sdk.services.SMSService;
import java.util.Map;

/**
 *
 * @author Milzam
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HoiioService hoiio = new HoiioService("Jx7wMle4AUBW9JAi", "3GypndjBxKSJWExW");

        try {

            // Get sms history
            Map<String, Object> getData = SMSService.getRate("Jx7wMle4AUBW9JAi", "3GypndjBxKSJWExW", "+6593905831", "Hello World!");

            for (String tKey : getData.keySet()) {
                System.out.println(tKey + " : " + getData.get(tKey).toString());
            }
            Map<String, Object> sendData = SMSService.send("Jx7wMle4AUBW9JAi", "3GypndjBxKSJWExW", "+6593905831", null, "Hello World!", null, null);
            
            for (String tKey : sendData.keySet()) {
                System.out.println(tKey + " : " + sendData.get(tKey).toString());
            }

        } catch (HoiioException e) {
            // This is thrown when the request doesn't return success_ok
            System.out.println(e.getMessage());
        }
    }
}
