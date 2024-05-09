package com.example.minitest

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minitest.ui.theme.MinitestTheme
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinitestTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        // in scaffold we are specifying the top bar.
                        topBar = {
                            // inside top bar we are specifying
                            // background color.
                            TopAppBar(
                                // along with that we are specifying
                                // title for our top bar.
                                title = {
                                    // in the top bar we are
// specifying tile as a text
                                    Text(
                                        // on below line we are specifying
// text to display in top app bar
                                        text = "GFG",
                                        // on below line we are specifying
                                        // modifier to fill max width
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {innerPadding ->
                        Text(
                            modifier = Modifier.padding(innerPadding),
                            text = "Them du lieu."
                        )
// on below line we are calling
// method to display UI
                        FirebaseUI(LocalContext.current)
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirebaseUI(context: Context) {
    // on below line creating variable for course name,
    // course duration and course description.
    val courseID = remember {
        mutableStateOf("")
    }
    val courseName = remember {
        mutableStateOf("")
    }
    val courseType = remember {
        mutableStateOf("")
    }
    val coursePrice = remember {
        mutableStateOf("")
    }
    val courseImage = remember {
        mutableStateOf("")
    }

    // on below line creating a column
    // to display our retrieved image view.
    Column(
        // adding modifier for our column
        modifier = Modifier
            .padding(top =60.dp)
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Center, horizontalAlignment =
        Alignment.CenterHorizontally
    ) {
 Text(text = "Dữ liệu sản phẩm", fontSize = 28.sp)
        TextField(
            // on below line we are specifying
            // value for our course name text field.
            value = courseName.value,
            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseName.value = it },
            // on below line we are adding place holder
            // as text as "Enter your course name"
            placeholder = { Text(text = "Tên sản phẩm") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
// on below line we are specifying
// value for our course duration text field.
            value = courseType.value,
            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseType.value = it },
            // on below line we are adding place holder
            // as text as "Enter your course duration"
            placeholder = { Text(text = "Loại sản phẩm") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = coursePrice.value,
            // on below line we are adding on
            // value change for text field.
            onValueChange = { coursePrice.value = it },
            // on below line we are adding place holder
            // as text as "Enter your course description"
            placeholder = { Text(text = "Giá sản phẩm",) },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(2.dp))
        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = courseImage.value,
            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseImage.value = it },
            // on below line we are adding place holder
            // as text as "Enter your course description"
            placeholder = { Text(text = "Hình ảnh sản phẩm",) },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(2.dp))
        // on below line creating button to add data
        // to firebase firestore database.
        Button(
            onClick = {
                // on below line we are validating user input parameters.
                if (TextUtils.isEmpty(courseName.value.toString())) {
                    Toast.makeText(context, "Hãy nhập tên sản pẩm",
                        Toast.LENGTH_SHORT).show()
                } else if
                               (TextUtils.isEmpty(courseType.value.toString())) {
                    Toast.makeText(context, "Hãy nhập loại sản phẩm",
                        Toast.LENGTH_SHORT)
                        .show()
                } else if
                               (TextUtils.isEmpty(coursePrice.value.toString())) {
                    Toast.makeText(context, "Hãy nhập giá sản phẩm",
                        Toast.LENGTH_SHORT)
                        .show()
                } else if
                               (TextUtils.isEmpty(courseImage.value.toString())) {
                    Toast.makeText(context, "Hãy thêm hình ảnh sản phẩm",
                        Toast.LENGTH_SHORT)
                        .show()

                } else {// val courseID: UUID = UUID.randomUUID()
                    // on below line adding data to firebase firestore database.

                    addDataToFirebase(courseID.value, courseName.value,
                        courseType.value, coursePrice.value,courseImage.value ,context)
                }
                context.startActivity(Intent(context, CourseDetailsActivity::class.java))
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Thêm sản phẩm", modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}
fun addDataToFirebase(
    courseID:String,courseName: String, courseType: String,
    coursePrice: String,courseImage:String ,context: Context
) {
    // on below line creating an instance of firebase firestore.
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    // db.collection("Courses").document(courseID.toString()).set(updatedCourse)
    // creating a collection reference for our Firebase Firestore database.
    val dbCourses: CollectionReference = db.collection("Courses")
    // adding our data to our courses object class.
    val courses = Course(courseID,courseName,
        courseType,coursePrice,courseImage)
    // below method is use to add data to Firebase Firestore
    // after the data addition is successful
    dbCourses.add(courses).addOnSuccessListener {
        // we are displaying a success toast message.
        Toast.makeText(
            context, "Your Course has been added to Firebase Firestore",
            Toast.LENGTH_SHORT
        ).show()
    }.addOnFailureListener { e ->
        // this method is called when the data addition process is failed.
        // displaying a toast message when data addition is failed.
        Toast.makeText(context, "Fail to add course \n$e",
            Toast.LENGTH_SHORT).show()
    }
}

