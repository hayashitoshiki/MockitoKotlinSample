package com.example.mockitokotlinsample

class SampleRepositoryImp:SampleRepository {

    override fun getUserById(id:Int):String{
        if (id != 0){
            return "taro"
        }else {
            return "error"
        }
    }
}