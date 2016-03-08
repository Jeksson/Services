<%--
  Created by IntelliJ IDEA.
  User: jekss
  Date: 23.10.15
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="_header.jsp"/>

<div class="registr_container">
    <form>
        <h2>Регистрация</h2>

        <div class="row" id="row-login">
            <input id="inp_login" class="validation" type="text" placeholder="Login" autofocus maxlength="30"
                   name="login">
        </div>
        <div class="row" id="row-name" >
            <input id="inp_name" class="validation" type="text" placeholder="Name" required maxlength="15" name="name">
        </div>
        <div class="row" id="row-email">
            <input id="inp_email" class="validation" type="text" placeholder="Email" required maxlength="60"
                   name="mail">
            <span>не доделано. сделать обьект еррор</span>
        </div>
        <div class="row" id="row-password1">
            <input id="inp_password1" class="validation" type="password" placeholder="Password" maxlength="30"
                   name="password">
        </div>
        <div class="row" id="row-password2">
            <input id="inp_password2" class="validation" type="password" placeholder="Password confirm" maxlength="30"
                   name="passwordconfirm">
        </div>
        <div id="button">
            <button class="btn_reg" type="button" onclick="isSendToFormAjax()">Регистрация</button>
        </div>

    </form>
</div>

<script>

   $(document).ready(function(){

       $('#inp_login').keyup(function(){
           var term = '';
           if($('#inp_login') != term){
               $.ajax({
                   url: 'registration/login',
                   type: 'POST',
                   dataType: 'json',
                   data: ({
                       text: $("#inp_login").val()
                   }),
                   beforeSend: function() {
                       $("#inp_login").css('border', 'green 1px solid');
                       $("#row-login" + ' span.msg').remove();
                   },
                   success: function (data) {
                       if(data != '<span class="ok msg"></span>') {
                           $('#row-login').append(data);
                           $("#inp_login").css('border', 'red 1px solid');
                           console.log('fuck login');
                                                  } else{
                           $('#row-login').append(data);
                           $('#inp-login').css('border', 'green 1px solid');
                           console.log('ok login');
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       console.log(textStatus + " " + errorThrown)
                   }
               });
           }

       });

       $('#inp_name').keyup(function(){
           var term = '';
           if($('#inp_name') != term){
               $.ajax({
                   url: 'registration/name',
                   type: 'POST',
                   dataType: 'json',
                   data: ({
                       name: $("#inp_name").val(),
                       login: $("#inp_login").val()
                   }),
                   beforeSend: function()
                   {
                       $("#inp_name").css('border', 'green 1px solid');
                       $('#row-name' + ' span.msg').remove();
                   },
                   success: function (data) {
                       if(data != '<span class="ok msg"></span>'){
                           $('#row-name').append(data);
                           $("#inp_name").css('border', 'red 1px solid');
                       } else {
                           $('#row-name').append(data);
                           $("#inp_name").css('border', 'green 1px solid');
                           console.log('ok name')}
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       console.log(textStatus + " " + errorThrown)
                   }
               });
           }
       });

       $('#inp_email').keyup(function(){
           var term = '';
           if($('#inp_email') != term){
               $.ajax({
                   url: 'registration/email',
                   type: 'POST',
                   dataType: 'json',
                   data: ({
                       text: $("#inp_email").val()
                   }),
                   beforeSend: function() {
                       $("#inp_email").css('border', 'green 1px solid');
                       $('#row-email' + ' span.msg').remove();
                   },
                   success: function (data) {
                       if(data != '<span class="ok msg"></span>'){
                           $('#row-email').append(data);
                           $("#inp_email").css('border', 'red 1px solid');
                       } else{
                           $('#row-email').append(data);
                           $("#inp_email").css('border', 'green 1px solid');
                           console.log('ok email')
                       }
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       console.log(textStatus + " " + errorThrown)
                   }
               });
           }
       });

       $('#inp_password1').keyup(function(){
           var term = '';
           if($('#inp_password1').val() != term){
               if ($("#inp_password1").val() === '') {
                   $("#inp_password1").css('border', 'red 1px solid');
                   $("#row-password1" + ' span.msg').remove();
                   $("#row-password1").append('<span class="error msg" style="color: red; font-weight: bold;">поле не должно быть пустым</span>');
               } else if(($("#inp_password1").val() != $("#inp_password2").val())){
                   $("#inp_password1").css('border', 'red 1px solid');
                   $("#inp_password2").css('border', 'red 1px solid');
                   $("#row-password1" + ' span.msg').remove();
                   $("#row-password1").append('<span class="error msg" style="color: red; font-weight: bold;">пароли не совпадают</span>');
               } else {
                   $("#inp_password1").css('border', 'green 1px solid');
                   $("#inp_password2").css('border', 'green 1px solid');
                   $("#row-password1" + ' span.msg').remove();
                   $("#row-password2" + ' span.msg').remove();
                   $("#row-password1").append('<span class="ok msg" ></span>');
                   $("#row-password2").append('<span class="ok msg" ></span>');
               }
           }
       });

       $('#inp_password2').keyup(function(){
           var term = '';
           if($('#inp_password2').val() != term){
               if (($("#inp_password2").val() === "")) {
                   $("#inp_password1").css('border', 'red 1px solid');
                   $("#inp_password2").css('border', 'red 1px solid');
                   $("#row-password2" + ' span.msg').remove();
                   $("#row-password2").append('<span class="error msg" style="color: red; font-weight: bold;">поле не должно быть пустым</span>');
               }else if(($("#inp_password1").val() != $("#inp_password2").val())){
                   $("#inp_password1").css('border', 'red 1px solid');
                   $("#inp_password2").css('border', 'red 1px solid');
                   $("#row-password2" + ' span.msg').remove();
                   $("#row-password2").append('<span class="error msg" style="color: red; font-weight: bold;">пароли не совпадают</span>');
               } else {
                   $("#inp_password1").css('border', 'green 1px solid');
                   $("#inp_password2").css('border', 'green 1px solid');
                   $("#row-password2" + ' span.msg').remove();
                   $("#row-password1" + ' span.msg').remove();
                   $("#row-password1").append('<span class="ok msg" ></span>');
                   $("#row-password2").append('<span class="ok msg" ></span>');
               }
           }
       });
   })

   function isSendToFormAjax() {
       var elements = $('.validation').length;
       var has = $('.row:has(span.ok)').length;
       if(elements == has){
           console.log("work");
           $.ajax({
               url: 'registration/addUser',
               type: 'POST',
               dataType: 'json',
               data:{
                   login: $('#inp_login').val(),
                   name: $('#inp_name').val(),
                   email: $('#inp_email').val(),
                   password: $('#inp_password1').val()
               },
               beforeSend: function(){
                   $("#button" + ' span.msg').remove();
               },
               success: function (data) {
                   document.location.href='/';
               }
           });
       } else{
           $('#button').append('<span class="error msg" style="color: red; font-weight: bold;">не корректо заполнены поля</span>');
           console.log("gjkz yt pfgjkytys")
       }
    }
</script>
