
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

    val students = mutableListOf<Student>()

    while (true) {
        // Display prompt and read the student's ID from console input
        print("Enter student ID: ")
        val id = readln()

        print("Enter student name (or quit to stop): ")
        val name = readln()

        if (name.lowercase() == "quit") {
            break
        }

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

        students.add(student)

        println("Student added successfully!\n")
    }


    println("Program finished.\n")

    println("--- All Students List ---")
    for (s in students) {
        println(s)
    }
}