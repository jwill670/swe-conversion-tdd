# TDD Process Documentation

This document chronicles the Test-Driven Development process for adding two new conversion features to the unit conversion program:
1. Miles per hour (mph) ↔ Kilometers per hour (km/h)
2. Kelvin (K) ↔ Celsius (C)

Each section follows the TDD cycle: RED (failing test) → GREEN (passing test) → REFACTOR (improve code)

---

## User Story 1: Convert MPH to KM/H

**User Story:**
As a traveler visiting countries that use the metric system, I want to convert miles per hour to kilometers per hour so that I can understand speed limits and vehicle speeds in metric units.

**Acceptance Criteria:**
- Given a speed in mph, the system converts it to km/h
- Conversion uses the formula: km/h = mph × 1.60934
- Result respects user-selected decimal precision (0-4 places)
- System handles edge cases (zero, large values, small values)

---

### TDD Cycle 1: Basic MPH to KM/H Conversion

**TEST (RED Phase):**
- Created `testConvertMph2Kmh` in ConversionTest.java
- Test verifies that 60 mph converts to 96.56 km/h with 2 decimal precision
- Test FAILED as expected: `convertMph2Kmh()` method does not exist
- Error message: "cannot find symbol: method convertMph2Kmh(String,int)"
- This is the expected RED state - the test fails because the feature doesn't exist yet

**IMPLEMENTATION (GREEN Phase):**
- Created `convertMph2Kmh(String mphAsStr, int decimalPrecision)` method in conversion.java
- Changed method visibility from `private` to `public` to enable unit testing
- Method uses existing `genericConvert()` helper function for consistency
- Conversion factor: 1.60934 (standard mph to km/h conversion)
- Formula: km/h = mph × 1.60934
- Leverages the refactored code infrastructure from Assignment 3
- Test now PASSES

**Implementation Details:**
- Method signature: `public static float convertMph2Kmh(String mphAsStr, int decimalPrecision)`
- Returns: float value representing speed in km/h
- Implementation: `return genericConvert(mphAsStr, 1.60934f, decimalPrecision);`
- Integration: Seamlessly integrates with existing conversion infrastructure

**REFACTORING:**
- Reviewed implementation for potential improvements
- Code is already clean and maintainable
- Successfully leverages existing `genericConvert()` infrastructure from Assignment 3 refactoring
- Follows established pattern used by other conversion methods (distance, weight, volume, time)
- No code duplication present
- Variable names are clear and descriptive
- Conversion factor is documented in code comment
- **Decision: No refactoring required**

**Status:** TDD Cycle 1 Complete
- RED: Test written and failed as expected 
- GREEN: Minimal implementation makes test pass 
- REFACTOR: Code reviewed, no changes needed

---

### TDD Cycle 2: Zero Input Edge Case

