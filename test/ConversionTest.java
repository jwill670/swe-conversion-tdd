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

    /**
     * TDD CYCLE 2: Zero Input Edge Case
     *
     * RED PHASE:
     * - Testing edge case where input is zero
     * - Should handle gracefully and return 0
     * - Validates that the conversion handles boundary values correctly
     * - 0 mph should convert to 0 km/h
     */
    @Test
    public void testConvertMph2Kmh_ZeroInput() {
        // Arrange
        String mphValue = "0";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertMph2Kmh(mphValue, decimalPrecision);

        // Assert
        assertEquals(0.0f, result, 0.01f);
    }

    /**
     * TDD CYCLE 3: Decimal Precision Variations
     *
     * RED PHASE:
     * - Testing that decimal precision parameter is respected
     * - Same input (60 mph) with different precision settings
     * - Validates proper rounding behavior
     */
    @Test
    public void testConvertMph2Kmh_VariablePrecision() {
        // Test with 0 decimal places
        float result0 = conversion.convertMph2Kmh("60", 0);
        assertEquals(97.0f, result0, 0.5f); // 96.56 rounds to 97

        // Test with 1 decimal place
        float result1 = conversion.convertMph2Kmh("60", 1);
        assertEquals(96.6f, result1, 0.05f); // 96.56 rounds to 96.6

        // Test with 4 decimal places
        float result4 = conversion.convertMph2Kmh("60", 4);
        assertEquals(96.5604f, result4, 0.0001f);
    }

    /**
     * TDD CYCLE 4: Large Value Handling
     *
     * RED PHASE:
     * - Testing conversion with large values
     * - Validates no overflow or precision loss
     */
    @Test
    public void testConvertMph2Kmh_LargeValue() {
        // Arrange
        String mphValue = "1000";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertMph2Kmh(mphValue, decimalPrecision);

        // Assert
        assertEquals(1609.34f, result, 0.01f);
    }

// ========================================
// USER STORY 2: Convert KM/H to MPH
// ========================================

    /**
     * TDD CYCLE 5: Basic KM/H to MPH Conversion
     *
     * RED PHASE:
     * - Writing this test first (method doesn't exist yet)
     * - Test will fail because convertKmh2Mph() is not implemented
     * - Expected: 100 km/h should convert to 62.14 mph (with 2 decimal precision)
     */
    @Test
    public void testConvertKmh2Mph() {
        // Arrange
        String kmhValue = "100";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertKmh2Mph(kmhValue, decimalPrecision);

        // Assert
        assertEquals(62.14f, result, 0.01f);
    }

    /**
     * TDD CYCLE 6: Zero Input Edge Case
     *
     * RED PHASE:
     * - Testing edge case where input is zero
     * - Should handle gracefully and return 0
     * - Validates that the conversion handles boundary values correctly
     * - 0 km/h should convert to 0 mph
     */
    @Test
    public void testConvertKmh2Mph_ZeroInput() {
        float result = conversion.convertKmh2Mph("0", 2);
        assertEquals(0.0f, result, 0.01f);
    }

    /**
     * TDD CYCLE 7: Large Value Handling
     *
     * RED PHASE:
     * - Testing conversion with large values
     * - Validates no overflow or precision loss
     */
    @Test
    public void testConvertKmh2Mph_LargeValue() {
        float result = conversion.convertKmh2Mph("1000", 2);
        assertEquals(621.37f, result, 0.01f);
    }

