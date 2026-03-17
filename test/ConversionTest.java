import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TDD Test Suite for Unit Conversion Program
 *
 * This file documents the Test-Driven Development process for adding:
 * 1. Miles per hour <-> Kilometers per hour conversions
 * 2. Kelvin <-> Celsius conversions
 */
public class ConversionTest {

    // ========================================
    // USER STORY 1: Convert MPH to KM/H
    // ========================================

    /**
     * TDD CYCLE 1: Basic MPH to KM/H Conversion
     *
     * RED PHASE:
     * - Writing this test first (method doesn't exist yet)
     * - Test will fail because convertMph2Kmh() is not implemented
     * - Expected: 60 mph should convert to 96.56 km/h (with 2 decimal precision)
     *
     * Acceptance Test: Verifies that basic speed conversion works correctly
     */
    @Test
    public void testConvertMph2Kmh() {
        // Arrange
        String mphValue = "60";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertMph2Kmh(mphValue, decimalPrecision);

        // Assert
        assertEquals(96.56f, result, 0.01f);
    }
}