**TEST (RED Phase):**
- Created `testConvertMph2Kmh_ZeroInput()` in ConversionTest.java
- Test verifies that 0 mph converts to 0 km/h
- Edge case: Validates boundary value handling
- **Test PASSED immediately (no RED phase needed)** 
- This indicates the existing `genericConvert()` implementation is robust

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertMph2Kmh()` method already handles zero input correctly
- The formula (0 × 1.60934 = 0) works as expected
- This demonstrates the value of the generic conversion infrastructure

**REFACTORING:**
- No refactoring needed
- Test validates that existing code handles edge cases properly
- This confirms the robustness of the Assignment 3 refactoring

**Status:** TDD Cycle 2 Complete
- RED: Test passed immediately (implementation already correct)
- GREEN: No changes needed
- REFACTOR: No changes needed

**Key Insight:** When a test passes immediately, it validates that your existing implementation is already handling that scenario correctly. This is a positive outcome in TDD!

---

### TDD Cycle 3: Decimal Precision Variations

**TEST (RED Phase):**
- Created `testConvertMph2Kmh_VariablePrecision()` in ConversionTest.java
- Test verifies decimal precision parameter works correctly (0, 1, and 4 decimals)
- Tests same input (60 mph) with different precision settings
- **Test PASSED immediately** 
- Confirms `roundNum()` helper correctly handles variable precision

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- The `decimalPrecision` parameter is properly passed through to `genericConvert()`
- `roundNum()` correctly applies precision using `Math.pow(10, decimalPrecision)`

**REFACTORING:**
- No refactoring needed
- This test validates the Assignment 3 precision feature integration

**Status:** TDD Cycle 3 Complete

---

### TDD Cycle 4: Large Value Handling

**TEST (RED Phase):**
- Created `testConvertMph2Kmh_LargeValue()` in ConversionTest.java
- Test verifies that 1000 mph converts to 1609.34 km/h
- **Test PASSED immediately**

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Method handles large values without overflow

**REFACTORING:**
- No refactoring needed

**Status:** TDD Cycle 4 Complete

---

## User Story 1 - COMPLETE

**Summary:**
- Implemented `convertMph2Kmh()` method
- Created 4 comprehensive tests covering:
    - Basic conversion functionality
    - Zero input edge case
    - Variable decimal precision
    - Large value handling
- All tests passing 
- No refactoring needed - leveraged existing infrastructure
- Code is production-ready

**Total TDD Cycles for User Story 1:** 4

---

## User Story 2: Convert KM/H to MPH

**User Story:**
As a driver familiar with imperial units, I want to convert kilometers per hour to miles per hour so that I can understand metric speed measurements in familiar units.

**Acceptance Criteria:**
- Given a speed in km/h, the system converts it to mph
- Conversion uses the formula: mph = km/h × 0.621371
- Result respects user-selected decimal precision (0-4 places)

---

### TDD Cycle 5: Basic KM/H to MPH Conversion

**TEST (RED Phase):**
- Created `testConvertKmh2Mph` in ConversionTest.java
- Test verifies that 100 km/h converts to 62.14 mph with 2 decimal precision
- Test FAILED as expected: `convertKmh2Mph()` method does not exist 
- Error: "cannot find symbol: method convertKmh2Mph(String,int)"

**Status:** Test failing (RED) - Ready to implement

---

### TDD Cycle 6: Zero Input Edge Case

**TEST (RED Phase):**
- Created `testConvertKmh2Mph_ZeroInput()` in ConversionTest.java
- Test verifies that 0 km/h converts to 0 mph
- Edge case: Validates boundary value handling
- **Test PASSED immediately (no RED phase needed)**
- This indicates the existing `genericConvert()` implementation is robust

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertKmh2Mph()` method already handles zero input correctly
- The formula (0 × 0.621371 = 0) works as expected
- This demonstrates the value of the generic conversion infrastructure

**REFACTORING:**
- No refactoring needed
- Test validates that existing code handles edge cases properly
- This confirms the robustness of the Assignment 3 refactoring

**Status:** TDD Cycle 2 Complete
- RED: Test passed immediately (implementation already correct)
- GREEN: No changes needed
- REFACTOR: No changes needed

**Key Insight:** When a test passes immediately, it validates that your existing implementation is already handling that scenario correctly. This is a positive outcome in TDD!

---

### TDD Cycle 7: Large Value Handling

**TEST (RED Phase):**
- Created `testConvertKmh2Mph_LargeValue()` in ConversionTest.java
- Test verifies that 1000 km/h converts to 621.37 mph
- **Test PASSED immediately**

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Method handles large values without overflow

**REFACTORING:**
- No refactoring needed

**Status:** TDD Cycle 7 Complete

---

## User Story 2 - COMPLETE

**Summary:**
- Implemented `convertKmh2Mph()` method
- Created 3 comprehensive tests covering:
  - Basic conversion functionality
  - Zero input edge case
  - Large value handling
- All tests passing
- No refactoring needed - leveraged existing infrastructure
- Code is production-ready

**Total TDD Cycles for User Story 2:** 3

---

## User Story 3: Convert Kelvin to Celsius

**User Story:**
As a science student working with temperature data, I want to convert Kelvin to Celsius so that I can work with temperatures in more familiar Celsius scale.

**Acceptance Criteria:**
- Given a temperature in Kelvin, the system converts it to Celsius
- Conversion uses the formula: C = K - 273.15
- Result respects user-selected decimal precision (0-4 places)
- Handles absolute zero (0K = -273.15°C) correctly
- Handles water freezing point (273.15K = 0°C) correctly

---

### TDD Cycle 8: Basic Kelvin to Celsius Conversion

**TEST (RED Phase):**
- Created `testConvertK2C()` in ConversionTest.java
- Test verifies that 300 K converts to 26.85°C with 2 decimal precision
- **Important Note:** This conversion requires subtraction (offset), not multiplication
- Cannot use `genericConvert()` directly (designed for multiplication only)
- Test FAILED as expected: `convertK2C()` method does not exist 
- Error: "cannot find symbol: method convertK2C(String,int)"

