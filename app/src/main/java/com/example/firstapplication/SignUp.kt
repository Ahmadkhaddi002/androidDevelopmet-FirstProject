package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        auth=FirebaseAuth.getInstance()
        binding.signupButton.setOnClickListener{

            val username=binding.username.text.toString()
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            val repeat=binding.repeat.text.toString()

            if (username.isEmpty()|| email.isEmpty() || password.isEmpty() || repeat.isEmpty() ){



            }
            else if(password != repeat){

            }
            else{
                auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(this){
                    task->
                    if(task.isSuccessful){

                        startActivity(Intent(this,SignIn::class.java))
                        Toast.makeText(this, "account created", Toast.LENGTH_SHORT).show()


                    }
                    else{
                        Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()


                    }
                }

            }



        }





    }
}