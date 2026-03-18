# Unit Conversion Program - TDD Assignment

**Student:** Jayden Williams  
**Course:** SWE 437-001 
**Assignment:** Assignment 5 - Test-Driven Development  
**Date:** 3/17/26

---

## Description

This program converts between various units of measurement using a command-line interface. The program was enhanced using Test-Driven Development (TDD) methodology to add two new conversion features:

1. **Speed Conversions:** Miles per hour ↔ Kilometers per hour
2. **Kelvin Temperature Conversions:** Kelvin ↔ Celsius

### Existing Features
- Temperature conversions (Fahrenheit, Celsius, Kelvin)
- Distance conversions (inches, feet, miles, centimeters, meters, kilometers)
- Weight conversions (ounces, pounds, grams, kilograms)
- Volume conversions (gallons, liters)
- Time conversions (hours, seconds)
- User-configurable decimal precision (0-4 decimal places)

### New Features (TDD Assignment)
- **Speed conversions** (Menu option 9)
  - Miles per hour → Kilometers per hour
  - Kilometers per hour → Miles per hour
- **Kelvin temperature conversions** (Menu option 1)
  - Kelvin → Celsius
  - Celsius → Kelvin

---

## Project Structure
```
swe-conversion-tdd/
├── src/
│   └── conversion.java              # Main program with all conversion logic
├── test/
│   └── ConversionTest.java          # JUnit test suite (15 tests)
├── screenshots/                     # Screenshots of working features
│   ├── k2c-conversion.png
│   ├── c2k-conversion.png
│   ├── mph2kmh-conversion.png
│   └── ...
├── USER-STORIES.md                  # User stories for TDD assignment
├── TDD-NARRATIVE.md                 # Complete TDD process documentation
└── README.md                        # This file
```

---

## Requirements

- **Java JDK:** Version 8 or higher
- **JUnit:** 4.13.2 (for running tests)
- **Operating System:** Windows, Mac, or Linux

---

## How to Compile

### Compile Main Program:
```bash
javac src/conversion.java
```

### Compile Tests (if you have JUnit):
```bash
javac -cp .:test:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar test/ConversionTest.java src/conversion.java
```

**Windows users:** Replace `:` with `;` in classpath:
```bash
javac -cp .;test;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar test/ConversionTest.java src/conversion.java
```

---

## How to Run

### Run the Program:
```bash
cd src
java conversion
```

### Run Tests:
```bash
java -cp .:test:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore ConversionTest
```

**Windows:**
```bash
java -cp .;test;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore ConversionTest
```

---

## How to Use the Program

1. **Start the program** by running `java conversion`
2. **Enter decimal precision** when prompted (0-4)
3. **Select a conversion category** from the main menu (1-10)
4. **Choose specific conversion** from the submenu
5. **Enter the value** to convert
6. **View the result**
7. Repeat or select option 10 to exit

### Example Session:
```
====== Unit Converter ======

Enter decimal precision (0-4): 2
Using 2 decimal places.

Choose an operation category:
1. Temperatures (F, C, K)
2. Short Distance
3. Medium Distance
4. Large Distance
5. Volume
6. Small Weight
7. Medium Weight
8. Time
9. Speed
10. Exit
Enter choice (1-10): 9

1. Miles per Hour to Kilometers per Hour
2. Kilometers per Hour to Miles per Hour
Enter choice: 1
Enter speed value: 60
60 mph = 96.56 km/h
```

---

## New Features Added via TDD

### Speed Conversions (Menu Option 9)

**Conversions Available:**
- **MPH to KM/H:** Converts miles per hour to kilometers per hour
  - Formula: `km/h = mph × 1.60934`
  - Example: 60 mph = 96.56 km/h

- **KM/H to MPH:** Converts kilometers per hour to miles per hour
  - Formula: `mph = km/h × 0.621371`
  - Example: 100 km/h = 62.14 mph

**Use Cases:**
- Understanding international speed limits
- Converting vehicle speedometer readings
- Comparing athletic performance metrics

---

### Kelvin Temperature Conversions (Menu Option 1)

**Conversions Available:**
- **Kelvin to Celsius:** Converts Kelvin to Celsius
  - Formula: `C = K - 273.15`
  - Example: 300 K = 26.85°C

- **Celsius to Kelvin:** Converts Celsius to Kelvin
  - Formula: `K = C + 273.15`
  - Example: 25°C = 298.15 K

**Use Cases:**
- Scientific calculations requiring absolute temperature
- Thermodynamics problems
- Converting between lab measurements and everyday scales

