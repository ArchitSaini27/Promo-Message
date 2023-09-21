package com.archit.promomessage
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerValues: Array<String> = arrayOf("Android Developer","Android Engineer")
        val spinnerAdapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerValues)
        Spinner_Job_Title.adapter=spinnerAdapter

        Button_PreviewMessage.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {

//        Instead of sending multiple values via Intent,we use a message data class, to refactor code
//        val contactName=EditText_ContactName.text.toString()
//        val contactNumber=EditText_ContactNumber.text.toString()
//        val displayName=EditText_MyDisplayName.text.toString()
//        val includeJunior=CheckBox_IncludeJunior.isChecked
//        val jobTitle=Spinner_Job_Title?.selectedItem.toString()
//        val immediateJoiner=CheckBox_ImmediateJoiner.isChecked
//        val availableFromDate=EditText_AvailableFromDate.text.toString()

        val message:Message=Message(
            EditText_ContactName.text.toString(),
            EditText_ContactNumber.text.toString(),
            EditText_MyDisplayName.text.toString(),
            CheckBox_IncludeJunior.isChecked,
            Spinner_Job_Title?.selectedItem.toString(),
            CheckBox_ImmediateJoiner.isChecked,
            EditText_AvailableFromDate?.text.toString()
        )

        val messagePreviewIntent:Intent=Intent(this,MessagePreview::class.java)
        messagePreviewIntent.putExtra("Message",message)
        startActivity(messagePreviewIntent)


//        messagePreviewIntent.putExtra("Contact Name",contactName)
//        messagePreviewIntent.putExtra("Contact Number",contactNumber)
//        messagePreviewIntent.putExtra("Display Name",displayName)
//        messagePreviewIntent.putExtra("Include Junior",includeJunior)
//        messagePreviewIntent.putExtra("Job Title",jobTitle)
//        messagePreviewIntent.putExtra("Immediate Joiner",immediateJoiner)
//        messagePreviewIntent.putExtra("Available From Date",availableFromDate)


    }
}