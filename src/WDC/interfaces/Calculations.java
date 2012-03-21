/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WDC.interfaces;

/**
 *
 * @author nick
 */
public interface Calculations {
    
    // Constants
    static final int UNIT_EM = 0;
    static final int UNIT_PERCENT = 1;
    static final String REGEX = "[0-9]*?\\.?[0-9]*?";
    
    // Methods
    double px_to_em (double baseSize, double desiredSize);
    double px_to_percent (double baseSize, double desiredSize);
}
