/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WDC.helper;

import javax.swing.JOptionPane;

/**
 *
 * @author ARMIGER1
 * @version 1.0
 */
public class Converter {
    
    // Class constants
    
    /**
     * A relative unit of measurement based off of pixels.
     */
    public static final int UNIT_EM = 0;
    
    /**
     * A relative unit of measurement based off the base font size in pixels.
     */
    public static final int UNIT_PERCENT = 1;
    
    /**
     * A regular expression that matches a float or double.
     */
    public static final String REGEX_DECIMAL = "[0-9]*?\\.?[0-9]*?";
    
    /**
     * A regular expression that matches an integer.
     */
    public static final String REGEX_INT = "[0-9]*?";
    
    // Methods
    
    /**
     * Converts a user-specified length to another unit of measurement.
     * @param baseSize double The base size in pixels
     * @param desiredSize double The desired size in pixels
     * @param type int The unit of measurement to convert to
     * @return 
     */
    public double convert_size(double baseSize, double desiredSize, int type) {
        double result = 0;
        
        switch (type) {
            //case this.UNIT_EM:
            case UNIT_EM:
                result = desiredSize / baseSize;
                break;
            case UNIT_PERCENT:
                result = (desiredSize / baseSize) * 100;
                break;
        }
        
        return result;
    }
}