**Status:** Test failing (RED) - Ready to implement

**IMPLEMENTATION (GREEN Phase):**
- Created `convertK2C(String kAsStr, int decimalPrecision)` method in conversion.java
- Method signature: `public static float convertK2C(String kAsStr, int decimalPrecision)`
- Formula: C = K - 273.15
- **Implementation approach:** Follows same pattern as `convertF2C()` and `convertC2F()`
  - Cannot use `genericConvert()` because conversion requires subtraction, not multiplication
  - Uses `roundNum()` helper for input and output rounding
  - Handles the offset operation manually: `num2 = num1 - 273.15`
- Test now PASSES 

**Status:** Test passing (GREEN) - Ready to refactor

**REFACTORING:**
- Reviewed implementation for potential improvements
- Observed similarity with `convertF2C()` and `convertC2F()` methods
- All three use offset-based conversions (not simple multiplication)
- **Design Decision:** Keep methods separate rather than creating offset helper
  - Only 4 total offset conversions (F↔C, K↔C)
  - Methods are simple and readable as-is
  - Creating generic offset helper would add complexity without significant benefit
  - Pattern is clear and maintainable
- **Decision: No refactoring required**

**Status:** TDD Cycle 8 Complete
- RED: Test written and failed as expected 
- GREEN: Implementation makes test pass 
- REFACTOR: Reviewed, no changes needed 

---

### TDD Cycle 9: Absolute Zero Edge Case

**TEST (RED Phase):**
- Created `testConvertK2C_AbsoluteZero()` in ConversionTest.java
- Tests critical scientific boundary: 0 Kelvin (absolute zero)
- Expected: 0 K should convert to -273.15°C
- **Test PASSED immediately**
- Implementation correctly handles negative Celsius values

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing method handles absolute zero correctly
- Formula works for all Kelvin values including 0

**REFACTORING:**
- No refactoring needed

**Status:** TDD Cycle 9 Complete

---

### TDD Cycle 10: Water Freezing Point

**TEST (RED Phase):**
- Created `testConvertK2C_WaterFreezingPoint()` in ConversionTest.java
- Tests important physical reference point: water freezing point
- Expected: 273.15 K should convert to 0.0°C
- This is a critical calibration point for temperature scales
- **Test PASSED immediately** 
- Implementation correctly handles the conversion at this reference point

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertK2C()` method handles water freezing point correctly
- The formula (273.15 - 273.15 = 0) works as expected
- Validates that offset calculation is accurate

**REFACTORING:**
- No refactoring needed
- Test confirms accuracy of the 273.15 offset constant

**Status:** TDD Cycle 10 Complete
- RED: Test passed immediately (implementation already correct) 
- GREEN: No changes needed 
- REFACTOR: No changes needed 

**Scientific Validation:** This test confirms that the Kelvin-Celsius conversion is scientifically accurate at a known reference point (water's freezing point at standard pressure).

---

### TDD Cycle 11: Water Boiling Point

**TEST (RED Phase):**
- Created `testConvertK2C_WaterBoilingPoint()` in ConversionTest.java
- Tests another critical physical reference point: water boiling point at sea level
- Expected: 373.15 K should convert to 100.0°C
- Validates conversion accuracy across a wider temperature range (0°C to 100°C)
- **Test PASSED immediately**
- Implementation maintains accuracy across the full range of common temperatures

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertK2C()` method handles water boiling point correctly
- The formula (373.15 - 273.15 = 100.0) produces expected result
- Demonstrates consistent accuracy from absolute zero (-273.15°C) to boiling point (100°C)

**REFACTORING:**
- No refactoring needed
- Test suite now covers critical temperature range with three reference points:
  - Absolute zero (0 K = -273.15°C)
  - Freezing point (273.15 K = 0°C)
  - Boiling point (373.15 K = 100°C)

**Status:** TDD Cycle 11 Complete
- RED: Test passed immediately (implementation already correct) 
- GREEN: No changes needed 
- REFACTOR: No changes needed 

**Scientific Validation:** Together with Cycles 9 and 10, this test confirms the conversion is accurate across a 373.15-degree range, covering all common scientific and everyday temperature scenarios.

---

## User Story 3 - COMPLETE 

