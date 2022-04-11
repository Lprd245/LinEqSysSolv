# LinEqSysSolv
Linear Equation System Solver:

A math project that aims to put math stuff to practical use.

## Usage:

To compile the necessary classes (Determinator.java, Output_Engine.java), just run the compile.sh script.

To use the LinEqSysSolv(er) make sure that all the necessary classes are compiled and then run ```java Input.java x y``` with x and y being the dimensions of the Matrix that you're about to enter (Matrix has to be x = y + 1). Then enter all the numbers for the Matrix to be solved.

## How it works

The program uses the Determinant method to solve a linear equation system in the form of a coefficient matrix. To use the program, first transform you equation system to the form noted below and enter just the coefficients [a, b, c, d, ...] as a matrix with the dimensions x = y + 1 (one more column than rows) into the Input.java program. To start the program first compile/run the Input.java class with the ```java Input.java [x-dimension] [y-dimension]``` command.

a<sub>1</sub>x + b<sub>1</sub>y + c<sub>1</sub>z = d<sub>1</sub>\
a<sub>2</sub>x + b<sub>2</sub>y + c<sub>2</sub>z = d<sub>2</sub>\
a<sub>3</sub>x + b<sub>3</sub>y + c<sub>3</sub>z = d<sub>3</sub>

#### Note:
to save a matrix use the command like this:\
```java Input.java [x-dim] [y-dim] save [filename]```\
to load a matrix use the command like this:\
```java Input.java load [filename]```

## How each class (and the math behind it) works

- compile.sh\
The compile.sh shell script does nothing else than just deleting the old class files and recompiling all the necessary classes.
- Input.java\
The input class just has to be launched with at least 2 arguments. It can solve a matrix that gets enterd as the program runs, save that to a file and also load one from a file. It's only job is it to initialize the whole process by taking the input arguments and based on them either launch the Determinator with a matrix pulled from a file using the File_io class or reading a matrix from the console and, on demand, also saving that to a file.
- Output_Engine_2.java\
The Output engine only has one job: to output a 1-dimensional or 2-dimensional array in a nice way.
- Determinator.java\
The determinator takes a (2-dimensional) matrix as an input and creates a 3-dimensional array with one 2d-matrix for each variable and one for the denominator to calculate. It then calculates the determinant for each variable's matrix by first reducing them to 3x3 matrixes (using math) and stores them in a 1-dimensional array (called sol_arr). To get the actual solutions for the numbers that will actually solve all of the conditional equations, the only step left is to divide each variable determinant by the denominator determinant (which is always stored in sol_arr\[0]).