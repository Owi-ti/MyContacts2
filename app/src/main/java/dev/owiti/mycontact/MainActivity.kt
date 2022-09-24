package dev.owiti.mycontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.owiti.mycontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContact()
    }

  fun displayContact(){

      var contact1=Contact("Esther Owiti","0114618145","esther@gmail.com","korongo road","https://media.istockphoto.com/photos/young-african-american-woman-standing-casual-and-cool-over-white-picture-id1214258886?k=20&m=1214258886&s=612x612&w=0&h=mN8b071CV7yz-pRRmf9FRrZiTHPzvAEqZF89YOHE22s=")
      var contact2=Contact("Eric James","0114618145","ericJ@gmail.com","korongo road","https://images.unsplash.com/photo-1522529599102-193c0d76b5b6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8YmxhY2slMjBhZnJpY2FuJTIwbWVufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=400&q=60")
      var contact3=Contact("Andrea Brillantes","0114618145","aundrea@gmail.com","korongo road","https://media.istockphoto.com/photos/beautiful-girl-with-curly-hairstyle-picture-id1306514019?b=1&k=20&m=1306514019&s=170667a&w=0&h=DxndQA4sEkVaJjpwmqWfCznbogNSEp4XiVOwQooExuQ=")
      var contact4=Contact("Jake Johnson","0114618145","jake@gmail.com","korongo road","https://media.istockphoto.com/photos/youll-gain-your-strength-back-with-every-breath-picture-id1298515486?k=20&m=1298515486&s=612x612&w=0&h=Q-4EJ-EOT_WzvGcb1LnsrDyy1uBu5CJhRS15cHxGMSE=46yreiur743ry")
      var contact5=Contact("Vida Martins","0114618145","vida@gmail.com","korongo road","https://media.istockphoto.com/photos/excited-woman-wearing-rainbow-cardigan-picture-id1327495344?k=20&m=1327495344&s=612x612&w=0&h=QgjS_6tete6V8lyg2yzrZlD2QnNmHUzpyUL82j0hh1A=")
      var contact6=Contact("Austine Ashavin","0114618145","ostine@gmail.com","korongo road","https://media.istockphoto.com/photos/successful-african-american-freelancer-guy-sitting-at-desk-with-picture-id1309261249?k=20&m=1309261249&s=612x612&w=0&h=QMmvYnA9v1RAhZDhuc2X3Zg3U90Doku4f7zhbELIqVw=")

      var contactList =
          listOf(contact1,contact2,contact3,contact4,contact5,contact6)
      var contactAdapter=ContactRvAdapter(contactList)
      binding.rvContacts.layoutManager=LinearLayoutManager(this)
      binding.rvContacts.adapter=contactAdapter

  }  }