**Summary:**
- Implemented `convertK2C()` method using offset-based conversion
- Created 4 comprehensive tests covering:
  - Basic conversion functionality
  - Absolute zero (0 K = -273.15°C)
  - Water freezing point (273.15 K = 0°C)
  - Water boiling point (373.15 K = 100°C)
- All tests passing
- Method follows same pattern as Fahrenheit↔Celsius conversions
- Code is production-ready

**Total TDD Cycles for User Story 3:** 4

**Key Design Decision:**
- Did not use `genericConvert()` helper (designed for multiplication only)
- Used manual offset calculation following F<->C pattern
- Considered creating offset helper but decided against it for simplicity

---

## User Story 4: Convert Celsius to Kelvin

**User Story:**
As a scientist performing thermodynamic calculations, I want to convert Celsius to Kelvin so that I can use absolute temperature scale for scientific work.

**Acceptance Criteria:**
- Given a temperature in Celsius, the system converts it to Kelvin
- Conversion uses the formula: K = C + 273.15
- Result respects user-selected decimal precision (0-4 places)
- Handles absolute zero (-273.15°C = 0 K) correctly
- Handles water freezing point (0°C = 273.15 K) correctly
- Handles water boiling point (100°C = 373.15 K) correctly

---

### TDD Cycle 12: Basic Celsius to Kelvin Conversion

**TEST (RED Phase):**
- Created `testConvertC2K()` in ConversionTest.java
- Test verifies that 25°C converts to 298.15 K with 2 decimal precision
- **Important Note:** This conversion requires addition (offset), not multiplication
- Cannot use `genericConvert()` directly (designed for multiplication only)
- Reverse operation of `convertK2C()` (User Story 3)
- Test FAILED as expected: `convertC2K()` method does not exist 
- Error: "cannot find symbol: method convertC2K(String,int)"

**Status:** Test failing (RED) - Ready to implement

**IMPLEMENTATION (GREEN Phase):**
- Created `convertC2K(String cAsStr, int decimalPrecision)` method in conversion.java
- Method signature: `public static float convertC2K(String cAsStr, int decimalPrecision)`
- Formula: K = C + 273.15
- **Implementation approach:** Mirrors `convertK2C()` with reversed operation
  - Uses addition instead of subtraction
  - Cannot use `genericConvert()` (requires multiplication, not addition)
  - Uses `roundNum()` helper for input and output rounding
  - Handles the offset operation manually: `num2 = num1 + 273.15`
- Test now PASSES 

**Status:** Test passing (GREEN) - Ready to refactor

**REFACTORING:**
- Reviewed implementation for potential improvements
- Method is the inverse of `convertK2C()` - both use same offset (273.15)
- Follows established pattern for offset-based conversions
- Code is clean, readable, and maintainable
- Consistent with other temperature conversion methods
- **Decision: No refactoring required**

**Status:** TDD Cycle 12 Complete
- RED: Test written and failed as expected 
- GREEN: Implementation makes test pass
- REFACTOR: Reviewed, no changes needed

---

### TDD Cycle 13: Absolute Zero in Celsius

**TEST (RED Phase):**
- Created `testConvertC2K_AbsoluteZero()` in ConversionTest.java
- Tests critical scientific boundary: -273.15°C (absolute zero)
- Expected: -273.15°C should convert to 0 K
- Validates that conversion works correctly with negative Celsius values
- **Test PASSED immediately**
- Implementation correctly handles the lowest possible temperature

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing method handles negative Celsius values correctly
- Formula works: -273.15 + 273.15 = 0 K
- Validates inverse relationship with User Story 3, Cycle 9

**REFACTORING:**
- No refactoring needed
- Test confirms bidirectional accuracy: 0 K <-> -273.15°C

**Status:** TDD Cycle 13 Complete

**Cross-Validation:** This test paired with Cycle 9 (0 K -> -273.15°C) confirms perfect bidirectional conversion accuracy.

---

### TDD Cycle 14: Water Freezing Point from Celsius

