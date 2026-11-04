
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
    // 1. Cria o objeto University que vai gerir todos os estudantes (Agregação)
    val university = University()

    while (true) {
        // Display prompt and read the student's ID from console input
        print("Enter student ID: ")
        val id = readln()

        // Display prompt and read the student's name from console input
        print("Enter student name (or quit to stop): ")
        val name = readln()

        // Stop the loop when the user types "quit"
        if (name.lowercase() == "quit") {
            break
        }

        // Display prompt and read the course from console input
        print("Enter course: ")
        val course = readln()

        // Display prompt and read the mark from console input
        print("Enter mark: ")
        val mark = readln().toDoubleOrNull() ?: 0.0

        // Ask the user whether the student is Undergraduate or Masters
        print("Is the student (U)ndergraduate or (M)asters? ")
        val type = readln()

        // Construct the appropriate object using the entered data
        val student: Student = if (type.equals("M", ignoreCase = true) || type.equals("Masters", ignoreCase = true)) {
            Masters(id, name, course, mark)
        } else {
            Undergraduate(id, name, course, mark)
        }

        // 2. Adiciona o estudante à universidade utilizando o método enrolStudent
        university.enrolStudent(student)

        println("Student added successfully!\n")
    }

    // After the loop ends, display "Program finished"
    println("Program finished.\n")

    println("--- All Students List ---")
    
    // 3. Exibe todos os estudantes chamando o método da classe University
    university.displayAllStudents()
}