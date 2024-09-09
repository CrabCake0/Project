## Overview
This project implements a simple, extensible calculator in Java that supports multiple operations. It adheres to object-oriented principles, especially the Open-Closed Principle (OCP), to ensure that the system is easily maintainable and extensible.

## Key Features
- Basic operations: ADD, SUBTRACT, MULTIPLY, DIVIDE.
- Supports chaining operations on a single value.
- Extensible design allowing new operations without modifying the existing calculator code.
- IoC compatible for easy testing and integration.
- Comprehensive error handling for unsupported operations and division by zero.

## Design Decisions
- Used the Strategy Pattern to allow flexible addition of new operations.
- Chaining operations are handled by sequentially applying a list of `CalculationStep` objects to an initial value.
- Error handling for invalid operations and division by zero.

## Requirements
- Java 8 or above
- JUnit 5 for testing

## How to Use
1. Clone the repository.
2. Compile and run the `BasicCalculator` class.
3. Add additional operations by using the `addOperation` method.

## Testing
Run the unit tests included in the `BasicCalculatorTest` class to validate the functionality.
"""