**TEST (RED Phase):**
- Created `testConvertC2K_WaterFreezingPoint()` in ConversionTest.java
- Tests important physical reference point: water freezing point
- Expected: 0°C should convert to 273.15 K
- **Test PASSED immediately** 
- Implementation correctly handles zero Celsius input

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertC2K()` method handles water freezing point correctly
- The formula (0 + 273.15 = 273.15) works as expected
- Validates inverse relationship with User Story 3, Cycle 10

**REFACTORING:**
- No refactoring needed
- Test confirms accuracy at critical calibration point

**Status:** TDD Cycle 14 Complete

**Cross-Validation:** This test paired with Cycle 10 (273.15 K -> 0°C) confirms perfect bidirectional conversion at water's freezing point.

---

### TDD Cycle 15: Water Boiling Point from Celsius

**TEST (RED Phase):**
- Created `testConvertC2K_WaterBoilingPoint()` in ConversionTest.java
- Tests water boiling point at standard pressure: 100°C = 373.15 K
- Validates conversion accuracy across full common temperature range
- **Test PASSED immediately** 
- Implementation maintains accuracy from absolute zero to boiling point

**IMPLEMENTATION (GREEN Phase):**
- No implementation changes required
- Existing `convertC2K()` method handles water boiling point correctly
- The formula (100 + 273.15 = 373.15) produces expected result
- Validates inverse relationship with User Story 3, Cycle 11

**REFACTORING:**
- No refactoring needed
- Test suite now covers full bidirectional Kelvin↔Celsius conversion
- Four reference points validated in both directions:
  - Absolute zero: 0 K <-> -273.15°C
  - Freezing point: 273.15 K <-> 0°C
  - Boiling point: 373.15 K <-> 100°C
  - General values: 300 K <-> 26.85°C and 298.15 K <-> 25°C

**Status:** TDD Cycle 15 Complete

**Cross-Validation:** This test paired with Cycle 11 (373.15 K -> 100°C) confirms perfect bidirectional conversion at water's boiling point.

---

# TDD Assignment - COMPLETE 

## Final Summary

**All User Stories Implemented Successfully**

### User Story 1: MPH to KM/H 
- 4 TDD cycles (Cycles 1-4)
- Tests: Basic, Zero, Precision, Large values
- Implementation: Uses `genericConvert()` with factor 1.60934

### User Story 2: KM/H to MPH 
- 3 TDD cycles (Cycles 5-7)
- Tests: Basic, Zero, Large values
- Implementation: Uses `genericConvert()` with factor 0.621371

### User Story 3: Kelvin to Celsius 
- 4 TDD cycles (Cycles 8-11)
- Tests: Basic, Absolute zero, Freezing point, Boiling point
- Implementation: Manual offset calculation (K - 273.15)

### User Story 4: Celsius to Kelvin 
- 4 TDD cycles (Cycles 12-15)
- Tests: Basic, Absolute zero, Freezing point, Boiling point
- Implementation: Manual offset calculation (C + 273.15)

---

## Overall Statistics

**Total TDD Cycles:** 15
**Total Tests Written:** 15
**Tests Passing:** 15 
**Tests Failing:** 0 
**Pass Rate:** 100%

**Methods Added:**
1. `convertMph2Kmh(String, int)` - Speed conversion
2. `convertKmh2Mph(String, int)` - Speed conversion
3. `convertK2C(String, int)` - Temperature conversion
4. `convertC2K(String, int)` - Temperature conversion

**Code Quality:**
- All methods follow established patterns
- Leveraged existing infrastructure (`genericConvert()`, `roundNum()`)
- Consistent naming conventions
- Comprehensive test coverage
- Scientifically accurate conversions
- Production-ready code

---

## TDD Process Observations

**What Worked Well:**
- Using `genericConvert()` for linear conversions (speed) minimized code
- Existing `roundNum()` helper seamlessly integrated with new conversions
- Many tests passed immediately, validating robust existing infrastructure
- Bidirectional testing (K↔C) caught potential inconsistencies
- Scientific reference points provided strong validation

**Key Learnings:**
- TDD encourages small, incremental development
- Tests passing immediately indicates robust generic implementations
- Refactoring from Assignment 3 paid dividends (genericConvert, roundNum)
- Offset conversions require different approach than multiplicative conversions
- Comprehensive edge case testing builds confidence in implementation

**Design Decisions:**
- Kept offset conversions (K↔C, F↔C) separate from `genericConvert()`
- Decided against creating generic offset helper (simplicity over abstraction)
- Made all conversion methods `public` for testability
- Used scientific reference points for validation (absolute zero, phase transitions)

---

## Next Steps

- Update main() method to add new conversion options to menu
- Take screenshots showing new features working
- Create README.md with compilation/run instructions
- Commit all changes to GitHub
- Submit assignment
