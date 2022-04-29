package org.example.ProblemB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


    public class ProblemB {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<String> fullNames = new ArrayList<>();
            List<String> firstNames = new ArrayList<>();
            List<String> lastNames = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (!line.equals("exit")) {
                    fullNames.add(line);
                } else {
                    // Extract students from fullNames
                    for (int i = 0; i < fullNames.size(); i++) {
                        firstNames.add(fullNames.get(i).substring(0, fullNames.get(i).indexOf(" ")));
                        lastNames.add(fullNames.get(i).substring(fullNames.get(i).indexOf(" ") + 1));
                        students.add(new Student(lastNames.get(i), firstNames.get(i)));
                    }
                    // Sort students by last name
                    Collections.sort(students);
                    for (int i = 0; i < students.size() - 1; i++) {
                        // Check if two or more people have the same last name
                        if (students.get(i).lastName.equals(students.get(i + 1).lastName)) {
                            // Just list the first name (clear last name)
                            students.get(i).setLastName("");
                            students.get(i + 1).setLastName("");
                            // Sort first names with the same last name
                            if (students.get(i).firstName.compareTo(students.get(i + 1).firstName) > 0) {
                                Student temp = students.get(i);
                                students.set(i, students.get(i + 1));
                                students.set(i + 1, temp);
                            }
                        }
                    }
                    students.forEach(s -> System.out.println(s.firstName + " " + s.lastName));
                    break;
                }
            }
        }
    }

    class Student implements Comparable<Student> {
        String lastName;
        String firstName;

        public Student(String lastName, String firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Student o) {
            return this.lastName.compareTo(o.lastName);
        }
    }

