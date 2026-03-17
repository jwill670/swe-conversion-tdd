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
[To be filled in as you progress...]

---

[Continue with more cycles as you add tests...]
```

---

## **Your File Structure Should Now Look Like:**
```
swe-conversion-tdd/
├── src/
│   └── conversion.java
├── test/
│   └── ConversionTest.java
├── USER-STORIES.md          ✅ (Already created)
├── TDD-NARRATIVE.md         ← CREATE THIS NOW
└── README.md                (You'll create this at the end)