**Important Reference Points:**
- Absolute zero: 0 K = -273.15°C
- Water freezing: 273.15 K = 0°C
- Water boiling: 373.15 K = 100°C

---

## Test-Driven Development Process

This assignment followed strict TDD methodology:

1. **Write a failing test** (RED phase)
2. **Write minimal code to pass** (GREEN phase)
3. **Refactor if needed** (REFACTOR phase)
4. **Repeat** for each feature

### Test Statistics:
- **Total TDD Cycles:** 15
- **Total Tests:** 15
- **Passing Tests:** 15 
- **Failing Tests:** 0
- **Pass Rate:** 100%

### Test Coverage:
- Basic conversions (all 4 new conversions)
- Edge cases (zero values, absolute zero)
- Scientific reference points (water phase transitions)
- Variable decimal precision (0-4 places)
- Large values
- Bidirectional validation (Kelvin ↔ Celsius)

**For detailed TDD process documentation, see:** `TDD-NARRATIVE.md`

---

## Conversion Formulas

### Speed:
- **MPH to KM/H:** `km/h = mph × 1.60934`
- **KM/H to MPH:** `mph = km/h × 0.621371`

### Temperature (Kelvin):
- **K to C:** `C = K - 273.15`
- **C to K:** `K = C + 273.15`

### Temperature (Fahrenheit/Celsius):
- **F to C:** `C = (F - 32) × 5/9`
- **C to F:** `F = (C × 9/5) + 32`

### Distance:
- **Inches to Centimeters:** `cm = in × 2.54`
- **Feet to Meters:** `m = ft × 0.3048`
- **Miles to Kilometers:** `km = mi × 1.609`

*[Other formulas available in source code]*

---

## File Descriptions

### Source Code:
- **`src/conversion.java`** - Main program containing:
  - User interface (CLI menu system)
  - 18 conversion methods (14 original + 4 new)
  - Helper methods (`genericConvert`, `roundNum`)
  - All business logic

### Test Suite:
- **`test/ConversionTest.java`** - JUnit test suite containing:
  - 15 comprehensive tests
  - Tests for all 4 new conversions
  - Edge case validation
  - Scientific reference point verification
  - Embedded TDD process documentation in comments

### Documentation:
- **`USER-STORIES.md`** - Four user stories for TDD features
- **`TDD-NARRATIVE.md`** - Complete TDD process documentation (15 cycles)
- **`README.md`** - This file

---

## GitHub Repository

**Repository URL:** `https://github.com/jwill670/swe-conversion-tdd`

**How to Clone:**
```bash
git clone https://github.com/jwill670/swe-conversion-tdd.git
cd swe-conversion-tdd
```

---

## Design Decisions

### Architecture:
- **Separation of concerns:** UI logic separated from conversion logic
- **Reusable helpers:** `genericConvert()` for linear conversions, `roundNum()` for precision
- **Consistent patterns:** All conversions follow similar structure
- **Public methods:** All conversion methods are public for testability

### TDD Approach:
- **Leveraged existing infrastructure:** New conversions used refactored helpers from Assignment 3
- **Offset handling:** Kelvin/Celsius conversions follow Fahrenheit/Celsius pattern
- **Test-first development:** All features implemented after writing tests
- **Comprehensive coverage:** Each conversion has 3-4 tests

### Code Quality:
- **No duplication:** Generic helpers eliminate repeated code
- **Clear naming:** Method names follow `convertX2Y` pattern
- **Documentation:** Inline comments explain formulas
- **Maintainability:** Easy to add new conversions following existing patterns

---

## Known Issues / Limitations

- **Input validation:** Program doesn't validate non-numeric input (will throw exception)
- **Negative Kelvin:** Program allows negative Kelvin values (physically impossible)
- **Precision limits:** Float precision may cause minor rounding errors at extreme values

---

## Future Enhancements

Potential improvements (not implemented):
- Input validation for numeric values
- Scientific notation support for very large/small numbers
- More conversion types (pressure, energy, power)
- Batch conversion mode (convert multiple values)
- Conversion history tracking
- GUI interface

---

## Author

**Jayden Williams**  
**Email:** jwill67@gmu.edu  
**GitHub:** jwill670

---

## Acknowledgments

- Original conversion program by Jeff Offutt & Ren Li
- Assignment 3 refactoring provided foundation for TDD implementation
- JUnit framework for test-driven development

---

## License

This project is for educational purposes as part of SWE 437 at George Mason University.

---

**Last Updated:** 3/17/26
