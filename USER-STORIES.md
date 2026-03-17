# User Stories - TDD Assignment

## User Story 1: Convert MPH to KM/H
**As a** traveler visiting countries that use the metric system  
**I want** to convert miles per hour to kilometers per hour  
**So that** I can understand speed limits and vehicle speeds in metric units

**Acceptance Criteria:**
- Given a speed in mph, the system converts it to km/h
- Conversion uses the formula: km/h = mph × 1.60934
- Result respects user-selected decimal precision (0-4 places)

---

## User Story 2: Convert KM/H to MPH
**As a** driver familiar with imperial units  
**I want** to convert kilometers per hour to miles per hour  
**So that** I can understand metric speed measurements in familiar units

**Acceptance Criteria:**
- Given a speed in km/h, the system converts it to mph
- Conversion uses the formula: mph = km/h × 0.621371
- Result respects user-selected decimal precision (0-4 places)

---

## User Story 3: Convert Kelvin to Celsius
**As a** science student working with temperature data  
**I want** to convert Kelvin to Celsius  
**So that** I can work with temperatures in more familiar Celsius scale

**Acceptance Criteria:**
- Given a temperature in Kelvin, the system converts it to Celsius
- Conversion uses the formula: C = K - 273.15
- Result respects user-selected decimal precision (0-4 places)
- Handles absolute zero (0K = -273.15°C) correctly

---

## User Story 4: Convert Celsius to Kelvin
**As a** scientist performing thermodynamic calculations  
**I want** to convert Celsius to Kelvin  
**So that** I can use absolute temperature scale for scientific work

**Acceptance Criteria:**
- Given a temperature in Celsius, the system converts it to Kelvin
- Conversion uses the formula: K = C + 273.15
- Result respects user-selected decimal precision (0-4 places)
- Handles freezing point of water (0°C = 273.15K) correctly
