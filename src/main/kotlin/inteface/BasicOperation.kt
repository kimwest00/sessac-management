package inteface

interface BasicOperation {
    //TODO: 1.Create
    fun <T>createData(data:T)
    //TODO: 2.Update
    fun <T>updateData(data:T)
    //TODO: 3.Read
    fun readData()
}