// ========================================
// USER STORY 3: Convert Kelvin to Celsius
// ========================================

    /**
     * TDD CYCLE 8: Basic Kelvin to Celsius Conversion
     *
     * RED PHASE:
     * - Writing this test first (method doesn't exist yet)
     * - Test will fail because convertK2C() is not implemented
     * - Expected: 300 K should convert to 26.85°C (with 2 decimal precision)
     * - Note: This conversion has an OFFSET (subtract 273.15), not just multiplication
     */
    @Test
    public void testConvertK2C() {
        // Arrange
        String kelvinValue = "300";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertK2C(kelvinValue, decimalPrecision);

        // Assert
        // 300 K - 273.15 = 26.85°C
        assertEquals(26.85f, result, 0.01f);
    }

    /**
     * TDD CYCLE 9: Absolute Zero Edge Case
     *
     * RED PHASE:
     * - Testing absolute zero (0 Kelvin)
     * - Should convert to -273.15°C
     * - Critical scientific boundary value
     */
    @Test
    public void testConvertK2C_AbsoluteZero() {
        // Arrange
        String kelvinValue = "0";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertK2C(kelvinValue, decimalPrecision);

        // Assert
        // 0 K = -273.15°C (absolute zero)
        assertEquals(-273.15f, result, 0.01f);
    }

    /**
     * TDD CYCLE 10: Water Freezing Point
     *
     * RED PHASE:
     * - Testing water freezing point (273.15 K = 0°C)
     * - Important reference point in temperature conversion
     */
    @Test
    public void testConvertK2C_WaterFreezingPoint() {
        // Arrange
        String kelvinValue = "273.15";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertK2C(kelvinValue, decimalPrecision);

        // Assert
        // 273.15 K = 0°C (water freezing point)
        assertEquals(0.0f, result, 0.01f);
    }

    /**
     * TDD CYCLE 11: Water Boiling Point
     *
     * RED PHASE:
     * - Testing water boiling point (373.15 K = 100°C)
     * - Another important reference point
     */
    @Test
    public void testConvertK2C_WaterBoilingPoint() {
        // Arrange
        String kelvinValue = "373.15";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertK2C(kelvinValue, decimalPrecision);

        // Assert
        // 373.15 K = 100°C (water boiling point at sea level)
        assertEquals(100.0f, result, 0.01f);
    }

// ========================================
// USER STORY 4: Convert Celsius to Kelvin
// ========================================

    /**
     * TDD CYCLE 12: Basic Celsius to Kelvin Conversion
     *
     * RED PHASE:
     * - Writing this test first (method doesn't exist yet)
     * - Test will fail because convertC2K() is not implemented
     * - Expected: 25°C should convert to 298.15 K (with 2 decimal precision)
     * - Note: This conversion adds an offset (+ 273.15)
     */
    @Test
    public void testConvertC2K() {
        // Arrange
        String celsiusValue = "25";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertC2K(celsiusValue, decimalPrecision);

        // Assert
        // 25°C + 273.15 = 298.15 K
        assertEquals(298.15f, result, 0.01f);
    }

    /**
     * TDD CYCLE 13: Absolute Zero in Celsius
     *
     * RED PHASE:
     * - Testing absolute zero from Celsius perspective
     * - -273.15°C should convert to 0 K
     * - Critical scientific boundary - lowest possible temperature
     */
    @Test
    public void testConvertC2K_AbsoluteZero() {
        // Arrange
        String celsiusValue = "-273.15";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertC2K(celsiusValue, decimalPrecision);

        // Assert
        // -273.15°C = 0 K (absolute zero)
        assertEquals(0.0f, result, 0.01f);
    }

    /**
     * TDD CYCLE 14: Water Freezing Point from Celsius
     *
     * RED PHASE:
     * - Testing water freezing point: 0°C = 273.15 K
     * - Important reference point in temperature conversion
     */
    @Test
    public void testConvertC2K_WaterFreezingPoint() {
        // Arrange
        String celsiusValue = "0";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertC2K(celsiusValue, decimalPrecision);

        // Assert
        // 0°C = 273.15 K (water freezing point)
        assertEquals(273.15f, result, 0.01f);
    }

    /**
     * TDD CYCLE 15: Water Boiling Point from Celsius
     *
     * RED PHASE:
     * - Testing water boiling point: 100°C = 373.15 K
     * - Validates conversion accuracy at upper common temperature range
     */
    @Test
    public void testConvertC2K_WaterBoilingPoint() {
        // Arrange
        String celsiusValue = "100";
        int decimalPrecision = 2;

        // Act
        float result = conversion.convertC2K(celsiusValue, decimalPrecision);

        // Assert
        // 100°C = 373.15 K (water boiling point at sea level)
        assertEquals(373.15f, result, 0.01f);
    }

}
