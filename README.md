# pippo-code

I think it's important to keep problem-solving skills alive, I pay special attention to solve coding exercises regularly during my free time.
The repository contains my solutions to several programming problems, each solution is implemented in Java and encapsulated in a class.
I provided comments and aimed to keep code clean and readable and always find an efficient solution in terms of computational time and memory space.
This repository also serves as a learning resource for me and for anyone who is interested in understanding different ways to solve coding problems.

## 📘 Description

Follow these markdowns for each problem description

* [Binary gap](./src/site/BinaryGap.md)
* [Dominator](./src/site/Dominator.md)
* [Max counters](./src/site/MaxCounters.md)
* [Max double slice sum](./src/site/MaxDoubleSliceSum.md)
* [Max slice sum](./src/site/MaxSliceSum.md)
* [Missing integer](./src/site/MissingInteger.md)
* [Odd occurrences in array](./src/site/OddOccurrencesInArray.md)

In some cases I provide more than one solution, the easy one and the smarter, and the `@Silly` annotation marks the method that implement the easy algorithm.

## 💾 Installation

Make sure you've installed:

* The JDK (Java development kit), any version is fine, this repository is focused on problem solving and advanced Java functionalities are not necessary. 
```
ilizin:~$ java -version
openjdk version "17" 2021-09-14
OpenJDK Runtime Environment (build 17+35-2724)
OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
ilizin:~$ 
```

* Maven
```
ilizin:~$ mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /opt/apache-maven-3.9.9
Java version: 17, vendor: Oracle Corporation, runtime: /opt/jdk-17
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.8.0-31-generic", arch: "amd64", family: "unix"
ilizin:~$ 
```

* Clone the repository.
```
git clone git@github.com:ilizin/pippo-code.git
```

* Move to the repo folder:
```
ilizin@ilizin:~/repos$ cd pippo-code
ilizin@ilizin:~/repos/pippo-code$
```

* Run the `mvn clean install` in order to install the project.
```
ilizin@ilizin:~/repos/pippo-code$ mvn clean install
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.561 s
[INFO] Finished at: 2025-02-08T16:34:36+01:00
[INFO] ------------------------------------------------------------------------
ilizin@ilizin:~/repos/pippo-code$ 
```

## Usage

* Open the project with your favourite IDE.

* Choose a problem, run its junit, debug, try to understand the solution and you can easily add a new test case as the junits are parametrized: 
```java
 @Parameterized.Parameters(name = "{index}: values = {2}, expectedSmallestPositiveMissingInteger = {1}")
 public static Object[][] provideTestData() {
     return new Object[][] {
             { new int[] {1, 3, 6, 4, 1, 2}, 5, "[1, 3, 6, 4, 1, 2]" },
             { new int[] {1, 2, 3}, 4, "[1, 2, 3]" },
             { new int[] {-1, -3}, 1, "[-1, -3]" },
     };
 }
```

## 📂 Structure 

Each problem solution is stored in its own class within the `me.ilizin.coding` package, has a junit and a markdown containing the problem description.

```
/
└── src
    ├── main
    │   └── java
    │       └── me.ilizin.coding
    │           ├── BinaryGap
    │           └── ...
    ├── site
    │   ├── BinaryGap
    │   └── ...
    └── test
        └── java
            └── me.ilizin.coding
                ├── BinaryGap
                └── ...
```

## 🤝 Contributing

Contributions are welcome! If you have an alternative solution or an improvement to an existing solution, feel free to contribute. Follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature-new-solution).
3. Commit your changes (git commit -m 'Add new solution for problem X').
4. Push to the branch (git push origin feature-new-solution).
5. Open a pull request.

## 📬 Contact

GitHub: [ilizin](https://github.com/ilizin)

## 🙌 Acknowledgments

Thank you to Codility for providing a platform to practice coding problems.