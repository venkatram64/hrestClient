package com.venkat.scala

/**
  * Created by venkatram.veerareddy on 8/28/2017.
  */
object PocApp extends App{

  val restClient = new HBaseRestClient

  //println(restClient.createEmployee("http://localhost:8080/employee/createEmp"))
  //println(restClient.updateEmployee("http://localhost:8080/employee/createEmp"))
  //println(restClient.getEmployeeById("http://localhost:8080/employee/"+"emp-17"))
  //println(restClient.deleteEmployeeById("http://localhost:8080/employee/"+"emp-17"))
  println(restClient.getEmployees("http://localhost:8080/employee/employees"))

}

