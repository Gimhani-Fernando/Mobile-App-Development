package com.gimhani.android.driver2.services

class HelloMessageService {
    fun compose(name:String, age:String):String{
        return if(age==""){
            "Age should not be empty!"
        }else if(name==""){
            "Name should not be empty!"
        }else {
            "Hello $name. You are $age years old."
        }
    }
}