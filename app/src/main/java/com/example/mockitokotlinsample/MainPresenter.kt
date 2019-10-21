package com.example.mockitokotlinsample

class MainPresenter(private val view:MainContact.View, private val repository:SampleRepository):MainContact.Presenter{

    override fun getName(id:Int):String{
        return repository.getUserById(id)
    }
}