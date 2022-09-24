package dev.owiti.mycontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.owiti.mycontact.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        binding.ivBack.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        setContentView(binding.root)

        getExtras()
    }

    fun getExtras(){
        val extras=intent.extras
        val name= extras?.getString("NAME","")
        binding.tvName2.text = name
        val email=extras?.getString("EMAIL","")
        binding.tvEmail2.text = email
        val number = extras?.getString("PHONE-NUMBER", "")
        binding.tvPhoneNumber.text = number
        val image= extras?.getString("IMAGE","")
        Picasso.get().load(image)
           .placeholder(R.drawable.ic_baseline_person_24)
           .error(R.drawable.ic_baseline_error_outline_24)
           .resize(300, 300)
           .centerCrop()
           .networkPolicy(NetworkPolicy.NO_CACHE)
           .into(binding.ivContact1)

        Toast.makeText(this,"$name: $email",Toast.LENGTH_LONG).show()

   }
}


