
// fun main() {

//     while (true) {

//         // Display prompt and read the student's ID from console input
//         print("Enter student ID: ")
//         val id = readln()

//         // Display prompt and read the student's name from console input
//         print("Enter student name (or quit to stop): ")
//         val name = readln()

//         // Stop the loop when the user types "quit"
//         if (name == "quit") {
//             break
//         }

//         // Display prompt and read the course from console input
//         print("Enter course: ")
//         val course = readln()

//         // Display prompt and read the mark from console input
//         print("Enter mark: ")
//         val mark = readln().toDouble()

//         // Construct a Student object using the entered data
//         val student = Student(id, name, course, mark)

//         println(student)
//         println()
//     }

//     // After the loop ends, display "Program finished"
//     println("Program finished.")
// }

fun main() {
    val university = University()
    var choice = ""

    while (choice != "4") {
        println("\n=== University Menu ===")
        println("1. Add a student")
        println("2. Search for student by ID")
        println("3. Search for students by name")
        println("4. Quit")
        print("Enter your choice (1-4): ")

        choice = readln()

        when (choice) {
            "1" -> {
                print("Enter student ID: ")
                val id = readln()

                print("Enter student name: ")
                val name = readln()

                print("Enter course: ")
                val course = readln()

                print("Enter mark: ")
                val mark = readln().toDoubleOrNull() ?: 0.0

                print("Is the student (U)ndergraduate or (M)asters? ")
                val type = readln()

                val student: Student = if (type.equals("M", ignoreCase = true) || type.equals("Masters", ignoreCase = true)) {
                    Masters(id, name, course, mark)
                } else {
                    Undergraduate(id, name, course, mark)
                }

                university.enrolStudent(student)
                println("Student added successfully!\n")
            }
            "2" -> {
                print("Enter student ID to search: ")
                val searchId = readln()
                val found = university.findStudentById(searchId)
                
                if (found != null) {
                    println("Found: $found")
                } else {
                    println("Student with ID '$searchId' not found.")
                }
            }
            "3" -> {
                
                print("Enter student name to search: ")
                val searchName = readln()
                val results = university.findStudentsByName(searchName)
                
                if (results.isNotEmpty()) {
                    println("Found ${results.size} student(s):")
                    for (s in results) {
                        println(s)
                    }
                } else {
                    println("No students found with the name '$searchName'.")
                }
            }
            "4" -> {
                println("Exiting program. Goodbye!")
            }
            else -> {
                println("Invalid choice. Please enter a number between 1 and 4.")
            }
        }
    }
}