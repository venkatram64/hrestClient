package com.venkat.scala

import com.google.gson.Gson
import org.apache.http.client.methods.{HttpDelete, HttpGet, HttpPost}
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicHeader
import org.apache.http.protocol.HTTP

/**
  * Created by venkatram.veerareddy on 8/28/2017.
  */
class HBaseRestClient {

  def getEmployees(url:String):String = {

    val httpClient = new DefaultHttpClient
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager.shutdown
    content

  }

  def getEmployeeById(url:String):String = {

    val httpClient = new DefaultHttpClient
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager.shutdown
    content

  }

  def deleteEmployeeById(url:String):String = {

    val httpClient = new DefaultHttpClient
    val httpDelete = new HttpDelete(url)
    httpDelete.setHeader(HTTP.CONTENT_TYPE, "application/json")
    val httpResponse = httpClient.execute(httpDelete)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString("\n")
      inputStream.close
    }
    httpClient.getConnectionManager.shutdown
    content
  }

  def createEmployee(url:String):String = {
    val emp = Employee("1","John","Lewis","john@gmail.com")
    var gson = new Gson()

    val strEntity = new StringEntity(gson.toJson(emp))
    strEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"))
    val httpClient = new DefaultHttpClient
    val httpPost = new HttpPost(url)
    httpPost.setEntity(strEntity)
    val httpResponse = httpClient.execute(httpPost)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager.shutdown
    content
  }

  def updateEmployee(url:String):String = {
    val emp =Employee("1","John","Lewis","john@gmail.com")
    var gson = new Gson()

    val strEntity = new StringEntity(gson.toJson(emp))
    strEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"))
    val httpClient = new DefaultHttpClient
    val httpPost = new HttpPost(url)
    httpPost.setEntity(strEntity)
    val httpResponse = httpClient.execute(httpPost)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager.shutdown
    content
  }



}
