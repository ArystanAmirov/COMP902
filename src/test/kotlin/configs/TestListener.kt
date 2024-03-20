package configs

import org.testng.ITestContext
import org.testng.ITestListener
import java.text.SimpleDateFormat
import java.util.*

class TestListener : ITestListener {
    private var startTime: Long = 0

    override fun onStart(context: ITestContext) {
        startTime = System.currentTimeMillis()
        println("Test start time - ${formatDateTime(startTime)}")
    }

    override fun onFinish(context: ITestContext) {
        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime
        println("Test end time - ${formatDateTime(endTime)}")
        println("Total test execution time: $totalTime ms.")
    }

    private fun formatDateTime(timeMillis: Long): String {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date(timeMillis))
    }
}