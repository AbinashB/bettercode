import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.example.solid.liskovsubstitution.main

class MainTest {

    @Test
    fun `test main function with valid input`() {
        // Simulate user input
        val simulatedInput = "John\n"
        val inputStream = ByteArrayInputStream(simulatedInput.toByteArray())
        System.setIn(inputStream)

        // Capture the output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // Call the main function
        main()

        // Verify the output
        val expectedOutput = "What's your name?\nHello, John!\n"
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun `test main function with another input`() {
        // Simulate user input
        val simulatedInput = "Alice\n"
        val inputStream = ByteArrayInputStream(simulatedInput.toByteArray())
        System.setIn(inputStream)

        // Capture the output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // Call the main function
        main()

        // Verify the output
        val expectedOutput = "What's your name ?\nHello, Alice!\n"
        assertEquals(expectedOutput, outputStream.toString())
    }
}

